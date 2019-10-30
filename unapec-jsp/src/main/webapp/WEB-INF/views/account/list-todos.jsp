<%
String title = "Cuenta";

request.setAttribute("pageTitle", title);
request.setAttribute("pageHeading", title);
%>
<%@ include file="../../common/header.jspf"%>
<jsp:useBean id='date'  class='java.util.Date'/>
<jsp:useBean id='account'  class='com.unapec.jsp.core.AccountInfo'>
    <jsp:setProperty name='account' property='username'
                     value='${name}'/>
    <!--jsp:setProperty name='account' property='password'
                     value='smith'/-->
 </jsp:useBean>

<div class="row">
<div class="col-md-2"></div>
<div class="col-md-8">
	<!--h2>Welcome ${name}</h2-->
        <!--h2>Welcome <jsp:getProperty name='account' property='username'/>!</h2-->
        <h2><%=account%></h2>
        <span> Today is <%=date%> </span>
        <script type="text/javascript">
            function submit() {
                document.getElementById('gadget_url').value = "WAITING FOR MESSAGE";
                var Http = new XMLHttpRequest();
                var url='http://localhost:8181/unapec-jsp/receiveJMS.do';
                Http.open("GET", url);
                Http.send();

                Http.onreadystatechange = (e) => {
//                  console.log(Http.responseText)
                    document.getElementById('gadget_url').value = Http.responseText;
                }
            }

        </script>
        <p> Todo of the day: <input type="text" name="gadget_url" id="gadget_url" style="width: 350px;" class="input"/> <input type="submit" value="Get Daily" onclick="submit()"> </p>

	<table class="table table-striped">
		<figcaption class="figure-caption text-left">Your Todos are</figcaption>
		<thead>
			<th>Description</th>
			<th>Category</th>
			<th>Actions</th>
		</thead>
		<tbody>
                    <c:forEach items="${todos}" var="todo">
                    <tr>
                            <td>${todo.description}</td>
                            <td>${todo.category}</td>
                            <td>&nbsp;&nbsp;<a class="btn btn-danger"
                                    href="${url}delete-todo.do?todo=${todo.id}">Delete</a></td>
                    </tr>
                    </c:forEach>
		</tbody>
	</table>

	<p>
		<font color="red">${errorMessage}</font>
	</p>
	<a class="btn btn-success" href="${url}add-todo.do">Add New Todo</a>
	<a class="btn btn-success" href="${url}add-random-todo.do">Add Random Todo</a>
</div>
    
</div>

<%@ include file="../../common/footer.jspf"%>