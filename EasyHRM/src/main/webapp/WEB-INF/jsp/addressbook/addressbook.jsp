<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 引入jstl核心标签库  -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> - 通讯录</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link href="${ctx}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/css/font-awesome.min.css" rel="stylesheet">

    <link href="${ctx}/css/animate.css" rel="stylesheet">
    <link href="${ctx}/css/style.css" rel="stylesheet">

</head>

<body class="gray-bg">

    <div class="wrapper wrapper-content animated fadeInRight">
        <!-- start -->
        <div class="col-sm-3" style="padding-top:10px;">
            <div class="ibox float-e-margins">
                <div class="ibox-content">
                    <div class="file-manager">
                        <h1>通讯录</h1>
                        <div class="hr-line-dashed"></div>
                        <!-- <button class="btn btn-primary btn-block">上传文件</button>
                        <div class="hr-line-dashed"></div> -->
                        <h3>分类</h3>
                        <ul class="folder-list" style="padding: 0">
                            <li><a href="/addressbook/selectAddressbooks"><i class="fa fa-group"></i> 显示所有 </a>
                            </li>
                            <li><a href="/addressbook/selectByCategory/1"><i class="fa fa-user-o"></i> 快递服务类 </a>
                            </li>
                            <li><a href="/addressbook/selectByCategory/2"><i class="fa fa-user-o"></i> 外卖订餐类 </a>
                            </li>
                            <li><a href="/addressbook/selectByCategory/3"><i class="fa fa-user-o"></i> 银行客服类 </a>
                            </li>
                        </ul>
                        <div class="clearfix" style="height: 100px;"></div>
                    </div>
                </div>
            </div>
        </div>

        <!-- end -->
        <div class="col-sm-9">

            <div class="row m-b-sm m-t-sm">
                
                <div class="col-md-8">
                    <div class="input-group">
                        <input type="text" placeholder="请输入名称" class="input-sm form-control" name="key" id="key"> 
                        <span class="input-group-btn">
                            <button type="button" class="btn btn-sm btn-primary" id="search"> &nbsp;&nbsp;&nbsp;搜索&nbsp;&nbsp;&nbsp; </button> 
                        </span>
                    </div>
                </div>
                <div class="col-md-2">
                    <button type="button" id="loading-example-btn" class="btn btn-white btn-sm" onclick="javascript:window.location.href='/addressbook/selectAddressbooks'"><i class="fa fa-refresh"></i> 刷新  </button>
                </div>
            </div>

            <div class="row">
            	<c:forEach var="item" items="${addressbooks}">
            		<div class="col-sm-6">
	                    <div class="contact-box">
	                        <a href="profile.html">
	                            <div class="col-sm-4">
	                                <div class="text-center">
	                                    <img alt="image" class="img-circle m-t-xs img-responsive" src="${ctx}/images/default_head.jpg">
	                                    <div class="m-t-xs font-bold">${item.company}</div>
	                                </div>
	                            </div>
	                            <div class="col-sm-8">
	                                <h3><strong>${item.name}</strong></h3>
	                                <!-- <p><i class="fa fa-map-marker"></i> 甘肃·兰州</p> -->
	                                <address>
	                                <strong>${item.company}</strong><br>
	                                	邮箱：${item.email}<br>
	                                	备注：<a href="">${item.remark}</a><br>
	                                	手机：${item.telephone}<br>
	                      				固话：${item.settledPhone}
	                            </address>
	                            </div>
	                            <div class="clearfix"></div>
	                        </a>
	                    </div>
	                </div>
            	</c:forEach>
            </div>
        </div>
    </div>

    <!-- 全局js -->
    <script src="${ctx}/js/jquery-3.3.1.min.js"></script>
    <script src="${ctx}/js/bootstrap.min.js"></script>
    <!-- 自定义js -->
    <script src="${ctx}/js/content.js"></script>
    <script>
        $(document).ready(function () {
            $('.contact-box').each(function () {
                animationHover(this, 'pulse');
            });
        });
        // 搜索
        $("#search").click(function(){
        	var key = $("#key").val();
        	window.location.href="${ctx}/addressbook/searchAddressbook?key="+key;
        });
    </script>

</body>

</html>
