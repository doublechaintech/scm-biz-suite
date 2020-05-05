function reportResult(target, reqURI, container, successMessage, failMessage,newValue) {

	var done = false;
	target.attr(workingAttrName,"YES");
	target.css('background-color', 'yellow');
	var request = $.ajax({
		url : "./" + reqURI,
		type : "GET",
		dataType : "html"
	});
	//console.log("---->"+reqURI);
	request.fail(function(msg){target.attr(workingAttrName,"NO");});
	request.done(function(msg) {
		var index = msg.indexOf("Exception");
		target.attr(workingAttrName,"NO");
		if(index >0){
			var firstLine = msg.substring(index).split('\n')[0];
			$(container).html(firstLine);
			target.css('background-color', 'red');
			$(container).css('background-color', 'red');
			return;
		}
		index = msg.indexOf("alert-danger");
		if(index >0){
			//var firstLine = msg.substring(index).split('\n')[0];
			$(container).html(msg);
			target.css('background-color', 'red');
			//$(container).css('background-color', 'red');
			return;
		}
		//have to get the version number from the response, this is more reliable way
		
		
		
		$(container).html("");
		//currentVersion
		target.css('background-color', '#0c0');
		var line = target.closest("tr");
		var lineId = line.attr("id");
		
		var returnedLine = $(msg).find("#"+lineId);
		
		
		
		
		
		//var currentVersion = parseInt(line.attr("currentVersion")) + 1;
		
		var currentVersion = returnedLine.attr("currentVersion");
		console.log("------------------> id '"+lineId+"' from remote: "+currentVersion );
		line.attr("currentVersion",currentVersion);
		//console.log("currentVersion is: "+line.attr("currentVersion"));
		target.attr('storedCellValue',newValue);
		
		
		//$(container).html(successMessage);
		
	});

}
var reportCellError = function(target, reqURI,successMessage, failMessage, newValue){
	
	
	reportResult(target, reqURI,"#msg",successMessage,failMessage, newValue);
}
/*
 * 					String cellProperty = "contenteditable='true' class='edit-value' "
							+" currentVersion='${item.version}' propertyToChange='"+fd.getCamelRunName()+"'"
							+" prefix='${ownerBeanName}Manager/update"+ od.getClassName()+"/${result.id}/${item.id}/";
	
 * 
 * 
 * */
var workingAttrName='working-indicator';
var handleCellChange = function(targetElement) {
	
	//event.preventDefault();
	var line = $(targetElement).closest("tr");
	var working = $(targetElement).attr(workingAttrName);
	if(working){
		if(working=="YES"){
			return;
		}
		
	}
	
	var prefix = $(targetElement).attr('prefix');
	var currentVersion = line.attr('currentVersion');
	var propertyToChange = $(targetElement).attr('propertyToChange');
	var storedCellValue = $(targetElement).attr('storedCellValue');
	
	//var linkto=$(targetElement).attr('action');
	var linkto=prefix+currentVersion+"/"+propertyToChange+"/";
	
	//toggleActive($(this));
	//console.log("---->"+linkto+": "+$(targetElement));
	var fieldValue = $(targetElement).text();
	
	if(fieldValue.length==0){
		return;
	}
	
	if(storedCellValue == fieldValue){
		//return;
	}
	
	console.log("current value: "+ fieldValue +"; currentVersion: "+currentVersion);
	var pageToken = $(targetElement).closest("table").attr("pageToken");
	var reqURI = linkto + encodeURIComponent(fieldValue) +"/"+pageToken+"/";
	
	//console.log("---->"+reqURI);
	
	//http://localhost:8080/naf/orderManager/updateLineItem/O000001/LI000010/skuName/iPad%20-%20133/
	reportCellError($(targetElement),reqURI,"GOOD: "+ reqURI,"OOPS: "+ reqURI,fieldValue);
	return false;
	
}

