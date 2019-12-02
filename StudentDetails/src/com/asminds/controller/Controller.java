package com.asminds.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.asminds.daoimple.DaoImple;
import com.asminds.pojo.Student;
import com.asminds.pojo.UpdatePojo;

@org.springframework.stereotype.Controller
public class Controller {

	@RequestMapping("/")
	public String home()
	{
		System.out.println("i am in home method");
		return "home";
	}
	
	
	@RequestMapping("/home")
	public String ho()
	{
		
		System.out.println("i am in ho method  ");
		return"home";
	}
	@RequestMapping("/create")
	public String insert1()
	{
		System.out.println("im in insert1 method");
		return "insert1";
	}
	
	
	@RequestMapping("/save")
	
	public String CreateValidatmethod(@ModelAttribute ("u") Student s)
	{
		System.out.println("im in CreateValidatemethod control");
		
		DaoImple dao=new DaoImple();
		dao.insert(s);
	
		return "redirect:/" ;
		
	}
	
	@RequestMapping("/select")
	public String search1()
	{
		System.out.println("i am in search1 method");
		return "search1";
	}
	@RequestMapping("/search1")
	public ModelAndView SearchAfter(@ModelAttribute ("t") Student s)
	{
		System.out.println("im in searchAfter control");
		System.out.println(s.getId());
		DaoImple dao=new DaoImple();
		List<Student>l=dao.search(s);
		return new ModelAndView("search2","kk",l);	
	}
	

	@RequestMapping("/delete")  
    public ModelAndView EmpView() {  
      System.out.println(" Im in delete 2");
		DaoImple dao=new DaoImple();
     
      System.out.println(" Going to get details for delete ");
      List<Student> emp = dao.getallStudentpojo();
 
        return new ModelAndView("delete", "list", emp);
 }
	
	

	@RequestMapping(value="/deleteemp/{id}")  
    public ModelAndView delete(@PathVariable int id){ 
	 
		DaoImple dao=new DaoImple();
		dao.deleteEmployee(id);
	
      return new ModelAndView("redirect:/"); 
	}
     
      
      @RequestMapping("/update")  
	    public ModelAndView update() {  
	      System.out.println(" Im in logincheck");
			DaoImple dao=new DaoImple();
	     
	      System.out.println(" Going to get  details for update");
	      List<Student> emp = dao.getallStudentpojo();
	    
	        return new ModelAndView("update", "update", emp);
      }
      
      @RequestMapping("/update1")
  	public ModelAndView update1(@ModelAttribute("h") UpdatePojo up) {
  		System.out.println("sixth method");
  		DaoImple di=new DaoImple();
  		List<Student>l=di.updateDAO(up);
  		System.out.println("total number of records"+l.size());
  		return new ModelAndView("update1","up",l);
  	}
  	
	        
	        
	    	@RequestMapping("/update2")
	    	public String Update2(@ModelAttribute("upd") Student loo) {
	    	
	    		System.out.println("updted");
	    		System.out.println(loo.getAddress());

	    		DaoImple update=new DaoImple();
	    		Boolean b = update.updateemployeeDao(loo);
	    		if(b==true) {
	    			return "redirect:/";
	    		}else {
	    			return "/update";	
	    		}		
	    		}
	
	    	
	    	@RequestMapping("/displayall")
	    	public ModelAndView display()
	    	{    		   
	    		      System.out.println(" Im in logincheck");
	    				DaoImple dao=new DaoImple();
	    		     
	    		      System.out.println(" Going to get the emp");
	    		      List<Student> emp = dao.getallStudentpojo();
	    		     
	    		        return new ModelAndView("displayall", "list", emp);
	    		 }
	    		
	    	}
	



