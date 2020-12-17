package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Page;
import vo.Product;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dao.ProductDao;


@WebServlet(urlPatterns="/queryProduct.do")
public class queryProduct extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String queryParams = request.getParameter("queryParams");
		String pageParams = request.getParameter("pageParams");
		System.out.println("分页参数:"+queryParams);
		System.out.println("查询参数:"+pageParams);
		Product product = new Product();
		ProductDao dao = new ProductDao();
		//将json字符串参数值转换为java对象
		Gson gson = new GsonBuilder().serializeNulls().create();
		HashMap<String,Object> mapPage = gson.fromJson(pageParams,HashMap.class);
		Page page = Page.getPageParams(mapPage);
		if(queryParams!=null){
			product = gson.fromJson(queryParams,Product.class);
		}
		ArrayList<Product>rows = dao.query(product, page);
		int total = dao.count(product,page);
		
		HashMap<String,Object>mapReturn = new HashMap<String,Object>();
		mapReturn.put("rows", rows);
		mapReturn.put("total", total);
		System.out.println("total:"+total);
		String jsonStr = gson.toJson(mapReturn);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonStr);
		out.flush();
		out.close();
	}
}
