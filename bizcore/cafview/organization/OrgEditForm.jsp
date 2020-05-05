
<%@page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html; charset=UTF-8"%>
<ul>
	<c:set var="currentLevel" value="0"/>
<c:forEach var="field" items="${result.fields}" varStatus="status">
	
	
	<c:if test="${ field.level > currentLevel}">
		<c:set var="currentLevel" value="${field.level}"/>
		<ul>
	</c:if>
	<c:if test="${ field.level < currentLevel}">
		<c:set var="currentLevel" value="${field.level}"/>
		</ul>
	</c:if>

	<li>
	<span id="fl${status.index}" placeHolder="${field.name}" title="${field.key}" type="text" contentEditable="true">
	${field.value}
	</span></li>
	
	
	

</c:forEach>
<ul>