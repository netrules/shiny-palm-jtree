<%
String title = "Añadir Algo";

request.setAttribute("pageTitle", title);
request.setAttribute("pageHeading", title);
%>
<%@ include file="../../common/header.jspf"%>

<div class="row">
<div class="col-md-2"></div>
<div class="col-md-8">
    <h2>Your New Action Item:</h2>
                        
    <form action="${url}add-todo.do" method="post">

    <p>
            <font color="red">${errorMessage}</font>
    </p>
      <div class="md-form">
        <input type="text" id="defaultForm-email" name="todo" class="form-control">
        <label for="defaultForm-email">Description</label>
      </div>

      <div class="md-form">
        <input type="text" id="defaultForm-pass" name="category"  class="form-control">
        <label for="defaultForm-pass">Categoría</label>
      </div>

      <div class="text-center">
        <input name="add" type="submit" value="Submit" class="btn btn-success"/>
      </div>
    </form>

</div>
    
</div>


<%@ include file="../../common/footer.jspf"%>