package vo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;


public class Page implements Serializable{
	private int pageSize;
	private int pageNumber;
	private String sortName;
	private String sortOrder;
	
	public Page() {
		super();
	}

	public Page(int pageSize, int pageNumber,String sortName,String sortOrder) {
		super();
		this.pageSize = pageSize;
		this.pageNumber = pageNumber;
		this.sortName = sortName;
		this.sortOrder = sortOrder;
	}
	
	public static Page getPageParams(HashMap<String, Object> mapPage) {
		int pageSize = Integer.parseInt((String) mapPage.get("pageSize"));
		int pageNumber = Integer.parseInt((String) mapPage.get("pageNumber"));
		String sortName = (String) mapPage.get("productCode");
		String sortOrder = (String) mapPage.get("desc");
		return new Page(pageSize,pageNumber,sortName,sortOrder);
	}

	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
	
	public String toString(){
		return "pageSize:"+this.pageSize+"  pageNumber:"+this.pageNumber+"  sortName:"+this.sortName
				+"  sortOrder:"+this.sortOrder;
	}
	
}
