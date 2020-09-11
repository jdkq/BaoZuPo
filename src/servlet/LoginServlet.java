package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import domain.User;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao = new UserDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json; charset=utf-8");
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("passwd");
		String type = request.getParameter("ad");
		
		if(type.equals("root"))
		{
			User user = userDao.adminLogin(userName, password);
			if(user != null){
				response.getWriter().write("{\"result\":\"1\"}");
			}
			else{
				response.getWriter().write("{\"result\":\"0\"}");
			}
		}
		else if (type.equals("lease")) 
		{
			User user = userDao.findUserByUsernameAndPwd(userName, password, 1);
			
			if(user != null)
			{
				HttpSession session = request.getSession();
				session.setAttribute("userName", userName);
				response.getWriter().write("{\"result\":\"1\"}");
			}
			else {
				response.getWriter().write("{\"result\":\"0\"}");
			}
			
		}
		else
		{
			User user = userDao.findUserByUsernameAndPwd(userName, password, 0);
			
			if(user != null)
			{
				HttpSession session = request.getSession();
				session.setAttribute("userName", userName);
				response.getWriter().write("{\"result\":\"1\"}");
			}
			else {
				response.getWriter().write("{\"result\":\"0\"}");
			}
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
