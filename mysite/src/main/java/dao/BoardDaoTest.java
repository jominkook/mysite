package dao;

import java.util.List;

import vo.BoardVo;
import vo.PageMakeVo;



public class BoardDaoTest {

	public static void main(String[] args) {
		//����Ʈ��ȸ
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
		//������Ʈ
		/*BoardVo vo = new BoardVo();
		BoardDao dao = new BoardDaoImpl();
		vo.setTitle("test7");
		vo.setContent("�ȳ��ϼ��� ���α�7�Դϴ�");
		//vo.setHit("0");
		//vo.setUser_no(1);
		vo.setNo(1);
		if(dao.update(vo)) {
			System.out.println("�����ͼ�������");
		}
		else {
			System.out.println("����");
		}*/
		//������ �߰�
		/*BoardVo vo = new BoardVo();
		BoardDao dao = new BoardDaoImpl();
		vo.setTitle("test4");
		vo.setContent("�ȳ��ϼ��� ���α�3�Դϴ�");
		vo.setHit("0");
		vo.setUser_no(2);
		if(dao.insert(vo)) {
			System.out.println("�������߰�����");
		}
		else {
			System.out.println("����");
		}*/
		
		//getBoard ��ȸ
		/*BoardDao dao = new BoardDaoImpl();
		BoardVo vo = new BoardVo();
		vo.setNo(1);
		dao.getBoard(vo);
		System.out.println(vo.getUser_name());*/
		
		//������ ����
		/*BoardDao dao = new BoardDaoImpl();
		
		if(dao.delete(61)) {
			System.out.println("�����ͻ��� ����");
		}
		else {
			System.out.println("����");
		}*/
		
		//��ȸ�� ����
		/*BoardDao dao = new BoardDaoImpl();
		
		if(dao.countHit(1)) {
			System.out.println("����");
		}
		else {
			System.out.println("����");
		}*/
		
		//����¡�׽�Ʈ
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
