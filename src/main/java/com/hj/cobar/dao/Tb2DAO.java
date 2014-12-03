package com.hj.cobar.dao;

import com.hj.cobar.bean.Cont;
import com.hj.cobar.bean.Tb2;
import com.hj.cobar.common.Result;
import com.hj.cobar.query.ContQuery;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hj
 * @date 2013-12-11
 */

@Repository
public class Tb2DAO {

	@Resource
	SqlMapClientTemplate sqlMapClientTemplate;

	public Integer addTb2(Tb2 tb2) throws SQLException {
		return (Integer) this.sqlMapClientTemplate.insert("Tb2.insertTb2", tb2);
	}

	/**
	 * 根据主键查找
	 *
	 * @throws java.sql.SQLException
	 */
	public Tb2 getTb2ById(Integer id) throws SQLException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		Tb2 result = (Tb2) this.sqlMapClientTemplate.queryForObject(
				"Tb2.getTb2Key", params);
		return result;
	}

}