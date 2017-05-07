<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
	<jsp:include page="/common/head_import.jsp"></jsp:include>
	<script type="text/javascript" src="<%=request.getContextPath()%>/dwr/engine.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/dwr/util.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/dwr/interface/RoleService.js"></script>
</head>
<body>
	<div class="row">
     <div class="col-md-12">
         <!-- BEGIN VALIDATION STATES-->
         <div class="portlet light portlet-fit portlet-form bordered">
             <div class="portlet-title">
                 <div class="caption">
                     <i class="icon-settings font-dark"></i>
                     <span class="caption-subject font-dark sbold uppercase">角色信息录入</span>
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
                 <!-- BEGIN FORM-->
                 <form action="#" id="form_sample_3" class="form-horizontal">
                     <div class="form-body">
                         <div class="alert alert-danger display-hide">
                             <button class="close" data-close="alert"></button> You have some form errors. Please check below. </div>
                         <div class="alert alert-success display-hide">
                             <button class="close" data-close="alert"></button> Your form validation is successful! </div>
                         <div class="form-group">
                             <label class="control-label col-md-3">角色姓名
                                 <span class="required"> * </span>
                             </label>
                             <div class="col-md-4">
                                 <input type="text" id="roleName" name="roleName" data-required="1" class="form-control" /> </div>
                         </div>
                         <div class="form-group last">
                             <label class="control-label col-md-3">角色描述
                                 <span class="required"> * </span>
                             </label>
                             <div class="col-md-9">
                                 <textarea class="ckeditor form-control" id="roleDesc" name="roleDesc" rows="6" data-error-container="#editor2_error"></textarea>
                                 <div id="editor2_error"> </div>
                             </div>
                         </div>
                     </div>
                     <div class="form-actions">
                         <div class="row">
                             <div class="col-md-offset-3 col-md-9">
                                 <button type="button" class="btn green" id="btnSubmit">提交</button>
                                 <button type="button" class="btn default" id="btnCon">取消</button>
                             </div>
                         </div>
                     </div>
                 </form>
                 <!-- END FORM-->
             </div>
             <!-- END VALIDATION STATES-->
         </div>
     </div>

	<jsp:include page="/common/footer_import.jsp"></jsp:include>
	<script type="text/javascript">
		var roleObj;
	
		function goBack(){
			history.go(-1);
		}
		$(document).ready(function() {
			$("#roleName").bind("blur", checkRoleNameExist);
			$("#btnSubmit").bind("click", saveRole);
			$("#btnCon").bind("click", goBack);
		});
		/**
		 * 校验角色名称是否存在函数
		 */
		function checkRoleNameExist(){
			$("#roleName_alert").remove();//先移除之前的提示信息
			var roleName = $("#roleName").val().trim();//获取去除空格后的用户账号信息
			if(roleName=="")return;//如果账号输入空则跳出校验方法

			RoleService.getRoleByName(roleName,function(msg){
				if(msg!=null){//如果返回角色ID信息则提示角色已被占用
					$("#roleName").after("<font color='red' id='roleName_alert'>此角色已被使用，请更改！</font>");
					$("#roleName").focus();
				}else{//否则提示账号可用信息
					$("#roleName").after("<font color='green' id='roleName_alert'>恭喜您，此角色可用！</font>");
				}
			})
		}
		/**
		*将Form表单数据封装到一个js对象中
		*/
		function getFormObject(){
			roleObj = new Object();
			roleObj.roleId = $("#roleId").val();
			roleObj.roleName = $("#roleName").val();
			roleObj.roleDesc = $("#roleDesc").val();
		}
		/**
		 * 校验角色信息是否符合规则要求函数
		 */
		function checkForm(){
			//先移除之前的提示信息
			$("#roleName_alert").remove();
			$("#roleDesc_alert").remove();
			
			getFormObject();//获取表单元素值对象
			
			if(roleObj.roleName == ""){
				$("#roleName").focus();
				$("#roleName").after("<font color='red' id='roleName_alert'>请输入角色名称！</font>")
				return false;
			}
			
			if((roleObj.roleName.length < 1) || (roleObj.roleName.length > 20)){
				$("#roleName").focus();
				$("#roleName").after("<font color='red' id='pw_alert'>角色名称长度介于1-20位</font>")
				return false;
			}
			
			return true;
		}
		function saveRole(){
			if(!checkForm()){
				return;
			}
			
			RoleService.insertRole(roleObj,function(msg){
				if(msg.result>0){
					alert("保存成功！");
					document.location="RoleManage.jsp"
				}
			})
		}
	</script>
</body>
</html>