package com.cyb.crm.workbench.service;

import com.cyb.crm.workbench.domain.Clue;
import com.cyb.crm.workbench.domain.Tran;

/**
 * Author 北京动力节点
 */
public interface ClueService {

    Boolean save(Clue c);

    Clue detail(String id);

    boolean unbund(String id);

    boolean bund(String cid, String[] aids);
}
