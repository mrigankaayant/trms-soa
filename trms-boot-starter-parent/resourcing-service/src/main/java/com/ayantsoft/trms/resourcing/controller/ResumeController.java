package com.ayantsoft.trms.resourcing.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.ayantsoft.trms.resourcing.info.URLInfo;
import com.ayantsoft.trms.resourcing.model.Candidate;
import com.ayantsoft.trms.resourcing.model.Documents;
import com.ayantsoft.trms.resourcing.model.ResumeInfo;
import com.ayantsoft.trms.resourcing.service.CandidateService;
import com.ayantsoft.trms.resourcing.service.DocumentService;
import com.ayantsoft.trms.resourcing.service.ResumeService;

@RestController
@RequestMapping(URLInfo.ROOTURL)
public class ResumeController implements Serializable {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = 8587901677157896086L;

	@Autowired
	private ResumeService resumeService;

	@Autowired
	private DocumentService documentService;
	
	@Autowired
	private CandidateService candidateService;


	@PostMapping(URLInfo.UPLOAD_RESUME)
	@PreAuthorize("hasAuthority('TRMSRES_CANDIDATE_CREATE')")
	public ResponseEntity<?> uploadResume(@RequestParam("file") MultipartFile file,@PathVariable String candidateId,@PathVariable String candidateName){
			
		HttpStatus httpStatus = null;
		String filename = candidateName+"_"+candidateId;
		try{
			if(file != null){
				File convFile = new File(file.getOriginalFilename());
				convFile.createNewFile(); 
				FileOutputStream fos = new FileOutputStream(convFile); 
				fos.write(file.getBytes());
				fos.close(); 
				resumeService.uploadResume(candidateName+"_"+candidateId,convFile,file.getContentType());
			}

			Documents document = new Documents();
			document.setCandidateId(candidateId);
			document.setCandidateName(candidateName);
			document.setDocumentName("resume");
			document.setFileName(filename);

			documentService.save(document);
			
			Candidate candidate = candidateService.findCandidateById(candidateId);
			
			ResumeInfo resumeInfo = new ResumeInfo();
			resumeInfo.setDocumentId(document.getDocumentId());
			resumeInfo.setDocumentName(document.getDocumentName());
			resumeInfo.setFileName(document.getFileName());
			
			candidate.setResumeInfo(resumeInfo);
			
			candidateService.updateCandidate(candidate); 
			httpStatus = HttpStatus.OK;
		}catch(Exception e){
			e.printStackTrace();
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(httpStatus);
	}


	@GetMapping(URLInfo.DOWNLOAD_RESUME)
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public ResponseEntity<?> downloadFilebyID(@PathVariable("fileName")String fileName) throws IOException {
		HttpStatus httpStatus = null;
		InputStreamResource in = null;
		try{
			in = resumeService.downResume(fileName);
			if(in == null){
				httpStatus = HttpStatus.NO_CONTENT;
			}else{
				httpStatus = HttpStatus.OK;
			}
		}catch(Exception e){
			e.printStackTrace();
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<InputStreamResource>(in,httpStatus);
	}


}
