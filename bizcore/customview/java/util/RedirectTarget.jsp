<%@ page import='com.terapico.caf.baseelement.RedirectTarget,
	com.caucho.server.connection.AbstractHttpResponse,
	com.caucho.server.http.HttpResponse'%>
<% 
AbstractHttpResponse respWrapper = (AbstractHttpResponse)response;
HttpResponse httpResponse = (HttpResponse)respWrapper.getResponse();
httpResponse.setContentType("text/plain; charset=UTF-8");
RedirectTarget result = (RedirectTarget)request.getAttribute("result");
String tgtUrl = result.getRedirectUrl();
if (tgtUrl.startsWith("http")){
  httpResponse.sendRedirect(tgtUrl);
}else{
  String baseUrl = (String)request.getAttribute("baseURL");
  String ctxPath = request.getContextPath();
  
  System.out.println("baseUrl url is " + baseUrl);
  if (tgtUrl.startsWith("./")){
      tgtUrl = ctxPath + tgtUrl.substring(1);
  }else if (tgtUrl.startsWith("/")){
      // nothing to do
  }else{
      tgtUrl = ctxPath + tgtUrl;
  }
  System.out.println("redirect url is " + tgtUrl);
  httpResponse.sendRedirect(tgtUrl);
}
%><%@ page language="java" contentType="text/plain; charset=utf-8"%>
