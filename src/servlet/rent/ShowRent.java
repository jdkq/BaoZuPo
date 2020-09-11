package servlet.rent;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RentDao;
import domain.Stock;


public class ShowRent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = (String)request.getSession().getAttribute("userName");
		
		RentDao rentDao = new RentDao();
		List<Stock> goods = rentDao.getGoods(userName);
		
		request.setAttribute("list", goods);
		request.getRequestDispatcher("/rent.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
