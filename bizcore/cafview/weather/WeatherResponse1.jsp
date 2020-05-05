<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
.message{
	font-size:30px;
}

</style>
<c:set var="today" value="${result.retData.today}"/>
<div class="message">
     ${today.type} 空气质量: ${today.aqi}  当前温度： ${today.curTemp} 温度范围:  ${today.lowtemp} ~ ${today.hightemp}
</div>
