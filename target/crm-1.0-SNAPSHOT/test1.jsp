<%--
  Created by IntelliJ IDEA.
  User: ccc
  Date: 2021/12/29
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" +
            request.getServerPort() + request.getContextPath() + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
    <script>

        $.ajax({
            url:"",
            data:{},
            type:"",
            dataType:"json",
            success:function (data){
            }
        })

    </script>
</head>
<body>
String createTime = DateTimeUtil.getSysTime();//创建时间：当前系统时间
String createBy = ((User) request.getSession().getAttribute("user")).getName();//创建人：当前登录用户
</body>
</html>
