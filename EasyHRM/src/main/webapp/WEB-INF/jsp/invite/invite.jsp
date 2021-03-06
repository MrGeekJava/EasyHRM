<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fkjava" uri="/pager-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>人事管理系统 ——信息管理</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="pragma" content="no-cache" />
    <meta http-equiv="cache-control" content="no-cache" />
    <meta http-equiv="expires" content="0" />
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
    <meta http-equiv="description" content="This is my page" />
    <link href="${ctx}/css/css.css" type="text/css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="${ctx}/js/ligerUI/skins/Aqua/css/ligerui-dialog.css"/>
    <link href="${ctx}/js/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${ctx }/js/jquery-1.11.0.js"></script>
    <script type="text/javascript" src="${ctx }/js/jquery-migrate-1.2.1.js"></script>
    <script src="${ctx}/js/ligerUI/js/core/base.js" type="text/javascript"></script>
    <script src="${ctx}/js/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script>
    <script src="${ctx}/js/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
    <script src="${ctx}/js/ligerUI/js/plugins/ligerResizable.jss" type="text/javascript"></script>
    <link href="${ctx}/css/pager.css" type="text/css" rel="stylesheet" />

    <script type="text/javascript">
        $(function(){
            /** 获取上一次选中的部门数据 */
            var boxs  = $("input[type='checkbox'][id^='box_']");

            /** 给数据行绑定鼠标覆盖以及鼠标移开事件  */
            $("tr[id^='data_']").hover(function(){
                $(this).css("backgroundColor","#eeccff");
            },function(){
                $(this).css("backgroundColor","#ffffff");
            })


            /** 删除员工绑定点击事件 */
            $("#delete").click(function(){
                /** 获取到用户选中的复选框  */
                var checkedBoxs = boxs.filter(":checked");
                if(checkedBoxs.length < 1){
                    $.ligerDialog.error("请选择一个需要删除的用户！");
                }else{
                    /** 得到用户选中的所有的需要删除的ids */
                    var ids = checkedBoxs.map(function(){
                        return this.value;
                    })

                    $.ligerDialog.confirm("确认要删除吗?","删除用户",function(r){
                        if(r){
                            // alert("删除："+ids.get());
                            // 发送请求
                            window.location = "${ctx }/user/removeUser?ids=" + ids.get();
                        }
                    });
                }
            })
        })
    </script>
</head>
<body>
<!-- 导航 -->
<table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr><td height="10"></td></tr>
    <tr>
        <td width="15" height="32"><img src="${ctx}/images/main_locleft.gif" width="15" height="32"></td>
        <td class="main_locbg font2"><img src="${ctx}/images/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：管理 &gt; 招聘管理</td>
        <td width="15" height="32"><img src="${ctx}/images/main_locright.gif" width="15" height="32"></td>
    </tr>
</table>

<table width="100%" height="90%" border="0" cellpadding="5" cellspacing="0" class="main_tabbor">
    <!-- 查询区  -->
    <tr valign="top">
        <td height="30">
            <table width="100%" border="0" cellpadding="0" cellspacing="10" class="main_tab">
                <tr>
                    <td class="fftd">
                        <form name="inviteform" method="post" id="inviteform" action="${ctx}/invite/selectInvite">
                            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                                <tr>
                                    <td class="font3">
                                        招聘名称：<input type="text" name="title">
                                        招聘状态：<input type="text" name="status">
                                        <input type="submit" value="搜索"/>
                                        <input id="delete" type="button" value="删除"/>
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </td>
                </tr>
            </table>
        </td>
    </tr>

    <!-- 数据展示区 -->
    <tr valign="top">
        <td height="20">
            <table width="100%" border="1" cellpadding="5" cellspacing="0" style="border:#c2c6cc 1px solid; border-collapse:collapse;">
                <tr class="main_trbg_tit" align="center">
                    <td><input type="checkbox" name="checkAll" id="checkAll"></td>



                    <td>招聘发布人</td>
                    <td>招聘名称</td>
                    <td>招聘方式</td>
                    <td>预计费用</td>
                    <td>招聘人数</td>
                    
                    <td>结束日期</td>
                    <td>岗位职责</td>
                    <td>公司福利</td>
                    <td>审核状态</td>
                    
                    <td align="center">操作</td>
                </tr>
                <c:forEach items="${requestScope.invites}" var="invite" varStatus="stat">
                    <tr id="data_${stat.index}" align="center" class="main_trbg" onMouseOver="move(this);" onMouseOut="out(this);">
                        <td><input type="checkbox" id="box_${stat.index}" value="${invite.inviteId}"></td>

                        

                        <td>${invite.empId }</td>
                        <td>${invite.title }</td>
                        <td>${invite.type }</td>
                        <td>${invite.cost }</td>
                        <td>${invite.number }</td>
                        
                        <td><f:formatDate value="${invite.endDate}"
                                          type="date" dateStyle="long"/></td>
                        
                        <td>${invite.responsibility }</td>
                        <td>${invite.welfare }</td>
                        <td>${invite.status }</td>
                       
                        <td align="center" width="40px;"><a href="${ctx}/user/updateUser?flag=1&managerId=${user.managerId}">
                            <img title="修改" src="${ctx}/images/update.gif"/></a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </td>
    </tr>
    <!-- 分页标签 -->
    <tr valign="top"><td align="center" class="font3">
        <fkjava:pager
                pageIndex="${requestScope.pageModel.pageIndex}"
                pageSize="${requestScope.pageModel.pageSize}"
                recordCount="${requestScope.pageModel.recordCount}"
                style="digg"
                submitUrl="${ctx}/invite/selectInvite?pageIndex={0}"/>
    </td></tr>
</table>
<div style="height:10px;"></div>
</body>
</html>