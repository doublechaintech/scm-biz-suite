<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<style>
.message{
	font-size:30px;
  padding-top: 100px;
}

</style>
<c:set var="ret" value="${result.retData.transResult}"/>


<div class="message">


		<c:forEach var="item" items="${ret}">
${item.src} => ${item.dst}

		</c:forEach >

</div>
