package com.mvc.jsonexam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JsoneIndexController {

   @RequestMapping(value="jsontest.do", method=RequestMethod.GET)
   public String jsontest() {
      System.out.println("test");
      return "jsontest/test";
   }
}
