<%@ tag 
		pageEncoding="UTF-8"
		body-content="scriptless" 
		dynamic-attributes="dynParameters"
		import="java.net.URL" %>

<%@ attribute name="page" type="java.lang.String" required="true" %>
<%@ attribute name="referName" type="java.lang.String" required="false" %>


<%! public URL fileURL;%>
<%
	String filePath = (String)pageContext.getAttribute("page"); //should be replaced with some mechanism of getting the name;perhaps as a request attribute
    fileURL = pageContext.getServletContext().getResource("/customview/" + filePath);
	if (fileURL != null) {
		filePath = "/customview/" + filePath;
	} 
	if (fileURL == null) {
		fileURL = pageContext.getServletContext().getResource("/coreview/" + filePath);
		if (fileURL != null) {
			filePath = "/coreview/" + filePath;
		}
	}
	if (fileURL == null) {
		filePath = null;
	}
	
	if (filePath != null) {
%>
<!-- from <%=filePath%> -->
<jsp:include page="<%=filePath%>" flush="true">
    <jsp:param name="referName" value="${referName}"/>
</jsp:include>
<%}else{%>
 <span style="background-color: black; color: white;">你可以在文件 <%=pageContext.getAttribute("page") %> 中为此页面添加片段</span>
<%}%>