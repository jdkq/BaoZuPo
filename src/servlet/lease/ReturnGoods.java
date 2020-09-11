package servlet.lease;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LeaseDao;


public class ReturnGoods extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
		
		String goosId = request.getParameter("goodsId");
		String orderId = request.getParameter("orderId");
		
		LeaseDao leaseDao = new LeaseDao();
		leaseDao.editLeaseState(Integer.parseInt(orderId), 4);
		leaseDao.editStockState(Integer.parseInt(goosId), 4);
		
		String url = request.getContextPath() +"/myOrder";
		response.getWriter().write("<script>alert('归还中，请等待管理员审核！');location.href='" + url + "'</script>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
