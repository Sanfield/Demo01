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
	//	var jsonPara={"orderId":'\"'+orderId+'\""}
		$.ajax({
			type:"POST",
			url:"./1111/JQueryAjaxServlet",
			data:{"order":orderId,"commant":commant},
			dataType:"json",
			async:false,
			cache:false,
			success:function(data){
				//alert(data.success);
				//var member = eval(data);//返回数据解析为json对象模式
				var member = data;
				if(member.success=="true"){
					flag= true;
				}else if(member.success=="false"){
					alert(member.info);
				}
				$("#content").html(data.name+":"+data.type);
			},error:function(json){
				alert("刷新后重试....");
			}
		});
	}
	function ajax_post(){
		$.post("./1111/AjaxPostServlet",{"orderId":$("#orderId").val(),"commant":$("#commant").val()},function(data){
			$("#msg").html(data);
			
		},"text")//返回值有text，html，json，xml；
	}
	//AJax的getJSON样例
	function ajax_getjson(){
		var city = $("#city");
		$.getJSON("./1111/GetJsonServlet",function(data){
			//通过循环获取data里的值
			$.each(data,function(i,value){
				var tempOption  =document.createElement("option");
				tempOption.value=value.id;
				tempOption.innerHTML = value.name;
				city.append(tempOption);
			});
		});
	}
	$(document).ready(function(){
		ajax_getjson();//通过ajax的getjson方法获取selesct列表的信息
		$("#btsubmit").click(function(){
			ajaxTest();
			ajax_post()
		})
		$("#orderId").blur(function(){//焦点移除事件
			ajaxTest();
			ajax_post();
			ajax_getjson();
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
			<tr><td>服务器返回:</td><td id="content"></td></tr>
			<tr><td>Post返回:</td><td id="msg"></td></tr>
			<tr><td>城市:</td><td><select id="city">
				<option>==选择==</option></select>
			</td></tr>
			<tr><td><input type="submit" value="提交" id="btsubmit"></td>
			<td><input type="button" value="取消"/></td></tr>			
		</table>
		  
	</div>
</body>
</html>