package com.unapec.jsp.core;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Config {
    	
    // https://mdbootstrap.com/support/jquery/mdboostrap-cdn-starter-template/
    
	public final static String SITE_NAME = "unapec-jsp";
	public final static String TITLE_SITE = "Hogar";
	public final static String META_DESCRIPTION = "Welcome on my site";
	public final static String META_KEYWORDS = "ph, software, java, jsp";
	    
	public final static String SITE_URL = "/unapec-jsp/";
	public final static String TPL_URL = "/unapec-jsp/assets/";
	public final static String STATIC_URL = "/unapec-jsp/static/";
	    
	public final static String ANALYTICS_ID = "UA-31501397-1"; // Google Analytics ID
	public final static String CONTACT_EMAIL = "support@seikenvolf.com";
	    
    public static String getYear() {
    	Date date = new Date();
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
    	return dateFormat.format(date);	
    }
    	
}
  