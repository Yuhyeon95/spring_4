package com.choa.s4.board.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choa.s4.MyTestCase;
import com.choa.s4.board.BoardDTO;
import com.choa.s4.util.Pager;

public class NoticeServiceTest extends MyTestCase{

	@Autowired
	private NoticeService noticeService;
	
	@Test
	public void getListTest() throws Exception {
		Pager pager = new Pager(); //NoticeService에서 row, page 메서드 실행함
		
		List<BoardDTO> ar = noticeService.getList(pager);
		assertEquals(10, ar.size());
	}
}
