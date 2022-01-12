package com.cyb.crm.workbench.dao;

import com.cyb.crm.workbench.domain.Tran;

public interface TranDao {

    int save(Tran t);

    Tran detail(String id);
}
