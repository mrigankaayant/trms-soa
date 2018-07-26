package com.ayantsoft.trms.finance.dto;

import java.io.Serializable;
import java.util.List;

import com.ayantsoft.trms.finance.model.Candidate;

public class LazyCandidateDto implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3029603268574410048L;
	
	private List<Candidate> candidateList;
	private long pageSize;
	private int pageNumber;
	
	public LazyCandidateDto(){
		
	}
	
	public LazyCandidateDto(List<Candidate> candidateList,long pageSize,int pageNumber){
		this.candidateList = candidateList;
		this.pageSize = pageSize;
		this.pageNumber = pageNumber;
	}

	public List<Candidate> getCandidateList() {
		return candidateList;
	}

	public void setCandidateList(List<Candidate> candidateList) {
		this.candidateList = candidateList;
	}

	public long getPageSize() {
		return pageSize;
	}

	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
}
