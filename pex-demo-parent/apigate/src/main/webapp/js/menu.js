
function gotoURL(url) {
    document.menuForm.action = url;
    document.menuForm.target = "mainFrame";
    document.menuForm.submit();
}

/** *新的MENU** */
var LastLeftID = "";

function quickmenuToggle(obj) {
    var i;
    var smsum;
    var elementID = obj.id;

   /* var obj2 = document.getElementById("subquickmenutitle")
	    .getElementsByTagName("li");
    for ( var i = 0; i < obj2.length; i++) {

	obj2[i].getElementsByTagName("a")[0].className = "quickmenu";
    }*/
    var obj1 = document.getElementById("nav").getElementsByTagName("li");
    for ( var i = 0; i < obj1.length; i++) {

	obj1[i].getElementsByTagName("a")[0].className = "nomal";

    }
    obj.getElementsByTagName("a")[0].className = "chang";

}

function menuToggle(obj) {
    var i;
    var smsum;
    var elementID = obj.id;
    var obj1 = document.getElementById("nav").getElementsByTagName("li");
    for ( var i = 0; i < obj1.length; i++) {
	obj1[i].getElementsByTagName("a")[0].className = "nomal";
    }
    /*var obj2 = document.getElementById("subquickmenutitle")
	    .getElementsByTagName("li");
    for ( var i = 0; i < obj2.length; i++) {

	obj2[i].getElementsByTagName("a")[0].className = "quickmenu";

    }*/
    obj.getElementsByTagName("a")[0].className = "ag";
}

function DoMenu(emid) {
    var obj = document.getElementById(emid);
    obj.className = (obj.className.toLowerCase() == "expanded" ? "collapsed"
	    : "expanded");
    if ((LastLeftID != "") && (emid != LastLeftID)) // 关闭上一个Menu
    {
	document.getElementById(LastLeftID).className = "collapsed";
    }
    LastLeftID = emid;
}

function DoMenuFrameMenu(emid) {
    var obj = parent.menuFrame.document.getElementById(emid);
    obj.className = (obj.className.toLowerCase() == "expanded" ? "collapsed"
	    : "expanded");

    if ((parent.menuFrame.LastLeftID != "")
	    && (emid != parent.menuFrame.LastLeftID)) // 关闭上一个Menu
    {
	parent.menuFrame.document.getElementById(parent.menuFrame.LastLeftID).className = "collapsed";
    }
    parent.menuFrame.LastLeftID = emid;
}

function GetMenuID() {

    var MenuID = "";
    var _paramStr = new String(window.location.href);

    var _sharpPos = _paramStr.indexOf("#");

    if (_sharpPos >= 0 && _sharpPos < _paramStr.length - 1) {
	_paramStr = _paramStr.substring(_sharpPos + 1, _paramStr.length);
    } else {
	_paramStr = "";
    }

    if (_paramStr.length > 0) {
	var _paramArr = _paramStr.split("&");
	if (_paramArr.length > 0) {
	    var _paramKeyVal = _paramArr[0].split("=");
	    if (_paramKeyVal.length > 0) {
		MenuID = _paramKeyVal[1];
	    }
	}
	/*
	 * if (_paramArr.length>0) { var _arr = new Array(_paramArr.length); }
	 * 
	 * //取所有#后面的，菜单只需用到Menu //for (var i = 0; i < _paramArr.length; i++) {
	 * var _paramKeyVal = _paramArr[i].split('=');
	 * 
	 * if (_paramKeyVal.length>0) { _arr[_paramKeyVal[0]] = _paramKeyVal[1]; } }
	 */
    }

    if (MenuID != "") {
	DoMenu(MenuID);
    }
}
