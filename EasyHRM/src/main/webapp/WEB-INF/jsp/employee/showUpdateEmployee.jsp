<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<title>人事管理系统——修改员工</title>
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
	<script language="javascript" type="text/javascript" src="${ctx }/js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript">
	$(function(){
		// 控制文档加载完成以后 选中性别 
		$("#sex").val("${employee.sex}");
		$("#job_id").val("${employee.job.id}");
		
    	/** 员工表单提交 */
			$("#employeeForm").submit(function(){
				var name = $("#name");
				var codeId = $("#codeId");
				var email = $("#email");
				var telephone = $("#telephone");
				var party = $("#party");
				var address = $("#address");
				var postCode = $("#postCode");
				var birthday = $("#birthday");
				var race = $("#race");
				var major = $("#major");
				var msg = "";
				if ($.trim(name.val()) == ""){
					msg = "姓名不能为空！";
					name.focus();
				}else if ($.trim(codeId.val()) == ""){
					msg = "身份证号码不能为空！";
					codeId.focus();
				}else if (!/^[1-9]\d{16}[0-9A-Za-z]$/.test($.trim(codeId.val()))){
					msg = "身份证号码格式不正确！";
					codeId.focus();
				}else if ($.trim(email.val()) == ""){
					msg = "邮箱不能为空！";
					email.focus();
				}else if (!/^\w+@\w{2,3}\.\w{2,6}$/.test($.trim(email.val()))){
					msg = "邮箱格式不正确！";
					email.focus();
				}else if ($.trim(telephone.val()) == ""){
					msg = "手机号码不能为空！";
					telephone.focus();
				}else if (!/^1[3|5|8]\d{9}$/.test($.trim(telephone.val()))){
					msg = "手机号码格式不正确！";
					telephone.focus();
				}else if ($.trim(party.val()) == ""){
					msg = "政治面貌不能为空！";
					party.focus();
				}else if ($.trim(address.val()) == ""){
					msg = "地址不能为空！";
					address.focus();
				}else if ($.trim(postCode.val()) == ""){
					msg = "邮政编码不能为空！";
					postCode.focus();
				}else if (!/^[1-9]\d{5}$/.test($.trim(postCode.val()))){
					msg = "邮政编码格式不正确！";
					postCode.focus();
				}else if ($.trim(birthday.val()) == ""){
					msg = "出生日期不能为空！";
					birthday.focus();
				}else if (!birthday.val()){
// 					!/^\d{4}-\d{2}-\d{2}$/.test($.trim(birthday.val()))
					msg = "出生日期格式不正确！";
					birthday.focus();
				}else if ($.trim(race.val()) == ""){
					msg = "民族不能为空！";
					race.focus();
				}else if ($.trim(major.val()) == ""){
					msg = "专业不能为空！";
					major.focus();
				}
				if (msg != ""){
					$.ligerDialog.error(msg);
					return false;
				}else{
					return true;
				}
				$("#employeeForm").submit();
			});
	    });
		

	</script>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr><td height="10"></td></tr>
  <tr>
    <td width="15" height="32"><img src="${ctx}/images/main_locleft.gif" width="15" height="32"></td>
	<td class="main_locbg font2"><img src="${ctx}/images/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：员工管理  &gt; 修改员工</td>
	<td width="15" height="32"><img src="${ctx}/images/main_locright.gif" width="15" height="32"></td>
  </tr>
</table>
<table width="100%" height="90%" border="0" cellpadding="5" cellspacing="0" class="main_tabbor">
  <tr valign="top">
    <td>
    	 <form action="${ctx}/employee/updateEmployee" id="employeeForm" method="post">
			<!-- 隐藏表单，flag表示添加标记 -->
    	 	<input type="hidden" name="flag" value="2">
			<input type="hidden" name="id" value="${employee.id }">
		  <table width="100%" border="0" cellpadding="0" cellspacing="10" class="main_tab">
		    <tr><td class="font3 fftd">
		    	<table>
		    		<tr>
		    			<td class="font3 fftd">姓名：<input type="text" name="name" id="name" size="20"/></td>
		    			<td class="font3 fftd">身份证号码：<input type="text" name="codeId" id="codeId" size="20"/></td>
		    		</tr>
		    		<tr>
		    			<td class="font3 fftd">性别：
									<select name="gender" style="width:143px;">
					    			<option value="0">--请选择性别--</option>
					    			<option value="1">男</option>
					    			<option value="2">女</option>
					    		</select></td>
		    			<td class="font3 fftd">职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;位：
		    			 <select name="positionId" style="width:143px;">
					    			<option value="0">--请选择职位--</option>
					    			<c:forEach items="${requestScope.jobs }" var="job">
					    				<option value="${job.positionId }">${job.name }</option>
					    			</c:forEach>
					    		</select>
					    </td>
		    		</tr>
		    		<tr>
		    			<td class="font3 fftd">手机：<input name="telephone" id="telephone" size="20"/></td>
					<td class="font3 fftd">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱：<input name="email" id="email" size="20"/></td>
		    		</tr>
		    		
		    	</table>
		    </td></tr>
			<tr><td class="main_tdbor"></td></tr>
			
			<tr>
				<td class="font3 fftd">
					政治面貌：<input name="party" id="party" size="40"/>&nbsp;&nbsp;
					<td class="font3 fftd">共&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;资：<input name="basePay" id="basePay" size="20"/></td>
			</tr>
			<tr><td class="main_tdbor"></td></tr>
			
			<tr>
				<td class="font3 fftd">
					联系地址：<input name="address" id="address" size="40"/>&nbsp;&nbsp;
					邮政编码：<input name="postCode" id="postCode" size="20"/>
				</td>
			</tr>
			<tr><td class="main_tdbor"></td></tr>
			
			<tr>
				<td class="font3 fftd">
					出生日期：<input class="Wdate" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'});" 
					name="birthday" id="birthday" size="40"/>&nbsp;&nbsp;
					民&nbsp;&nbsp;&nbsp;&nbsp;族：<input name="race" id="race" size="20"/>
				</td>
			</tr>
			<tr><td class="main_tdbor"></td></tr>
			
			<tr>
				<td class="font3 fftd">
					所学专业：<input  name="major" id="major" size="40"/>&nbsp;&nbsp;
					爱&nbsp;&nbsp;&nbsp;&nbsp;好：<input name="hobby" id="hobby" size="20"/>
				</td>
			</tr>
			<tr><td class="main_tdbor"></td></tr>
			
			<tr>
				<td class="font3 fftd">
					备&nbsp;&nbsp;&nbsp;&nbsp;注：<input name="remark" id="remark" size="40"/>
					&nbsp;&nbsp;所属部门：
					<select  name="dept_id" style="width:100px;">
						   <option value="0">--部门选择--</option>
						   <c:forEach items="${requestScope.depts }" var="dept">
			    				<option value="${dept.deptId }">${dept.name }</option>
			    			</c:forEach>
					</select>
				</td>
			</tr>
			<tr><td class="main_tdbor"></td></tr>
			<tr><td align="left" class="fftd"><input type="submit" value="修改">&nbsp;&nbsp;<input type="reset" value="取消 "></td></tr>
		  </table>
		 </form>
	</td>
  </tr>
</table>
<div style="height:10px;"></div>
</body>
</html>