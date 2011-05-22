package com.danny.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.danny.domain.Person;
import com.danny.service.PersonService;


/**
 * Handles and retrieves person request
 */
@SuppressWarnings("restriction")
@Controller
@RequestMapping("/person")
public class PersonController {

	protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name="personService")
	private PersonService personService;

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	/**
	 * Handles and retrieves all persons and show it in a JSP page
	 * 
	 * @return the name of the JSP page
	 */
    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public String getPersons(Model model) {
    	
    	logger.debug("Received request to show all persons");
    	
    	// Retrieve all persons by delegating the call to PersonService
    	List<Person> persons = personService.getAll();
    	
    	// Attach persons to the Model
    	model.addAttribute("persons", persons);
    	String test = "test if jrebel works =D";
    	model.addAttribute("testing", test);
    	
    	// This will resolve to /WEB-INF/jsp/personspage.jsp
    	return "personspage";
	}
    
    @RequestMapping(value = "/persons/search", method = RequestMethod.POST)
    public String search(@RequestParam(value="searchTerm", required=true) String searchTerm, Model model) {
    	
    	logger.debug("Received request to show all persons");
    	
    	// Search for persons by delegating the call to PersonService
    	List<Person> persons = personService.searchByFirstName(searchTerm);
    	
    	// Attach persons to the Model
    	model.addAttribute("persons", persons);
    	
    	// This will resolve to /WEB-INF/jsp/searchpage.jsp
    	return "searchpage";
	}
    
    /**
     * Retrieves the add page
     * 
     * @return the name of the JSP page
     */
    @RequestMapping(value = "/persons/add", method = RequestMethod.GET)
    public String getAdd(Model model) {
    	logger.debug("Received request to show add page");
    String testString = "Data from model!!!";
    	// Create new Person and add to model
    	// This is the formBackingOBject
    	model.addAttribute("personAttribute", new Person());
    	model.addAttribute("testAttribute", testString);

    	// This will resolve to /WEB-INF/jsp/addpage.jsp
    	return "addpage";
	}
 
    /**
     * Adds a new person by delegating the processing to PersonService.
     * Displays a confirmation JSP page
     * 
     * @return  the name of the JSP page
     */
   
    @RequestMapping(value = "/persons/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("personAttribute") @Valid Person person, BindingResult result) {
		logger.debug("Received request to add new person");
		
		if (result.hasErrors()){
			return "addpage";
		}
		
    	// The "personAttribute" model has been passed to the controller from the JSP
    	// We use the name "personAttribute" because the JSP uses that name
		
		// Call PersonService to do the actual adding
		personService.add(person);

    	// This will resolve to /WEB-INF/jsp/addedpage.jsp
		return "addedpage";
	}
    
    /**
     * Deletes an existing person by delegating the processing to PersonService.
     * Displays a confirmation JSP page
     * 
     * @return  the name of the JSP page
     */
    @RequestMapping(value = "/persons/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value="id", required=true) Integer id, 
    										Model model) {
   
		logger.debug("Received request to delete existing person");
		
		// Call PersonService to do the actual deleting
		personService.delete(id);
		
		// Add id reference to Model
		model.addAttribute("id", id);
    	
    	// This will resolve to /WEB-INF/jsp/deletedpage.jsp
		return "deletedpage";
	}
    
    @RequestMapping(value = "/persons/view", method = RequestMethod.GET)
    public String view(@RequestParam(value="id", required=true) Integer id, 
    										Model model) {
   
		logger.debug("Received request to delete existing person");
		
		Person person = personService.get(id);
		
		// Add id reference to Model
		model.addAttribute("person", person);
    	
    	// This will resolve to /WEB-INF/jsp/deletedpage.jsp
		return "viewpage";
	}
    
    /**
     * Retrieves the edit page
     * 
     * @return the name of the JSP page
     */
    @RequestMapping(value = "/persons/edit", method = RequestMethod.GET)
    public String getEdit(@RequestParam(value="id", required=true) Integer id,  
    										Model model) {
    	logger.debug("Received request to show edit page");
    
    	// Retrieve existing Person and add to model
    	// This is the formBackingOBject
    	model.addAttribute("personAttribute", personService.get(id));
    	
    	// This will resolve to /WEB-INF/jsp/editpage.jsp
    	return "editpage";
	}
    
    /**
     * Edits an existing person by delegating the processing to PersonService.
     * Displays a confirmation JSP page
     * 
     * @return  the name of the JSP page
     */
    @RequestMapping(value = "/persons/edit", method = RequestMethod.POST)
    public String saveEdit(@ModelAttribute("personAttribute") Person person, 
    										   @RequestParam(value="id", required=true) Integer id, 
    												Model model) {
    	logger.debug("Received request to update person");
    
    	// The "personAttribute" model has been passed to the controller from the JSP
    	// We use the name "personAttribute" because the JSP uses that name
    	
    	// We manually assign the id because we disabled it in the JSP page
    	// When a field is disabled it will not be included in the ModelAttribute
    	person.setId(id);
    	
    	// Delegate to PersonService for editing
    	personService.edit(person);
    	
    	// Add id reference to Model
		model.addAttribute("id", id);
		
    	// This will resolve to /WEB-INF/jsp/editedpage.jsp
		return "editedpage";
	}
    
    
    ///AJAX METHODS
    @RequestMapping(value = "/personsajaxpage", method = RequestMethod.GET)
    public String getPersonsAjaxPage() {
    	
    	logger.debug("Received request to show persons page for ajax");
    	return "persons-ajax";
	}
	
	@RequestMapping(value = "/personsajax", method = RequestMethod.GET)
    public @ResponseBody List<Person> getPersonsAjax() {
    	
    	logger.debug("Received ajax request to show all persons");
    	
    	// Retrieve all persons by delegating the call to PersonService
    	List<Person> persons = personService.getAll();
    	
    	return persons;
	}
	
	@RequestMapping(value = "/personsearchajax", method = RequestMethod.GET)
    public @ResponseBody List<Person> ajaxSearch(@RequestParam(value="personsID", required=true) String personsID) {
    	
    	logger.debug("Received ajax request to search for persons (by first name)");
    	
    	// Search for persons by delegating the call to PersonService
    	List<Person> persons = personService.searchByFirstName(personsID);
    	
    	// This will resolve to /WEB-INF/jsp/searchpage.jsp
    	return persons;
	}
    
}
