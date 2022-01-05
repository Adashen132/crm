package com.cyb.crm.settings.service.impl;


import com.cyb.crm.settings.dao.DicTypeDao;
import com.cyb.crm.settings.dao.DicValueDao;
import com.cyb.crm.settings.service.DicService;
import com.cyb.crm.utils.SqlSessionUtil;

public class DicServiceImpl implements DicService {
    private DicTypeDao dicTypeDao = SqlSessionUtil.getSqlSession().getMapper(DicTypeDao.class);
    private DicValueDao dicValueDao = SqlSessionUtil.getSqlSession().getMapper(DicValueDao.class);

}




















