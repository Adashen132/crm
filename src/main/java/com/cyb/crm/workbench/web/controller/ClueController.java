package com.cyb.crm.workbench.web.controller;

import com.cyb.crm.settings.domain.User;
import com.cyb.crm.settings.service.UserService;
import com.cyb.crm.settings.service.impl.UserServiceImpl;
import com.cyb.crm.utils.DateTimeUtil;
import com.cyb.crm.utils.PrintJson;
import com.cyb.crm.utils.ServiceFactory;
import com.cyb.crm.utils.UUIDUtil;
import com.cyb.crm.vo.PaginationVO;
import com.cyb.crm.workbench.domain.Activity;
import com.cyb.crm.workbench.domain.ActivityRemark;
import com.cyb.crm.workbench.service.ActivityService;
import com.cyb.crm.workbench.service.impl.ActivityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Service层是建立在DAO层之上的，建立了DAO层后才可以建立Service层，而Service层又是在Controller层之下的，
 * 因而Service层应该既调用DAO层的接口，又要提供接口给Controller层的类来进行调用，
 * 它刚好处于一个中间层的位置。每个模型都有一个Service接口，每个接口分别封装各自的业务处理方法
 */

/**
 * @author ccc
 * @create 2021-12-29 11:34
 */
//controller是界面层（servlet）
public class ClueController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入到线索clue控制器");
        String path = request.getServletPath();

        if ("/workbench/clue/getUserList.do".equals(path)) {
//            getUserList(request, response);
        } else if ("/workbench/clue/save.do".equals(path)) {
//            save(request, response);
        }
    }



}
