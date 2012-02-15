package jcf.edu.user.controller;



import jcf.edu.user.service.PicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PicController {
	
	@Autowired
	private PicService picService;
	
	

}
