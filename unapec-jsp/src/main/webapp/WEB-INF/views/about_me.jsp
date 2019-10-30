<%
String title = "About Me";

request.setAttribute("pageTitle", title);
request.setAttribute("pageHeading", title);
%>
<%@ include file="../common/header.jspf"%>

  <div class="row">

      <div class="col-md-2">
      </div>
      <div class="col-md-8">
        <ul class="unstyled">
              <li>You like this website?</li>
          <li>You want to help me for the time that I take to create software and open source scripts?</li>
          <li>You want my projects evolve and remains on the Web?</li>
          <li>You want to help with the cost of servers and the time that I take to do this?</li>
          <li>You use one of my scriptsVous love what I do?</li>
          <li>Etc...</li>
        </ul>
      </div>
  </div>
    
    <h3><strong>So you can support me in different ways:</strong></h3>
  <div class="row">
      <div class="col-md-3">
        <p><h4>So, make a donation!</h4><br />
        You can give what you want ;-)</p>
        <form action="https://www.paypal.com/cgi-bin/webscr" method="post">
            <input type="hidden" name="cmd" value="_s-xclick">
            <!--input type="hidden" name="hosted_button_id" value="3QDGGYCTF5V3A"-->
            <input type="hidden" name="hosted_button_id" value="3QDGGYCTF5V3A">
            <input type="image" src="https://www.paypalobjects.com/en_US/BE/i/btn/btn_donateCC_LG.gif" border="0" name="submit" alt="PayPal - The safer, easier way to pay online!">
            <img alt="" border="0" src="https://www.paypalobjects.com/en_US/i/scr/pixel.gif" width="1" height="1">
        </form>
      </div>
      <div class="col-md-3">
        <p><h4>Make a link site or article:</h4></p>
        <p>Put a link on your website, blog or forums in your signature.</p>

      </div>
      <div class="col-md-3">
        <p><h4>Word of mouth:</h4></p>
        <p>Feel free to talk about this site and its products around you and around you.</p>
      </div>
      <div class="col-md-3">
        <p><h4>Help me in what I do:</h4></p>
        <p>Feel free to contribute to my work (software, scripts, ...), give your opinions and reviews, etc..</p>
      </div>
  </div>
        <p>Thank you very much for your understanding!</p>

        <p class="italic gray">Contact me at: <a href="mailto:${emailAddress}">${emailAddress}</a></p>
        
<%@ include file="../common/footer.jspf"%>