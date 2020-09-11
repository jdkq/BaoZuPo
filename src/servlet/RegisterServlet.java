package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import domain.User;


public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao = new UserDao();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/json; charset=utf-8");
		User user = new User();
		
		String username=request.getParameter("new_username");
		String password=request.getParameter("new_passwd");
		String name=request.getParameter("Name");
		String address=request.getParameter("address");
		int type = Integer.parseInt(request.getParameter("radio"));

		user.setUserName(username);
		user.setPassword(password);
		user.setName(name);
		user.setAddress(address);
		user.setType(type);
		
		if(userDao.addUser(user)){
			response.getWriter().write("{\"result\":\"1\"}");
		}
		else{
			response.getWriter().write("{\"result\":\"0\"}");
		}
		

	}

}
