package vo;

public class Product {
	private String productCode;
	private String barCode;
	private String tradeName;
	private String primaryClassification;
	private String secondaryClassification;
	private int supplyPrice;
	private int minPrice;
	private int recommendedPrice;
	private String commoditySpecifications;
	private String commodityOrigin;
	private String unitOfMeasurement;
	private String commodityProvider;
	private String auditStatus;
	private String company;
	
	public Product() {
		super();
	}

	public Product(String productCode, String barCode, String company) {
		super();
		this.productCode = productCode;
		this.barCode = barCode;
		this.company = company;
	}


	public Product(String productCode, String barCode, String tradeName,
			String primaryClassification, String secondaryClassification,
			int supplyPrice, int minPrice, int recommendedPrice,
			String commoditySpecifications, String commodityOrigin,
			String unitOfMeasurement, String commodityProvider,
			String auditStatus) {
		super();
		this.productCode = productCode;
		this.barCode = barCode;
		this.tradeName = tradeName;
		this.primaryClassification = primaryClassification;
		this.secondaryClassification = secondaryClassification;
		this.supplyPrice = supplyPrice;
		this.minPrice = minPrice;
		this.recommendedPrice = recommendedPrice;
		this.commoditySpecifications = commoditySpecifications;
		this.commodityOrigin = commodityOrigin;
		this.unitOfMeasurement = unitOfMeasurement;
		this.commodityProvider = commodityProvider;
		this.auditStatus = auditStatus;
	}
	
	public Product(String productCode, String barCode, String tradeName,
			String primaryClassification, String secondaryClassification,
			int supplyPrice, int minPrice, int recommendedPrice,
			String commoditySpecifications, String commodityOrigin,
			String unitOfMeasurement, String commodityProvider,
			String auditStatus, String company) {
		super();
		this.productCode = productCode;
		this.barCode = barCode;
		this.tradeName = tradeName;
		this.primaryClassification = primaryClassification;
		this.secondaryClassification = secondaryClassification;
		this.supplyPrice = supplyPrice;
		this.minPrice = minPrice;
		this.recommendedPrice = recommendedPrice;
		this.commoditySpecifications = commoditySpecifications;
		this.commodityOrigin = commodityOrigin;
		this.unitOfMeasurement = unitOfMeasurement;
		this.commodityProvider = commodityProvider;
		this.auditStatus = auditStatus;
		this.company = company;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public String getTradeName() {
		return tradeName;
	}

	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}

	public String getPrimaryClassification() {
		return primaryClassification;
	}

	public void setPrimaryClassification(String primaryClassification) {
		this.primaryClassification = primaryClassification;
	}

	public String getSecondaryClassification() {
		return secondaryClassification;
	}

	public void setSecondaryClassification(String secondaryClassification) {
		this.secondaryClassification = secondaryClassification;
	}

	public int getSupplyPrice() {
		return supplyPrice;
	}

	public void setSupplyPrice(int supplyPrice) {
		this.supplyPrice = supplyPrice;
	}

	public int getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}

	public int getRecommendedPrice() {
		return recommendedPrice;
	}

	public void setRecommendedPrice(int recommendedPrice) {
		this.recommendedPrice = recommendedPrice;
	}

	public String getCommoditySpecifications() {
		return commoditySpecifications;
	}

	public void setCommoditySpecifications(String commoditySpecifications) {
		this.commoditySpecifications = commoditySpecifications;
	}

	public String getCommodityOrigin() {
		return commodityOrigin;
	}

	public void setCommodityOrigin(String commodityOrigin) {
		this.commodityOrigin = commodityOrigin;
	}

	public String getUnitOfMeasurement() {
		return unitOfMeasurement;
	}

	public void setUnitOfMeasurement(String unitOfMeasurement) {
		this.unitOfMeasurement = unitOfMeasurement;
	}

	public String getCommodityProvider() {
		return commodityProvider;
	}

	public void setCommodityProvider(String commodityProvider) {
		this.commodityProvider = commodityProvider;
	}

	public String getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Product [productCode=" + productCode + ", barCode=" + barCode
				+ ", tradeName=" + tradeName + ", primaryClassification="
				+ primaryClassification + ", secondaryClassification="
				+ secondaryClassification + ", supplyPrice=" + supplyPrice
				+ ", minPrice=" + minPrice + ", recommendedPrice="
				+ recommendedPrice + ", commoditySpecifications="
				+ commoditySpecifications + ", commodityOrigin="
				+ commodityOrigin + ", unitOfMeasurement=" + unitOfMeasurement
				+ ", commodityProvider=" + commodityProvider + ", auditStatus="
				+ auditStatus + "]";
	}
	
	
}