var handleCellReturn = function(event) {
	
	//console.log("handleReturn---->"+event.target);
	
	console.log("keyCode: "+event.keyCode);
	/*
	if(event.keyCode == 37){
		var nexttd = $(event.target).prev();// td->tr->tbody
		nexttd.focus();
		return false;
	}
	if(event.keyCode == 39){
		var nexttd = $(event.target).next();// td->tr->tbody
		nexttd.focus();
		return false;

	}*/
	if(event.keyCode == 37 || event.keyCode ==39){
		return true;
	}
	if(event.keyCode >= 112 &&  event.keyCode <= 123){
		// ignore F1~F12
		return true;
	}
	if(event.keyCode == 0){
		// ignore none-key event
		return true;
	}
	if(event.keyCode == 38){
		var columnIndex = $(event.target).index();
		var tr = $(event.target).parent();// td->tr->tbody
		tr.prev().children().eq(columnIndex).focus();
		return false;

	}
	if(event.keyCode == 40){ //down key
		var columnIndex = $(event.target).index();
		var tr = $(event.target).parent();// td->tr->tbody
		tr.next().children().eq(columnIndex).focus().select();
		return false;

	}
	
	
	if(event.keyCode == 13){
		var columnIndex = $(event.target).index();
		var tr = $(event.target).parent();// td->tr->tbody
		tr.next().children().eq(columnIndex).focus().select();
		
		
		/*tr.children().each(function(index){
			console.log($(this));
			console.log($(this).index());
			if(columnIndex == index ){
				console.log("try to focus")
				$(this).focus();
				return false;
			}
			
		})*/
		
		
		
		return false;
    }
	
	handleCellChange(event.target);
	
	return true;
	
	//event.preventDefault();
	
	
}



var handleCellPress = function(event) {
	
	console.log("---->"+event.target);

	if(event.keyCode == 13){
		//handleChange(event);
		return false;
    }
	
	
	
	//event.preventDefault();
	
	
}



function fillPartialResult(reqURI, container) {

	var done = false;
	
	var request = $.ajax({
		url : "./" + reqURI,
		type : "GET",
		dataType : "html"
	});
	
	request.done(function(msg) {
		done = true;
		var index = msg.indexOf("Exception");
		if(index >0){
			var firstLine = msg.substring(index).split('\n')[0];
			alert(firstLine);
			return;
		}

		//$(container).html(msg);
		console.log("logging to history section" + reqURI);
		//$('#parent').find('div').first().remove();
		
		//var dom = $.parseHTML( msg );
		var text = $(msg).find(container);
		console.log("get the text from "+container+"" + text.html());
		$(container).html(text.html());
		//var lastReqURL = $('#parent').find('li').last().attr("href");
		
		
	});
	/*<a href="#acceleratorCreationManager/loadAcceleratorCreationDetail"
	 *  methodname="loadAcceleratorCreationDetail" beanname="acceleratorCreationManager" 
	 *  class="action">loadAcceleratorCreationDetail</a>*/
	
	console.log("---------------------------------------------");

	request.fail(function(jqXHR, textStatus, errorThrown) {
		// alert("Request failed: " + textStatus);
		done = true;
		$(container).html("<div style='text-align: left' >" + jqXHR.responseText + "</div>")
	});

	var wait = function() {
		if (done) {
			return;
		}
		$(container).html("请耐心等待" + reqURI + "，时间可能有点长，外面的服务比较慢，不是我慢........要不，给你讲个笑话吧....");
	}
	setTimeout(wait, 500);

}


