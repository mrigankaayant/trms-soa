package com.ayantsoft.trms.resourcing.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import com.ayantsoft.trms.resourcing.info.DatabaseInfo;
import com.ayantsoft.trms.resourcing.lazy.model.LazyFreepoolCandidateDto;
import com.ayantsoft.trms.resourcing.lazy.model.LazyLoadEvent;
import com.ayantsoft.trms.resourcing.model.MaxFollowUp;

@Repository
public class MaxFollowUpDaoImpl implements Serializable,MaxFollowUpDao {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = 9001419803190860484L;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public void addMaxFollowUp(MaxFollowUp maxFollowUp) {
		try{
			mongoTemplate.save(maxFollowUp,DatabaseInfo.MAX_FOLLOWUP_COLLECTION); 
		}catch(Exception e){
			e.printStackTrace();
			try {
				throw new Exception("MAX_FOLLOW_UP SAVE EXCEPTION");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	@Override
	public MaxFollowUp findByCandidateId(String candidateId) {
		MaxFollowUp maxFollowUp = null;
		try{	
			Query query = new Query();
			query.addCriteria(Criteria.where("candidateId").is(candidateId));
			maxFollowUp = mongoTemplate.findOne(query,MaxFollowUp.class,DatabaseInfo.MAX_FOLLOWUP_COLLECTION);
		}catch(Exception e){
			e.printStackTrace();
			try {
				throw new Exception("MAXFOLLOWUP FIND EXCEPTION");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return maxFollowUp;
	}


	@Override
	public void updateMaxFollowUp(MaxFollowUp maxFollowUp) {
		try{
			mongoTemplate.save(maxFollowUp,DatabaseInfo.MAX_FOLLOWUP_COLLECTION);
		}catch(Exception e){
			e.printStackTrace();
			try {
				throw new Exception("MAXFOLLOWUP UPDATE EXCEPTION");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}



	@Override
	public LazyFreepoolCandidateDto list(LazyLoadEvent lazyLoadEvent, Date dateBefore30Days) {
		LazyFreepoolCandidateDto lazyFreepoolCandidateDto = null;
		try{

			Criteria criteria = new Criteria();

			Criteria statusCriteria = new Criteria().orOperator(Criteria.where("candidateStatus").is("New Entry"),Criteria.where("candidateStatus").is("Partially Interested"),
					Criteria.where("candidateStatus").is("Not Responding"),Criteria.where("candidateStatus").is("Not Interested"),
					Criteria.where("candidateStatus").is("Voicemail"),Criteria.where("candidateStatus").is("Awaited"),
					Criteria.where("candidateStatus").is("Interested"),Criteria.where("candidateStatus").is("Pipeline"));

			Criteria dateCriteria = Criteria.where("maxFollowUpDate").lt(dateBefore30Days);

			Criteria matchModeCriteria = new Criteria().andOperator(statusCriteria,dateCriteria);

			if(lazyLoadEvent.getFilters() != null){
				List<Criteria> criteriaList = new ArrayList<Criteria>();
				criteriaList.add(matchModeCriteria);
				lazyLoadEvent.getFilters().forEach((k,v)->{
					Criteria c = Criteria.where(k).regex(Pattern.compile((String)v.getValue(), Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE));
					if(c != null){
						criteriaList.add(c);
					}
				});

				Criteria[] arr = new Criteria[criteriaList.size()];
				arr = criteriaList.toArray(arr);
				criteria.andOperator(arr);
			}else{
				criteria.andOperator(statusCriteria,dateCriteria);
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
			long totalData = mongoTemplate.count(query,DatabaseInfo.MAX_FOLLOWUP_COLLECTION);
			List<MaxFollowUp> candidateList = mongoTemplate.find(query,MaxFollowUp.class,DatabaseInfo.MAX_FOLLOWUP_COLLECTION);
			lazyFreepoolCandidateDto = new LazyFreepoolCandidateDto(candidateList,totalData,pageRequest.getPageNumber()); 
		}catch(Exception e){
			e.printStackTrace();
			try {
				throw new Exception("LAZY FREEPOOL CANDIDATE LIST EXCEPTION");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return lazyFreepoolCandidateDto;
	}
}
