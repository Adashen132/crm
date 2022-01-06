package com.cyb.crm.settings.dao;


import com.cyb.crm.settings.domain.DicValue;

import java.util.List;

public interface DicValueDao {
    List<DicValue> getListByCode(String code);
}
