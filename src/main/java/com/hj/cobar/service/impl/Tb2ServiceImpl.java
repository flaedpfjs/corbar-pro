package com.hj.cobar.service.impl;

import com.hj.cobar.bean.Tb2;
import com.hj.cobar.dao.Tb2DAO;
import com.hj.cobar.service.Tb2Service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;

/**
 * Created by hesheng on 14-12-2.
 */
@Service("tb2Service")
public class Tb2ServiceImpl implements Tb2Service {
    private static final Log log = LogFactory.getLog(Tb2ServiceImpl.class);

    @Resource
    Tb2DAO tb2DAO;

    @Override
    public Integer addTb2(Tb2 tb2) {
        try {
            return tb2DAO.addTb2(tb2);
        } catch (SQLException e) {
            log.error("todo", e);
            return 0;
        }
    }

    @Override
    public Tb2 getTb2ById(Integer id) {
        try {
            return tb2DAO.getTb2ById(id);
        } catch (Exception e) {
            log.error("todo", e);
            return null;
        }
    }
}
