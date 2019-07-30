(function($, myWindow) {
	let $z = {
		// RequestBody接收 async(是否异步)
		ajaxStrAndJson : function ajaxStrAndJson(allData) {
			$.ajax({
				url : allData.url,
				type : "post",
				headers : {
					Accept : "application/json; charset=utf-8"
				},
				async : allData.async,
				contentType : "application/json; charset=utf-8",
				data : JSON.stringify(allData.data),
				beforeSend : allData.beforeSend,
				success : allData.success,
				complete : function(XMLHttpRequest) {
				},
				error : function(data, status, e) {
					alert("出现未知错误，请刷新页面重试！");
				}
			});
		},
		// 普通参数或对象接收
		ajaxFormAndJson : function ajaxFormAndJson(allData) {
			$.ajax({
				url : allData.url,
				type : "post",
				headers : {
					Accept : "application/json; charset=utf-8"
				},
				async : allData.async,
				data : allData.data,
				beforeSend : allData.beforeSend,
				success : allData.success,
				complete : function(XMLHttpRequest) {
				},
				error : function(data, status, e) {
					alert("出现未知错误，请重试！");
				}
			});
		},
		downLoadExcel : function downLoadExcel(filePath) {
			// alert(filePath);
			window.parent.location.href = '/excel/downloadfile?filePath='
					+ encodeURI(filePath);
		}

	};
	myWindow.$z = $z;
})(jQuery, window);