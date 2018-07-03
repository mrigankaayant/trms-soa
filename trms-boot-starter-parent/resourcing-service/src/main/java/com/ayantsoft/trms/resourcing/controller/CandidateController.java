package com.ayantsoft.trms.resourcing.controller;

import java.io.Serializable;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ayantsoft.trms.resourcing.dto.CandidateDto;
import com.ayantsoft.trms.resourcing.info.URLInfo;
import com.ayantsoft.trms.resourcing.model.Candidate;
import com.ayantsoft.trms.resourcing.model.CreatedBy;
import com.ayantsoft.trms.resourcing.model.Employee;
import com.ayantsoft.trms.resourcing.service.CandidateService;
import com.ayantsoft.trms.resourcing.service.EmployeeService;

@RestController
@RequestMapping(URLInfo.ROOTURL)
public class CandidateController implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8516412036040851076L;


	@Autowired
	private CandidateService candidateService;

	@Autowired
	private EmployeeService employeeService;
	

	@PostMapping(URLInfo.CREATE_CANDIDATE)
	@PreAuthorize("hasAuthority('TRMSRES_CANDIDATE_CREATE')")
	public ResponseEntity<?> addCandidate(@Valid @RequestBody CandidateDto candidateDto,HttpServletRequest request){
		HttpStatus httpStatus = null; 
		Candidate candidate = null;
		try{

			Employee employee = employeeService.getEmployeeByUsername(request, request.getUserPrincipal().getName());

			candidate = new Candidate();
			candidate.setCandidateName(candidateDto.getCandidateName());
			candidate.setWorkMobile(candidateDto.getWorkMobile());
			candidate.setEmail(candidateDto.getEmail());

			if(candidateDto.getPayType() != null){
				candidate.setPayType(candidateDto.getPayType());
			}
			if(candidateDto.getPayRate() != null){
				candidate.setPayRate(candidateDto.getPayRate());
			}
			if(candidateDto.getAltEmail() != null){
				candidate.setAltEmail(candidateDto.getAltEmail());
			}
			if(candidateDto.getGraduationDate() != null){
				candidate.setGraduationDate(candidateDto.getGraduationDate());
			}
			if(candidateDto.getCurrentLocation() != null){
				candidate.setCurrentLocation(candidateDto.getCurrentLocation());
			}
			if(candidateDto.getPhone() != null){
				candidate.setPhone(candidateDto.getPhone());
			}
			if(candidateDto.getVisa() != null){
				candidate.setVisa(candidateDto.getVisa());
			}
			if(candidateDto.getVisaStartDate() != null){
				candidate.setVisaStartDate(candidateDto.getVisaStartDate()); 
			}
			if(candidateDto.getRecruitmentSource() != null){
				candidate.setRecruitmentSource(candidateDto.getRecruitmentSource());
			}
			if(candidateDto.getSkill() != null ){
				candidate.setSkill(candidateDto.getSkill());
			}
			if(candidateDto.getCourseFee() != null){
				candidate.setCourseFee(candidateDto.getCourseFee());
			}
			if(candidateDto.getEnrollmentStatus() != null){
				candidate.setEnrollmentStatus(candidateDto.getEnrollmentStatus());
			}
			if(candidateDto.getRecruitmentService() != null){
				candidate.setRecruitmentService(candidateDto.getRecruitmentService());
			}
			if(candidateDto.getPrefferedLocations() != null && candidateDto.getPrefferedLocations().size() >0){
				candidate.setPrefferedLocations(candidateDto.getPrefferedLocations());
			}
			candidate.setCreatedDate(new Date());
			candidate.setNextFollowupDate(new Date());

			CreatedBy createdBy = new CreatedBy();
			createdBy.setEmployeeId(employee.getEmployeeId());
			createdBy.setEmployeeName(employee.getName());
			createdBy.setEmployeeEmail(employee.getWorkEmail());
			createdBy.setEmployeePhone(employee.getWorkMobile());
			if(employee.getSupervisor() != null){
				createdBy.setSupervisorId(employee.getSupervisor().getSupervisorId());
				createdBy.setSupervisorName(employee.getSupervisor().getSupervisorName());
				createdBy.setSupervisorEmail(employee.getSupervisor().getSupervisorEmail());
				createdBy.setSupervisorPhone(employee.getSupervisor().getSupervisorPhone());
			}
			candidate.setCreatedBy(createdBy); 
			candidateService.addCandidate(candidate);
			httpStatus = HttpStatus.CREATED;
		}catch(Exception e){
			e.printStackTrace();
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Candidate>(candidate, httpStatus);
	}


	@GetMapping(URLInfo.CHECK_EMAIL)
	@PreAuthorize("hasAuthority('TRMSRES_CANDIDATE_READ')")
	public ResponseEntity<?> checkEmail(@PathVariable String email,@PathVariable String id){
		HttpStatus httpStatus = null; 
		Candidate candidate = null;
		String val = null;
		try {
			Decoder decoder = Base64.getDecoder();
			byte[] b = decoder.decode(email);
			val = new String(b); 
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try{
			candidate = candidateService.checkEmail(val,id);
			if(candidate == null){
				httpStatus = HttpStatus.NOT_FOUND;
			}else{
				httpStatus = HttpStatus.OK;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<Candidate>(candidate, httpStatus);
	}	


	@GetMapping(URLInfo.CHECK_PHONE)
	@PreAuthorize("hasAuthority('TRMSRES_CANDIDATE_READ')")
	public ResponseEntity<?> checkMobile(@PathVariable String mobile,@PathVariable String id){
		HttpStatus httpStatus = null; 
		Candidate candidate = null;
		try{
			candidate = candidateService.checkMobile(mobile,id);
			if(candidate == null){
				httpStatus = HttpStatus.NOT_FOUND;
			}else{
				httpStatus = HttpStatus.OK;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<Candidate>(candidate, httpStatus);
	}
	
	
	
	@GetMapping(URLInfo.CANDIDATE_LIST)
	@PreAuthorize("hasAuthority('TRMSRES_CANDIDATE_LIST')")
	public ResponseEntity<?> candidateList(HttpServletRequest request){
		HttpStatus httpStatus = null; 
		List<Candidate> list = null;
		try{
			Employee employee = employeeService.getEmployeeByUsername(request, request.getUserPrincipal().getName());
			String[] roles = employee.getRoles();

			list = candidateService.list(isRole("Admin",roles),employee.getEmployeeId());
			if(list == null){
				httpStatus = HttpStatus.NOT_FOUND;
			}else{
				httpStatus = HttpStatus.OK;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<List<Candidate>>(list, httpStatus);
	}

	
	
	
	public boolean isRole(String role,String[] roles){
		boolean hasRole = false;
		try{
			for(String r:roles){
				if(r.equals(role)){
					hasRole = true;
					break;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return hasRole;
	}

}