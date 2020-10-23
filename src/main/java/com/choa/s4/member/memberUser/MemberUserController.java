package com.choa.s4.member.memberUser;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.choa.s4.member.MemberDTO;

@Controller
@RequestMapping("/member/**")
public class MemberUserController {
	
	@Autowired
	private MemberUserService memberUserService;
	
	//getMemberLogout
	@GetMapping("memberLogout")
	public ModelAndView getMemberLogout(HttpSession session) throws Exception{
		
		//웹브라우저 종료
		//일정시간 경과(로그인 후에 요청이 발생하면 시간이 연장)
		//MemberDTO를 NULL로 대체
		session.invalidate();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:../");
		return mv;
	}
	

	//getMemberLogin
	@GetMapping("memberLogin")
	public ModelAndView getMemberLogin() throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("member/memberLogin");
		return mv;
	}
	
	@PostMapping("memberLogin")
	public ModelAndView getMemberLogin(MemberDTO memberDTO, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		memberDTO = memberUserService.getMemberLogin(memberDTO);
		
		if(memberDTO !=null) {
			//index.jsp 페이지로 이동
			//redirect
			//mv.addObject("member", memberDTO);
			session.setAttribute("member", memberDTO);
			mv.setViewName("redirect:../");
			
		}else {
			//로그인 실패 메세지를 alert
			mv.addObject("msg", "Login Fail");
			
			//로그인 입력 폼으로 이동
			mv.addObject("path", "./memberLogin");
			//forward
			mv.setViewName("common/result");

		}
		return mv;
		
	}
}
