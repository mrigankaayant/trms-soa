package com.ayantsoft.trms.employee.dao;

import java.io.Serializable;
import java.util.List;
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
			criteria.andOperator(Criteria.where("username").is(username),Criteria.where("active").is(true));
			Query query = new Query(criteria);
			employee = mongoTemplate.findOne(query,Employee.class,DatabaseInfo.EMPLOYEECOLLECTION);
		}catch(Exception e){
			e.printStackTrace();
			try{
				throw new Exception("FIND EMPLOYEE BY USERNAME EXCEPTION ");
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
		return employee;
	}


	@Override
	public void update(Employee employee) {
		try{
			mongoTemplate.save(employee,DatabaseInfo.EMPLOYEECOLLECTION);
		}catch(Exception e){
			e.printStackTrace();
			try{
				throw new Exception("EMPLOYEE UPDATE EXCEPTION ");
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}	
	}


	@Override
	public void delete(String employeeId) {
		try{
			Query query = new Query();
			query.addCriteria(Criteria.where("employeeId").is(employeeId));
			Employee employee = mongoTemplate.findOne(query,Employee.class);
			mongoTemplate.remove(employee,DatabaseInfo.EMPLOYEECOLLECTION);
		}catch(Exception e){
			e.printStackTrace();
			try{
				throw new Exception("EMPLOYEE DELETE EXCEPTION ");
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
	}


	@Override
	public List<Employee> list() {
		List<Employee> list = null;
		try{
			list = mongoTemplate.findAll(Employee.class,DatabaseInfo.EMPLOYEECOLLECTION);
		}catch(Exception e){
			e.printStackTrace();
			try{
				throw new Exception("EMPLOYEE LIST EXCEPTION ");
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
		return list;
	}


	@Override
	public Employee create(Employee employee) {
		try{
			mongoTemplate.save(employee,DatabaseInfo.EMPLOYEECOLLECTION);
		}catch(Exception e){
			e.printStackTrace();
			try{
				throw new Exception("EMPLOYEE CREATE EXCEPTION ");
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
		return employee;
	}

}
