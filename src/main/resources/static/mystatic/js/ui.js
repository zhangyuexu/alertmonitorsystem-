$(function (){
	//日期选择控件
//	$('.ui-timepicker').datetimepicker({
//		language:'zh-CN',
//		minView: 2,
//		pickerPosition:'top-left',
//		format:'yyyy-mm-dd hh:ii:ss'
//	});

	 $('.form_datetime').datetimepicker({
            weekStart: 1,
            todayBtn:  1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            forceParse: 0,
            showMeridian: 1,
            format: 'yyyy-mm-dd hh:ii:ss'///
        });
	//轮播图
	$(".ui-main-visual").hover(function(){
		$("#ui-btn-prev,#ui-btn-next").fadeIn()
		},function(){
		$("#ui-btn-prevv,#ui-btn-next").fadeOut()
		})
	$dragBln = false;
	$(".ui-main-image").touchSlider({
		flexible : true,
		speed : 400,
		btn_prev : $("#ui-btn-prev"),
		btn_next : $("#ui-btn-next"),
		paging : $(".ui-flicking-con a"),
		counter : function (e) {
			$(".ui-flicking-con a").removeClass("on").eq(e.current-1).addClass("on");
		}
	});
	$(".ui-main-image a").click(function() {
		if($dragBln) {
			return false;
		}
	})
	timer = setInterval(function() { $("#ui-btn-next").click();}, 2500);
	$(".ui-main-visual").hover(function() {
		clearInterval(timer);
	}, function() {
		timer = setInterval(function() { $("#ui-btn-next").click();}, 2500);
	})
	$(".ui-main-image").bind("touchstart", function() {
		clearInterval(timer);
	}).bind("touchend", function() {
		timer = setInterval(function() { $("#ui-btn-next").click();}, 2500);
	})
});