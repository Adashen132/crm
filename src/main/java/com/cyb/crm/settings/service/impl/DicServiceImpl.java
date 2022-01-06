package com.cyb.crm.settings.service.impl;


import com.cyb.crm.settings.dao.DicTypeDao;
import com.cyb.crm.settings.dao.DicValueDao;
import com.cyb.crm.settings.domain.DicValue;
import com.cyb.crm.settings.service.DicService;
import com.cyb.crm.utils.SqlSessionUtil;

import java.util.List;
import java.util.Map;

public class DicServiceImpl implements DicService {
    private DicTypeDao dicTypeDao = SqlSessionUtil.getSqlSession().getMapper(DicTypeDao.class);
    private DicValueDao dicValueDao = SqlSessionUtil.getSqlSession().getMapper(DicValueDao.class);

    @Override
    public Map<String, List<DicValue>> getAll() {
        return null;
    }
}




















