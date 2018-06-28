package com.ayantsoft.trms.resourcing.controller;

import java.io.Serializable;
import java.security.Principal;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ayantsoft.trms.resourcing.dto.CandidateDto;
import com.ayantsoft.trms.resourcing.info.URLInfo;
import com.ayantsoft.trms.resourcing.model.Candidate;
import com.ayantsoft.trms.resourcing.model.CreatedBy;
import com.ayantsoft.trms.resourcing.service.CandidateService;

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
	private RestTemplate restTemplate;

	@PostMapping(URLInfo.CREATECANDIDATE)
	@PreAuthorize("hasAuthority('TRMSRES_CANDIDATE_CREATE')")
	public ResponseEntity<?> addCandidate(@RequestBody CandidateDto candidateDto,HttpServletRequest request){
		HttpStatus httpStatus = null; 
		try{

			Candidate candidate = new Candidate();
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
			createdBy.setEmployeeId("1");
			createdBy.setEmployeeName("Mriganka Koley");
			createdBy.setEmployeeEmail("mriganka@gmail.com");
			createdBy.setEmployeePhone("7679813180");
			
			candidate.setCreatedBy(createdBy); 
		
			/*Principal principal = request.getUserPrincipal();
			System.out.println("=============== >>>   "+principal.getName());*/

			candidateService.addCandidate(candidate);
			httpStatus = HttpStatus.CREATED;
		}catch(Exception e){
			e.printStackTrace();
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<CandidateDto>(candidateDto, httpStatus);
	}





}