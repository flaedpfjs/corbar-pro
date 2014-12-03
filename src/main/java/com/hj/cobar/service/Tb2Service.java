package com.hj.cobar.service;

import com.hj.cobar.bean.Tb2;

/**
 * @author hj
 * @since 2013-12-11
 */
public interface Tb2Service {
	/**
	 * 基本插入
	 * 
	 * @return
	 */
	public Integer addTb2(Tb2 tb2);

	/**
	 * 根据主键查询
	 */
	public Tb2 getTb2ById(Integer id);

}
