package com.cyb.crm.workbench.service;

import com.cyb.crm.vo.PaginationVO;
import com.cyb.crm.workbench.domain.Activity;
import com.cyb.crm.workbench.domain.ActivityRemark;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ccc
 * @create 2021-12-30 15:26
 */
public interface ActivityService {
    boolean save(Activity a);

    PaginationVO<Activity> pageList(HashMap<String, Object> map);//传入条件map（name,owner...），输出VO（total总条数、Activity）

    boolean delete(String[] ids);

    Map<String, Object> getUserListAndActivity(String id);

    boolean update(Activity a);

    Activity detail(String id);

    List<ActivityRemark> getRemarkListByAid(String activityId);

    boolean deleteRemark(String id);


    boolean saveRemark(ActivityRemark ar);

    boolean updateRemark(ActivityRemark ar);

    List<Activity> getActivityListByClueId(String clueId);
}
