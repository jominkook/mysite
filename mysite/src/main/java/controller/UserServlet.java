package controller;

import java.io.IOException;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import dao.UserDao;
import dao.UserDaoImpl;
import vo.UserVo;


@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String actionName = request.getParameter("a");
		System.out.println("user:" + actionName);
		if("loginform".equals(actionName)) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/user/loginform.jsp");			
			rd.forward(request, response);

		}
		else if("joinform".equals(actionName)) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/user/joinform.jsp");			
			rd.forward(request, response);
		}
		else if("login".equals(actionName)) {
			
			String email = request.getParameter("email");
			String password = request.getParameter("password");			
			
			UserVo vo = new UserVo();
			UserDao dao = new UserDaoImpl();
			
			vo.setEmail(email);
			vo.setPassword(password);
			dao.getUser(vo);
			
									
			if(vo != null) {
				HttpSession session = request.getSession(true);
				session.setAttribute("authUser",vo);
				//System.out.println(vo.getNo());
				//System.out.println(vo.getName());
				response.sendRedirect("/mysite/main");	
			}
			else if(vo == null){	
				System.out.println("½ÇÆÐ");
				response.sendRedirect("/mysite/user?a=loginform&result=fail?");
				
			}
			
		}
		else if("logout".equals(actionName)) {
				HttpSession session = request.getSession();
				session.removeAttribute("authUser");
			 	session.invalidate();
			    response.sendRedirect("/mysite/main");
		}
		else if("join".equals(actionName)) {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String gender = request.getParameter("gender");
			UserVo vo = new UserVo();
			
			vo.setName(name);
			vo.setEmail(email);
			vo.setPassword(password);
			vo.setGender(gender);
			
			UserDao dao = new UserDaoImpl();
			if(dao.insert(vo)) {
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/user/joinsuccess.jsp");			
				rd.forward(request, response);
			}
				
		}
		else if("modifyform".equals(actionName)) {
		
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/user/modifyform.jsp");			
			rd.forward(request, response);
		
		}
		else if("modify".equals(actionName)) {
			
			UserVo vo = new UserVo();
			int no = Integer.parseInt(request.getParameter("no"));
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String gender = request.getParameter("gender");
			
			//HttpSession session = request.getSession();
			//session.setAttribute("authUser", vo);
			System.out.println(vo.getNo());
			vo.setNo(no);
			vo.setName(name);
			vo.setPassword(password);
			vo.setGender(gender);
			UserDao dao = new UserDaoImpl();
			dao.update(vo);
			if(dao.update(vo)) {
				HttpSession session = request.getSession(true);
				session.setAttribute("authUser",vo);
				response.sendRedirect("/mysite/main");	
			}
		}
		
}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
