/**
 * How to use:
 * 	each dragable-list can have a DragDropManager instance.
 *  So, after body content, write scripts like below:
 *  <script>
 *    var dragManager1 = new DragDropManager();
 *    dragManager1.init('#drag_container_id', '.drag_item_class', dragStyle_obj, callback);
 *  </script>
 *  dragStyle_obj is a JSON object, for example:
 *  dragStyle_obj = {
 *  	over_left_top_style: 'a_css_class_used_when_the_dragging_obj_is_over_the_lef_top_of_an_element',
 *  	over_left_bottom_style: 'a_css_class_used_when_over_left_bottom',
 *  	over_right_top_style: 'a_class_for_right_top',
 *  	over_right_bottom_style: 'a_class_for_right_bottom'
 *  }
 *  callback is a function called back when drop occured.
 *  function foo(draggingELement, dropedTargetELement, drop_postion) {...}
 *  drop_postion could be "left_top", "left_bottom", "right_top" or "right_bottom"
 */
var oid = 1000;
var currentToolId = 0;

var DragDropManager = function(){
    var showDragingPoints = true;
    var me = this;
    var controlInfo = {};
    function clearDragableElementStyle() {
        var lastElem = controlInfo.lastEffectElement;
        if (lastElem) {
            lastElem.removeClass(controlInfo.dragStyle.over_left_top_style);
            lastElem.removeClass(controlInfo.dragStyle.over_left_bottom_style);
            lastElem.removeClass(controlInfo.dragStyle.over_right_top_style);
            lastElem.removeClass(controlInfo.dragStyle.over_right_bottom_style);
        }
    }
    function findDragbleElement(startElem){
        var obj = startElem;
        while(obj != null){
            if ($(obj).data("drag-drop-tool-id") == controlInfo.objId){
                return obj;
            }
            obj = $(obj).parent()[0];
        }
        return null;
    }
    function clearDragPoints(){
        if (showDragingPoints){
            $(controlInfo.targetSelector).children("#start_point").remove();
            $(controlInfo.targetSelector).children("#current_point").remove();
            $(controlInfo.targetSelector).children("#target_point").remove();
        }
    }
    me.reinit = function(){
        $(controlInfo.elementSelector).each(function(i, elem){
            $(elem).prop("draggable", true);
            //$(elem).data("index", i);
            $(elem).attr("data-index", i);
            $(elem).data("drag-drop-tool-id", controlInfo.objId);
            elem.ondragstart=me.onStart;
            elem.ondragover=me.onOver;
            //console.log("elem_"+i+": " + elem.offsetLeft+"," + elem.offsetTop+", " +$(elem).data("index"));
        });
    }
    me.init = function(targetSelector, elementSelector, dragStyle, callback){
        controlInfo.targetSelector = targetSelector;
        controlInfo.elementSelector = elementSelector;
        controlInfo.callback = callback;
        controlInfo.dragStyle=dragStyle;
        showDragingPoints = dragStyle.showDragingPoints | false;

        $(targetSelector)[0].ondrop = me.onDrop;
        controlInfo.objId = oid++;

        callbackFun = callback;
        me.reinit();
        
    }
    me.onStart = function(event){
        var elemData=$(event.target).data("index");
        event.dataTransfer.setData("Text",elemData);
        currentToolId = controlInfo.objId;
        
        //console.log(elemData+" was dragged");
        controlInfo.startElement = event.target;
        controlInfo.sourceIndex = elemData;
        controlInfo.startOffsetLeft = event.target.offsetLeft + event.target.clientWidth/2;
        controlInfo.startOffsetTop = event.target.offsetTop+ event.target.clientHeight/2;
        controlInfo.startClientX = event.clientX
        controlInfo.startClientY = event.clientY;
        //$(controlInfo.startElement).hide();
        if (showDragingPoints) {
            var targetSelector = $(controlInfo.targetSelector)
            targetSelector.append('<div id="start_point" style="z-index: 100; position: absolute; height: 3px; width: 3px; color: yellow;">o</div>');
            targetSelector.append('<div id="current_point" style="z-index: 100; position: absolute; height: 3px; width: 3px; color: blue;">+</div>');
            targetSelector.append('<div id="target_point" style="z-index: 100; position: absolute; height: 3px; width: 3px; color: red;">x</div>');
        }
    }

    me.onOver = function(event){
        var tgtToolId = currentToolId;
        var orgToolId = controlInfo.objId;
        if (tgtToolId != orgToolId){
            return;
        }
        event.preventDefault();
        
        var tgtElement = findDragbleElement(event.target);
        if (tgtElement == null){
            return;
        }

        var elemData=$(tgtElement).data("index");
        var srcData=event.dataTransfer.getData("Text");
        
        controlInfo.targetIndex = elemData;

        var offsetLeft = event.clientX - controlInfo.startClientX + controlInfo.startOffsetLeft;
        var offsetTop = event.clientY - controlInfo.startClientY + controlInfo.startOffsetTop;

        var curElemOffsetLeft = tgtElement.offsetLeft;
        var curElemOffsetTop = tgtElement.offsetTop;
        var curElemClientWidth = tgtElement.clientWidth;
        var curElemClientHeight = tgtElement.clientHeight;

        if (showDragingPoints) {
            $('#start_point').css('left',controlInfo.startOffsetLeft+"px");
            $('#start_point').css('top',controlInfo.startOffsetTop+"px");

            $('#current_point').css('left',offsetLeft+"px");
            $('#current_point').css('top',offsetTop+"px");

            $('#target_point').css('left',curElemOffsetLeft + curElemClientWidth/2+"px");
            $('#target_point').css('top',curElemOffsetTop + curElemClientHeight/2+"px");
        }

        //console.log("offset is " +offsetLeft+","+offsetTop);

        var quadrant = "";
        if (offsetLeft < (curElemOffsetLeft + curElemClientWidth/2)){
            quadrant = "left_";
        }else{
            quadrant = "right_";
        }

        if (offsetTop < (curElemOffsetTop + curElemClientHeight/2)){
            quadrant += "top";
        }else{
            quadrant += "bottom";
        }
        controlInfo.quadrant = quadrant;
        clearDragableElementStyle();
        lastElem = $(tgtElement);
        lastElem.addClass(controlInfo.dragStyle["over_"+quadrant+"_style"]);
        //console.log("the source " + srcData + " is over " + elemData+" " + quadrant);
        controlInfo.lastEffectElement = lastElem;
    }
    me.onDrop = function(event){
        clearDragPoints();
        clearDragableElementStyle();
        var tgtToolId = currentToolId;
        var orgToolId = controlInfo.objId;
        if (tgtToolId != orgToolId){
            return;
        }
        currentToolId = 0;
        
        
        event.dataTransfer.clearData();
        var movedELement = $(controlInfo.targetSelector).find("[data-index='"+controlInfo.sourceIndex+"']");
        var tgtELement = $(controlInfo.targetSelector).find("[data-index='"+controlInfo.targetIndex+"']");
        controlInfo.callback(movedELement, tgtELement, controlInfo.quadrant);
    }
}