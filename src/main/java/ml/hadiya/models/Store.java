package ml.hadiya.models;

enum StoreLicence{
	RETAIL_DRUG_LICENCE,
	WHOLESALE_DRUG_LICENCE
};

public class Store {
	
	public static final int RETAIL_DRUG_LICENCE = 0;
	public static final int WHOLESALE_DRUG_LICENCE = 1;
	
	private int id;
	private String storeName;
	private String username;
	private String password;
	private String storeEmailId;
	private String mobile;
	private String address1;
	private String address2;
	private int storeLicense;
	private int storeTypeId;
	private String storeTypeName;
	private String storeRegistrationNumber;
	
	public Store(int id, String storeName, String username, String password, String storeEmailId, String mobile,
			String address1, String address2, int storeLicense, int storeTypeId, String storeTypeName,
			String storeRegistrationNumber) {
		super();
		this.id = id;
		this.storeName = storeName;
		this.username = username;
		this.password = password;
		this.storeEmailId = storeEmailId;
		this.mobile = mobile;
		this.address1 = address1;
		this.address2 = address2;
		this.storeLicense = storeLicense;
		this.storeTypeId = storeTypeId;
		this.storeTypeName = storeTypeName;
		this.storeRegistrationNumber = storeRegistrationNumber;
	}

	public Store(String storeName, String username, String password, String storeEmailId, String mobile,
			String address1, String address2, int storeLicense, int storeTypeId, String storeRegistrationNumber) {
		super();
		this.storeName = storeName;
		this.username = username;
		this.password = password;
		this.storeEmailId = storeEmailId;
		this.mobile = mobile;
		this.address1 = address1;
		this.address2 = address2;
		this.storeLicense = storeLicense;
		this.storeTypeId = storeTypeId;
		this.storeRegistrationNumber = storeRegistrationNumber;
	}

	public int getId() {
		return id;
	}

	public String getStoreName() {
		return storeName;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getStoreEmailId() {
		return storeEmailId;
	}

	public String getMobile() {
		return mobile;
	}

	public String getAddress1() {
		return address1;
	}

	public String getAddress2() {
		return address2;
	}

	public int getStoreLicense() {
		return storeLicense;
	}

	public int getStoreTypeId() {
		return storeTypeId;
	}

	public String getStoreTypeName() {
		return storeTypeName;
	}

	public String getStoreRegistrationNumber() {
		return storeRegistrationNumber;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setStoreEmailId(String storeEmailId) {
		this.storeEmailId = storeEmailId;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public void setStoreLicense(int storeLicense) {
		this.storeLicense = storeLicense;
	}

	public void setStoreTypeId(int storeTypeId) {
		this.storeTypeId = storeTypeId;
	}

	public void setStoreTypeName(String storeTypeName) {
		this.storeTypeName = storeTypeName;
	}

	public void setStoreRegistrationNumber(String storeRegistrationNumber) {
		this.storeRegistrationNumber = storeRegistrationNumber;
	}
	
	
}
