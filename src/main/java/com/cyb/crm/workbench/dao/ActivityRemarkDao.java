package com.cyb.crm.workbench.dao;

import com.cyb.crm.workbench.domain.ActivityRemark;

import java.util.List;

/**
 * @author ccc
 * @create 2021-12-30 16:33
 */
public interface ActivityRemarkDao {

    int getCountByAids(String[] ids);

    int deleteByAids(String[] ids);

    List<ActivityRemark> getRemarkListByAid(String activityId);

    int deleteById(String id);

    int saveRemark(ActivityRemark ar);

    int updateRemark(ActivityRemark ar);
}
