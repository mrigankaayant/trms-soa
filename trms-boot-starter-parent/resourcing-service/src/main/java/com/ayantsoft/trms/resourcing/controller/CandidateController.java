package com.ayantsoft.trms.resourcing.controller;

import java.io.Serializable;
import java.util.Base64;
import java.util.Calendar;
import java.util.Base64.Decoder;
import java.util.Date;
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
import com.ayantsoft.trms.resourcing.dto.SearchDto;
import com.ayantsoft.trms.resourcing.info.URLInfo;
import com.ayantsoft.trms.resourcing.lazy.model.LazyCandidateDto;
import com.ayantsoft.trms.resourcing.lazy.model.LazyFreepoolCandidateDto;
import com.ayantsoft.trms.resourcing.lazy.model.LazyLoadEvent;
import com.ayantsoft.trms.resourcing.model.Candidate;
import com.ayantsoft.trms.resourcing.model.CandidateInfo;
import com.ayantsoft.trms.resourcing.model.CreatedBy;
import com.ayantsoft.trms.resourcing.model.Employee;
import com.ayantsoft.trms.resourcing.model.FollowUp;
import com.ayantsoft.trms.resourcing.model.MaxFollowUp;
import com.ayantsoft.trms.resourcing.service.CandidateService;
import com.ayantsoft.trms.resourcing.service.EmployeeService;
import com.ayantsoft.trms.resourcing.service.FollowUpService;
import com.ayantsoft.trms.resourcing.service.MaxFollowUpService;

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

	@Autowired
	private FollowUpService followUpService;

	@Autowired
	private MaxFollowUpService maxFollowUpService;


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
			if(candidateDto.getHighestQualification() != null){
				candidate.setHighestQualification(candidateDto.getHighestQualification());
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


			FollowUp followup = new FollowUp();
			followup.setFollowupDate(new Date());
			followup.setFollowupRemarks("Candidate Created By "+candidate.getCreatedBy().getEmployeeName());
			followup.setEmployeeId(candidate.getCreatedBy().getEmployeeId());
			CandidateInfo candidateInfo = new CandidateInfo();
			candidateInfo.setCandidateId(candidate.getCandidateId());
			candidateInfo.setCandidateName(candidate.getCandidateName());
			candidateInfo.setEmail(candidate.getEmail());
			candidateInfo.setWorkMobile(candidate.getWorkMobile());
			candidateInfo.setCandidateStatus(candidate.getEnrollmentStatus());
			candidateInfo.setRecruiterName(candidate.getCreatedBy().getEmployeeName());
			followup.setCandidateInfo(candidateInfo);

			followUpService.addFollowup(followup);

			MaxFollowUp maxFollowUp = new MaxFollowUp();

			maxFollowUp.setMaxFollowUpDate(new Date());
			maxFollowUp.setRecruiterId(candidate.getCreatedBy().getEmployeeId());
			maxFollowUp.setCandidateId(candidate.getCandidateId());
			maxFollowUp.setCandidateName(candidate.getCandidateName());
			maxFollowUp.setCandidateEmail(candidate.getEmail());
			maxFollowUp.setCandidateWorkMobile(candidate.getWorkMobile());
			maxFollowUp.setCandidateStatus(candidate.getEnrollmentStatus());
			maxFollowUp.setRecruiterName(candidate.getCreatedBy().getEmployeeName());

			maxFollowUpService.addMaxFollowup(maxFollowUp); 

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
				httpStatus = HttpStatus.NO_CONTENT;
			}else{
				httpStatus = HttpStatus.OK;
			}
		}catch(Exception e){
			e.printStackTrace();
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
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
				httpStatus = HttpStatus.NO_CONTENT;
			}else{
				httpStatus = HttpStatus.OK;
			}
		}catch(Exception e){
			e.printStackTrace();
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Candidate>(candidate, httpStatus);
	}


	@PostMapping(URLInfo.CANDIDATE_LAZY_LIST)
	@PreAuthorize("hasAuthority('TRMSRES_CANDIDATE_LIST')")
	public ResponseEntity<?> candidateList(@RequestBody LazyLoadEvent lazyLoadEvent,HttpServletRequest request){

		HttpStatus httpStatus = null;
		LazyCandidateDto lazyCandidateDto = null;
		try{
			Employee employee = employeeService.getEmployeeByUsername(request, request.getUserPrincipal().getName());
			lazyCandidateDto = candidateService.list(lazyLoadEvent,employee.getEmployeeId());
			httpStatus = HttpStatus.OK;
		}catch(Exception e){
			e.printStackTrace();
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<LazyCandidateDto>(lazyCandidateDto,httpStatus);
	}


	@GetMapping(URLInfo.CANDIDATE_FIND_BY_ID)
	@PreAuthorize("hasAuthority('TRMSRES_CANDIDATE_READ')")
	public ResponseEntity<?> findCandidateById(@PathVariable("id") String candidateId){

		HttpStatus httpStatus = null;
		Candidate candidate = null;
		try{
			candidate = candidateService.findCandidateById(candidateId);
			if(candidate != null){
				httpStatus = HttpStatus.OK;
			}else{
				httpStatus = HttpStatus.NO_CONTENT;
			}
		}catch(Exception e){
			e.printStackTrace();
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Candidate>(candidate,httpStatus);
	}


	@PostMapping(URLInfo.UPDATE_CANDIDATE)
	@PreAuthorize("hasAuthority('TRMSRES_CANDIDATE_UPDATE')")
	public ResponseEntity<?> updateCandidate(@Valid @RequestBody CandidateDto candidateDto,HttpServletRequest request){
		HttpStatus httpStatus = null; 
		Candidate candidate = null;
		try{

			candidate = candidateService.findCandidateById(candidateDto.getCandidateId());

			Employee employee = employeeService.getEmployeeByUsername(request, request.getUserPrincipal().getName());

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
			if(candidateDto.getHighestQualification() != null){
				candidate.setHighestQualification(candidateDto.getHighestQualification());
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

			candidateService.updateCandidate(candidate);

			FollowUp followup = new FollowUp();
			followup.setFollowupDate(new Date());
			followup.setFollowupRemarks("Candidate Updated By "+candidate.getCreatedBy().getEmployeeName());
			followup.setEmployeeId(candidate.getCreatedBy().getEmployeeId());
			CandidateInfo candidateInfo = new CandidateInfo();
			candidateInfo.setCandidateId(candidate.getCandidateId());
			candidateInfo.setCandidateName(candidate.getCandidateName());
			candidateInfo.setEmail(candidate.getEmail());
			candidateInfo.setWorkMobile(candidate.getWorkMobile());
			candidateInfo.setCandidateStatus(candidate.getEnrollmentStatus());
			candidateInfo.setRecruiterName(candidate.getCreatedBy().getEmployeeName());
			followup.setCandidateInfo(candidateInfo);

			followUpService.addFollowup(followup);

			MaxFollowUp maxFollowUp = maxFollowUpService.findByCandidateId(candidate.getCandidateId());

			if(maxFollowUp == null){
				maxFollowUp = new MaxFollowUp();
				maxFollowUp.setMaxFollowUpDate(new Date());
				maxFollowUp.setRecruiterId(candidate.getCreatedBy().getEmployeeId());
				maxFollowUp.setCandidateId(candidate.getCandidateId());
				maxFollowUp.setCandidateName(candidate.getCandidateName());
				maxFollowUp.setCandidateEmail(candidate.getEmail());
				maxFollowUp.setCandidateWorkMobile(candidate.getWorkMobile());
				maxFollowUp.setCandidateStatus(candidate.getEnrollmentStatus());
				maxFollowUp.setRecruiterName(candidate.getCreatedBy().getEmployeeName());
				maxFollowUpService.addMaxFollowup(maxFollowUp); 
			}else{
				maxFollowUp.setMaxFollowUpDate(new Date());
				maxFollowUp.setRecruiterId(candidate.getCreatedBy().getEmployeeId());
				maxFollowUp.setCandidateId(candidate.getCandidateId());
				maxFollowUp.setCandidateName(candidate.getCandidateName());
				maxFollowUp.setCandidateEmail(candidate.getEmail());
				maxFollowUp.setCandidateWorkMobile(candidate.getWorkMobile());
				maxFollowUp.setCandidateStatus(candidate.getEnrollmentStatus());
				maxFollowUp.setRecruiterName(candidate.getCreatedBy().getEmployeeName());
				maxFollowUpService.updateMaxFollowUp(maxFollowUp); 
			}
			httpStatus = HttpStatus.OK;
		}catch(Exception e){
			e.printStackTrace();
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Candidate>(candidate, httpStatus);
	}


	@PostMapping(URLInfo.FREEPOOL_CANDIDATE_LIST)
	@PreAuthorize("hasAuthority('TRMSRES_CANDIDATE_LIST')")
	public ResponseEntity<?> getFreePoolCandidates(@RequestBody LazyLoadEvent lazyLoadEvent,HttpServletRequest request){

		HttpStatus httpStatus = null;
		LazyFreepoolCandidateDto lazyFreepoolCandidateDto = null;
		try{
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			cal.add(Calendar.DATE, -30);
			Date dateBefore30Days = cal.getTime();

			lazyFreepoolCandidateDto = maxFollowUpService.list(lazyLoadEvent, dateBefore30Days);

			if(lazyFreepoolCandidateDto == null){
				httpStatus = HttpStatus.NO_CONTENT;
			}else{
				httpStatus = HttpStatus.OK;
			}
		}catch(Exception e){
			e.printStackTrace();
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<LazyFreepoolCandidateDto>(lazyFreepoolCandidateDto,httpStatus);
	}


	@GetMapping(URLInfo.FREEPOOL_CANDIDATE_TRANSFER)
	@PreAuthorize("hasAuthority('TRMSRES_FREEPOOL_CANDIDATE_TRANSFER')")
	public ResponseEntity<?> freepoolCandidateTransfer(@PathVariable("candidateId") String candidateId,HttpServletRequest request){

		HttpStatus httpStatus = null;
		Candidate candidate = null;
		try{

			Employee employee = employeeService.getEmployeeByUsername(request, request.getUserPrincipal().getName());

			candidate = candidateService.findCandidateById(candidateId);

			CreatedBy createdBy = candidate.getCreatedBy();
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
			candidate.setNextFollowupDate(new Date());

			candidateService.updateCandidate(candidate);

			FollowUp followup = new FollowUp();
			followup.setFollowupDate(new Date());
			followup.setFollowupRemarks("Got candidate from freepool By "+candidate.getCreatedBy().getEmployeeName());
			followup.setEmployeeId(candidate.getCreatedBy().getEmployeeId());
			CandidateInfo candidateInfo = new CandidateInfo();
			candidateInfo.setCandidateId(candidate.getCandidateId());
			candidateInfo.setCandidateName(candidate.getCandidateName());
			candidateInfo.setEmail(candidate.getEmail());
			candidateInfo.setWorkMobile(candidate.getWorkMobile());
			candidateInfo.setCandidateStatus(candidate.getEnrollmentStatus());
			candidateInfo.setRecruiterName(candidate.getCreatedBy().getEmployeeName());
			followup.setCandidateInfo(candidateInfo);

			followUpService.addFollowup(followup);

			MaxFollowUp maxFollowUp = maxFollowUpService.findByCandidateId(candidate.getCandidateId());

			maxFollowUp.setMaxFollowUpDate(new Date());
			maxFollowUp.setRecruiterId(candidate.getCreatedBy().getEmployeeId());
			maxFollowUp.setRecruiterName(candidate.getCreatedBy().getEmployeeName());
			maxFollowUpService.updateMaxFollowUp(maxFollowUp); 
			httpStatus = HttpStatus.OK;
		}catch(Exception e){
			e.printStackTrace();
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Candidate>(candidate,httpStatus);
	}



	@PostMapping(URLInfo.SEARCH_CANDIDATE)
	@PreAuthorize("hasAuthority('TRMSRES_CANDIDATE_SEARCH')")
	public ResponseEntity<?> searchCandidate(@RequestBody SearchDto searchDto){

		HttpStatus httpStatus = null;
		Candidate candidate = null;
		try{
			candidate = candidateService.searchCandidate(searchDto);
			if(candidate == null){
				httpStatus = HttpStatus.NO_CONTENT;
			}else{
				httpStatus = HttpStatus.OK;
			}
		}catch(Exception e){
			e.printStackTrace();
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Candidate>(candidate,httpStatus);
	}


	@PostMapping(URLInfo.ALL_CANDIDATE_LAZY_LIST)
	@PreAuthorize("hasAuthority('TRMSRES_CANDIDATE_LIST')")
	public ResponseEntity<?> candidateList(@RequestBody LazyLoadEvent lazyLoadEvent){

		HttpStatus httpStatus = null;
		LazyCandidateDto lazyCandidateDto = null;
		try{
			lazyCandidateDto = candidateService.list(lazyLoadEvent);
			if(lazyCandidateDto == null){
				httpStatus = HttpStatus.NO_CONTENT;
			}else{
				httpStatus = HttpStatus.OK;
			}
		}catch(Exception e){
			e.printStackTrace();
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<LazyCandidateDto>(lazyCandidateDto,httpStatus);
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