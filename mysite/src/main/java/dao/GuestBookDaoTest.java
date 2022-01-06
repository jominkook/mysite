package dao;

import java.util.List;

import vo.GuestBookVo;

public class GuestBookDaoTest {

	public static void main(String[] args) {
		GuestBookDao dao = new GuestBookDaoImpl();
		
		List<GuestBookVo> list = dao.getlist();
		
		for(GuestBookVo vo : list) {
			System.out.println(vo.getNo());
			System.out.println(vo.getName());
			System.out.println(vo.getPassword());
		}

	}

}
