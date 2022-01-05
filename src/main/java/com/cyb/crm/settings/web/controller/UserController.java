package com.cyb.crm.settings.web.controller;

import com.cyb.crm.settings.domain.User;
import com.cyb.crm.settings.service.impl.UserServiceImpl;
import com.cyb.crm.settings.service.UserService;
import com.cyb.crm.utils.MD5Util;
import com.cyb.crm.utils.PrintJson;
import com.cyb.crm.utils.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
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
public class UserController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入到用户控制器");
        String path = request.getServletPath();
        if("/settings/user/login.do".equals(path)){
            login(request,response);
        }else if("/settings/user/xxx.do".equals(path)){
            //xxx(request,response);
        }
    }
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入到验证登录操作");
        String loginAct = request.getParameter("loginAct");
        String loginPwd = request.getParameter("loginPwd");
        //将密码进行转换
        loginPwd = MD5Util.getMD5(loginPwd);
        //接收浏览器端的ip地址
        String ip = request.getRemoteAddr();
        System.out.println("********************ip:"+ip);

        //未来业务层service开发，统一使用代理类形态的接口对象(service对象)。(Service层提供接口给Controller层的类来进行调用)
//        UserService us = new UserServiceImpl();//Impl普通实现类形态，不走事务。使用代理类形态的接口对象
        UserService us = (UserService) ServiceFactory.getService(new UserServiceImpl());//
        try{
            //到userServiceImpl()中去实现login方法。业务层service实现login方法，利用user返回验证成功或者失败消息
            User user = us.login(loginAct,loginPwd,ip);
            //将User对象保存到Session域中
            request.getSession().setAttribute("user",user);
            //如果程序执行到此处，说明业务层Service没有为controller抛出任何异常，表示登陆成功。之后给前端返回true
            PrintJson.printJsonFlag(response,true);//{"success":true}

        }catch(Exception e){
            e.printStackTrace();
            //一旦程序执行了catch块的信息，说明业务层为我们验证登录失败，为controller抛出异常。之后给前段返回false，并返回msg错误消息
            String msg = e.getMessage();
            /* 我们现在作为contoller，需要为ajax请求提供多项信息
                可以有两种手段来处理：
                    （1）将多项信息打包成为map，将map解析为json串
                    （2）创建一个Vo类，包括下面两个属性
                            private boolean success;
                            private String msg;
                    如果对于展现的信息将来还会大量的使用，我们创建一个vo类，使用方便
                    如果对于展现的信息只有在这个需求中能够使用，我们使用map就可以了
             */
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("success",false);
            map.put("msg",msg);
            PrintJson.printJsonObj(response,map);
        }
    }
}
