package com.ayantsoft.trms.resourcing.model;

import java.util.List;

public class Children {
	
	private String label;
	private boolean expanded;
	private List<Children> children;
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public boolean isExpanded() {
		return expanded;
	}
	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}
	public List<Children> getChildren() {
		return children;
	}
	public void setChildren(List<Children> children) {
		this.children = children;
	}
	
	
}
