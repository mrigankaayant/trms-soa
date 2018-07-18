package com.ayantsoft.trms.resourcing.lazy.model;

import java.io.Serializable;
import java.util.List;
import com.ayantsoft.trms.resourcing.model.MaxFollowUp;

public class LazyFreepoolCandidateDto implements Serializable {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = -1111305195581685062L;
	
	private List<MaxFollowUp> candidateList;
	private long pageSize;
	private long pageNumber;
	
	public LazyFreepoolCandidateDto(){
		
	}
	
	public LazyFreepoolCandidateDto(List<MaxFollowUp> candidateList,long pageSize,long pageNumber){
		this.candidateList = candidateList;
		this.pageSize = pageSize;
		this.pageNumber = pageNumber;
	}

	public List<MaxFollowUp> getCandidateList() {
		return candidateList;
	}

	public void setCandidateList(List<MaxFollowUp> candidateList) {
		this.candidateList = candidateList;
	}

	public long getPageSize() {
		return pageSize;
	}

	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}

	public long getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(long pageNumber) {
		this.pageNumber = pageNumber;
	}
}
