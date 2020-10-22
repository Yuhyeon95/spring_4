package com.choa.s4.board.qna;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choa.s4.MyTestCase;
import com.choa.s4.board.BoardDTO;
import com.choa.s4.util.Pager;

public class QnaDAOTest extends MyTestCase {

	@Autowired
	private QnaDAO qnaDAO;
	
	@Test
	public void getList() throws Exception {
		Pager pager = new Pager();
		pager.makeRow();
		
		List<BoardDTO> ar = qnaDAO.getList(pager);
		System.out.println(ar.size());
		assertNotEquals(0, ar.size());
	}
	
	//@Test
	public void setInsert() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setTitle("Test title");
		boardDTO.setWriter("Test Writer");
		boardDTO.setContents("Test Contents");
		
		int result =qnaDAO.setInsert(boardDTO);
		assertEquals(1, result);
	}

}
