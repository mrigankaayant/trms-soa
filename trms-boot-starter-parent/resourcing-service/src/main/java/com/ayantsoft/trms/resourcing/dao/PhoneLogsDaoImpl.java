package com.ayantsoft.trms.resourcing.dao;

import java.io.Serializable;
import java.util.ArrayList;
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
import com.ayantsoft.trms.resourcing.lazy.model.LazyLoadEvent;
import com.ayantsoft.trms.resourcing.lazy.model.LazyPhoneLogDto;
import com.ayantsoft.trms.resourcing.model.PhoneLogs;

@Repository
public class PhoneLogsDaoImpl implements Serializable,PhoneLogsDao {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = -2203588017024747185L;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public LazyPhoneLogDto listByEmployeeId(LazyLoadEvent lazyLoadEvent,String employeeId) {
		LazyPhoneLogDto lazyPhoneLogDto = null;
		try{
			Criteria criteria = new Criteria();
			Criteria c1 = criteria.orOperator(Criteria.where("employeeId").is(employeeId),
					Criteria.where("managerId").is(employeeId));

			if(lazyLoadEvent.getFilters() != null){
				List<Criteria> criteriaList = new ArrayList<Criteria>();
				criteriaList.add(c1);
				lazyLoadEvent.getFilters().forEach((k,v)->{
					Criteria c = Criteria.where(k).regex(Pattern.compile((String)v.getValue(), Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE));
					if(c != null){
						criteriaList.add(c);
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
			long totalData = mongoTemplate.count(query,DatabaseInfo.PHONE_LOGS_COLLECTION);
			List<PhoneLogs> phoneLogsList = mongoTemplate.find(query,PhoneLogs.class,DatabaseInfo.PHONE_LOGS_COLLECTION);
			lazyPhoneLogDto = new LazyPhoneLogDto(phoneLogsList,totalData,pageRequest.getPageNumber()); 
		}catch(Exception e){
			e.printStackTrace();
			try {
				throw new Exception("LAZY PHONE LOG LIST EXCEPTION");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return lazyPhoneLogDto;
	}




	@Override
	public List<PhoneLogs> listByCandidateId(String candidateId) {
		List<PhoneLogs> list = null;
		try{	
			Query query = new Query();
			query.addCriteria(Criteria.where("candidateId").is(candidateId));
			list = mongoTemplate.find(query,PhoneLogs.class,DatabaseInfo.PHONE_LOGS_COLLECTION);
		}catch(Exception e){
			e.printStackTrace();
			try {
				throw new Exception("PHONE LOGS LIST EXCEPTION");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return list;
	}

}
