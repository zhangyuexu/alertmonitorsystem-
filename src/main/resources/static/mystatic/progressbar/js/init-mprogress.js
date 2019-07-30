
  /**
   * 初始化进度条
   * 
   */
    function InitMprogress(domId){
    	var dom ="body";
    	if(domId!=null){
    		dom = "#"+domId;
    	}
    	//构造进度条容器
    	var conStr ="<div id='progressCon' style='height:100%;position:absolute;box-sizing:boder-box;top:0;right:0;bottom:0;left:0;background-color:rgba(0,0,0,.1);text-align:center;'><div id='my_progress' style='margin-left:auto;margin-right:auto;width:60%;box-sizing:boder-box;height:15px;position:relative;top:50%;'></div></div>";
    		//父容器
        	$(dom).css({"position":"relative"});
    		$(dom).append(conStr);
    	
    	bufferIntObj = {
    	          template: 3,
    	          start:true,
    	          parent:'#my_progress'
    	         };
    	 bufProgress = new Mprogress(bufferIntObj);
    }
    /**
     * 设置进度
     */
    function MprogressIng(num){
    	bufProgress.set(num);
    	bufProgress.setBuffer(Number(num)+0.2)
    	setTimeout(function(){
    		var pro = num+0.1;
            bufProgress.set(pro);
    	    bufProgress.setBuffer(Number(pro)+0.2)},500);
    }
    /**
     * 开始显示进度条
     */
    function MprogressStart(){
    	bufProgress.start();
    }
    /**
     *  停止进度条自动前进
     */
    function MprogressStop(){
    	bufProgress.stop();
    }
    /**
     *  进度条消失
     */
    function MprogressEnd(domId){
    	bufProgress.end();
    	setTimeout(function(){
    		if(domId!=null){
        		var dom = "#"+domId;
        		$(dom).css({"position":""});
        		$(dom).children("#progressCon").remove();
        	}else{
        		$("#progressCon").remove();
        	}
    	},800);
    	
    }