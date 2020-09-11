package servlet.lease;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LeaseDao;


public class LeaseGoods extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("goodsId");
		String userName = (String)request.getSession().getAttribute("userName");
		int days = Integer.parseInt(request.getParameter("days"));
		LeaseDao leaseDao = new LeaseDao();
		if(leaseDao.leaseGoods(userName, days, id))
		{
			leaseDao.editStockState(Integer.parseInt(id), 3);
			response.getWriter().write("<script>alert('×âÁÞ³É¹¦£¡')</script>");
			response.sendRedirect(request.getContextPath() +"/myOrder");
		}
		else
		{
			response.getWriter().write("<script>alert('×âÁÞÊ§°Ü£¡')</script>");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
