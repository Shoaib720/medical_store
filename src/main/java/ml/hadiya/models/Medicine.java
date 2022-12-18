package ml.hadiya.models;

public class Medicine {

	private int id;
	private String name;
	private String details;
	private double price;
	private int quantity;
	private String expiryDate;
	private int storeId;
	private String storeName;
	private int medicineTypeId;
	private String medicineTypeName;
	
	
	// used when retrieving from database
	public Medicine(int id, String name, String details, double price, int quantity, String expiryDate, int storeId,
			String storeName, int medicineTypeId, String medicineTypeName) {
		super();
		this.id = id;
		this.name = name;
		this.details = details;
		this.price = price;
		this.quantity = quantity;
		this.expiryDate = expiryDate;
		this.storeId = storeId;
		this.storeName = storeName;
		this.medicineTypeId = medicineTypeId;
		this.medicineTypeName = medicineTypeName;
	}
	
	
	// used when storing in database;
	public Medicine(String name, String details, double price, int quantity, String expiryDate, int storeId, int medicineTypeId) {
		super();
		this.name = name;
		this.details = details;
		this.price = price;
		this.quantity = quantity;
		this.expiryDate = expiryDate;
		this.storeId = storeId;
		this.medicineTypeId = medicineTypeId;
	}

	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDetails() {
		return details;
	}
	public double getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public int getStoreId() {
		return storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public int getMedicineTypeId() {
		return medicineTypeId;
	}
	public String getMedicineTypeName() {
		return medicineTypeName;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public void setMedicineTypeId(int medicineTypeId) {
		this.medicineTypeId = medicineTypeId;
	}
	public void setMedicineTypeName(String medicineTypeName) {
		this.medicineTypeName = medicineTypeName;
	}
	
}
