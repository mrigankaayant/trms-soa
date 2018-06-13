package com.ayantsoft.trms.resourcing.model;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sequence")
public class Sequence implements Serializable{
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4343342501058961035L;
	
	
	@Id
	private String id;
	private long seq;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getSeq() {
		return seq;
	}
	public void setSeq(long seq) {
		this.seq = seq;
	}
}
