package com.ayantsoft.trms.resourcing.lazy.model;

import java.io.Serializable;
import java.util.List;
import com.ayantsoft.trms.resourcing.model.PhoneLogs;

public class LazyPhoneLogDto implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7811972034748187750L;
	
	
	private List<PhoneLogs> phoneLogs;
	private long pageSize;
	private int pageNumber;
	
	
	public LazyPhoneLogDto(){
		
	}
	
	public LazyPhoneLogDto(List<PhoneLogs> phoneLogs,long pageSize,int pageNumber){
		this.phoneLogs = phoneLogs;
		this.pageSize = pageSize;
		this.pageNumber = pageNumber;
	}

	public List<PhoneLogs> getPhoneLogs() {
		return phoneLogs;
	}

	public void setPhoneLogs(List<PhoneLogs> phoneLogs) {
		this.phoneLogs = phoneLogs;
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
