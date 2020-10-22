package com.choa.s4.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.choa.s4.board.BoardDTO;
import com.choa.s4.util.Pager;

@Controller
@RequestMapping(value="/notice/**")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;

	
	@GetMapping("noticeSelect")
	public ModelAndView getOne(BoardDTO boardDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		boardDTO = noticeService.getOne(boardDTO);
		
		if(boardDTO != null) {
			mv.setViewName("board/boardSelect");
			mv.addObject("one", boardDTO);
			mv.addObject("board", "notice");
		}else {
			mv.setViewName("common/result");
			mv.addObject("msg", "No Data");
			mv.addObject("path", "./noticeList");
		}
		return mv;
	}
	
	@PostMapping("noticeWrite")
	public ModelAndView setInsert(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setInsert(boardDTO);
		String message = "Write Fail";
		if(result>0) {
			message = "Write Success";
		}
		
		mv.addObject("msg", message);
		mv.addObject("path", "./noticeList");
		mv.setViewName("common/result");
		return mv;
		
	}
	
	@GetMapping("noticeWrite")
	public ModelAndView setInsert() throws Exception {
		ModelAndView mv = new ModelAndView();

		mv.addObject("board", "notice");
		mv.setViewName("board/boardWrite");
		
		return mv;
	}
	
	//@RequestMapping(value="noticeList") 
	@GetMapping("noticeList") //request를 get방식으로 받을 경우(<->@PostMapping post 방식)
	public ModelAndView getList(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> ar = noticeService.getList(pager);
		
		mv.addObject("board", "notice");
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		System.out.println("Notice List");
		//servlet-context.xml에 prefix 값 /WEB-INF/views/ 되어있음 
		mv.setViewName("board/boardList"); //view이름 설정 : 속성명에 jsp경로명쓰기 
		return mv;
	}
}
