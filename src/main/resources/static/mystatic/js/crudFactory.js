(function($, myWindow) {
	let $crud = {
		getDataByCurrentPage : function getDataByCurrentPage() {

			sqlMap.currentPage = currentPage;
			sqlMap.orderData = orderData;

			// 传到后台引擎处理数据
			$z.ajaxStrAndJson({
				url : basePath + "/" + controllerPrefix + "/likeSelect",
				data : sqlMap,
				beforeSend : function() {
					// 显示进度条
					InitMprogress();
				},
				success : function(data) {

					if (data.result.length == 0) {
						alert("没有您想要查询的数据！");
						MprogressEnd();
						$('#dataTable').empty();
						$("#pageID").empty();
						return;
					}

					currentPage = data.currentPage;
					totalPage = data.totalPage
					$("#pageID").empty();
					// pageMe.js 使用方法
					$("#pageID").paging({
						pageNum : currentPage, // 当前页面
						totalNum : totalPage, // 总页码
						totalList : data.count, // 记录总数量
						callback : function(num) { // 回调函数
							$crud.getCurrentPageData(num);
						}
					});

					var bodyHtmlTemplate = $("#tableContentTemplate").html();
					Mustache.parse(bodyHtmlTemplate); // 预编译模板
					
					makeResult(data.result);
										
					var bodyHtml = Mustache.render(bodyHtmlTemplate, data);
					$('#dataTable').html(bodyHtml);

					// 进度条消失
					MprogressEnd();

				}
			});

		},

		getDataByCondition : function getDataByCondition() {
		    // 传到后台引擎处理数据
            $z.ajaxStrAndJson({
                url : basePath + "/" + controllerPrefix + "/select",
                data : sqlMap,
                beforeSend : function() {
                    // 显示进度条
                    InitMprogress();
                },
                success : function(data) {

					if (data.result.length == 0) {
						alert("没有您想要查询的数据！");
						MprogressEnd();
						$('#dataTable').empty();
//						$("#pageID").empty();
						return;
					}

                    var bodyHtmlTemplate = $("#tableContentTemplate").html();
                    Mustache.parse(bodyHtmlTemplate); // 预编译模板

                    makeResult(data.result);

                    var bodyHtml = Mustache.render(bodyHtmlTemplate, data);
                    $('#dataTable').html(bodyHtml);

                    // 进度条消失
                    MprogressEnd();

                }
            });
		},

		getDataById : function getDataByName() {
        		    // 传到后台引擎处理数据
                    $z.ajaxStrAndJson({
                        url : basePath + "/" + controllerPrefix + "/selectByName",
                        data : sqlMap,
                        beforeSend : function() {
                            // 显示进度条
                            InitMprogress();
                        },
                        success : function(data) {

        					if (data.result.length == 0) {
        						alert("没有您想要查询的数据！");
        						MprogressEnd();
        						$('#dataTable').empty();
        //						$("#pageID").empty();
        						return;
        					}

                            var bodyHtmlTemplate = $("#tableContentTemplate").html();
                            Mustache.parse(bodyHtmlTemplate); // 预编译模板

                            makeResult(data.result);

                            var bodyHtml = Mustache.render(bodyHtmlTemplate, data);
                            $('#dataTable').html(bodyHtml);

                            // 进度条消失
                            MprogressEnd();

                        }
                    });
        		},

		getCurrentPageData : function getCurrentPageData(num) {
			currentPage = num;
			$crud.getDataByCurrentPage();
		},
		// 设置升序字段
		setAscColumn : function setAscColumn(thisVal, columnName) {
			// 如果没有style属性 则加入排序的数组 并设置样式
			if ($(thisVal).attr("style") == undefined) {
				orderData.push(columnName + " ASC");
				$(thisVal).attr("style", "color:red");
				// 查看有没有相同字段的desc
				var index = orderData.indexOf(columnName + " DESC");
				// 如果有 移除
				if (index > -1) {
					orderData.splice(index, 1);
				}
				// 移除下一个兄弟的样式
				$(thisVal).next().removeAttr("style");

				// 说明已经被加入到了排序数组中，删除样式并移除该元素
			} else {
				$(thisVal).removeAttr("style");
				var index = orderData.indexOf(columnName + " ASC");
				// 移除
				if (index > -1) {
					orderData.splice(index, 1);
				}
			}
			$crud.getDataByCurrentPage();
		},
		// 设置降序字段
		setDescColumn : function setDescColumn(thisVal, columnName) {
			// 如果没有style属性 则加入排序的数组
			if ($(thisVal).attr("style") == undefined) {
				orderData.push(columnName + " DESC");
				$(thisVal).attr("style", "color:red");

				// 查看有没有相同字段的asc
				var index = orderData.indexOf(columnName + " ASC");
				// 如果有 移除
				if (index > -1) {
					orderData.splice(index, 1);
				}

				// 移除上一个兄弟的样式
				$(thisVal).prev().removeAttr("style");

				// 说明已经被加入到了排序数组中，删除样式并移除该元素
			} else {
				$(thisVal).removeAttr("style");
				var index = orderData.indexOf(columnName + " DESC");
				// 移除
				if (index > -1) {
					orderData.splice(index, 1);
				}
			}
			$crud.getDataByCurrentPage();
		}
	};
	myWindow.$crud = $crud;
})(jQuery, window);
