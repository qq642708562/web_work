package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.Page;
import vo.Product;

import com.mysql.jdbc.Statement;

public class ProductDao {
	private static final String URL = "jdbc:mysql://localhost:3306/excise";
	private static final String userName1 = "root";
	private static final String pwd = "123";
	
	public ArrayList<Product> query(Product product, Page page) {
		ArrayList<Product> list = new ArrayList<Product>(); // 存放查询结果的集合
		StringBuffer condition = new StringBuffer();// 查询条件
		Connection con = null;
		Statement pst = null;
		ResultSet rs = null;
		if (product.getProductCode() != null && !"".equals(product.getProductCode())) { // 判断是否有该查询条件
			condition.append(" and productCode like '%")
					.append(product.getProductCode()).append("%'");
		}
		if (product.getBarCode()+"" != null && !"".equals(product.getBarCode()+"")) { //
			condition.append(" and barCode like '%").append(product.getBarCode())
					.append("%'");
		}
		if (product.getCompany()+"" != null && !"".equals(product.getCompany()+"")) { //
			condition.append(" and company like '%").append(product.getCompany())
			.append("%'");
		}
		int begin = page.getPageSize() * (page.getPageNumber() - 1);
		String sql = "select * from t_table";
		sql = sql + " where  1=1 ";
		sql = sql + condition + " order by " + 
				 page.getSortOrder() + " limit " + begin + ","
				+ page.getPageSize();

		System.out.println(sql);

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(URL, userName1, pwd);
			pst = (Statement) con.createStatement();
			rs = pst.executeQuery(sql);
			while (rs.next()) {
				product = new Product(rs.getString(1), rs.getString(2),rs.getString(3),
				rs.getString(4),rs.getString(5),rs.getInt(6), rs.getInt(7),rs.getInt(8),
				rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),
				rs.getString(13));
				list.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}// 6.关闭连接
		}

		return list;
	}
	
	public int count(Product product, Page page) {
		int num = 0;
		ArrayList<Product> list = new ArrayList<Product>(); // 存放查询结果的集合
		Connection con = null;
		Statement pst = null;
		ResultSet rs = null;
		String sql = "select count(productCode) from t_table";
		System.out.println(sql);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(URL, userName1, pwd);
			pst = (Statement) con.createStatement();
			rs = pst.executeQuery(sql);
			if (rs.next()) {
				num = rs.getInt("count(productCode)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}// 6.关闭连接
		}
		return num;
	}
}
