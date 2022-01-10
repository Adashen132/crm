package com.cyb.crm.workbench.service.impl;

import com.cyb.crm.settings.dao.UserDao;
import com.cyb.crm.utils.SqlSessionUtil;
import com.cyb.crm.utils.UUIDUtil;
import com.cyb.crm.workbench.dao.*;
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

    //线索相关表
    private ClueDao clueDao = SqlSessionUtil.getSqlSession().getMapper(ClueDao.class);
    private ClueActivityRelationDao clueActivityRelationDao = SqlSessionUtil.getSqlSession().getMapper(ClueActivityRelationDao.class);
    private ClueRemarkDao clueRemarkDao = SqlSessionUtil.getSqlSession().getMapper(ClueRemarkDao.class);

    //客户相关表
    private CustomerDao customerDao = SqlSessionUtil.getSqlSession().getMapper(CustomerDao.class);
    private CustomerRemarkDao customerRemarkDao = SqlSessionUtil.getSqlSession().getMapper(CustomerRemarkDao.class);

    //联系人相关表
    private ContactsDao contactsDao = SqlSessionUtil.getSqlSession().getMapper(ContactsDao.class);
    private ContactsRemarkDao contactsRemarkDao = SqlSessionUtil.getSqlSession().getMapper(ContactsRemarkDao.class);
    private ContactsActivityRelationDao contactsActivityRelationDao = SqlSessionUtil.getSqlSession().getMapper(ContactsActivityRelationDao.class);

    //交易相关表
    private TranDao tranDao = SqlSessionUtil.getSqlSession().getMapper(TranDao.class);
    private TranHistoryDao tranHistoryDao = SqlSessionUtil.getSqlSession().getMapper(TranHistoryDao.class);

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

    @Override
    public boolean bund(String cid, String[] aids) {

        boolean flag = true;
        for(String aid:aids){
            //取得买一个aid和cid做关联
            ClueActivityRelation car = new ClueActivityRelation();
            car.setId(UUIDUtil.getUUID());
            car.setClueId(cid);
            car.setActivityId(aid);
            //添加关联关系表中的记录
            int count = clueActivityRelationDao.bund(car);
            if(count != 1){
                flag = false;
            }
        }
        return flag;
    }

    @Override
    public boolean convert() {
        boolean flag = true;

        return flag;
    }
}
