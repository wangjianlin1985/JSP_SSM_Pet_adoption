/**
 * 新增课程
 */


$(function(){
	window.top.document.title = "新增宠物信息";
	$("#tbtn_sub").bind("click",function(){
		pet.addteacherList();
	});
	if($("#id").val()){
		$("#btn_sub").bind("click",function(){
			pet.editPet();
		});
	}else{
		$("#btn_sub").bind("click",function(){
			pet.addPet();
		});
	};
	$("#btn_back").bind("click", function() {
		window.location.href = "m/pet/list";
	});
});
var pet = {};
pet.addPet = function(){
	if($("#petForm").form("validate")){
		$.ajax({
			url : 'm/pet/create',// 跳转到 action  
			type : 'post',
			cache : false,
			data : $('#petForm').serialize(),
			dataType : "json",
			success : function(data) {
				if(data.code == 1){
					$.messager.alert('操作提示', '新增成功！');
					window.location.href = "m/pet/list";//跳转到列表页
				}else{
					$.messager.alert('操作提示', data.message);
				}
			},
			error : function() {
				//TODO:请求错误
			}
		});
	}else{
		$.messager.alert("操作提示", "表单验证不通过");
	}
};

pet.uploadCover = function(fileId,img,picId){
	$.ajaxFileUpload({
		url:"m/pet/upload",	//需要链接到服务器地址 
		secureuri:false,
		fileElementId:fileId,//文件选择框的id属性
		dataType: 'json',	//json
		success: function (obj) {
			$("#"+img).attr("src",obj.convertFileName).show();
			$("#"+picId).val(obj.newFileName);
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
			$.messager.alert('操作提示', '上传失败！');
		}
	});
};

pet.editPet = function(){
	if($("#petForm").form("validate")){
		$.ajax({
			url : 'm/pet/update',// 跳转到 action  
			type : 'post',
			cache : false,
			data :  $('#petForm').serialize(),
			dataType : 'json',
			success : function(data) {
				if(data.code == 1){
					$.messager.alert('操作提示', '修改成功！');
					window.location.href = "m/pet/list";//跳转到列表页
				}else{
					$.messager.alert('操作提示', data.message);
				}
			},
			error : function() {
				//TODO:请求错误
			}
		});
	}else{
		$.messager.alert("操作提示", "表单验证不通过");
	}
};

