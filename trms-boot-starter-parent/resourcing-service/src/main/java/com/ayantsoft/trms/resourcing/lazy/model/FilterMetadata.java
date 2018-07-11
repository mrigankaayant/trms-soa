package com.ayantsoft.trms.resourcing.lazy.model;

public class FilterMetadata {
	
	private Object value;
    private String matchMode;
    
    
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public String getMatchMode() {
		return matchMode;
	}
	public void setMatchMode(String matchMode) {
		this.matchMode = matchMode;
	}
}
