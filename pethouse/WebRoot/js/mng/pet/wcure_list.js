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

	fmt.fmtType = function(val, row, index) {
		if (val == '1') {
			return "狗狗";
		} else if (val == '2') {
			return "猫咪";
		} else {
			return "小宠";
		}
	};

	fmt.fmtStaff = function(val, row, index) {
		var html = '<select id="s_' + row.id + '">';
		$(userList).each(function(i,item){
			if(item.id!=undefined && item.id!=null && item.id!=''){
				html += '<option value="'+item.id+'">'+item.name+'</option>';
			}
			
		});
		html += '</select>';
		return html;
	};

	fmt.fmtOpt = function(val, row, index) {
		return '<a href="javascript:void(0);" onclick="fmt.edit(' + row.id+ ');">医治</a> ';
	};
	fmt.edit = function(id) {
		if(confirm('是否确认开始医治该宠物')){
			var staffId=$("#s_"+id).val();
			$.ajax({
				url : 'm/pet/cure',// 跳转到 action  
				type : 'post',
				cache : false,
				data : {id:id,staffId:staffId},
				dataType : 'json',
				success : function(data) {
					if(data.code == 1){
						$("#pet_datagrid").datagrid("reload");
					}else{
						$.messager.alert('操作提示', data.message);
					}
				},
				error : function(data) {
					console.log("remove　error"+ JSON.stringify(data));
				}
			});
		}
	};
	return fmt
})();
var userList=new Array();
$(function() {
	
	$.ajax({
		url : 'm/user/findList?role=2',
		type : 'post',
		dataType : 'json',
		cache : true,
		success : function(data) {
			
			
			userList=data.data;
			
			var pet_columns = [ [ {
				field : 'id',
				title : 'ID',
				width : 60,
				hidden : true
			}, {
				field : 'name',
				title : '名称',
				width : 100
			}, {
				field : 'type',
				title : '宠物类别',
				width : 60,
				formatter : fmt.fmtType
			}, {
				field : 'image',
				title : '图片展示',
				width : 120,
				formatter : fmt.fmtImage
			}, {
				field : 'otherName',
				title : '别名',
				width : 100
			}, {
				field : 'enName',
				title : '英文名',
				width : 100
			}, {
				field : 'weight',
				title : '体重',
				width : 70
			}, {
				field : 'size',
				title : '大小',
				width : 70
			}, {
				field : 'hairColor',
				title : '毛色',
				width : 100
			}, {
				field : 'selectStaff',
				title : '选择医生',
				width : 100,
				formatter : fmt.fmtStaff
			}, {
				field : 'operate',
				title : '操作',
				width : 60,
				formatter : fmt.fmtOpt
			} ] ];

			var pet_toolbar = [ {
				text : '刷新',
				iconCls : 'icon-reload',
				handler : function() {
					$("#pet_datagrid").datagrid("options").url = 'm/pet/findPage?statue=4';
					$('#pet_datagrid').datagrid('reload');
				}
			} ];

			window.top.document.title = "全部宠物信息管理";
			$("#pet_datagrid").datagrid({
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
				url : 'm/pet/findPage?statue=4',
				method : 'post',
				columns : pet_columns,
				toolbar : pet_toolbar,
				onBeforeLoad : function(_post) {
					_post.currentPage = _post.page;
					_post.pageSize = _post.rows;

					delete _post.page;
					delete _post.rows;
				}
			});
			
		},
		error : function() {// form表单数据无效

		}
	});
	
	
	

});