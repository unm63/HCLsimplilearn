package com.example.UserManager.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.UserManager.entities.User;
import com.example.UserManager.exceptions.UserNotFoundException;
import com.example.UserManager.services.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
    Logger logger = LoggerFactory.getLogger(UserController.class);

	
	@GetMapping("/users")
	public String showUsers(ModelMap model) {
		
		
		logger.info("Getting all Users");
		Iterable<User> users = userService.GetAllUsers();
		
		logger.info("Passing users to view");
	    model.addAttribute("users", users);    
		
        return "users";
    }
	
	@RequestMapping("/changepage")
	public String showPage()
	{
		return "queryUserInput";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView showEditStudentPage(@RequestParam(name = "id") int id) {
        ModelAndView mav = new ModelAndView("editUserInput");
        User user = userService.GetUserById(id);
        if (user == null) {
        	throw new UserNotFoundException();
        }
        mav.addObject("user", user);
       // userService.UpdateUser(user);
        return mav;
        
    }
//	@RequestMapping(value = "/edit/{id}", method= RequestMethod.GET) 
//	public String edit(@PathVariable(name = "id") int id, Map<String, Object> map ){
//		
//		User user = userService.GetUserById(id);
//		map.put("user", user);
//		
//		return "user/edit";
//		
//	}
	
	
	  @RequestMapping(value = "/save", method = RequestMethod.POST) 
	  public String saveUser(@ModelAttribute("user") User user){
		  logger.info("saving user");
		  userService.UpdateUser(user);
			 
		  return "redirect:/";
		  
		  
	  }
	
	  @RequestMapping(value= "/go", method=RequestMethod.GET)
		public String updateUsers(ModelMap model,@RequestParam("id") int id, @RequestParam("name") String name, 
				@RequestParam("email") String email,@RequestParam("password") String password) {
				
			logger.info("About to update user");
			User userupdate = userService.GetUserById(id);
			userupdate.setName(name);
			userupdate.setEmail(email);
			userupdate.setPassword(password);
			userService.UpdateUser(userupdate);
			String result="Successfully Updated"; 
			logger.info("User Updated");
		    model.addAttribute("result", result);     
			
	        return "redirect:/";
		

	}
	

}
