package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LeaseDao;


public class Examine extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderIdS = request.getParameter("orderId");
		String goodsIdS = request.getParameter("goodsId");
		
		int state = Integer.parseInt(request.getParameter("state"));
		
		LeaseDao leaseDao = new LeaseDao();
		if(orderIdS != null && goodsIdS != null)
		{
			int orderId = Integer.parseInt(orderIdS);
			int goodsId = Integer.parseInt(goodsIdS);
			
			leaseDao.editLeaseState(orderId, state);
			
			if(state == 5)
			{
				leaseDao.editStockState(goodsId, 2);
			}
			else
			{
				leaseDao.editStockState(goodsId, state);
			}
		}
		
		if(orderIdS == null && goodsIdS != null)
		{
			int goodsId = Integer.parseInt(goodsIdS);
			leaseDao.editStockState(goodsId, state);
		}
		
		response.sendRedirect(request.getContextPath() + "/admin");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
