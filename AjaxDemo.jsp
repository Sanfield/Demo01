<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="<%=request.getContextPath() %>/JS/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AJax</title>
<script type="text/javascript">
	function ajaxTest(){
		var flag=false;
		var orderId= $("#orderId").val();
		var commant=$("#commant").val();
		$.ajax({
			type:"POST",
			url:"./1111/JQueryAjaxServlet",
			data:{"order":order,"commant":commant},
			dataType:"json",
			async:false,
			cache:false,
			success:function(data){
				alert(data);
				var member = eval(data);
				if(member.success=="true"){
					flag= true;
				}else if(member.success=="false"){
					alert(member.info);
				}
			},error:function(json){
				alert("刷新后重试....");
			}
		});
	}
	$(document).ready(function(){
		$("#submit").click(function(){
			ajaxTest();
		})
	})
</script>
</head>
<body>
	<div align="center">
		<table>
			<tr><td colspan="2" align="center">订单信息</td></tr>
			<tr><td>订单号:</td><td><input type="text" id="orderId"></td></tr>
			<tr><td>内容:</td><td><input type="text" id="commant"></td></tr>
			<tr><td><input type="submit" value="提交" id="submit"></td>
			<td><input type="button" value="取消"/></td></tr>
		</table>
	</div>
</body>
</html>