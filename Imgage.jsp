<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=request.getContextPath() %>/JS/jquery.min.js"></script>
<title>图片轮播</title>
<style type="text/css">
	body,div,ul,li,a,img{
	margin:0;
	padding:0;
	}
	ul,li{
	list-style:none;
	}
	a{
	text-decoration:none;
	}
	#wrapper{
	position:relative;
	margin:30px auto;
	width:400px;
	height:200px;
	}
	#banner{
	position:relative;
	width:400px;
	height:200px;
	overflow:hidden;
	}
	.imgList{
	position:relative;
	width:2000px;
	height:200px;
	z-index:10;
	overflow:hidden;
	}
	.imgList li{
	float:left;
	display:inline;
	}
	#prev,
	#next{
	position:absolute;
	top:80px;
	z-index:20px;
	cursor:pointer;
	opacity:0.2;
	filter:alpha(opacity=20);
	}
	#prev:hover,
	#next:hover{
	opacity:0.5;
	filter:alpha(opacity=50);
	}
	.bg{
	position:absolute;
	bottom:0;
	width:400px;
	height:40px;
	z-index:20;
	opacity:0.4;
	filter:alpha(opacity=40);
	background: black;
	}
	.infoList{
	position:absolute;
	left:10px;
	bottom:10px;
	z-index:30;
	}
	.infoList li{
	display:none;
	}
	.infoList .infoOn{
	display:inline;
	color:white;
	}
	.indexList{
	position:absolute;
	right:10px;
	bottom:5px;
	z-index: 30;
	}
	.indexList li{
	float:left;
	margin-left:5px;
	padding:3px;
	border:2px solid black;
	background: grey;
	cursor:pointer;  <!--鼠标样式 -->
	}
	.indexList .indexOn{
	background: red;
	font-weight: bold;
	color:white;
	}
</style>

</head>
<body>
	<div id="wrapper"><!-- 最外层 -->
		<div id="banner"><!-- 轮番部分 -->
			<ul class="imgList">
				<li><a href="#"><img src="./img/Login.jpg" width="400px" height="200px" alt="图1"></a></li>
				<li><a href="#"><img src="./img/002.jpg" width="400px" height="200px" alt="图2"></a></li>
				<li><a href="#"><img src="./img/003.jpg" width="400px" height="200px" alt="图3"></a></li>
				<li><a href="#"><img src="./img/004.jpg" width="400px" height="200px" alt="图4"></a></li>
				<li><a href="#"><img src="./img/img5.PNG" width="400px" height="200px" alt="图5"></a></li>
				<li><a href="#"><img src="./img/img3.png" width="400px" height="200px" alt="图6"></a></li>
			</ul>
			<img src="./img/Login.jpg" width="20px" height="40px" id="prev"/><!-- 切换按钮 -->
			<img src="./img/Login.jpg" width="20px" height="40px" id="next"/>
			<div class="bg"></div> <!-- 图片底部背景 -->
			<ul class="infoList"> <!-- 图片下角文字 -->
				<li class="infoOn">图1</li>
				<li>图2</li>
				<li>图3</li>
				<li>图4</li>
				<li>图5</li>
				<li>图6</li>
			
			</ul>
			<ul class="indexList">
				<li class="indexOn">1</li>
				<li>2</li>
				<li>3</li>
				<li>4</li>
				<li>5</li>
				<li>6</li>
			</ul>
		</div>
	</div>
</body>
<script type="text/javascript">
$(document).ready(function(){
	var curIndex=0;//当前Index
	var imgLen=$(".imgList li").length;//图片总数
	//定时器2.5秒两次
	var autoChange = setInterval(function(){
		if(curIndex < imgLen -1){
			curIndex++;
		}else{
			curIndex=0;
		}
		//调用变化处理函数
		changeTo(curIndex);
	},2500);
	//左箭头滑入事件处理
	$("#prev").hover(function(){
		//划入定时器
		clesrInterval(autoChange);
	},function(){
		//滑出定时器
		autoChangeAgain();
	});
	//左箭头点击处理
	$("#prev").click(function(){
		//根据curIndex进行上一个图片的处理
		curIndex = (curIndex > 0)?(--curIndex):(imgLen - 1);
		changeTo(curIndex);
	})
	$("#next").hover(function(){
		//滑入定时器
		clearInterval(autoChange);
	},function(){
		//滑出定时器清零
		autoChangeAgain();
	});
	$("#next").click(function(){
		curIndex=(curIndex < imgLen -1)?(++curIndex):0;
		changeTo(curIndex);
	});
	//对右下角按钮index进行事件绑定
	$(".indexList").find("li").each(function(item){
		$(this).hover(function(){
			clearInterval(autoChange);
			changeTo(item);
			curIndex = item;
		},function(){
			autoChangeAgain();
		})
	});
	//清除定时器的时候重置定时器--封装
	function autoChangeAgain(){
		autoChange = setInterval(function(){
			if(curIndex < imgLen -1){
				curIndex++;
			}else{
				curIndex=0;
			}
			changeTo(curIndex);
		},2500)
	}
	//切换到指定索引位置的图片
	function changeTo(num){
		var goLeft = num*400;
		$(".imgList").animate({left:"-"+goLeft+"px"},500);
		$(".infoList").find("li").removeClass("infoOn").eq(num).addClass("infoOn");
		$(".indexList").find("li").removeClass("indexOn").eq(num).addClass("indexOn");
	}
})
</script>
</html>