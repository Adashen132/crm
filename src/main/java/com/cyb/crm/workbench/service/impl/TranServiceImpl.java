package com.cyb.crm.workbench.service.impl;

import com.cyb.crm.utils.SqlSessionUtil;
import com.cyb.crm.workbench.dao.TranDao;
import com.cyb.crm.workbench.dao.TranHistoryDao;
import com.cyb.crm.workbench.service.TranService;

/**
 * @author ccc
 * @create 2022-01-11 9:59
 */
public class TranServiceImpl implements TranService {
    private TranDao tranDao = SqlSessionUtil.getSqlSession().getMapper(TranDao.class);
    private TranHistoryDao tranHistoryDao = SqlSessionUtil.getSqlSession().getMapper(TranHistoryDao.class);
}
