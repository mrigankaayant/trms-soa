package com.ayantsoft.trms.resourcing.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.ayantsoft.trms.resourcing.dto.SearchDto;
import com.ayantsoft.trms.resourcing.info.DatabaseInfo;
import com.ayantsoft.trms.resourcing.lazy.model.LazyCandidateDto;
import com.ayantsoft.trms.resourcing.lazy.model.LazyLoadEvent;
import com.ayantsoft.trms.resourcing.model.Candidate;

@Repository
public class CandidateDaoImpl implements CandidateDao,Serializable {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = -1177437504030163819L;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private CommonDao commonDao;

	@Override
	public void addCandidate(Candidate candidate) {
		try{
			candidate.setCandidateId(commonDao.getNextSequenceId("candidate"));
			mongoTemplate.save(candidate,DatabaseInfo.CANDIDATE_COLLECTION); 
		}catch(Exception e){
			e.printStackTrace();
			try {
				throw new Exception("CANDIDATE SAVE EXCEPTION");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}


	@Override
	public Candidate checkEmail(String email, String id) {
		Candidate candidate = null;
		try{
			Criteria criteria = new Criteria();
			if("0".equals(id)){
				criteria.orOperator(Criteria.where("email").is(email.trim()),Criteria.where("altEmail").is(email.trim()));
				Query query = new Query(criteria);
				candidate = mongoTemplate.findOne(query,Candidate.class,DatabaseInfo.CANDIDATE_COLLECTION);
			}else{
				Criteria c1 = criteria.orOperator(Criteria.where("email").is(email.trim()),Criteria.where("altEmail").is(email.trim()));
				Criteria c2 = Criteria.where("candidateId").ne(id);
				Criteria criteria2 = new Criteria();
				criteria2.andOperator(c1,c2);
				Query query = new Query(criteria2);
				candidate = mongoTemplate.findOne(query,Candidate.class,DatabaseInfo.CANDIDATE_COLLECTION);
			}

		}catch(Exception e){
			e.printStackTrace();
			try {
				throw new Exception("CANDIDATE CHECK EMAIL EXCEPTION");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return candidate;
	}



	@Override
	public Candidate checkMobile(String phone,String id) {
		Candidate candidate = null;
		try{
			Criteria criteria = new Criteria();
			if("0".equals(id)){
				criteria.orOperator(Criteria.where("workMobile").is(phone.trim()),Criteria.where("phone").is(phone.trim()));
				Query query = new Query(criteria);
				candidate = mongoTemplate.findOne(query,Candidate.class,DatabaseInfo.CANDIDATE_COLLECTION);
			}else{
				Criteria c1 = criteria.orOperator(Criteria.where("workMobile").is(phone.trim()),Criteria.where("phone").is(phone.trim()));
				Criteria c2 = Criteria.where("candidateId").ne(id);
				Criteria criteria2 = new Criteria();
				criteria2.andOperator(c1,c2);
				Query query = new Query(criteria2);
				candidate = mongoTemplate.findOne(query,Candidate.class,DatabaseInfo.CANDIDATE_COLLECTION);
			}
		}catch(Exception e){
			e.printStackTrace();
			try {
				throw new Exception("CANDIDATE CHECK MOBILE EXCEPTION");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return candidate;
	}


	@Override
	public Candidate findById(String candidateId) {
		Candidate candidate = null;
		try{	
			Query query = new Query();
			query.addCriteria(Criteria.where("candidateId").is(candidateId));
			candidate = mongoTemplate.findOne(query,Candidate.class,DatabaseInfo.CANDIDATE_COLLECTION);
		}catch(Exception e){
			e.printStackTrace();
			try {
				throw new Exception("CANDIDATE FIND EXCEPTION");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return candidate;
	}


	@Override
	public void updateCandidate(Candidate candidate) {
		try{
			mongoTemplate.save(candidate,DatabaseInfo.CANDIDATE_COLLECTION);
		}catch(Exception e){
			e.printStackTrace();
			try {
				throw new Exception("CANDIDATE UPDATE EXCEPTION");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}


	@Override
	public LazyCandidateDto list(LazyLoadEvent lazyLoadEvent,String employeeId) {
		LazyCandidateDto lazyCandidateDto = null;
		try{
			Criteria criteria = new Criteria();
			Criteria c1 = criteria.orOperator(Criteria.where("createdBy.employeeId").is(employeeId),
					Criteria.where("createdBy.supervisorId").is(employeeId));

			if(lazyLoadEvent.getFilters() != null){
				List<Criteria> criteriaList = new ArrayList<Criteria>();
				criteriaList.add(c1);
				lazyLoadEvent.getFilters().forEach((k,v)->{

					if(k.equals("nextFollowupDate")){

						System.out.println("#######  "+(String)v.getValue());

						/*Criteria c = Criteria.where(k).is((Date)v.getValue());
						if(c != null){
							criteriaList.add(c);
						}*/
					}else{
						Criteria c = Criteria.where(k).regex(Pattern.compile((String)v.getValue(), Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE));
						if(c != null){
							criteriaList.add(c);
						}
					}
				});

				Criteria[] arr = new Criteria[criteriaList.size()];
				arr = criteriaList.toArray(arr);
				criteria.andOperator(arr);
			}
			Query query = new Query(criteria);

			if(lazyLoadEvent.getSortField() != null){
				if(lazyLoadEvent.getSortOrder() == 1){
					query.with(new Sort(Direction.ASC,lazyLoadEvent.getSortField()));
				}else if(lazyLoadEvent.getSortOrder() == -1){
					query.with(new Sort(Direction.DESC,lazyLoadEvent.getSortField()));
				}
			}
			PageRequest pageRequest = PageRequest.of(lazyLoadEvent.getFirst()/lazyLoadEvent.getRows(),lazyLoadEvent.getRows());
			query.with(pageRequest);
			long totalData = mongoTemplate.count(query,DatabaseInfo.CANDIDATE_COLLECTION);
			List<Candidate> candidateList = mongoTemplate.find(query,Candidate.class,DatabaseInfo.CANDIDATE_COLLECTION);
			lazyCandidateDto = new LazyCandidateDto(candidateList,totalData,pageRequest.getPageNumber()); 
		}catch(Exception e){
			e.printStackTrace();
			try {
				throw new Exception("CANDIDATE LIST EXCEPTION");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return lazyCandidateDto;
	}


	@Override
	public Candidate searchCandidate(SearchDto searchDto) {
		Candidate candidate = null;
		try{

			Map<String,String> map = new HashMap<String,String>(); 
			List<Criteria> criteriaList = null;
			try{
				String candidateId = BeanUtils.getProperty(searchDto,"candidateId");
				String candidateName = BeanUtils.getProperty(searchDto,"candidateName");
				String email = BeanUtils.getProperty(searchDto,"email");
				String altEmail = BeanUtils.getProperty(searchDto,"altEmail");
				String workMobile = BeanUtils.getProperty(searchDto,"workMobile");
				String phone = BeanUtils.getProperty(searchDto,"phone");

				if(candidateId != null){
					map.put("candidateId",candidateId);
				}
				if(candidateName != null){
					map.put("candidateName",candidateName);
				}
				if(email != null){
					map.put("email",email);
				}
				if(altEmail != null){
					map.put("altEmail",altEmail);
				}
				if(workMobile != null){
					map.put("workMobile",workMobile);
				}
				if(phone != null){
					map.put("phone",phone);
				}
			}catch(Exception e){
				e.printStackTrace();
			}

			if(map.size() >0){
				criteriaList = new ArrayList<Criteria>();
				for(Map.Entry<String,String> entry:map.entrySet()){
					Criteria c = Criteria.where(entry.getKey()).is(entry.getValue());
					criteriaList.add(c);
				}
			}

			if(criteriaList != null){
				Query query = new Query();
				if(criteriaList.size() == 0){
					query.addCriteria(criteriaList.get(0));
				}else{
					Criteria[] arr = new Criteria[criteriaList.size()];
					arr = criteriaList.toArray(arr);
					Criteria cri = new Criteria();
					cri.orOperator(arr);
					query.addCriteria(cri);
				}
				candidate = mongoTemplate.findOne(query,Candidate.class,DatabaseInfo.CANDIDATE_COLLECTION);
			}		
		}catch(Exception e){
			e.printStackTrace();
			try {
				throw new Exception("CANDIDATE SEARCH EXCEPTION");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return candidate;
	}


	@Override
	public LazyCandidateDto list(LazyLoadEvent lazyLoadEvent) {
		LazyCandidateDto lazyCandidateDto = null;
		try{
			Criteria criteria = new Criteria();
			Query query = null;

			if(lazyLoadEvent.getFilters() != null){
				List<Criteria> criteriaList = new ArrayList<Criteria>();
				lazyLoadEvent.getFilters().forEach((k,v)->{

					if(k.equals("nextFollowupDate")){

						System.out.println("#######  "+(String)v.getValue());

						/*Criteria c = Criteria.where(k).is((Date)v.getValue());
						if(c != null){
							criteriaList.add(c);
						}*/
					}else{
						Criteria c = Criteria.where(k).regex(Pattern.compile((String)v.getValue(), Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE));
						if(c != null){
							criteriaList.add(c);
						}
					}
				});

				if(criteriaList.size() >0){
					Criteria[] arr = new Criteria[criteriaList.size()];
					arr = criteriaList.toArray(arr);
					criteria.andOperator(arr);
				}
			}

			if(lazyLoadEvent.getFilters() != null){
				query = new Query(criteria);
			}else{
				query = new Query();
			}


			if(lazyLoadEvent.getSortField() != null){
				if(lazyLoadEvent.getSortOrder() == 1){
					query.with(new Sort(Direction.ASC,lazyLoadEvent.getSortField()));
				}else if(lazyLoadEvent.getSortOrder() == -1){
					query.with(new Sort(Direction.DESC,lazyLoadEvent.getSortField()));
				}
			}
			PageRequest pageRequest = PageRequest.of(lazyLoadEvent.getFirst()/lazyLoadEvent.getRows(),lazyLoadEvent.getRows());
			query.with(pageRequest);
			long totalData = mongoTemplate.count(query,DatabaseInfo.CANDIDATE_COLLECTION);
			List<Candidate> candidateList = mongoTemplate.find(query,Candidate.class,DatabaseInfo.CANDIDATE_COLLECTION);
			lazyCandidateDto = new LazyCandidateDto(candidateList,totalData,pageRequest.getPageNumber()); 
		}catch(Exception e){
			e.printStackTrace();
			try {
				throw new Exception("CANDIDATE LIST EXCEPTION");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return lazyCandidateDto;
	}


	@Override
	public List<Candidate> findCandidateByProperty(String propertyName,String propertyValue) {
		List<Candidate> list = null;
		try{	
			Query query = new Query();
			query.addCriteria(Criteria.where(propertyName).is(propertyValue));
			list = mongoTemplate.find(query,Candidate.class,DatabaseInfo.CANDIDATE_COLLECTION);
		}catch(Exception e){
			e.printStackTrace();
			try {
				throw new Exception("CANDIDATE FIND BY PROPERTY NAME EXCEPTION");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return list;
	}
}
