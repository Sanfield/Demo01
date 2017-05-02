<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=request.getContextPath() %>/JS/jquery.min.js"></script>
<title>Json</title>
<script type="text/javascript">
	var httprequest = new XMLHttpRequest();
	var xmlDoc = httprequest.responseXML;
	var info="";
	var i=0;
	//Json的三种方式
	var mystr= {"name":"zhangsan","sex":"M","age":20};
	var json1= eval({"name":"zhangsan","sex":"M","age":20});//直接转换
	var json2= eval('({"name":"zhang san","sex":"M"})');//通过字符串转换
	var json3= eval(mystr);
	//var myjson = JSON.parse(mystr);
	$(document).ready(function(){
/**	alert(json1.age);
	alert(json2.sex);
	alert(json3.age);	
	alert(mujson.age);*/
/**	var attr = xmlDoc.getElementsByTagName("attribute");
	for(i=0;i<attr.length;i++){
		info=info+attr[i].childNodes[1].chaildNodes[1].nodeValue+"<br>";
	}
	$("#mydiv").html(info);*/
	$("#button").click(function(){
		$("#mydiv").load("work.txt");
	})
	})
</script>
</head>
<body>
	<div id="mydiv">
	使用 jquery ajax 获取文本内容
	</div>
	<input type="button" value="获取外部内容" id="button">
</body>
</html>