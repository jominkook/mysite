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
		
		/*vo.setName("������");
		vo.setPassword("1234");
		vo.setEmail("wqewwe@naver.com");
		dao.insert(vo);*/
		UserDao dao = new UserDaoImpl();
		UserVo vo = new UserVo();
		vo.setName("�͹���");
		vo.setPassword("1234");
		vo.setGender("female");
		vo.setNo(1);
		if(dao.update(vo)) {
			System.out.println("������Ʈ����");
		}
		else {
			System.out.println("����");
		}
		
	
	}

}
