<%
String title = "Contact Me";

request.setAttribute("pageTitle", title);
request.setAttribute("pageHeading", title);
%>
<%@ include file="../common/header.jspf"%>

	<p>Contact me at <a href="mailto:${emailAddress}">${emailAddress}</a></p>
        
<%@ include file="../common/footer.jspf"%>