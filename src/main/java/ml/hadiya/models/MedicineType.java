package ml.hadiya.models;

public class MedicineType 
{
	private int id;
	private String medicineTypeName;
	private String description;
	
	public MedicineType(int id, String medicineTypeName, String description) {
		super();
		this.id = id;
		this.medicineTypeName = medicineTypeName;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMedicineTypeName() {
		return medicineTypeName;
	}

	public void setMedicineTypeName(String medicineTypeName) {
		this.medicineTypeName = medicineTypeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	
	
}
