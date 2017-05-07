<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Insert title here</title>
	<jsp:include page="/common/head_import.jsp"></jsp:include>
	<script src="<%=request.getContextPath()%>/assets/js/jquery-1.8.3.js" type="text/javascript"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/dwr/engine.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/dwr/util.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/dwr/interface/RoleService.js"></script>
</head>
<body>
	 <div class="row">
	       <div class="col-md-12">
	           <!-- BEGIN EXAMPLE TABLE PORTLET-->
	           <div class="portlet light bordered">
	               <div class="portlet-title">
	                   <div class="caption font-dark">
	                       <i class="icon-settings font-dark"></i>
	                       <span class="caption-subject bold uppercase"> 角色管理</span>
	                   </div>
	                   <div class="actions">
	                       <div class="btn-group btn-group-devided" data-toggle="buttons">
	                           <label class="btn btn-transparent dark btn-outline btn-circle btn-sm active">
	                               <input type="radio" name="options" class="toggle" id="option1">Actions</label>
	                           <label class="btn btn-transparent dark btn-outline btn-circle btn-sm">
	                               <input type="radio" name="options" class="toggle" id="option2">Settings</label>
	                       </div>
	                   </div>
	               </div>
	               <div class="portlet-body">
	                   <div class="table-toolbar">
	                       <div class="row">
	                           <div class="col-md-6">
	                               <div class="btn-group">
	                                   <button id="sample_editable_1_new" class="btn sbold green" onclick="showRoleForm();">添加角色
	                                       <i class="fa fa-plus"></i>
	                                   </button>
	                               </div>
	                           </div>
	                           <div class="col-md-6">
	                               <div class="btn-group pull-right">
	                                   <button class="btn green  btn-outline dropdown-toggle" data-toggle="dropdown">工具
	                                       <i class="fa fa-angle-down"></i>
	                                   </button>
	                                   <ul class="dropdown-menu pull-right">
	                                       <li>
	                                           <a href="javascript:;">
	                                               <i class="fa fa-print"></i> 打印 </a>
	                                       </li>
	                                       <li>
	                                           <a href="javascript:;">
	                                               <i class="fa fa-file-pdf-o"></i> 保存为PDF </a>
	                                       </li>
	                                       <li>
	                                           <a href="javascript:;">
	                                               <i class="fa fa-file-excel-o"></i> 导出为Excel </a>
	                                       </li>
	                                   </ul>
	                               </div>
	                           </div>
	                       </div>
	                   </div>
	                   <table class="table table-striped table-bordered table-hover table-checkable order-column" id="sample_1">
	                       <thead>
	                           <tr>
	                               <th>
	                                   <label class="mt-checkbox mt-checkbox-single mt-checkbox-outline">
	                                       <input type="checkbox" class="group-checkable" data-set="#sample_1 .checkboxes" />
	                                       <span></span>
	                                   </label>
	                               </th>
	                               <th> 角色编号 </th>
	                               <th> 角色名称 </th>
	                               <th> 描述 </th>
	                           </tr>
	                       </thead>
	                       <tbody id="tbRole">
	                           
	                       </tbody>
	                   </table>
	               </div>
	           </div>
	           <!-- END EXAMPLE TABLE PORTLET-->
	       </div>
	   </div>
	<jsp:include page="/common/footer_import.jsp"></jsp:include>
	<script type="text/javascript">
		$(document).ready(function() {
			queryRoleList();
		});
		function showRoleForm(){
			document.location="RoleForm.jsp";
		}
		function queryRoleList(){
			var roleObj = new Object();
			var pageSize = 10;
			var pageIndex = 1;
			var orderName = "role_id";
			var orderRule = "desc";
			RoleService.getRoleListByPage(roleObj,pageSize,pageIndex,orderName,orderRule,function(msg){
				//alert(msg.length);
				var trRole;
				for(i=0;i<msg.length;i++){
					var role = msg[i];
					trRole += '<tr class="odd gradeX"><td><label class="mt-checkbox mt-checkbox-single mt-checkbox-outline">'+
                        '<input type="checkbox" class="checkboxes" value="1" />'+
                        '<span></span></label></td>';
                    trRole+=('<td>'+role.roleId+'</td>');
                    trRole+=('<td>'+role.roleName+'</td>');
                    trRole+=('<td>'+role.roleDesc+'</td>');
                    trRole+=('</tr>');
					//alert(user.userName);
				} 
				$("#tbRole").html(trRole);
			})
		}
	</script>
</body>
</html>