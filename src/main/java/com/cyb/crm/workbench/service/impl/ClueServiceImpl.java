package com.cyb.crm.workbench.service.impl;

import com.cyb.crm.settings.dao.UserDao;
import com.cyb.crm.utils.SqlSessionUtil;
import com.cyb.crm.workbench.dao.ActivityDao;
import com.cyb.crm.workbench.dao.ActivityRemarkDao;
import com.cyb.crm.workbench.dao.ClueActivityRelationDao;
import com.cyb.crm.workbench.dao.ClueDao;
import com.cyb.crm.workbench.domain.Clue;
import com.cyb.crm.workbench.domain.ClueActivityRelation;
import com.cyb.crm.workbench.service.ClueService;

/**
 * @author ccc
 * @create 2022-01-05 14:32
 */
public class ClueServiceImpl implements ClueService {
//    private ActivityDao activityDao = SqlSessionUtil.getSqlSession().getMapper(ActivityDao.class);
//    private ActivityRemarkDao activityRemarkDao = SqlSessionUtil.getSqlSession().getMapper(ActivityRemarkDao.class);
//    private UserDao userDao = SqlSessionUtil.getSqlSession().getMapper(UserDao.class);

    private ClueDao clueDao = SqlSessionUtil.getSqlSession().getMapper(ClueDao.class);
    private ClueActivityRelationDao clueActivityRelationDao = SqlSessionUtil.getSqlSession().getMapper(ClueActivityRelationDao.class);

    @Override
    public Boolean save(Clue c) {
        boolean flag = true;
        int count = clueDao.save(c);
        if(count != 1){
            flag = false;
        }
        return  flag;
    }

    @Override
    public Clue detail(String id) {
        Clue c = clueDao.detail(id);
        return c;
    }

    @Override
    public boolean unbund(String id) {
        boolean flag = true;
        int count = clueActivityRelationDao.unbund(id);
        if(count != 1){
            flag = false;
        }
        return  flag;

    }
}
