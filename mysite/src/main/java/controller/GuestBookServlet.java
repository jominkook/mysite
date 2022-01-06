package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GuestBookDao;
import dao.GuestBookDaoImpl;
import vo.GuestBookVo;



@WebServlet("/gb")
public class GuestBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String actionName = request.getParameter("a");
		System.out.println("gb:" + actionName);
		
		if ("add".equals(actionName)) {
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String content = request.getParameter("content");

			GuestBookVo gvo  = new GuestBookVo();
			gvo.setName(name);
			gvo.setPassword(password);
			gvo.setContent(content);
			
			GuestBookDao dao = new GuestBookDaoImpl();
		    dao.insert(gvo);
		  
		   
			
			response.sendRedirect("/mysite/gb");

		} else if ("deleteform".equals(actionName)) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/guestbook/deleteform.jsp");
			rd.forward(request, response);

		} else if ("delete".equals(actionName)) {
			int no = Integer.parseInt(request.getParameter("no"));
			String password = request.getParameter("password");

			GuestBookVo gvo = new GuestBookVo();
			gvo.setNo(no);
			gvo.setPassword(password);
			GuestBookDao dao = new GuestBookDaoImpl();
			dao.delete(gvo);

			response.sendRedirect("/mysite/gb");
		} else {
			GuestBookDao dao = new GuestBookDaoImpl();
			List<GuestBookVo> list = dao.getlist();

			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/guestbook/list.jsp");
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
