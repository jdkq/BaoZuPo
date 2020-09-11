package servlet.rent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;

import dao.PhotoDao;
import dao.RentDao;
import domain.Stock;

public class AddGoods extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String name = request.getParameter("name");
//		String function = request.getParameter("function");
//		System.out.println(request.getParameter("price"));
//		double price  = Double.parseDouble(request.getParameter("price"));
//		
		  List<String> list=new ArrayList<String>();
          String filename=PhotoDao.getPhotoNewName();
          ServletContext servletContext=null;
          servletContext=request.getSession().getServletContext();
          //数据库中存储格式:/webTest/imgs/***.jpg
          //第一步:获取页面上上传的图片资源
          List<FileItem> items=PhotoDao.getRequsetFileItems(request,servletContext);
          
         
          
          for(FileItem item:items) 
          {
              if(!item.isFormField())
              {
                  if(PhotoDao.isGif(item)) 
                  {
                      PhotoDao.saveFile(item,filename);
                  }
                  else 
                  {
                	  response.getWriter().write("{\"result\":\"0\"}");
                	  return;
                  }
              }
              else
              {
                  list.add(item.getString("UTF-8"));
              }
          }
          
        String finalPhotoName= request.getContextPath()+"/img/"+filename;
              
	
		
		Stock stock = new Stock();
		stock.setPath(finalPhotoName);
		stock.setFunction(list.get(1));
		stock.setName(list.get(0));
		stock.setUserName((String)request.getSession().getAttribute("userName"));
		stock.setPrice(Double.parseDouble(list.get(2)));
		stock.setState(1);
		
		RentDao rentDao = new RentDao();
		boolean flag = rentDao.addGoods(stock);
		
		if(flag){
			response.getWriter().write("{\"result\":\"1\"}");
		}
		else{
			response.getWriter().write("{\"result\":\"0\"}");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
