package com.ayantsoft.trms.finance.dao;

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
import com.ayantsoft.trms.finance.dto.LazyPaymentDto;
import com.ayantsoft.trms.finance.info.DatabaseInfo;
import com.ayantsoft.trms.finance.lazy.model.LazyLoadEvent;
import com.ayantsoft.trms.finance.model.PaymentDetails;


@Repository
public class PaymentDaoImpl implements Serializable,PaymentDao {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = -3852717969564699911L;


	@Autowired
	private MongoTemplate mongoTemplate;


	@Override
	public LazyPaymentDto list(LazyLoadEvent lazyLoadEvent,String status) {
		LazyPaymentDto lazyPaymentDto = null;
		try{
			Criteria criteria = new Criteria();
			Criteria statusCriteria = Criteria.where("status").is(status);

			if(lazyLoadEvent.getFilters() != null){
				List<Criteria> criteriaList = new ArrayList<Criteria>();
				criteriaList.add(statusCriteria);
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
			long totalData = mongoTemplate.count(query,DatabaseInfo.PAYMENT_DETAILS_COLLECTION);
			List<PaymentDetails> paymentDetailsList = mongoTemplate.find(query,PaymentDetails.class,DatabaseInfo.PAYMENT_DETAILS_COLLECTION);
			lazyPaymentDto = new LazyPaymentDto(paymentDetailsList,totalData,pageRequest.getPageNumber()); 
		}catch(Exception e){
			e.printStackTrace();
			try {
				throw new Exception("LAZY PAYMENT DETAILS  LIST EXCEPTION");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return lazyPaymentDto;
	}


	@Override
	public PaymentDetails findById(String paymentId) {
		PaymentDetails paymentDetails = null;
		try{	
			Query query = new Query();
			query.addCriteria(Criteria.where("paymentDetailsId").is(paymentId));
			paymentDetails = mongoTemplate.findOne(query,PaymentDetails.class,DatabaseInfo.PAYMENT_DETAILS_COLLECTION);
		}catch(Exception e){
			e.printStackTrace();
			try {
				throw new Exception("PAYMENT DETAILS FIND EXCEPTION");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return paymentDetails;
	}


	
	@Override
	public void update(PaymentDetails paymentDetails) {
		try{
			mongoTemplate.save(paymentDetails,DatabaseInfo.PAYMENT_DETAILS_COLLECTION);
		}catch(Exception e){
			e.printStackTrace();
			try {
				throw new Exception("PAYMENT DETAILS UPDATE EXCEPTION");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}
