<%
String title = "Ingreso";

request.setAttribute("pageTitle", title);
request.setAttribute("pageHeading", title);
%>
<!-- https://gist.github.com/kinetiq/652120033e4c515c1eacf51de7843ddf -->
<%@ include file="../common/header.jspf"%>

	<div class="container col-md-6" align="justify">
                        
            <form action="${url}login.do" method="post">

                <p>
                        <font color="red">${errorMessage}</font>
                </p>
              <div class="md-form">
                <i class="fa fa-envelope prefix grey-text"></i>
                <input type="text" id="defaultForm-email" name="name" class="form-control">
                <label for="defaultForm-email">Your email</label>
              </div>

              <div class="md-form">
                <i class="fa fa-lock prefix grey-text"></i>
                <input type="password" id="defaultForm-pass" name="password"  class="form-control">
                <label for="defaultForm-pass">Your password</label>
              </div>

              <div class="text-center">
                <input type="submit" value="Login" class="btn btn-default"/>
                <a href="${url}register.do" class="btn btn-blue"/>Register</a>
              </div>
            </form>

	</div>


<%@ include file="../common/footer.jspf"%>