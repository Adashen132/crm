package com.cyb.crm.workbench.service;

import com.cyb.crm.workbench.domain.Tran;
import com.cyb.crm.workbench.domain.TranHistory;

import java.util.List;
import java.util.Map;

/**
 * Author 北京动力节点
 */
public interface TranService {

    boolean save(Tran t, String customerName);

    Tran detail(String id);

    List<TranHistory> getHistoryListByTranId(String tranId);
}
