package com.ayantsoft.trms.resourcing.model;

import java.io.Serializable;

public class IncentiveStructure implements Serializable {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = -6126273093365576875L;
	
	private Double targetLowerLimit;
	private Double targetHigherLimit;
	private Double incentiveInInr;
	private String typeFor;
	
	
	public Double getTargetLowerLimit() {
		return targetLowerLimit;
	}
	public void setTargetLowerLimit(Double targetLowerLimit) {
		this.targetLowerLimit = targetLowerLimit;
	}
	public Double getTargetHigherLimit() {
		return targetHigherLimit;
	}
	public void setTargetHigherLimit(Double targetHigherLimit) {
		this.targetHigherLimit = targetHigherLimit;
	}
	public Double getIncentiveInInr() {
		return incentiveInInr;
	}
	public void setIncentiveInInr(Double incentiveInInr) {
		this.incentiveInInr = incentiveInInr;
	}
	public String getTypeFor() {
		return typeFor;
	}
	public void setTypeFor(String typeFor) {
		this.typeFor = typeFor;
	}
}
