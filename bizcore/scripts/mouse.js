var myitem = document.getElementById("myItem");
if (myitem.addEventListener)
{
    // IE9, Chrome, Safari, Opera
    myitem.addEventListener("mousewheel", MouseWheelHandler, false);
    // Firefox
    myitem.addEventListener("DOMMouseScroll", MouseWheelHandler, false);
}
// IE 6/7/8
else
{
    myitem.attachEvent("onmousewheel", MouseWheelHandler);
}

function MouseWheelHandler(e)
{
    // cross-browser wheel delta
    var e = window.event || e; // old IE support
    var delta = Math.max(-1, Math.min(1, (e.wheelDelta || -e.detail)));

    return false;
}