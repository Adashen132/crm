package com.cyb.crm.workbench.service.impl;


import com.cyb.crm.utils.SqlSessionUtil;
import com.cyb.crm.workbench.dao.CustomerDao;
import com.cyb.crm.workbench.service.CustomerService;

import java.util.List;


/**
 * Author 北京动力节点
 */
public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao = SqlSessionUtil.getSqlSession().getMapper(CustomerDao.class);

    @Override
    public List<String> getCustomerName(String name) {
        List<String> sList = customerDao.getCustomerName(name);
        return sList;
    }
}
















