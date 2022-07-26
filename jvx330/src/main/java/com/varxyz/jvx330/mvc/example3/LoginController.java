package com.varxyz.jvx330.mvc.example3;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller("example3.loginController") 
// 같은 이름을 가진 컨트롤러가 다른 패키지에도 존재할 경우 충돌할수도 있다.
// 그때는 위처럼 example3에 있는 LoginController라는걸 표시해주면 된다.
public class LoginController {
	
	@GetMapping("/example3/login")
	public String loginForm() {
		return "example3/login";
	}
	
	// @PostMapping("/example3/login")
	public ModelAndView login(HttpServletRequest request) { // getParameter 사용하기 위해 HttpServletRequest를 파라미터로 넣어줌
		String userId = request.getParameter("userId");
		String passwd = request.getParameter("passwd");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("userId", userId);
		mav.addObject("passwd", passwd);
		mav.setViewName("example3/login_result");
		
		return mav;
	}
	
	@PostMapping("/example3/login")
	public ModelAndView login(@RequestParam(value="userId", required = true) String id,
			@RequestParam String passwd) {
		/*
		 "userId"로 파라미터값 받아서 id에 넣어줌(required가 true만 반드시 값이 들어와야 한다. 안들어오면 에러.(required의 기본값은 true)
		 passwd같은 경우 "passwd"의 파라미터값을 받아와서 passwd에 넣어준다는 의미(userId와 동일하지만 생략이 많음. 이럴 땐 받아오는 파라미터의 이름 passwd와 담을 변수 이름이 동일해야 한다)
		 따라서 userId의 값을 간단하게 받아오려면 아래처럼 수정하면 된다.
		 @RequestParam String userId
		 */
		ModelAndView mav = new ModelAndView();
		mav.addObject("userId", id);
//		mav.addObject("userId", userId); // 어노테이션으로 설정해준 변수 이름을 담아줌
		mav.addObject("passwd", passwd);
		mav.setViewName("example3/login_result");
		
		return mav;
		
	}
}
