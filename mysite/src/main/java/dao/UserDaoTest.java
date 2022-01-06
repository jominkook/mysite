package dao;

import vo.UserVo;

public class UserDaoTest {

	public static void main(String[] args) {
		/*UserDao dao = new UserDaoImpl();
		UserVo vo = new UserVo();
		vo.setEmail("whalsrnraos@naver.com");
		vo.setPassword("1234");
		String email = vo.getEmail();
		String password = vo.getPassword();
		dao.getUser(email, password);
		//String email = vo.getEmail();
		//String password = vo.getPassword();
		//dao.getUser(email, password);*/
		/*UserDao dao = new UserDaoImpl();
		UserVo vo = new UserVo();
		
		/*vo.setName("남도완");
		vo.setPassword("1234");
		vo.setEmail("wqewwe@naver.com");
		dao.insert(vo);*/
		UserDao dao = new UserDaoImpl();
		UserVo vo = new UserVo();
		vo.setName("맹미혜");
		vo.setPassword("1234");
		vo.setGender("female");
		vo.setNo(1);
		if(dao.update(vo)) {
			System.out.println("업데이트성공");
		}
		else {
			System.out.println("실패");
		}
		
	
	}

}
