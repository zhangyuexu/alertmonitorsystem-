$('#sidebarHandler').hover(function(){
  $('body').removeClass('toggle-nav');
}, function(){
  $('body').addClass('toggle-nav');
});

$('#navHandler > li > a').click(function(){
  $(this).parent('li').toggleClass('active').siblings().removeClass('active');
});

$('[data-tab]').click(function(){
  var name = $(this).data('tab');
  var to = $(this).data('to');
  $('[data-tab="' + name + '"]').removeClass('active');
  $(this).addClass('active');
  $('[data-tab-group="' + name + '"]').hide();
  $('[data-tab-group="'+ name + '"][data-tab-item="' + to + '"]').show();
});

$('.admin-index-control-btns .icon-open').click(function(){
  var parent = $(this).parents('.admin-index-control');
  if(parent.hasClass('open')){
    parent.removeClass('open').removeAttr('style');
  }else{
    parent.addClass('open');
    var main = $('.main');
    parent.css('width', main.width()).css('height', main.height());
  }
});

$('[data-toggle="tooltip"]').tooltip();

var datepickerOptions = {
  language: 'zh-CN',
  minView: 2,
//  timeFormat: "HH:mm:ss",
  format: 'yyyy-mm-dd hh:ii:ss'
};
// $('#adminIndexOverviewTime, #adminFixedTitleTime').on('click', '.change-time input', function(){
//   $(this).datetimepicker(datepickerOptions).datetimepicker('show');
// });

function TabsPlus (tabs) {
  this.tabs = tabs;
  this.timer = null;
  this.init();
}
TabsPlus.prototype.init = function () {
  var _this = this;
  if(_this.tabs.data('auto')){
    _this.startInterval();
  }
  this.tabs.on('click', 'a', function(event, dontReInterval){
    var target = $(this).attr('href');
    $(target).siblings('.tab').fadeOut();
    $(target).fadeIn();
    $(this).addClass('active').siblings().removeClass('active');
    if(_this.tabs.data('auto') && !dontReInterval){
      _this.reInterval();
    }
  });
}
TabsPlus.prototype.reInterval = function () {
  clearInterval(this.timer);
  this.startInterval();
}
TabsPlus.prototype.startInterval = function () {
  this.timer = setInterval(function(){
    this.next();
  }.bind(this), this.tabs.data('auto'));
}
TabsPlus.prototype.next = function () {
  var cur = this.tabs.find('.active');
  var next = cur.next();
  if(next && next.length){
    next.trigger('click', true);
  }else{
    this.tabs.find(':first').trigger('click', true);
  }
}

$('.admin-nav-tabs').each(function () {
  new TabsPlus($(this));
});

$('[data-toggle="showpic"]').click(function(){
  $('#showPicBox').show();
});
$('#showPicBox > button.close').click(function(){
  $('#showPicBox').hide();
});

function TabControlAppend(i, t, h, r){
  window.parent.TabControlAppend(i, t, h, r);
}