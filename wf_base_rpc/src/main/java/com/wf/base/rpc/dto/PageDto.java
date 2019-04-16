package com.wf.base.rpc.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author zwf
 */
public class PageDto<T extends Serializable> implements Serializable{
	private List<T> data;

	private Long start;

	private Long length;

	private T p;

	private Long total;

	public PageDto(T entity, Long start, Long length) {
		this.p = entity;
		this.start = start;
		this.length = length;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public Long getStart() {
		return start;
	}

	public void setStart(Long start) {
		this.start = start;
	}

	public Long getLength() {
		return length;
	}

	public void setLength(Long length) {
		this.length = length;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public T getP() {
		return p;
	}

	public void setP(T p) {
		this.p = p;
	}
}
