package dao;

import java.util.List;

import vo.BoardVo;
import vo.PageMakeVo;



public class BoardDaoTest {

	public static void main(String[] args) {
		//리스트조회
		/*BoardDao dao = new BoardDaoImpl();
		List<BoardVo> list = dao.getlist();
		
		for(BoardVo vo : list) {
			System.out.println(vo.getNo());
			System.out.println(vo.getTitle());
			System.out.println(vo.getContent());
			System.out.println(vo.getHit());
			System.out.println(vo.getReg_date());
			System.out.println(vo.getUser_no());
			System.out.println(vo.getUser_name());
		}*/
		//업데이트
		/*BoardVo vo = new BoardVo();
		BoardDao dao = new BoardDaoImpl();
		vo.setTitle("test7");
		vo.setContent("안녕하세요 조민국7입니다");
		//vo.setHit("0");
		//vo.setUser_no(1);
		vo.setNo(1);
		if(dao.update(vo)) {
			System.out.println("데이터수정성공");
		}
		else {
			System.out.println("실패");
		}*/
		//데이터 추가
		/*BoardVo vo = new BoardVo();
		BoardDao dao = new BoardDaoImpl();
		vo.setTitle("test4");
		vo.setContent("안녕하세요 조민국3입니다");
		vo.setHit("0");
		vo.setUser_no(2);
		if(dao.insert(vo)) {
			System.out.println("데이터추가성공");
		}
		else {
			System.out.println("실패");
		}*/
		
		//getBoard 조회
		/*BoardDao dao = new BoardDaoImpl();
		BoardVo vo = new BoardVo();
		vo.setNo(1);
		dao.getBoard(vo);
		System.out.println(vo.getUser_name());*/
		
		//데이터 삭제
		/*BoardDao dao = new BoardDaoImpl();
		
		if(dao.delete(61)) {
			System.out.println("데이터삭제 성공");
		}
		else {
			System.out.println("실패");
		}*/
		
		//조회수 증가
		/*BoardDao dao = new BoardDaoImpl();
		
		if(dao.countHit(1)) {
			System.out.println("성공");
		}
		else {
			System.out.println("실패");
		}*/
		
		//페이징테스트
		/*BoardDao dao = new BoardDaoImpl();
		PageMakeVo pvo = new PageMakeVo();
		pvo.setPage(1);
		//int page = 1;
		pvo.setTotalCount(50);
		//System.out.println(pvo.getNo());
		List<BoardVo> list = dao.getlist(pvo.getPage());
		System.out.println(list);
		//List<BoardVo> list = dao.getlist();
		for(BoardVo vo : list) {
			System.out.println(vo.getNo());
			System.out.println(vo.getTitle());
			System.out.println(vo.getContent());
			System.out.println(vo.getHit());
			System.out.println(vo.getReg_date());
			System.out.println(vo.getUser_no());
			System.out.println(vo.getUser_name());
		}*/
		BoardDao dao = new BoardDaoImpl();
		dao.getAllCount();
		System.out.println(dao.getAllCount());
		
		
		
	
	}

}
