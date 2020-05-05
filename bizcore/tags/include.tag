<%@ tag 
		body-content="scriptless" 
		dynamic-attributes="dynParameters"
		import="java.net.URL" %>
<%@ attribute name="page" type="java.lang.String" required="true" %>
<%@ attribute name="referName" type="java.lang.String" required="false" %>


<%! public URL fileURL;%>
<%
    String filePath = (String)pageContext.getAttribute("page"); //should be replaced with some mechanism of getting the name;perhaps as a request attribute
    fileURL = pageContext.getServletContext().getResource("/customview/" + filePath);
%>
<% if(fileURL==null) {
	// cannot found orignal file
	filePath = "/coreview/" + filePath;
   } else {
	// already present jsp files
	filePath = "/customview/" + filePath;
   } %>
<!-- from <%=filePath%> -->
<jsp:include page="<%=filePath%>" flush="true">
    <jsp:param name="referName" value="${referName}"/>
</jsp:include>