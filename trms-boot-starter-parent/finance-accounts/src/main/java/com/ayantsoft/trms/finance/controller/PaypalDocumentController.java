package com.ayantsoft.trms.finance.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.ayantsoft.trms.finance.info.URLInfo;
import com.ayantsoft.trms.finance.model.Candidate;
import com.ayantsoft.trms.finance.model.CandidateInfo;
import com.ayantsoft.trms.finance.model.Documents;
import com.ayantsoft.trms.finance.model.Employee;
import com.ayantsoft.trms.finance.model.PaymentDetails;
import com.ayantsoft.trms.finance.model.PaypalDocInfo;
import com.ayantsoft.trms.finance.model.VerifiedBy;
import com.ayantsoft.trms.finance.service.CandidateService;
import com.ayantsoft.trms.finance.service.DocumentService;
import com.ayantsoft.trms.finance.service.EmployeeService;
import com.ayantsoft.trms.finance.service.PaymentService;
import com.ayantsoft.trms.finance.service.PaypalDocumentService;

@RestController
@RequestMapping(URLInfo.ROOTURL)
public class PaypalDocumentController implements Serializable{
	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = 397314517040818220L;

	@Autowired
	private PaypalDocumentService paypalDocumentService;

	@Autowired
	private DocumentService documentService;
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private CandidateService candidateService;
	
	@Autowired
	private EmployeeService employeeService;


	@PostMapping(URLInfo.UPLOAD_PAYPAL_DOCUMENT)
	@PreAuthorize("hasAuthority('TRMSRES_CANDIDATE_CREATE')")
	public ResponseEntity<?> uploadPaypalDoc(HttpServletRequest request,@RequestParam("file") MultipartFile file,
			                                         @PathVariable String candidateId,@PathVariable String candidateName,@PathVariable String paymentId){

		HttpStatus httpStatus = null;
		String filename = candidateName+"_"+candidateId+"_"+paymentId;
		try{
			if(file != null){
				File convFile = new File(file.getOriginalFilename());
				convFile.createNewFile(); 
				FileOutputStream fos = new FileOutputStream(convFile); 
				fos.write(file.getBytes());
				fos.close(); 
				paypalDocumentService.uploadPaypalDocument(filename,convFile,file.getContentType());
			}

			Documents document = new Documents();
			document.setCandidateId(candidateId);
			document.setCandidateName(candidateName);
			document.setDocumentName("paypal_doc");
			document.setFileName(filename);

			documentService.save(document);
			
			PaymentDetails paymentDetails = paymentService.findById(paymentId);
			Candidate candidate = candidateService.findCandidateById(request, candidateId);
			
			paymentDetails.setStatus("VERIFIED");
			paymentDetails.setCreatedDate(new Date());
			
			Calendar now = Calendar.getInstance();
			int year = now.get(Calendar.YEAR);
			String  month = new SimpleDateFormat("MMM").format(now.getTime());
			
			paymentDetails.setCreatedYear(String.valueOf(year));
			paymentDetails.setCreatedMonth(month);
			
			CandidateInfo candidateInfo = new CandidateInfo();
			candidateInfo.setCandidateId(candidateId);
			candidateInfo.setCandidateName(candidate.getCandidateName());
			candidateInfo.setEmail(candidate.getEmail());
			if(candidate.getAltEmail() != null){
				candidateInfo.setAltEmail(candidate.getAltEmail());
			}
			candidateInfo.setWorkMobile(candidate.getWorkMobile());
			if(candidate.getPhone() != null){
				candidateInfo.setPhone(candidate.getPhone());
			}
			if(candidate.getCourseFee() != null){
				candidateInfo.setCourseFee(candidate.getCourseFee());
			}
			if(candidate.getCreatedBy() != null){
				candidateInfo.setCreatedBy(candidate.getCreatedBy());
			}
			
			paymentDetails.setCandidateInfo(candidateInfo); 
			
			Employee employee = employeeService.getEmployeeByUsername(request, request.getUserPrincipal().getName());
			VerifiedBy verifiedBy = new VerifiedBy();
			verifiedBy.setEmailId(employee.getEmployeeId());
			verifiedBy.setName(employee.getName());
			verifiedBy.setWorkPhone(employee.getWorkMobile());
			verifiedBy.setEmailId(employee.getEmployeeId());
			
			paymentDetails.setVerifiedBy(verifiedBy);
			
			PaypalDocInfo paypalDocInfo = new PaypalDocInfo();
			paypalDocInfo.setDocumentId(document.getDocumentId());
			paypalDocInfo.setDocumentName(document.getDocumentName());
			paypalDocInfo.setFileName(document.getFileName());
			
			paymentDetails.setPaypalDocInfo(paypalDocInfo);
			
			paymentService.update(paymentDetails); 
			
			httpStatus = HttpStatus.OK;
		}catch(Exception e){
			e.printStackTrace();
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(httpStatus);
	}

}
