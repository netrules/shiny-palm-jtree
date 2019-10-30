<%
String title = "Registrar";

request.setAttribute("pageTitle", title);
request.setAttribute("pageHeading", title);
%>
<!-- https://gist.github.com/kinetiq/652120033e4c515c1eacf51de7843ddf -->
<%@ include file="../common/header.jspf"%>

<!-- Default form register -->


      <div class="row">
          <div class="col-md-3"></div>
        <div class="col-md-6">
<form class="text-center border border-light p-5" action="${url}register.do" method="post">

    <p>
            <font color="red">${errorMessage}</font>
    </p>
                
    <!-- E-mail -->
    <input type="email"name="name" id="defaultRegisterFormEmail" class="form-control mb-4" placeholder="E-mail">

    <!-- Password -->
    <input type="password" name="password" id="defaultRegisterFormPassword" class="form-control" placeholder="Password" aria-describedby="defaultRegisterFormPasswordHelpBlock">
    <small id="defaultRegisterFormPasswordHelpBlock" class="form-text text-muted mb-4">
        At least 8 characters and 1 digit
    </small>
    
    <!-- Password -->
    <input type="password" name="password2" id="defaultRegisterFormPassword2" class="form-control" placeholder="Repeat Password" aria-describedby="defaultRegisterFormPasswordHelpBlock">
    <small id="defaultRegisterFormPasswordHelpBlock" class="form-text text-muted mb-4">
        Same as before
    </small>

    <!-- Register button -->
    <input type="submit" value="Register" class="btn btn-info"/>

    <hr>

    <!-- Terms of service -->
    <p>By clicking
        <em>Sign up</em> you agree to our
        <a href="${url}privacy.do" target="_blank">terms of service</a>

</form>
<!-- Default form register -->

        </div></div>


<%@ include file="../common/footer.jspf"%>