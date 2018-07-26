package com.ayantsoft.trms.finance.lazy.model;

import java.util.Map;

public class LazyLoadEvent {
	
	private int first;
    private int rows;
    private String sortField;
    private int sortOrder;
    private Object globalFilter;
    private SortMeta[] multiSortMeta;
    private Map<String,FilterMetadata> filters;
    
    
	public int getFirst() {
		return first;
	}
	public void setFirst(int first) {
		this.first = first;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public String getSortField() {
		return sortField;
	}
	public void setSortField(String sortField) {
		this.sortField = sortField;
	}
	public int getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}
	public Object getGlobalFilter() {
		return globalFilter;
	}
	public void setGlobalFilter(Object globalFilter) {
		this.globalFilter = globalFilter;
	}
	public SortMeta[] getMultiSortMeta() {
		return multiSortMeta;
	}
	public void setMultiSortMeta(SortMeta[] multiSortMeta) {
		this.multiSortMeta = multiSortMeta;
	}
	public Map<String, FilterMetadata> getFilters() {
		return filters;
	}
	public void setFilters(Map<String, FilterMetadata> filters) {
		this.filters = filters;
	}
}
