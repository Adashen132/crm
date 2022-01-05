package com.cyb.crm.settings.dao;

import com.cyb.crm.settings.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @author ccc
 * @create 2021-12-29 11:28
 */
public interface UserDao {

    User login(Map<String, String> map);

    List<User> getUserList();
}