function fillResult(reqURI, container) {

	var done = false;
	
	var request = $.ajax({
		url : "./" + reqURI,
		type : "GET",
		dataType : "html"
	});
	
	request.done(function(msg) {
		done = true;
		var index = msg.indexOf("Exception");
		if(index >0){
			var firstLine = msg.substring(index).split('\n')[0];
			alert(firstLine);
			return;
		}
		$(container).html(msg);
		console.log("logging to history section" + reqURI);
		//$('#parent').find('div').first().remove();
		
		
		var lastReqURL = $('#parent').find('li').last().attr("href");
		
		if(lastReqURL == reqURI){
			console.log("the same with previous: " + reqURI);
			
			return;
		}
		
		
		var array=reqURI.split("/");
		if(array.length < 4){
			//means no parameter
			return;
		}
		
		var size  = $("#history").find('li').size();
		if(size > 5){
			$('#history').find('li').first().remove();
		}
		$("#history").append("<li><a href='#"+reqURI+"' class='history-action'>"+array[1]+"</li>");
		
		
	});
	/*<a href="#acceleratorCreationManager/loadAcceleratorCreationDetail"
	 *  methodname="loadAcceleratorCreationDetail" beanname="acceleratorCreationManager" 
	 *  class="action">loadAcceleratorCreationDetail</a>*/
	
	//console.log("---------------------------------------------");

	request.fail(function(jqXHR, textStatus, errorThrown) {
		// alert("Request failed: " + textStatus);
		done = true;
		$(container).html("<div style='text-align: left' >" + jqXHR.responseText + "</div>")
	});

	var wait = function() {
		if (done) {
			return;
		}
		$(container).html("请耐心等待" + reqURI + "，时间可能有点长，外面的服务比较慢，不是我慢........要不，给你讲个笑话吧....");
	}
	setTimeout(wait, 500);

}

var isMobile = false; //initiate as false
//device detection
if(/(android|bb\d+|meego).+mobile|avantgo|bada\/|blackberry|blazer|compal|elaine|fennec|hiptop|iemobile|ip(hone|od)|ipad|iris|kindle|Android|Silk|lge |maemo|midp|mmp|netfront|opera m(ob|in)i|palm( os)?|phone|p(ixi|re)\/|plucker|pocket|psp|series(4|6)0|symbian|treo|up\.(browser|link)|vodafone|wap|windows (ce|phone)|xda|xiino/i.test(navigator.userAgent) 
 || /1207|6310|6590|3gso|4thp|50[1-6]i|770s|802s|a wa|abac|ac(er|oo|s\-)|ai(ko|rn)|al(av|ca|co)|amoi|an(ex|ny|yw)|aptu|ar(ch|go)|as(te|us)|attw|au(di|\-m|r |s )|avan|be(ck|ll|nq)|bi(lb|rd)|bl(ac|az)|br(e|v)w|bumb|bw\-(n|u)|c55\/|capi|ccwa|cdm\-|cell|chtm|cldc|cmd\-|co(mp|nd)|craw|da(it|ll|ng)|dbte|dc\-s|devi|dica|dmob|do(c|p)o|ds(12|\-d)|el(49|ai)|em(l2|ul)|er(ic|k0)|esl8|ez([4-7]0|os|wa|ze)|fetc|fly(\-|_)|g1 u|g560|gene|gf\-5|g\-mo|go(\.w|od)|gr(ad|un)|haie|hcit|hd\-(m|p|t)|hei\-|hi(pt|ta)|hp( i|ip)|hs\-c|ht(c(\-| |_|a|g|p|s|t)|tp)|hu(aw|tc)|i\-(20|go|ma)|i230|iac( |\-|\/)|ibro|idea|ig01|ikom|im1k|inno|ipaq|iris|ja(t|v)a|jbro|jemu|jigs|kddi|keji|kgt( |\/)|klon|kpt |kwc\-|kyo(c|k)|le(no|xi)|lg( g|\/(k|l|u)|50|54|\-[a-w])|libw|lynx|m1\-w|m3ga|m50\/|ma(te|ui|xo)|mc(01|21|ca)|m\-cr|me(rc|ri)|mi(o8|oa|ts)|mmef|mo(01|02|bi|de|do|t(\-| |o|v)|zz)|mt(50|p1|v )|mwbp|mywa|n10[0-2]|n20[2-3]|n30(0|2)|n50(0|2|5)|n7(0(0|1)|10)|ne((c|m)\-|on|tf|wf|wg|wt)|nok(6|i)|nzph|o2im|op(ti|wv)|oran|owg1|p800|pan(a|d|t)|pdxg|pg(13|\-([1-8]|c))|phil|pire|pl(ay|uc)|pn\-2|po(ck|rt|se)|prox|psio|pt\-g|qa\-a|qc(07|12|21|32|60|\-[2-7]|i\-)|qtek|r380|r600|raks|rim9|ro(ve|zo)|s55\/|sa(ge|ma|mm|ms|ny|va)|sc(01|h\-|oo|p\-)|sdk\/|se(c(\-|0|1)|47|mc|nd|ri)|sgh\-|shar|sie(\-|m)|sk\-0|sl(45|id)|sm(al|ar|b3|it|t5)|so(ft|ny)|sp(01|h\-|v\-|v )|sy(01|mb)|t2(18|50)|t6(00|10|18)|ta(gt|lk)|tcl\-|tdg\-|tel(i|m)|tim\-|t\-mo|to(pl|sh)|ts(70|m\-|m3|m5)|tx\-9|up(\.b|g1|si)|utst|v400|v750|veri|vi(rg|te)|vk(40|5[0-3]|\-v)|vm40|voda|vulc|vx(52|53|60|61|70|80|81|83|85|98)|w3c(\-| )|webc|whit|wi(g |nc|nw)|wmlb|wonu|x700|yas\-|your|zeto|zte\-/i.test(navigator.userAgent.substr(0,4))){

	isMobile = true;

}

