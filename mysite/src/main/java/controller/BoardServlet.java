package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardDao;
import dao.BoardDaoImpl;
import util.WebUtil;
import vo.BoardVo;
import vo.PageMakeVo;
import vo.UserVo;



@WebServlet("/board")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String actionName = request.getParameter("a");
		System.out.println("board:" + actionName);

		if ("list".equals(actionName)) {
			// 리스트 가져오기
			
			//페이지 실험
			BoardDao dao = new BoardDaoImpl();
			int page = 1;
			if(request.getParameter("page")!=null) {
				page = Integer.parseInt(request.getParameter("page"));
			}						
			
			PageMakeVo pvo = new PageMakeVo();				
			int cnt = dao.getAllCount();
			pvo.setTotalCount(cnt);
			pvo.setPage(page);
			pvo.paging();
			System.out.println(pvo.getTotalCount());

			
			//List<BoardVo> list2 = dao.getlist();
			request.setAttribute("paging", pvo);
			List<BoardVo> list = dao.getlist(page);		
			
//			/*BoardDao dao = new BoardDaoImpl();
//			List<BoardVo> list = dao.getlist();*/
//			//System.out.println(list.toString());		
//			// 리스트 화면에 보내기			
			request.setAttribute("list", list);			
			WebUtil.forward(request, response, "/WEB-INF/views/board/list.jsp");
		} else if ("read".equals(actionName)) {
			// 게시물 가져오기
			int no = Integer.parseInt(request.getParameter("no"));
			BoardDao dao = new BoardDaoImpl();			
			BoardVo boardVo = dao.getBoard(no);
		    
			System.out.println(boardVo.toString());

			// 게시물 화면에 보내기
			request.setAttribute("boardVo", boardVo);
			WebUtil.forward(request, response, "/WEB-INF/views/board/view.jsp");
			
			if(dao.countHit(no)) {
				System.out.println("조회수증가");
			}
		} else if ("modifyform".equals(actionName)) {
			// 게시물 가져오기
			int no = Integer.parseInt(request.getParameter("no"));
			BoardDao dao = new BoardDaoImpl();
			BoardVo boardVo = dao.getBoard(no);

			// 게시물 화면에 보내기
			request.setAttribute("boardVo", boardVo);
			WebUtil.forward(request, response, "/WEB-INF/views/board/modify.jsp");
		} else if ("modify".equals(actionName)) {
			// 게시물 가져오기
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			int no = Integer.parseInt(request.getParameter("no"));
			System.out.println(no);
			BoardVo vo = new BoardVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setContent(content);
			BoardDao dao = new BoardDaoImpl();			
			dao.update(vo);
			System.out.println(vo.getTitle());
			System.out.println(vo.getContent());
			
			WebUtil.redirect(request, response, "/mysite/board?a=list");
		} else if ("writeform".equals(actionName)) {
			// 로그인 여부체크
			UserVo authUser = getAuthUser(request);
			if (authUser != null) { // 로그인했으면 작성페이지로
				WebUtil.forward(request, response, "/WEB-INF/views/board/write.jsp");
			} else { // 로그인 안했으면 리스트로
				WebUtil.redirect(request, response, "/mysite/board?a=list");
			}

		} else if ("write".equals(actionName)) {
			UserVo authUser = getAuthUser(request);

			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			int userNo = authUser.getNo();
			System.out.println("userNo : ["+userNo+"]");
			System.out.println("title : ["+title+"]");
			System.out.println("content : ["+content+"]");

			BoardVo vo = new BoardVo();
			vo.setTitle(title);
			vo.setContent(content);
			vo.setUser_no(userNo);
			BoardDao dao = new BoardDaoImpl();
			dao.insert(vo);

			WebUtil.redirect(request, response, "/mysite/board?a=list");

		} else if ("delete".equals(actionName)) {
			int no = Integer.parseInt(request.getParameter("no"));

			BoardDao dao = new BoardDaoImpl();
			
			dao.delete(no);

			WebUtil.redirect(request, response, "/mysite/board?a=list");

		} else {
			WebUtil.redirect(request, response, "/mysite/board?a=list");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	// 로그인 되어 있는 정보를 가져온다.
	protected UserVo getAuthUser(HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserVo authUser = (UserVo) session.getAttribute("authUser");

		return authUser;
	}

}
