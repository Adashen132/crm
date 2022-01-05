package com.cyb.crm.workbench.dao;

import com.cyb.crm.workbench.domain.Activity;

import java.util.HashMap;
import java.util.List;

/**
 * @author ccc
 * @create 2021-12-30 15:21
 */
public interface ActivityDao {
    int save(Activity a);

    List<Activity> getActivityListByCondition(HashMap<String, Object> map);

    int getTotalByCondition(HashMap<String, Object> map);

    int delete(String[] ids);

    Activity getById(String id);

    int update(Activity a);

    Activity detail(String id);
}
