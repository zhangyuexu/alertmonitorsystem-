var datepickerOptions = {
  language: 'zh-CN',
  pickerPosition: 'top-right',
  minView: 2,
//  timeFormat: "HH:mm:ss",
  format: 'yyyy-mm-dd hh:ii:ss'
};
$('#iTimeStart').datetimepicker(datepickerOptions);
$('#iTimeEnd').datetimepicker(datepickerOptions);