package ml.hadiya.models;

public class StoreType {
	private int id;
	private String typeName;
	
	public StoreType(int id, String typeName) {
		super();
		this.id = id;
		this.typeName = typeName;
	}

	public int getId() {
		return id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}	
}


