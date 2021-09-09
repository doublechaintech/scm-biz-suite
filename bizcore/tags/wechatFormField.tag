<%@ tag 
		body-content="scriptless" 
		dynamic-attributes="dynParameters"
		import="java.net.URL" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:if test="${curGroup == 'hidden' }">
    <input name="${curField.parameterName}" class="form-field" type="hidden" value="${curField.defaultValue}" />
</c:if>
<c:if test="${curGroup != 'hidden' }">
    <c:set var="fieldMessage" value="${formData.getFieldMessage(curField.parameterName) }"/>
    <c:if test='${not empty fieldMessage}'>
    <div class="weui-cells__tips">${fieldMessage.title}</div>
    </c:if>
    <div class="weui-cell <c:if test='${not empty fieldMessage and fieldMessage.level !="success" and fieldMessage.level !="info" }'> weui-cell_warn</c:if>">
        <div class="weui-cell__hd"><label class="weui-label">${curField.label}</label></div>
        <div class="weui-cell__bd">
            <jsp:doBody></jsp:doBody>
        </div>
        <c:if test='${not empty fieldMessage}'>
        <div class="weui-cell__ft">
            <c:if test="${fieldMessage.level == 'success'}"><i class="weui-icon-success"></i></c:if>
            <c:if test="${fieldMessage.level == 'info'}"><i class="weui-icon-info"></i></c:if>
            <c:if test="${fieldMessage.level == 'warning'}"><i class="weui-icon-warn" style="color: #FFBE00;"></i></c:if>
            <c:if test="${fieldMessage.level == 'danger'}"><i class="weui-icon-warn"></i></c:if>
        </div>
        </c:if>
    </div>
</c:if>