
<%@ page import='java.util.*,com.doublechaintech.retailscm.*'%>

<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<fmt:setLocale value="zh_CN"/>


<%BaseEntity result=(BaseEntity)request.getAttribute("result");%>


    <c:if test="${not empty result.userAppList}" >





 <c:forEach var="item" items="${result.userAppList}">
				
	 <span class=" col-xs-6 col-xm-6 col-sm-6 col-md-4 col-lg-3  text-center align-middle  icon-effect-1 icon-effect-1b">
	  			<br/><br/>
                 <a href="./secUserManager/selectApp/${item.id}/"> 
                <i class="icon fa fa-${item.appIcon} fa-5x" ></i> <br/> ${item.title} 
                </a>
                
                
      </span>			
	
		
</c:forEach>


 	


</div>       <!-- /.row -->
        


</div></c:if>



