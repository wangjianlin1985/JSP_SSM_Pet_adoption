<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<base href="http://127.0.0.1/pethouse/" />
<% 
	request.setAttribute("basePath",request.getContextPath());
%>
<script type="text/javascript">
	var basePath = '${basePath}';
</script>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>宠物之家</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="plugins/adminlte/css/font-awesome.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/web.css"/>
    <link rel="stylesheet" type="text/css" href="plugins/bootstrapvalidator/css/bootstrapValidator.css"/>
    

    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/web/common/manage.js"></script>
    <script type="text/javascript" src="plugins/bootstrapvalidator/js/bootstrapValidator.js"></script>
    <style>
	    .modal-body .form-control{
	    	width:300px
	    }
	    
	    .pet-list{
	    	height: 230px;
		    overflow-y: auto;
		    text-align: center;
		    margin-left: 124px !important;
		    width: 390px;
	    }
	    
	    .petItem{
	    	    vertical-align: middle;
			    line-height: 100px;
			    float: left;
			    margin: 10px 30px;
	    }
	    
	    .petItem img{
	    	width:100px;
	    }
	    
	    .petItem input{
	    	 margin-top: 50px;
   			 margin-right: 10px;
	    }
    </style>
	<script type="text/javascript">
	
		$(function(){
			
			$('#regForm').bootstrapValidator({
		        feedbackIcons: {
		            valid: 'glyphicon glyphicon-ok',
		            invalid: 'glyphicon glyphicon-remove',
		            validating: 'glyphicon glyphicon-refresh'
		        },
		        fields: {
		        	userName: {
		                validators: {
		                	notEmpty: {
			                    message: '用户名不能为空'
			                },
		                    stringLength: {
		                        min: 6,
		                        max: 20,
		                        message: '用户名长度为6-20个字符'
		                    },
			                remote: {
			                    type: 'POST',
			                    url: 'w/user/checkAccount',
			                    message: '用户名已被注册'
			                }
		                }
		            },
		            password: {
		                validators: {
		                    notEmpty: {
		                        message: '密码不能为空'
		                    },
		                    regexp: {
		                        enabled: true,
		                        regexp: /^(?![\d]+$)(?![a-zA-Z]+$)(?![!@#$%^&*,.\/<>?]+$)[\da-zA-Z!@#$%^&*,.\/<>?]{6,12}$/,
		                        message: '请输入6-12位密码，密码包含字母、数字及特殊符号'
		                    },
		                    identical: {
		                        field: 'confirmPwd',
		                        message: '两次密码不一样'
		                    }
		                }
		            },
		            confirmPwd: {
		                validators: {
		                    notEmpty: {
		                        message: '确认密码不能为空'
		                    },
		                    regexp: {
		                        enabled: true,
		                        regexp: /^(?![\d]+$)(?![a-zA-Z]+$)(?![!@#$%^&*,.\/<>?]+$)[\da-zA-Z!@#$%^&*,.\/<>?]{6,12}$/,
		                        message: '请输入6-12双组合密码'
		                    },
		                    identical: {
		                        field: 'password',
		                        message: '两次密码不一样'
		                    }
		                }
		            }
		        }
		    });
			
			$('#adoptForm').bootstrapValidator({
		        container: 'tooltip',
		        feedbackIcons: {
		            valid: 'glyphicon glyphicon-ok',
		            invalid: 'glyphicon glyphicon-remove',
		            validating: 'glyphicon glyphicon-refresh'
		        },
		        fields: {
		        	contacts: {
		                validators: {
		                	notEmpty: {
			                    message: '真实姓名不能为空'
			                }
		                }
		            },
		            idCard: {
		                validators: {
		                    notEmpty: {
		                        message: '身份证不能为空'
		                    },
		                    regexp: {
		                        enabled: true,
		                        regexp: /^[1-9]{1}[0-9]{14}$|^[1-9]{1}[0-9]{16}([0-9]|[xX])$/,
		                        message: '身份证格式错误'
		                    }
		                }
		            },
		            address: {
		                validators: {
		                	notEmpty: {
			                    message: '联系地址不能为空'
			                }
		                }
		            },
		            work: {
		                validators: {
		                    notEmpty: {
		                        message: '请输入工作'
		                    }
		                }
		            },
		            phone: {
		                validators: {
		                	notEmpty: {
			                    message: '联系电话不能为空'
			                },
			                phone: {
			                    country: 'CN',
			                    message: '手机号码格式错误'
			                }
		                }
		            }
		        }
		    });
			
			$('#medicalaidForm').bootstrapValidator({
		        container: 'tooltip',
		        feedbackIcons: {
		            valid: 'glyphicon glyphicon-ok',
		            invalid: 'glyphicon glyphicon-remove',
		            validating: 'glyphicon glyphicon-refresh'
		        },
		        fields: {
		        	contacts: {
		                validators: {
		                	notEmpty: {
			                    message: '真实姓名不能为空'
			                }
		                }
		            },
		            address: {
		                validators: {
		                	notEmpty: {
			                    message: '联系地址不能为空'
			                }
		                }
		            },
		            phone: {
		                validators: {
		                	notEmpty: {
			                    message: '联系电话不能为空'
			                },
			                phone: {
			                    country: 'CN',
			                    message: '手机号码格式错误'
			                }
		                }
		            }
		        }
		    });
			
			$("#regBtn").bind("click",function(){
		    	$("#regForm").data('bootstrapValidator').validate();
				if(!$("#regForm").data('bootstrapValidator').isValid()){
					return;
				}
		    	jQuery.ajax({
		        	type : "post" , 
		        	url : "w/user/create", 
		        	dataType : "json" , 
		        	data : $("#regForm").serializeObject(),
		        	success : function(obj) {
		        		alert("注册成功，请登录网站！");
		        		$("#regForm").find("input").val("");
	        			$('#regModal').modal('hide');
		        	}
		        });
		    	
			});
			$("#adoptBtn").bind("click",function(){
		    	$("#adoptForm").data('bootstrapValidator').validate();
				if(!$("#adoptForm").data('bootstrapValidator').isValid()){
					return;
				}
		    	jQuery.ajax({
		        	type : "post" , 
		        	url : "w/adopt/create", 
		        	dataType : "json" , 
		        	data : $("#adoptForm").serializeObject(),
		        	success : function(obj) {
		        		alert("领养申请成功，请耐心等待审核！");
		        		$("#adoptForm").find("input").val("");
	        			
	        			$('#adoptModal').modal('hide');
		        	}
		        });
		    	
			});
			
			$("#medicalaidBtn").bind("click",function(){
		    	$("#medicalaidForm").data('bootstrapValidator').validate();
				if(!$("#medicalaidForm").data('bootstrapValidator').isValid()){
					return;
				}
		    	jQuery.ajax({
		        	type : "post" , 
		        	url : "w/maid/create", 
		        	dataType : "json" , 
		        	data : $("#medicalaidForm").serializeObject(),
		        	success : function(obj) {debugger
		        		alert("救助申请成功，请耐心等待审核！");
		        		$("#medicalaidForm").find("input").val("");
	        			$('#medicalaidModal').modal('hide');
		        	}
		        });
		    	
			});
		});
	
	
	
        function adopt(id){
        	$("#adoptForm").find("#petId").val(id);
            $('#adoptModal').modal('show');
        }
        
        function medicalaid(){debugger
        	jQuery.ajax({
	        	type : "get" , 
	        	url : "w/pet/findList", 
	        	dataType : "json" ,
	        	success : function(obj) {
	        		$(".pet-list").empty();
	        		$(obj.data).each(function(i,pet){
	        			var html='<div class="petItem">';
	        			html+='<input type="radio" name="petId" value="'+pet.id+'">';
	        			html+='<img alt="" src="'+pet.image+'">';
                    	html+='</div>';
	        			$(".pet-list").append(html);
	        		});
	        		$('#medicalaidModal').modal('show');
	        	}
	        });
           
        }
        
        function reg(){
            $('#regModal').modal('show');
        }
        
        function submit() {
        	// 验证码
        	var userName = $.trim($("#userName").val());
        	var password = $.trim($("#password").val());
        	if(!userName){
        		alert("请输入用户名");
        		return;
        	}else if(!password){
        		alert("请输入密码");
        		return;
        	}
        	var userParam = {
        		userName : userName,
        		password : password
        	}
        	$.ajax({
        		url : 'w/login',
        		type : 'post',
        		cache : false,
        		data : userParam,
        		dataType : "JSON",
        		success : function(response) {
        			var res = response.data;
        			$("#password").val('')
        			if (res.code === 1) {
        				window.location.href = "w/index";
        			}else{
        				alert("该用户为管理员或 医护人员");
        			}
        		},
        		error : function() {
        			alert("用户名或者密码错误，请重新输入");
        		}
        	})
        };

    </script>
</head>
<body>
	<div class="global-content">
        <!--页头-->
        <div class="header">
            <div class="inner">
                <a href="index.html"><img src="images/logo.jpg" width="47"style="margin-top: 18px;"></a>
                <span style="font-size: 23px;font-family: '微软雅黑';margin-top: 20px;display: inline-block;">宠物之家</span>
            </div>
            <c:if test="${!empty sessionScope.webUser}">
            	<div style="position: absolute;top: 5px;right: 10px">
	            	欢迎  ${sessionScope.webUser.userName} 登录 | <a href="w/logout">注销</a>
	            </div>
            </c:if>
            
        </div>
        <div class="clearfix"></div>
        <!--首页菜单-->
        <div class="index-menu">
            <div class="menu inner">
                <ul>
                    <li><a class="cur" href="w/index">首页</a></li>
                    <c:choose>
						<c:when test="${empty webUser}">
							<li><a href="javascript:alert('请先登录网站');">我要求助</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="javascript:medicalaid();">我要求助</a></li>
						</c:otherwise>
					</c:choose>
                    
                </ul>

                <div class="clearfix"></div>
            </div>
        </div>
        <div class="clearfix" style="font-size:1px"></div>
        <!--首页banner-->
        <div class="banner">
            <div id="carousel-banner" class="carousel slide" data-ride="carousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#carousel-banner" data-slide-to="0" class="active"></li>
                    <li data-target="#carousel-banner" data-slide-to="1"></li>
                    <li data-target="#carousel-banner" data-slide-to="2"></li>
                </ol>

                <!-- Wrapper for slides -->
                <div class="carousel-inner" role="listbox">
                    <div class="item active">
                        <img src="images/banner.jpg" style="height: 633px" alt="...">
                    </div>
                    <div class="item">
                        <img src="images/banner.jpg" style="height: 633px" alt="...">
                    </div>
                    <div class="item">
                        <img src="images/banner.jpg" style="height: 633px" alt="...">
                    </div>
                </div>
            </div>
            
            <c:if test="${empty sessionScope.webUser}">
	            <div class="login-bg">
	                <div class="inner">
	                    <div class="login-content">
	                        <form>
	                            <div class="form-group" style="margin-bottom: 50px">
	                                <label class="message">&nbsp;</label>
	                            </div>
	                            <div class="form-group" style="margin-top: 0px">
	                                <input type="text" class="form-control" id="userName" name="userName" placeholder="用户名">
	                            </div>
	                            <div class="form-group">
	                                <input type="password" class="form-control" id="password" name="password" placeholder="密码">
	                            </div>
	                            <div class="clearfix"></div>
	                            <div class="form-group" style="margin-top: 14px">
	                                <input type="hidden" name="redirect" value="${redirect}" />
	                                <a class="btn btn-primary" onclick="submit();">登 录</a>
	                            </div>
	
	                            <a href="javascript:void(0);" style="color: #fff;font-size: 14px; margin-top: 13px;text-align: center;display: block;text-decoration: underline;" onclick="reg()">立即注册</a>
	                        </form>
	                    </div>
	                </div>
	            </div>
            </c:if>
            
            <div class="clearfix"></div>
        </div>
        <div class="main-content inner" style="margin-top: 34px">
            <div class="news">
                <div class="title">
                    <span>宠物常见病</span>
                </div>
                <ul>
                    <li><a href="index.html">贵宾犬得了抑郁症</a></li>
                    <li><a href="index.html">松狮缺乏维C有哪些表现</a></li>
                    <li><a href="index.html">暹罗猫患疥螨猫耳螨虫病怎么办</a></li>
                    <li><a href="index.html">教师快速入门</a></li>
                </ul>
            </div>
            <div class="news">
                <div class="title">
                    <span>宠物传染病</span>
                </div>
                <ul>
                    <li><a href="index.html">丰富的课程资源，为教师“减负”</a></li>
                    <li><a href="index.html">优化教育模式，满足个性化教学需求</a></li>
                    <li><a href="index.html">原版教材和系统个，拓展国际化学科视野</a></li>
                    <li><a href="index.html">教师快速入门</a></li>
                </ul>
            </div>
            <div class="news">
                <div class="title">
                    <span>宠物皮肤病</span>
                </div>
                <ul>
                    <li><a href="index.html">丰富的课程资源，为教师“减负”</a></li>
                    <li><a href="index.html">优化教育模式，满足个性化教学需求</a></li>
                    <li><a href="index.html">原版教材和系统个，拓展国际化学科视野</a></li>
                    <li><a href="index.html">教师快速入门</a></li>
                </ul>
            </div>

            <div class="clearfix"></div>
            <div class="pets">
                <div class="title">
                    <span>热门宠物</span>
                </div>
				<c:forEach var="pet" items="${petList}" varStatus="status">
					<div class="video-recot">
	                    <img src="http://127.0.0.1/pethouse/${pet.image}" width="218" height="123">
	                    <div class="explain">
	                        <div class="title"><span>${pet.name}</span></div>
	                        <div class="title"><span>别名：${pet.otherName}</span><span>肤色：${pet.hairColor}</span></div>
	                        <div class="author">
	                        	<c:choose>
									<c:when test="${empty webUser}">
										<a class="btn btn-default" href="javascript:alert('请先登录网站');">领养</a>
										
									</c:when>
									<c:otherwise>
										<a href="javascript:adopt(${pet.id});" class="btn btn-primary">领养</a>
									</c:otherwise>
								</c:choose>
	                        	
	                        </div>
	                    </div>
	                </div>
				</c:forEach>
                
            </div>
        </div>
        <div class="clearfix"></div>
        <!--页尾-->
        <div class="footer">
            <div class="inner">
                <div class="pull-left">
                    <p>
                        <a href="#">客户服务</a>
                        <a href="#">关于我们</a>
                        <a href="#">友情连接</a>
                    </p>
                    <p>版权所有 2016 xxxxxxxxxxxx 京ICP备08102525号 京公网安备110102004606号</p>
                    <p>电话：(010)xxxxxxxx, xxxxxxxx 传真：(010)xxxxxxxx, xxxxxxxx</p>
                </div>
                <div class="pull-right">
                    <img class="qr-code" src="images/qrcode.png" />
                </div>
            </div>
        </div>
    </div>
    
    <!-- Modal -->
	<div class="modal fade" id="medicalaidModal" role="dialog" aria-labelledby="medicalaidModalLabel" aria-hidden="true" style="z-index:1200">
	    <div class="modal-dialog">
	        <div class="modal-content" style="width: 620px">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
	                <h4 class="modal-title" id="medicalaidModalLabel">申请救助</h4>
	            </div>
	            <div class="modal-body" style="padding: 0px">
	                <form class="form-horizontal" id="medicalaidForm" onkeydown="if(event.keyCode==13)return false;" style="padding: 40px 0px;">
		                <div class="form-group pet-list">
		                    <div class="petItem">
		                    	<input type="radio" name="petId" value="">
		                    	<img alt="" src="resources/pet/file/dbf96221-73d2-4357-bb6a-5fe92ff80b53.jpg">
		                    </div>
		                    <div class="petItem">
		                    	<input type="radio" name="petId" value="">
		                    	<img alt="" src="resources/pet/file/dbf96221-73d2-4357-bb6a-5fe92ff80b53.jpg">
		                    </div>
		                    <div class="petItem">
		                    	<input type="radio" name="petId" value="">
		                    	<img alt="" src="resources/pet/file/dbf96221-73d2-4357-bb6a-5fe92ff80b53.jpg">
		                    </div>
		                    <div class="petItem">
		                    	<input type="radio" name="petId" value="">
		                    	<img alt="" src="resources/pet/file/dbf96221-73d2-4357-bb6a-5fe92ff80b53.jpg">
		                    </div>
		                </div>
		                
		                
		                <div class="form-group">
		                    <label for="contacts" class="col-sm-offset-1 col-sm-3 control-label">真实姓名：</label>
		                    <div class="col-sm-4">
		                        <input type="text" class="form-control" id="contacts" name="contacts" placeholder="真实姓名">
		                    </div>
		                </div>
		                <div class="form-group">
		                    <label for="phone" class="col-sm-offset-1 col-sm-3 control-label">联系电话：</label>
		                    <div class="col-sm-4">
		                        <input type="text" class="form-control" id="phone" name="phone" placeholder="联系电话">
		                    </div>
		                </div>		                
		                <div class="form-group">
		                    <label for="address" class="col-sm-offset-1 col-sm-3 control-label">联系地址：</label>
		                    <div class="col-sm-4">
		                        <input type="text" class="form-control" id="address" name="address" placeholder="联系地址">
		                    </div>
		                </div>
		                <div class="form-group text-center" style="margin-top: 40px">
		                    <a href="javascript:void(0);" class="btn btn-primary" style="padding: 10px 74px;" id="medicalaidBtn">申请</a>
		                </div>
		            </form>
	            </div>
	        </div>
	    </div>
	</div>
    <!-- Modal -->
	<div class="modal fade" id="adoptModal" role="dialog" aria-labelledby="adoptModalLabel" aria-hidden="true" style="z-index:1200">
	    <div class="modal-dialog">
	        <div class="modal-content" style="width: 620px">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
	                <h4 class="modal-title" id="adoptModalLabel">申请领养</h4>
	            </div>
	            <div class="modal-body" style="padding: 0px">
	                <form class="form-horizontal" id="adoptForm" onkeydown="if(event.keyCode==13)return false;" style="padding: 40px 0px;">
		                <div class="form-group">
		                    <label for="contacts" class="col-sm-offset-1 col-sm-3 control-label">真实姓名：</label>
		                    <div class="col-sm-4">
		                    	<input type="hidden" id="petId" name="petId">
		                        <input type="text" class="form-control" id="contacts" name="contacts" placeholder="真实姓名">
		                    </div>
		                </div>
		
		                <div class="form-group">
		                    <label for="realName" class="col-sm-offset-1 col-sm-3 control-label">身份证号：</label>
		                    <div class="col-sm-4">
		                        <input type="text" class="form-control" id="idCard" name="idCard" placeholder="身份证号">
		                    </div>
		                </div>
		                <div class="form-group">
		                    <label for="phone" class="col-sm-offset-1 col-sm-3 control-label">联系电话：</label>
		                    <div class="col-sm-4">
		                        <input type="text" class="form-control" id="phone" name="phone" placeholder="联系电话">
		                    </div>
		                </div>
		                <div class="form-group">
		                    <label for="work" class="col-sm-offset-1 col-sm-3 control-label">工作：</label>
		                    <div class="col-sm-4">
		                        <input type="text" class="form-control" id="work" name="work" placeholder="工作">
		                    </div>
		                </div>
		                
		                <div class="form-group">
		                    <label for="address" class="col-sm-offset-1 col-sm-3 control-label">联系地址：</label>
		                    <div class="col-sm-4">
		                        <input type="text" class="form-control" id="address" name="address" placeholder="联系地址">
		                    </div>
		                </div>
		                <div class="form-group text-center" style="margin-top: 40px">
		                    <a href="javascript:void(0);" class="btn btn-primary" style="padding: 10px 74px;" id="adoptBtn">申请</a>
		                </div>
		            </form>
	            </div>
	        </div>
	    </div>
	</div>
	
	
	<!-- Modal -->
	<div class="modal fade" id="regModal" role="dialog" aria-labelledby="adoptModalLabel" aria-hidden="true" style="z-index:1200">
	    <div class="modal-dialog">
	        <div class="modal-content" style="width: 620px">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
	                <h4 class="modal-title" id="adoptModalLabel">用户注册</h4>
	            </div>
	            <div class="modal-body" style="padding: 0px">
	                <form class="form-horizontal" id="regForm" onkeydown="if(event.keyCode==13)return false;"  method="post" style="padding: 50px 0px;">
		                <div class="form-group">
		                    <label for="userName" class="col-sm-offset-1 col-sm-3 control-label">用户名：</label>
		                    <div class="col-sm-4">
		                        <input type="text" class="form-control" id="userName" name="userName" placeholder="用户名为6～20字符">
		                    </div>
		                </div>
		                <div class="form-group">
		                    <label for="password" class="col-sm-offset-1 col-sm-3 control-label">密 码：</label>
		                    <div class="col-sm-4">
		                        <input type="password" class="form-control" id="password" name="password" placeholder="密码为6～12位">
		                    </div>
		                </div>
		                <div class="form-group">
		                    <label for="confirmPwd" class="col-sm-offset-1 col-sm-3 control-label">确认密码：</label>
		                    <div class="col-sm-4">
		                        <input type="password" class="form-control" id="confirmPwd" name="confirmPwd" placeholder="确认密码">
		                    </div>
		                </div>
		                <div class="form-group">
		                    <label for="sex" class="col-sm-offset-1 col-sm-3 control-label">性 别：</label>
		                    <div class="col-sm-4">
		                        <label class="radio-inline">
		                            <input type="radio" name="sex" value="1" checked> 男
		                        </label>
		                        <label class="radio-inline">
		                            <input type="radio" name="sex" value="0"> 女
		                        </label>
		                    </div>
		                </div>
		               <div class="form-group text-center" style="margin-top: 40px">
		                    <a href="javascript:void(0);" class="btn btn-primary" style="padding: 10px 74px;" id="regBtn">注册</a>
		                </div>
		            </form>
	            </div>
	        </div>
	    </div>
	</div>
</body>
</html>