
(function(){
	$(function(){
		$("form input").prop("readonly", true);
		if($("#id").val()){
			window.top.document.title = "用户详情";
			$("#address").combobox("loadData", data);
			
			$("#address").combobox("select",$("#userAddress").val());
		};
		$("#btn_back").bind("click",function(){
			window.location.href = "m/user/list";//跳转到列表页
		})

	});
})();