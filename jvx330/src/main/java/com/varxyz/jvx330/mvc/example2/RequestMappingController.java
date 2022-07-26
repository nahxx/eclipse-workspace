package com.varxyz.jvx330.mvc.example2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RequestMappingController {
	
	@RequestMapping(value="/example2/mapping", method = RequestMethod.GET) // Get방식으로 이 url로 들어왔을 때 메소드를 사용하라
	public String getMapping() { // 리턴타입 String은 보여주고 싶은 페이지url
		return "example2/mapping_result"; // 즉, return된 url 페이지로 이동
	}
	
	@RequestMapping(value="/example2/mapping", method = RequestMethod.POST) // POST방식으로 이 url로 들어왔을 때 메소드를 사용하라
	public ModelAndView postMapping() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("example2/mapping_result"); // example2/mapping_result 페이지로 이동
		mav.addObject("result", "post 요청의 결과 메시지");
		
		return mav;
	}
}
