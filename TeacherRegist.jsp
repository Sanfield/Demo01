<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>teacher Register</title>
</head>
<body>
<body>
	<div style="height: 20%">
		<jsp:include page="../part/head.jsp"></jsp:include>
	</div> 
		<div align="center" style="width: 35%" class="container">
		  <form>
			<table class="table table-hover">
			<thead><h2>老师注册</h2></thead>
			<tbody>
			<tr><td>昵称:</td><td><input type="text" name="name"></td></tr>
			<tr><td>账号:</td><td><input type="text" name="number"></td></tr>
			<tr><td>密码:</td><td><input type="password" name="password1"></td></tr>
			<tr><td>确认密码:</td><td><input type="password" name="password2"></td></tr>
			<tr><td>老师职称:</td><td>
			 	<select name="teachertitle" size="1">
			 	 <option value="trofessor">教授</option>
			 	 <option value="aprofessor">副教授</option>
			 	 <option value="lecturer">讲师</option>
			 	</select>
			 </td></tr>
			 <tr><td>学院:</td><td><input type="text" name="teacherdepartment"></td></tr>
			 <tr><td>部门:</td><td><input type="text" name="teacherdepartment"></td></tr> 
			 <tr><td>办公室:</td><td><input type="text" name="office"></td></tr>
			 <tr><td>电话:</td><td><input type="text" name="teacherphone"></td></tr>
			 <tr><td>固定电话:</td><td><input type="text" name="teachertelephone"></td>
			 <tr><td>电子邮件:</td><td><input type="text" name="teacheremail"></td></tr>	
		    <tr><td><input class="btn btn_lg btn-primary" type="button" value="提交" onclick="" />
					</td><td>
					<input class="btn btn_lg btn-warning" type="reset" value="重置" />
			</td></tr>			
		</table>
	</form>	
	</div>
</body>
</html>