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
import com.cyb.crm.workbench.domain.Clue;
import com.cyb.crm.workbench.service.ActivityService;
import com.cyb.crm.workbench.service.ClueService;
import com.cyb.crm.workbench.service.impl.ActivityServiceImpl;
import com.cyb.crm.workbench.service.impl.ClueServiceImpl;

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
            getUserList(request, response);
        } else if ("/workbench/clue/save.do".equals(path)) {
            save(request, response);
        }else if ("/workbench/clue/detail.do".equals(path)) {
            detail(request, response);
        }else if ("/workbench/clue/getActivityListByClueId.do".equals(path)) {
            getActivityListByClueId(request, response);
        }
    }

    private void getActivityListByClueId(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("根据线索id查询关联的市场活动列表");
        String clueId = request.getParameter("clueId");
        ActivityService as = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());
        List<Activity> aList = as.getActivityListByClueId(clueId);
        PrintJson.printJsonObj(response,aList);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        System.out.println("跳转到线索详细信息页");
        String id = request.getParameter("id");
        ClueService cs = (ClueService) ServiceFactory.getService(new ClueServiceImpl());
        Clue c = cs.detail(id);
        request.setAttribute("c",c);
        request.getRequestDispatcher("/workbench/clue/detail.jsp").forward(request,response);
    }


    private void save(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("执行线索的添加操作");
        String id = UUIDUtil.getUUID();
        String fullname = request.getParameter("fullname");
        String appellation = request.getParameter("appellation");
        String owner = request.getParameter("owner");
        String company = request.getParameter("company");
        String job = request.getParameter("job");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String website = request.getParameter("website");
        String mphone = request.getParameter("mphone");
        String state = request.getParameter("state");
        String source = request.getParameter("source");
        String createBy = ((User) request.getSession().getAttribute("user")).getName();//创建人：当前登录用户
        String createTime = DateTimeUtil.getSysTime();//创建时间：当前系统时间
        String description = request.getParameter("description");
        String contactSummary = request.getParameter("contactSummary");
        String nextContactTime = request.getParameter("nextContactTime");
        String address = request.getParameter("address");

        Clue c = new Clue();
        c.setId(id);
        c.setAddress(address);
        c.setWebsite(website);
        c.setState(state);
        c.setSource(source);
        c.setPhone(phone);
        c.setOwner(owner);
        c.setNextContactTime(nextContactTime);
        c.setMphone(mphone);
        c.setJob(job);
        c.setFullname(fullname);
        c.setEmail(email);
        c.setDescription(description);
        c.setCreateTime(createTime);
        c.setCreateBy(createBy);
        c.setContactSummary(contactSummary);
        c.setCompany(company);
        c.setAppellation(appellation);

        ClueService cs = (ClueService) ServiceFactory.getService(new ClueServiceImpl());
        Boolean flag = cs.save(c);
        PrintJson.printJsonFlag(response,flag);
    }
    private void getUserList(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("取得用户信息列表");
        UserService us = (UserService) ServiceFactory.getService(new UserServiceImpl());
        List<User> uList = us.getUserList();
        PrintJson.printJsonObj(response,uList);
    }


}
