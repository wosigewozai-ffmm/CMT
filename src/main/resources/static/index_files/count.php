
var stats_href       = escape(location.href);
var stats_referrer   = escape(document.referrer);
var stats_language   = navigator.systemLanguage ? navigator.systemLanguage : navigator.userLanguage;
var stats_colordepth = screen.colorDepth;
var stats_screensize = screen.width+'*'+screen.height;
var stats_date       = new Date();
var stats_timezone   = 0 - stats_date.getTimezoneOffset()/60;
document.write("<SCRIPT LANGUAGE='JavaScript' src='http://lib.seu.edu.cn/module/count/count.php?fid=1&nowurl="+stats_href+"&fromurl="+stats_referrer+"&windows_lang="+stats_language+"&screen_size="+stats_screensize+"'></SCRIPT>");
	