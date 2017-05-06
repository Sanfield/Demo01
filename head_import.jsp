<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&amp;subset=all" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css">
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<link href="<%=request.getContextPath()%>/assets/global/plugins/bootstrap-daterangepicker/daterangepicker.min.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/assets/global/plugins/morris/morris.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/assets/global/plugins/fullcalendar/fullcalendar.min.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/assets/global/plugins/jqvmap/jqvmap/jqvmap.css" rel="stylesheet" type="text/css">
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN THEME GLOBAL STYLES -->
<link href="<%=request.getContextPath()%>/assets/global/css/components.min.css" rel="stylesheet" id="style_components" type="text/css">
<link href="<%=request.getContextPath()%>/assets/global/css/plugins.min.css" rel="stylesheet" type="text/css">
<!-- END THEME GLOBAL STYLES -->
<!-- BEGIN THEME LAYOUT STYLES -->
<link href="<%=request.getContextPath()%>/assets/layouts/layout/css/layout.min.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/assets/layouts/layout/css/themes/darkblue.min.css" rel="stylesheet" type="text/css" id="style_color">
<link href="<%=request.getContextPath()%>/assets/layouts/layout/css/custom.min.css" rel="stylesheet" type="text/css">
<!-- END THEME LAYOUT STYLES -->
<script>
	
	/**
	 * 从Form中获取JSON数据
	 */
	function getData(formId) {
		var data = {};
		$("#" + formId).serializeArray().map(function(x){data[x.name] = x.value;});
		
		return data;
	}
	
	String.prototype.endWith=function(str){  
		if(str==null||str==""||this.length==0||str.length>this.length)  
        	return false;  
        if(this.substring(this.length-str.length)==str)  
          	return true;  
        else  
          	return false; 
          	 
        return true;  
	};  
	
</script>
