<style>
#login_tool_container {
	float: right;
}
#login_tool_container button {
	font-size: 1em;
	padding: 2px 5px;
	border-radius: 5px;
	border: none;
	display: inline-block;
	background-color: initial;
}
.login_method_buttons {
	display:inline;
	height: 40px;
	width: 100px;
	position: relative;
}
.login_method_buttons > span {
	display: flex;
	flex-direction: column;
	background-color: red;
}
</style>
<div style="display: block;margin-bottom: 10px;padding-bottom: 5px;box-shadow: 0px 10px 10px lightgray;">
	<div class="menu">
		[<a href="${userContext.ownerBeanName}/viewHomePage/">首页</a>]
		[<a href="${userContext.ownerBeanName}/customerViewTodoList/+/+/">工单</a>]
		[<a href="${userContext.ownerBeanName}/customerViewMaintenancePlan/+/">计划</a>]
		[<a href="${userContext.ownerBeanName}/viewMePage/">我的</a>]
		<span style="padding: 0px 20px">|</span>

		[<a href="wxappLogOut/">登出</a>]
		[<a href="${userContext.ownerBeanName}/openTools/" target="_blank">工具</a>]
		
		<div id="login_tool_container">
			<form action="${userContext.ownerBeanName}/clientLogin/" method="put">
			<label>Code|ID</label><input id="code" 
	<c:if test="${not empty userContext.currentUserInfo }">
				value="${userContext.currentUserInfo.internalType}_${userContext.currentUserInfo.id}"
	</c:if>
			/>
			<select id="loginMethod" onchange="javascript:clientLogin()" value="xxx">
				<option value="xxx">选登录方法</option>
				<option value="mobile_vcode">短信验证码登录</option>
				<option value="wechat-work">企业微信Code登录</option>
				<option value="wechat">普通微信Code登录</option>

				<option value="debug">Debug:直接ID登录</option>
			</select>
			</form>
		</div>

	</div>
	
</div>
<div id="wxlogin_container"></div>
<script type="text/javascript" src="https://res.wx.qq.com/connect/zh_CN/htmledition/js/wxLogin.js"></script>
<script type="text/javascript">

</script>
<script type="text/javascript">
function clientLogin() {
	var loginMethod = $('#loginMethod').val();
	switch (loginMethod) {
	case "mobile_vcode":
	    mobileVcodeLogin();
        break;
	case "wechat-work":
		wechatWorkLogin();
		break;
	case "wechat":
		wechatLogin();
		break;
	case "debug":
		debugLogin();
		break;
	default:
	}
}
function mobileVcodeLogin() {
	var url = "${userContext.ownerBeanName}/loginForTest/formData/";
    	var formData = {
            	loginMethod:"mobile_vcode",
            	code:$('#code').val()
    			};
    	$("#input4submitFormData").val(JSON.stringify(formData));
    	$("#form4submit")[0].action = url;
    	$("#form4submit")[0].submit();
}
function wechatLogin() {
    /*
    var obj = new WxLogin({
        self_redirect:true,
        id:"wxlogin_container",
        appid: "wxffe4c48a31d36507",
        scope: "snsapi_login",
        redirect_uri: "https://demo.doublechaintech.com/saleschain/${userContext.ownerBeanName}/callbackOnTestLogin/",
        state: "debug"
     });
    */

	var url = "${userContext.ownerBeanName}/loginForTest/formData/";
	var formData = {
        	loginMethod:"wechat_app",
        	code:$('#code').val()
			};
	$("#input4submitFormData").val(JSON.stringify(formData));
	$("#form4submit")[0].action = url;
	$("#form4submit")[0].submit();

}
function wechatWorkLogin() {
	var url = "${userContext.ownerBeanName}/loginForTest/formData/";
	var formData = { 
        	loginMethod:"wechat_work_app",
        	code:$('#code').val()
			};
	$("#input4submitFormData").val(JSON.stringify(formData));
	$("#form4submit")[0].action = url;
	$("#form4submit")[0].submit();
}
function debugLogin() {
	var url = "${userContext.ownerBeanName}/loginForTest/formData/";
	var formData = { 
        	loginMethod:"debug",
        	id:$('#code').val()
			};
	$("#input4submitFormData").val(JSON.stringify(formData));
	$("#form4submit")[0].action = url;
	$("#form4submit")[0].submit();
}

</script>
