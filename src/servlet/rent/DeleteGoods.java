package servlet.rent;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RentDao;

/**
 * Servlet implementation class DeleteGoods
 */
public class DeleteGoods extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteGoods() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		String goodsId = request.getParameter("goodsId");
		
		RentDao rentDao = new RentDao();
		boolean flag = rentDao.deleteGoods(goodsId);
		
		if(flag)
		{
			String url = request.getContextPath() +"/showRent";
			response.getWriter().write("<script>alert('É¾³ý³É¹¦£¡');location.href='" + url + "'</script>");
		}
		else
		{
			response.getWriter().write("<script>alert('É¾³ýÊ§°Ü£¡'); '</script>");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
