var fmt = (function() {
	var fmt = {};
	fmt.createTime = function(_val, _row, _index) {
		return DateUtil.stamp2Time(_val);
	};
	fmt.fmtImage = function(val, row, index) {
		if (val == 'image/default.png') {
			return "<img src='" + val
					+ "' style='width:80px; height:80px;padding:5px;'>";
		} else {
			return "<img src='" + val
					+ "' style='width:80px; height:80px;padding:5px;'>";
		}
	};
	
	fmt.fmtStatus=function(val, row, index){
		var sta = ["","待审核","审核通过","审核不通过"];
		return sta[val];
	}
	
	fmt.fmtOpt = function(val, row, index){
		return '<a href="javascript:void(0);" onclick="fmt.showAudit('+row.id+','+row.petId+');">审核</a>';
	};
	
	fmt.showAudit=function(id,petId){
		$.messager.confirm('领养审核', '该领养申请是否审核通过?', function(r){
			if (r){
				fmt.auditAdopt(id,petId, 2);
			}
		});
	};
	
	fmt.auditAdopt=function(id,petId,status){
		$.ajax({
			url : 'm/adopt/auditAdopt',// 跳转到 action  
			type : 'post',
			cache : false,
			data : {id:id,petId:petId,statue:status},
			dataType : 'json',
			success : function(data) {
				$("#dlg").dialog('close');
				if(data.code == 1){
					$.messager.alert('操作提示', '审核操作成功！','info',function(){
						$("#adopt_datagrid").datagrid("reload");
					});
				}else{
					$.messager.alert('操作提示', data.message);
				}
			},
			error : function() {
				//TODO:请求错误
			}
		});
	}

	return fmt
})();

$(function() {
	var adopt_columns = [ [ {
		field : 'id',
		title : 'ID',
		width : 60,
		hidden : true
	}, {
		field : 'petName',
		title : '宠物名',
		width : 100
	}, {
		field : 'image',
		title : '图片展示',
		width : 120,
		formatter : fmt.fmtImage
	}, {
		field : 'userName',
		title : '申请账号',
		width : 50
	}, {
		field : 'contacts',
		title : '领养人姓名',
		width : 100
	}, {
		field : 'work',
		title : '领养人工作',
		width : 100
	}, {
		field : 'phone',
		title : '联系电话',
		width : 100
	}, {
		field : 'address',
		title : '联系地址',
		width : 100
	}, {
		field : 'statue',
		title : '审核状态',
		width : 100,
		formatter:fmt.fmtStatus
	}, {
		field : 'createTime',
		title : '申请时间',
		width : 100,
		formatter : fmt.createTime
	}, {
		field : 'opt',
		title : '操作',
		width : 40,
		formatter : fmt.fmtOpt
	} ] ];

	var adopt_toolbar = [ {
		text : '刷新',
		iconCls : 'icon-reload',
		handler : function() {
			$("#adopt_datagrid").datagrid("options").url = 'm/adopt/findPage';
			$('#adopt_datagrid').datagrid('reload');
		}
	} ];

	window.top.document.title = "领养记录";
	$("#adopt_datagrid").datagrid({
		fit : true,
		striped : true,
		resizable : true,
		rownumbers : true,
		fitColumns : true,
		collapsible : true,
		singleSelect : true,
		pagination : true,
		pageSize : 10,
		pageList : [ 10, 20, 30, 40, 50 ],
		url : 'm/adopt/findPage',
		method : 'post',
		columns : adopt_columns,
		toolbar : adopt_toolbar,
		onBeforeLoad : function(_post) {
			_post.currentPage = _post.page;
			_post.pageSize = _post.rows;

			delete _post.page;
			delete _post.rows;
		}
	});

});