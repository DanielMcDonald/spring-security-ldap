package com.danny.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles and retrieves the common or admin page depending on the URI template.
 * A user must be log-in first he can access these pages.  Only the admin can see
 * the adminpage, however.
 */
@Controller
@RequestMapping("/main")
public class MainController {

	protected static Logger logger = Logger.getLogger("controller");
	
	/**
	 * Handles and retrieves the common JSP page that everyone can see
	 * 
	 * @return the name of the JSP page
	 */
    @RequestMapping(value = "/common", method = RequestMethod.GET)
    public String getCommonPage() {
    	logger.debug("Received request to show common page");
    
    	// Do your work here. Whatever you like
    	// i.e call a custom service to do your business
    	// Prepare a model to be used by the JSP page
    	
    	// This will resolve to /WEB-INF/jsp/commonpage.jsp
    	return "commonpage";
	}
    
    @RequestMapping(value = "/common", method = RequestMethod.POST)
    public @ResponseBody Integer add(@RequestParam(value="inputNumber1", required=true) Integer inputNumber1,
           @RequestParam(value="inputNumber2", required=true) Integer inputNumber2,
           Model model) {
  logger.debug("Received request to add two numbers");
   
  // Delegate to service to do the actual adding
  Integer sum = inputNumber1 + inputNumber2;
   
  // @ResponseBody will automatically convert the returned value into JSON format
  // You must have Jackson in your classpath
  return sum;
 }
    
    /**
     * Handles and retrieves the admin JSP page that only admins can see
     * 
     * @return the name of the JSP page
     */
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String getAdminPage() {
    	logger.debug("Received request to show admin page");
    
    	// Do your work here. Whatever you like
    	// i.e call a custom service to do your business
    	// Prepare a model to be used by the JSP page
    	
    	// This will resolve to /WEB-INF/jsp/adminpage.jsp
    	return "adminpage";
	}
  
    /**
     * Handles request for adding two numbers
     */
}