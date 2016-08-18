<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="resources/styles/jqx.base.css" type="text/css" />
	<link rel="stylesheet" href="resources/styles/jqx.ui-lightness.css" type="text/css" />
	<link rel="stylesheet" href="resources/styles/bootstrap.min.css" type="text/css" />
	
	<script type="text/javascript" src="resources/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/jqxcore.js"></script>
	<script type="text/javascript" src="resources/js/jqxribbon.js"></script>
	<script type="text/javascript" src="resources/js/jqxwindow.js"></script>
	<script type="text/javascript" src="resources/js/jqxlayout.js"></script>
	<script type="text/javascript" src="resources/js/jqxdockinglayout.js"></script>
	<script type="text/javascript" src="resources/js/jqxdata.js"></script>
    <script type="text/javascript" src="resources/js/jqxbuttons.js"></script>
    <script type="text/javascript" src="resources/js/jqxscrollbar.js"></script>
    <script type="text/javascript" src="resources/js/jqxlistbox.js"></script>
    <script type="text/javascript" src="resources/js/jqxmenu.js"></script>
    <script type="text/javascript" src="resources/js/jqxgrid.js"></script>
    <script type="text/javascript" src="resources/js/jqxgrid.selection.js"></script>
    <script type="text/javascript" src="resources/js/jqxgrid.columnsresize.js"></script>
    <script type="text/javascript" src="resources/js/jqxgrid.filter.js"></script>
    <script type="text/javascript" src="resources/js/jqxgrid.sort.js"></script>
    <script type="text/javascript" src="resources/js/jqxdropdownlist.js"></script>
    <script type="text/javascript" src="resources/js/jqxcheckbox.js"></script>
    <script type="text/javascript" src="resources/js/jqxgrid.edit.js"></script>
    <script type="text/javascript" src="resources/js/jqxnotification.js"></script>
    <script type="text/javascript" src="resources/js/jqxnavbar.js"></script>
    <script type="text/javascript" src="resources/js/jqxloader.js"></script>
    <script type="text/javascript" src="resources/js/jqxcombobox.js"></script>
		<title>Welcome</title>
	</head>
	
	<style type="text/css">
		#content{
			position: absolute;
   			top: 30%;
   			left: 50%;
    		margin-left: -250px;
		}
		.jqx-rc-all{
			 font-size: 30px;
			 opacity: 0.7; 
		}
		body{ 
			  background-image: url(resources/image/body.jpg);
			  background-size:100%;
			 }
	</style>
	
	 
<body >
	<div id="content">
		<div id='schoolList' style="float: left;"></div> 
		<input type="button" value="下载" id='download'  style="float: left;margin-left:10px;:"/>
	</div>
</body>
	
	<script type="text/javascript">
	 $(document).ready(function () { 
		 
	 	$("#schoolList").jqxComboBox({width: 400,height: 50,
		   theme:'ui-lightness',dropDownHeight:500});
		$("#download").jqxButton({ width: 120, height: 53 ,theme:'ui-lightness'});
			
		 $.getJSON(
					 "<%=request.getContextPath()%>/GetSchookList",
					 function(json){
						 var dataArray=eval(JSON.stringify(json));
						 $("#schoolList").jqxComboBox({selectedIndex:1,source:dataArray});
						
						}
				  );
		 
		 $('#download').on('click', function () { 
			 var item = $("#schoolList").jqxComboBox('getSelectedItem'); 
			 
			 
			 window.location.href='<%=request.getContextPath()%>/DownloadTeachingplan?symbol='+item.label;
			
	 })
	 })
	</script>
	
	<script type="text/javascript">
		

	function getType(x){  
	    if(x==null){  
	        return "null";  
	    }  
	    var t= typeof x;  
	    if(t!="object"){  
	        return t;  
	    }  
	    var c=Object.prototype.toString.apply(x);  
	    c=c.substring(8,c.length-1);  
	    if(c!="Object"){  
	        return c;  
	    }  
	    if(x.constructor==Object){  
	        return c  
	    }  
	    if("classname" in x.prototype.constructor  
	            && typeof x.prototype.constructor.classname=="string"){  
	        return x.constructor.prototype.classname;  
	    }  
	    return "<unknown type>";  
	}  
	</script>
</html>
