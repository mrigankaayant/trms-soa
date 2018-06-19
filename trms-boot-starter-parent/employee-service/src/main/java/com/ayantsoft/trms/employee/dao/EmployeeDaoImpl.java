package com.ayantsoft.trms.employee.dao;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.ayantsoft.trms.employee.info.DatabaseInfo;
import com.ayantsoft.trms.employee.model.Employee;

@Repository
public class EmployeeDaoImpl implements Serializable,EmployeeDao {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = -7906518682943993624L;
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public Employee getEmployeeByUsername(String username) {
		Employee employee = null;
		try{
			Criteria criteria = new Criteria();
			criteria.andOperator(Criteria.where("loginCredential.username").is(username),Criteria.where("active").is(true));
			Query query = new Query(criteria);
			employee = mongoTemplate.findOne(query,Employee.class,DatabaseInfo.EMPLOYEECOLLECTION);
		}catch(Exception e){
			e.printStackTrace();
		}
		return employee;
	}

}
