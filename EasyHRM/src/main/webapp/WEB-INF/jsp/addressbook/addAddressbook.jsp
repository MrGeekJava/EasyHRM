<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>人事管理系统——添加通讯录</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
	<meta http-equiv="description" content="This is my page" />
	<link href="${ctx}/css/css.css" type="text/css" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="${ctx}/js/ligerUI/skins/Aqua/css/ligerui-dialog.css"/>
	<link href="${ctx}/js/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
	<link href="${ctx}/css/pager.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript" src="${ctx }/js/jquery-1.11.0.js"></script>
	<script type="text/javascript" src="${ctx }/js/jquery-migrate-1.2.1.js"></script>
	<script src="${ctx}/js/ligerUI/js/core/base.js" type="text/javascript"></script>
	<script src="${ctx}/js/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script> 
	<script src="${ctx}/js/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
	<script src="${ctx}/js/ligerUI/js/plugins/ligerResizable.jss" type="text/javascript"></script>
	<script type="text/javascript">
		$(function(){
	    	/** 通讯录表单提交 */
			$("#addressbookForm").submit(function(){
				var name = $("#name");
				var company = $("#company");
				var settledPhone = $("#settledPhone");
				var telephone = $("#telephone");
				var remark = $("#remark");
				var email = $("#email");
				var msg = "";
				
				if($.trim(name.val()) == ""){
					msg = "姓名不能为空";
					name.focus();
				}else if($.trim(company.val()) == ""){
					msg = "公司不能为空";
					company.focus();
				}else if($.trim(settledPhone.val()) == ""){
					msg = "固话不能为空";
					settledPhone.focus();
				}else if($.trim(telephone.val()) == ""){
					msg = "手机不能为空";
					telephone.focus();
				}else if($.trim(remark.val()) == ""){
					msg = "备注不能为空";
					remark.focus();
				}else if($.trim(email.val()) == ""){
					msg = "邮箱不能为空";
					email.focus();
				}
				if(msg != ""){
					$.ligerDialog.error(msg);
					return false;
				} else {
					return true;
				}
				$("#addressbookForm").submit();
			});
	    });
	</script>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr><td height="10"></td></tr>
  <tr>
    <td width="15" height="32"><img src="${ctx}/images/main_locleft.gif" width="15" height="32"></td>
	<td class="main_locbg font2"><img src="${ctx}/images/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：通讯录  &gt; 添加通讯录</td>
	<td width="15" height="32"><img src="${ctx}/images/main_locright.gif" width="15" height="32"></td>
  </tr>
</table>
<table width="100%" height="90%" border="0" cellpadding="5" cellspacing="0" class="main_tabbor">
  <tr valign="top">
    <td>
    	 <form action="${ctx}/addressbook/insertAddressbook" id="addressbookForm" method="post">
    	 	<!-- 隐藏表单，flag表示添加标记 -->
    	 	<input type="hidden" name="flag" value="2">
		  <table width="100%" border="0" cellpadding="0" cellspacing="10" class="main_tab">
		    <tr><td class="font3 fftd">
		    	<table>
		    		<tr>
		    			<td class="font3 fftd">姓&nbsp;名：<input type="text" name="name" id="name" size="20"/></td>
		    			<td class="font3 fftd">性&nbsp;别：
		    				<input type="radio" name="gender" value="1" checked/>男 &nbsp;
		    				<input type="radio" name="gender" value="0"/>女
		    			</td>
		    		</tr>
		    			
		    		<tr>
		    			<td class="font3 fftd">分&nbsp;类：
		    				<select name="category">
		    					<option value="1" checked>快递服务类</option>
		    					<option value="2">外卖订餐类</option>
		    					<option value="3">银行客服类</option>
		    				</select>
		    			</td>
		    			<td class="font3 fftd">公&nbsp;司：<input name="company" id="company" size="20" /></td>
		    		</tr>
		    		
		    		<tr>
		    			<td class="font3 fftd">固&nbsp;话：
		    				<input type="text" name="settledPhone" id="settledPhone"/>
		    			</td>
		    			<td class="font3 fftd">手&nbsp;机：
		    				<input type="text" name="telephone" id="telephone" size="20"/>
		    			</td>
		    		</tr>
		    		
		    		<tr>
		    			<td class="font3 fftd">邮&nbsp;箱：
		    				<input type="text" name="email" id="email"/>
		    			</td>
		    			<td class="font3 fftd">备&nbsp;注：
		    				<input type="text" name="remark" id="remark" size="20"/>
		    			</td>
		    		</tr>
		    		
		    	</table>
		    </td></tr>
			<tr><td class="main_tdbor"></td></tr>
			
			<tr><td align="left" class="fftd"><input type="submit" value="添加">&nbsp;&nbsp;<input type="reset" value="取消 "></td></tr>
		  </table>
		 </form>
	</td>
  </tr>
</table>
<div style="height:10px;"></div>


</body>
</html>