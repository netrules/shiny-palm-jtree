<%
String title = "Home";

request.setAttribute("pageTitle", title);
request.setAttribute("pageHeading", title);
%>
<!-- https://gist.github.com/kinetiq/652120033e4c515c1eacf51de7843ddf -->
<%@ include file="../common/header.jspf"%>

      <!--First row-->
      <div class="row">
        <div class="col-md-7">
          <!--Featured image -->
          <div class="view overlay hm-white-light z-depth-1-half">
            <img src="https://mdbootstrap.com/images/proffesions/slides/socialmedia/img%20(2).jpg" class="img-fluid " alt="">
            <div class="mask">
            </div>
          </div>
          <br>
        </div>

        <!--Main information-->
        <div class="col-md-5">
          <h2 class="h2-responsive wow fadeInDown">unapec-jsp <small>by S. González.</small></h2>
          <hr>
          <p>

            <ul class="wow fadeInUp">
              <li>En este template se esta utilizando CDN de <a href="https://mdbootstrap.com/">MDBootstrap</a></li>
              <li class="red-text">Tambien se usa <b></b>, <b>Servlet</b>, <b>Beans</b> y mas metodos Java .</li>
              <li class="red-text">Adicionalmente, se le agrego funcionamiento con:</li>
              <li class="red-text"><b>JNDI</b>, <b>JMS</b>, <b>JNI</b> .</li>
              <li class="red-text"><b>EJB</b>, <b>RMI</b>, <b>CORBA</b></li>
              <li>Todo lo que necesitas en una <strong>sola</strong> pagina.</li>
              <!--li><a href="https://www.thoughtco.com/content-delivery-network-3469509">Razonamiento logistica ?</a></li-->
            </ul>
            <a href="https://gist.github.com/mrmccormack/1c3ba355f020d9901f0bb5af25f871f2" class="btn btn-primary">Get it now from GitHub.com!</a>
        </div>
      </div>
      <!--/.First row-->

      <hr class="extra-margins">

      <!--Second row-->
      <div class="row">
        <!--First columnn-->
        <div class="col-md-4">
          <!--Card-->
          <div class="card">

            <!--Card image-->
            <div class="view overlay hm-white-slight">
              <img src="https://mdbootstrap.com/images/regular/city/img%20(2).jpg" class="img-fluid" alt="">
              <a href="#">
                <div class="mask"></div>
              </a>
            </div>
            <!--/.Card image-->

            <!--Card content-->
            <div class="card-block p-3">
              <!--Title-->
              <h4 class="card-title">La Vega</h4>
              <!--Text-->
              <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
              <a href="#" class="btn btn-primary">Read more</a>
            </div>
            <!--/.Card content-->

          </div>
          <!--/.Card-->
        </div>
        <!--First columnn-->

        <!--Second columnn-->
        <div class="col-md-4">
          <!--Card-->
          <div class="card">

            <!--Card image-->
            <div class="view overlay hm-white-slight">
              <img src="https://mdbootstrap.com/images/regular/city/img%20(4).jpg" class="img-fluid" alt="">
              <a href="#">
                <div class="mask"></div>
              </a>
            </div>
            <!--/.Card image-->

            <!--Card content-->
            <div class="card-block p-3">
              <!--Title-->
              <h4 class="card-title">San Isidro</h4>
              <!--Text-->
              <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
              <a href="#" class="btn btn-primary">Read more</a>
            </div>
            <!--/.Card content-->

          </div>
          <!--/.Card-->
        </div>
        <!--Second columnn-->

        <!--Third columnn-->
        <div class="col-md-4">
          <!--Card-->
          <div class="card">

            <!--Card image-->
            <div class="view overlay hm-white-slight">
              <img src="https://mdbootstrap.com/images/regular/city/img%20(8).jpg" class="img-fluid" alt="">
              <a href="#">
                <div class="mask"></div>
              </a>
            </div>
            <!--/.Card image-->

            <!--Card content-->
            <div class="card-block p-3">
              <!--Title-->
              <h4 class="card-title">Santiago</h4>
              <!--Text-->
              <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
              <a href="#" class="btn btn-primary">Read more</a>
            </div>
            <!--/.Card content-->

          </div>
          <!--/.Card-->
        </div>
        <!--Third columnn-->
      </div>
      <!--/.Second row-->




<%@ include file="../common/footer.jspf"%>