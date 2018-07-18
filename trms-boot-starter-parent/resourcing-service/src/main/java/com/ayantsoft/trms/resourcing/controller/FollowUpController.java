package com.ayantsoft.trms.resourcing.controller;

import java.io.Serializable;
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
import com.ayantsoft.trms.resourcing.info.URLInfo;
import com.ayantsoft.trms.resourcing.model.Candidate;
import com.ayantsoft.trms.resourcing.model.CandidateInfo;
import com.ayantsoft.trms.resourcing.model.Employee;
import com.ayantsoft.trms.resourcing.model.FollowUp;
import com.ayantsoft.trms.resourcing.model.MaxFollowUp;
import com.ayantsoft.trms.resourcing.service.CandidateService;
import com.ayantsoft.trms.resourcing.service.EmployeeService;
import com.ayantsoft.trms.resourcing.service.FollowUpService;
import com.ayantsoft.trms.resourcing.service.MaxFollowUpService;

@RestController
@RequestMapping(URLInfo.ROOTURL)
public class FollowUpController implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7348811967903172874L;


	@Autowired
	private FollowUpService followUpService;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private CandidateService candidateService;

	@Autowired
	private MaxFollowUpService maxFollowUpService;



	@GetMapping(URLInfo.FOLLOWUP_LIST)
	@PreAuthorize("hasAuthority('TRMSRES_FOLLOWUP_LIST')")
	public ResponseEntity<?> followupList(@PathVariable("candidateId") String candidateId){

		HttpStatus httpStatus = null;
		List<FollowUp> followUpList = null;
		try{
			followUpList = followUpService.listByCandidateId(candidateId);

			if(followUpList == null){
				httpStatus = HttpStatus.NO_CONTENT;
			}else{
				httpStatus = HttpStatus.OK;
			}
		}catch(Exception e){
			e.printStackTrace();
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<List<FollowUp>>(followUpList,httpStatus);
	}


	@PostMapping(URLInfo.CREATE_FOLLOWUP)
	@PreAuthorize("hasAuthority('TRMSRES_FOLLOWUP_CREATE')")
	public ResponseEntity<?> addFollowup(@Valid @RequestBody FollowUp followUp,HttpServletRequest request){

		HttpStatus httpStatus = null;
		try{

			Employee employee = employeeService.getEmployeeByUsername(request, request.getUserPrincipal().getName());

			Candidate candidate = candidateService.findCandidateById(followUp.getCandidateInfo().getCandidateId());

			followUp.setFollowupDate(new Date());
			followUp.setEmployeeId(employee.getEmployeeId());

			CandidateInfo candidateInfo = new CandidateInfo();
			candidateInfo.setCandidateId(candidate.getCandidateId());
			candidateInfo.setCandidateName(candidate.getCandidateName());
			candidateInfo.setCandidateStatus(candidate.getEnrollmentStatus());
			candidateInfo.setEmail(candidate.getEmail());
			candidateInfo.setRecruiterName(candidate.getCreatedBy().getEmployeeName());
			candidateInfo.setWorkMobile(candidate.getWorkMobile()); 

			followUp.setCandidateInfo(candidateInfo);
			followUpService.addFollowup(followUp);

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

			candidate.setNextFollowupDate(followUp.getScheduledDate());

			candidateService.updateCandidate(candidate); 

			httpStatus = HttpStatus.CREATED;
		}catch(Exception e){
			e.printStackTrace();
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<FollowUp>(followUp,httpStatus);
	}
}
