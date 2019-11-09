package com.unapec.jsp.filter;

import com.unapec.jsp.core.AccountInfo;
import org.apache.commons.lang3.StringUtils;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import com.unapec.jsp.core.Config;
import java.util.Arrays;

@WebFilter(urlPatterns = "*.do")
public class LoginRequiredFilter implements Filter {

	@Override
	public void destroy() {

	}
        
        // LOGIN (JDBC)
        // http://met.guc.edu.eg/OnlineTutorials/JSP%20-%20Servlets/Full%20Login%20Example.aspx
        
        // WEB SERVICES
        // https://www.wisdomjobs.com/e-university/jsp-tutorial-279/soap-interacting-with-web-services-2164.html
        // https://www.oreilly.com/library/view/java-web-services/9781449373856/ch01s08.html
        // http://www.jtech.ua.es/j2ee/publico/struts-2010-11/sesion01-struts-apuntes.html
        
        // JSP IS OBSOLETE (due to RESTful apps being superior in org)
        // https://www.linkedin.com/pulse/20141028052803-6665552-has-rest-architecture-finally-put-jsp-to-rest

	@Override
	public void doFilter(ServletRequest servletRequest,
            ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {
            
            servletRequest.setAttribute("siteName", Config.SITE_NAME);
            servletRequest.setAttribute("pageTitle", Config.TITLE_SITE);
            servletRequest.setAttribute("metaDescription", Config.META_DESCRIPTION);
            servletRequest.setAttribute("metaKeywords", Config.META_KEYWORDS);
            servletRequest.setAttribute("year", Config.getYear());
            servletRequest.setAttribute("url", Config.SITE_URL);
            servletRequest.setAttribute("tplUrl", Config.TPL_URL);
            servletRequest.setAttribute("staticUrl", Config.STATIC_URL);
            servletRequest.setAttribute("analyticsId", Config.ANALYTICS_ID);
            servletRequest.setAttribute("emailAddress", Config.CONTACT_EMAIL);

            HttpServletRequest request = (HttpServletRequest) servletRequest;
            String pageRequested = request.getRequestURI();


            String[] pages = {"list-todos.do", "add-todo.do"};
//            if(pageRequested.contains("add-todo.do")) {   
// https://stackoverflow.com/questions/8992100/test-if-a-string-contains-any-of-the-strings-from-an-array
// https://coderanch.com/t/452077/java/JSF-Filter-prevent-direct-access
            /*if(StringUtils.indexOfAny(pageRequested, pages) != -1) {
                if(request.getSession().getAttribute("name") == null) {
                    request.getRequestDispatcher("/login.do").forward(servletRequest,
                            servletResponse);         
                }
            }*/
            if(Arrays.stream(pages).parallel().anyMatch(pageRequested::contains)) {
                if(request.getSession().getAttribute("name") == null) {
                    request.getRequestDispatcher("/login.do").forward(servletRequest,
                            servletResponse);     
                    return;
                }
            } else {
                if(request.getSession().getAttribute("name") != null) {
                    if(pageRequested == "register.do") {
                     request.getRequestDispatcher("/list-todos.do").forward(servletRequest,
                            servletResponse);     
                    }
                }
            }
            
            chain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void init(FilterConfig servletRequest) throws ServletException {
	}

}
