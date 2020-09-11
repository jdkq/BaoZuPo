package servlet.lease;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LeaseDao;
import domain.Lease;


public class MyOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LeaseDao leaseDao = new LeaseDao();
		List<Lease> list = leaseDao.getOrders((String)request.getSession().getAttribute("userName"));
		request.setAttribute("list", list);
		request.getRequestDispatcher("/lease2.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
