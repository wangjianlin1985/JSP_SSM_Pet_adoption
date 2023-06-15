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
				fmt.auditBack(id,petId, 2);
			}else{
				fmt.auditBack(id,petId, 3);
			}
		});
	};
	
	fmt.auditBack=function(id,petId,status){
		$.ajax({
			url : 'm/back/auditBack',// 跳转到 action  
			type : 'post',
			cache : false,
			data : {id:id,petId:petId,statue:status},
			dataType : 'json',
			success : function(data) {
				$("#dlg").dialog('close');
				if(data.code == 1){
					$.messager.alert('操作提示', '审核操作成功！','info',function(){
						$("#back_datagrid").datagrid("reload");
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
	var back_columns = [ [ {
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
		field : 'contacts',
		title : '联系人',
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
		field : 'staffName',
		title : '医护人员',
		width : 100
	},{
		field : 'statue',
		title : '审核状态',
		width : 100,
		formatter:fmt.fmtStatus
	}] ];

	var back_toolbar = [ {
		text : '刷新',
		iconCls : 'icon-reload',
		handler : function() {
			$("#back_datagrid").datagrid("options").url = 'm/back/findPage?statue=2';
			$('#back_datagrid').datagrid('reload');
		}
	} ];

	window.top.document.title = "救助记录";
	$("#back_datagrid").datagrid({
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
		url : 'm/back/findPage?statue=2',
		method : 'post',
		columns : back_columns,
		toolbar : back_toolbar,
		onBeforeLoad : function(_post) {
			_post.currentPage = _post.page;
			_post.pageSize = _post.rows;

			delete _post.page;
			delete _post.rows;
		}
	});

});