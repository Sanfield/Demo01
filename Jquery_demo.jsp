<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=request.getContextPath() %>/JS/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/JS/my.js"></script>
<title>JQuery</title>
<style type="text/css">
	.myclass{
	background-color:red;
	margin:10px;
	padding:10px;
	}
</style>
 </head>
<body>
	<span>阳春三月</span>
  <div id="mydiv">
	天气这么好，应该好好学习
  </div>
  <p>没心没肝</p>
  <p class="pclass">问心无愧</p>
  <p class="pclass">做人不累</p>
  <a href="#">上面说的好，我顶你们！</a>
  <a href="#">新闻</a>
  <a href="#">美女</a>
  <a href="#">香车</a>
  <a href="www.car.com">首页</a>
  <img name="icon" src="./img/Login.jpg" style="width:100px;heigth:100px" id="img1" alt="我漂亮吗"/>
  <input type="button" id="button1" value="点我你试试"/><br/>
  <div id="imgDs"></div><br/>
  <p id="p1">为人民服务</p>
  <div id="div3" style="background:red"></div>
  <input type="button" id="buttonhide" value="真的假的">
  <input type="button" id="buttonshow" value="show">
  <input type="button" id="buttontoggle" value="toggle">
  <input type="button" id="buttonslidedown" value="下滑">
  <input type="button" id="buttonslideup" value="上滑">
  <input type="button" id="b5" value="上下滑">
  <input type="button" id="fadein" value="淡入">
  <input type="button" id="fadeout" value="淡出">
  <input type="button" id="fadeto" value="指定透明度">
  <input type="button" id="animate1" value="我变">
  <input type="button" id="animate2" value="在变">
  <input type="button" id="btnaddclass" value="addclass">
  <input type="button" id="btnappend" value="追加我"><br/>
  <input type="button" id="btnAppendTo" value="我追你">
  <input type="button" id="After" value="我尾随你">
  <input type="button" id="before" value="插队">
  <input type="button" id="remove" value="删除Dom">
  <img name="dog" id="dog" src="./img/Login.jpg" style="width:500px;height:500px" alt="我就是我">
  <input type="text" id="name"/>
  <input type="button" id="btnvalue" value="现身">
</body>
</html>