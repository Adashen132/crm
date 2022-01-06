package com.cyb.crm.settings.service.impl;


import com.cyb.crm.settings.dao.DicTypeDao;
import com.cyb.crm.settings.dao.DicValueDao;
import com.cyb.crm.settings.domain.DicType;
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
        //将字典类型列表取出，7种
        List<DicType> dtList =  dicTypeDao.getTypeList();
        //价格字典类型列表遍历
        for(DicType dt: dtList){
            //取得每一种类型的字典类型编码appellation、clueState...
            String code = dt.getCode();
            //根据每一个字典类型，来取得字典纸列表
            List<DicValue> dvList = dicValueDao.getListByCode(code);
        }
    }
}




















