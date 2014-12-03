package com.hj.cobar.bean;

import java.io.Serializable;

public class Tb2 implements Serializable {

	@Override
	public String toString() {
		return "Tb2 [id=" + getId() + ", val=" + getVal() + "]";
	}

	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 1L;

	private String  val;

	private int id;


	/**
	 * val
	 */
	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}