$(function() {
	var linkfunc=function(event) {
		//event.preventDefault();
		var linkto=$(this).attr('href');
		console.log(linkto);
		//toggleActive($(this));		
		var reqURI = linkto.substring(1);
		
		
		var target = $("#result");
		//console.log(target);
		if(target.length){
			console.log("trying to fill result")
			fillResult(reqURI,"#result");
			return false;
		}
		
		console.log("trying to fill content")
		fillResult(reqURI,"#content");
		return false;
	};
	
	$(".sublist").on("click", ".link-action",linkfunc);
	$(".link-action").click(linkfunc);
	$(".verb-action").click(function(event) {
		
		//event.preventDefault();
		var linkto=$(this).attr('href');
		console.log(linkto);
		//toggleActive($(this));
		
		var reqURI = linkto.substring(1);
		
		
		var target = $("#result");
		
		
		console.log("trying to fill content")
		fillResult(reqURI,"#content");
		return false;
	});
	
	$(".sublist").on("click", ".page-action",function(event) {
		
		
		
		event.preventDefault();
		var linkto=$(this).attr('href');
		console.log(linkto);
		var reqURI = linkto.substring(1);
		
		console.log("trying to fill content")
		
		var id = $(this).closest(".sublist").attr("id");
		console.log("get the linked -> "+linkto);
		console.log("get the id -> "+id);
		
		fillPartialResult(reqURI,"#"+id);
		
		return false;
	});
	
	$(".sublist").on("click", ".delete-action, .copy-action",function(event) {
		console.log("is any code enter here?");
		event.preventDefault();
		var currentVersion = $(this).closest("tr").attr('currentVersion');
		var linkto=$(this).attr('href')+currentVersion+"/";
		console.log(linkto);
		
		
		var pageToken = $(this).closest("table").attr("pageToken");
		
		
		var reqURI = linkto.substring(1)+pageToken+"/";
		
		console.log("trying to fill content")
		
		var id = $(this).closest(".sublist").attr("id");
		
		
		console.log("get the linked -> "+linkto);
		console.log("get the id -> "+id);
		
		fillPartialResult(reqURI,"#"+id);
		
		return false;
	});
	
	$(".sublist").on("click", ".candidate-action",function(event) {
		console.log("want to select candidate");
		event.preventDefault();
		var tdElem = $(event.target).closest(".select_candidate_td");
		var queryUrl = $(tdElem).data("candidate-method");
		var actionUrl = $(tdElem).data("switch-method");
		var contentUrl = $(tdElem).data("link-template");
		console.log("query candidate to " + queryUrl);
		var tgtSpan = $(tdElem).find("div.candidate_span");
		var valueSpan = $(tdElem).find("span.display_span");
		var cnddInput = $(tgtSpan).find('.candidate-filter-input');
		var paginationElem = tgtSpan.find('div.candidate_pagination');
		//////////////////////////////
		$(cnddInput).typeahead('destroy');
		var tobj = $(cnddInput).typeahead({
			source: function(query, process){
				var me = this;
				console.log("query with " + query +" at page " + me.pageNo);
				var pageNo = Math.max(1, me.pageNo);
				me.pageNo = pageNo;
				var items = new Array();
				var queryContent = "+";
				if (query != ''){
					queryContent = encodeURIComponent(query);
				}
				var url = queryUrl+queryContent+"/"+pageNo+"/"; // init from empty filter and page 1
				var request = $.ajax({
					url : url,
					type : "GET",
					dataType : "json"
				});
				
				request.done(function(msg) {
					for(var i=0;i<msg.candidates.length;i++){
						items.push({
							value: msg.candidates[i][msg.valueFieldName],
							name: msg.candidates[i][msg.displayFieldName]
						});
					}
					if (items.length == 0){
						process([{value:"", name:"没有找到任何数据"}]);
						return;
					}
					me.totalPage = msg.totalPage;
					process(items);
					
					//$(cnddInput).focus();
				});
				
			},
			minLength:0,
			matcher: function(){return true;},
			fitToElement: true,
			delay: 500,
			items:20,
			showHintOnFocus: true,
			onCancel: function(){
				tgtSpan.hide();
				valueSpan.show();
			},
			afterSelect: function(item){
				if (item.value == ""){
					alert(item.name);
					return;
				}
				var url = actionUrl + item.value +"/";
				var request = $.ajax({
					url : url,
					type : "GET",
					dataType : "json"
				});
				request.done(function(msg) {
					if (typeof msg.id != "string"){
						alert("操作失败，请刷新页面再试。");
						return;
					}
					var aElem = $(tdElem).find("span.display_span a");
					$(aElem).attr("href", contentUrl.replace("\${ID}", item.value));
					$(aElem).text(item.name+"("+item.value+")");
					tgtSpan.hide();
					valueSpan.show();
				});
			}
		});
		//$(cnddInput).on('focus', $(cnddInput).typeahead.bind($(cnddInput), 'lookup'));
		
		tgtSpan.show();
		valueSpan.hide();
		$(cnddInput).focus();
	});
	
	if(!isMobile && ($("#qr").length == 0)){
		console.log("code get here in mobile");
		
		
		
		$("<li><a data-toggle='tab' href='#qr'><i class=\"fa fa-qrcode\"></i> "+qrLocaleLabel+"</a></li>").appendTo('#navi-tabs');
		
		
		
		var qr = $("<div id='qr' class='tab-pane fade sublist'></div>");
		
		var container = $("<div class='row' style='font-size: 30px;' ></div>");
		var imageContainer = $("<div id='imagediv' class='col-xs-12 col-md-12'style='padding-left:20px'>"+scanQRTips+"</div>")
		
		imageContainer.appendTo(container);
		container.appendTo(qr);
		console.log("current qr sect:" + qr.text());
		qr.appendTo('#tab-content');
		
		var url =  window.location.href;
		var index = url.indexOf("#");
		var trimedURL = url;
		if(index > 0){
			trimedURL = url.substring(0,index);
		}
		
		var el = document.getElementById("imagediv");
		if(el==null){
			return;
		}
		
		var qrcode = new QRCode("imagediv", {
    			text: trimedURL,
    			width: 128,
    			height: 128,
    			colorDark : "#000000",
    			colorLight : "#ffffff",
    			correctLevel : QRCode.CorrectLevel.H
			});
		
		
	
	}
	$(".sublist").on("keyup",".edit-value",handleCellReturn);
	$(".sublist").on("keypress",".edit-value",handleCellReturn);
	
	//$(".edit-value").keyup(handleCellReturn);
	//$(".edit-value").keypress(handleCellPress);
	
	
});



