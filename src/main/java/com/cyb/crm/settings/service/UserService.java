package com.cyb.crm.settings.service;

import com.cyb.crm.exception.LoginException;
import com.cyb.crm.settings.domain.User;

import java.util.List;

/**
 * @author ccc
 * @create 2021-12-29 11:31
 */
public interface UserService {
    User login(String loginAct, String loginPwd, String ip) throws LoginException;

    List<User> getUserList();
}
