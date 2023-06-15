(function() {

	var operation = (function() {

		var operation = {};
		// 添加用户
		operation.addUser = function() {
			if ($("#userForm").form("validate")) {

				var obj = $('#userForm').serializeObject();
				// 验证用户名和邮箱是否唯一
				$.ajax({
					url : 'm/user/checkAccount',
					type : 'post',
					dataType : 'json',
					cache : false,
					data : obj,
					success : function(data) {
						if (data.code == 1) {
							$.messager.alert('操作提示', '账号或者邮箱已经存在，请修改后保存!');
							return;// 直接返回，不进行保存
						} else {
							// 账号唯一才使用进行创建
							$.ajax({
								url : 'm/user/create',// 跳转到 action
								type : 'post',
								dataType : 'json',
								cache : false,
								data : obj,
								success : function(data) {
									if (data.code == 1) {
										$.messager.alert('操作提示', '新增成功!');
										window.location.href = "m/user/stafflist";// 跳转到列表页
									} else {
										$.messager.alert("操作提示", data.message);
									}
								},
								error : function() {
									// TODO:请求错误
								}
							});
						}
					},
					error : function() {// form表单数据无效

					}
				});
			} else {
				$.messager.alert("操作提示", "表单验证不通过");
			}
		}; // EndOf operation.addTopics

		operation.editUser = function() {
			if ($("#userForm").form("validate")) {
				var obj = $('#userForm').serializeObject();
				// 验证用户名和邮箱是否唯一
				$.ajax({
					url : 'm/user/checkNameEml',
					type : 'post',
					dataType : 'json',
					cache : false,
					data : obj,
					success : function(data) {
						$.ajax({
							url : 'mng/user/update',// 跳转到 action
							type : 'post',
							data : obj,
							dataType : 'json', // json
							success : function(data) {
								if (data.code == 1) {
									$.messager.alert('操作提示', '修改成功！');
									window.location.href = "m/user/stafflist";
								} else {
									$.messager.alert('操作提示', data.message);
								}
							},
							error : function() {
								// TODO:请求错误
							}
						});
					},
					error : function() {// form表单数据无效

					}
				});
			} else {
				$.messager.alert("操作提示", "表单验证不通过");
			}
		};

		return operation;
	})();

	window.operation = operation;

	$(function() {
		if ($("#id").val()) {
			window.top.document.title = "编辑管理员";

			$("#btn_sub").bind("click", function() {
				operation.editUser();
			});
		} else {
			window.top.document.title = "新增管理员";

			$("#btn_sub").bind("click", function() {
				operation.addUser();
			});
		}
		;
		$("#btn_back").bind("click", function() {
			window.location.href = "m/user/stafflist";
		});
	});
})();

