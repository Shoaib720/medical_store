package ml.hadiya.daos;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.util.ArrayList;
	import java.util.List;

	import ml.hadiya.models.Medicine;
import ml.hadiya.models.MedicineType;
import ml.hadiya.utils.DateHelper;
import ml.hadiya.utils.DatabaseConnection;

	public class MedicineDAO {
		
		private static final String SELECT_MEDICINE_BY_ID = "select details.id as medicine_id, medicine_name, medicine_details, medicine_price, medicine_quantity, medicine_expiry_date, store.id as store_id, store_name, type.id as medicine_type_id, medicine_type_name from medicine_details details inner join medicine_type type on details.medicine_type_id = type.id inner join medical_store store on details.store_id = store.id where details.id = ?";
		private static final String SELECT_ALL_MEDICINES = 	"select details.id as medicine_id, medicine_name, medicine_details, medicine_price, medicine_quantity, medicine_expiry_date, store.id as store_id, store_name, type.id as medicine_type_id, medicine_type_name from medicine_details details inner join medicine_type type on details.medicine_type_id = type.id inner join medical_store store on details.store_id = store.id";
		private static final String INSERT_MEDICINE = "insert into medicine_details(MEDICINE_NAME, MEDICINE_DETAILS, MEDICINE_PRICE, MEDICINE_QUANTITY, MEDICINE_EXPIRY_DATE, STORE_ID, MEDICINE_TYPE_ID, ID) values (?, ?, ?, ?, ?, ?, ?, ?)";
		private static final String UPDATE_MEDICINE_BY_ID = "update medicine_details set MEDICINE_NAME = ?, MEDICINE_DETAILS = ?, MEDICINE_PRICE = ?, MEDICINE_QUANTITY = ?, MEDICINE_EXPIRY_DATE = ?, STORE_ID = ?, MEDICINE_TYPE_ID = ? where ID = ?";
		private static final String DELETE_BY_ID = "delete from medicine_details where ID = ?";
		private static final String COMMIT = "commit";
		private static final String SELECT_ALL_MEDICINE_TYPES = "select * from medicine_type";
		private static final String SELECT_LAST_ROW_ID = "select * from (select ID from medicine_details order by ID desc) where rownum < 2";
		
		public boolean insertMedicine(Medicine medicine) {
			boolean rowInserted = false;
			
			try(Connection con = DatabaseConnection.getConnection(); PreparedStatement statement = con.prepareStatement(INSERT_MEDICINE)){
				
				int medicineId = getLastRow() + 1;
				
				
				statement.setString(1, medicine.getName());
				statement.setString(2, medicine.getDetails());
				statement.setDouble(3, medicine.getPrice());
				statement.setInt(4, medicine.getQuantity());
				statement.setString(5, medicine.getExpiryDate());
				statement.setInt(6, medicine.getStoreId());
				statement.setInt(7, medicine.getMedicineTypeId());
				statement.setInt(8, medicineId);
				
				rowInserted = statement.executeUpdate() > 0;
				commit();
				
			} catch(Exception e) {
				System.out.println(e);
			}
			return rowInserted;
		}

		public Medicine retreiveMedicineById(int id) {
			Medicine medicine = null;
			try(Connection con = DatabaseConnection.getConnection(); PreparedStatement statement = con.prepareStatement(SELECT_MEDICINE_BY_ID)){
				
				statement.setInt(1, id);
				ResultSet rs = statement.executeQuery();
				while(rs.next()) {
					String name = rs.getString("MEDICINE_NAME");
					String details = rs.getString("MEDICINE_DETAILS");
					double price = rs.getDouble("MEDICINE_PRICE");
					int quantity = rs.getInt("MEDICINE_QUANTITY");
					String expiryDate = DateHelper.formatDate(rs.getString("MEDICINE_EXPIRY_DATE"));
					int storeId = rs.getInt("STORE_ID");
					String storeName = rs.getString("STORE_NAME");
					int typeId = rs.getInt("MEDICINE_TYPE_ID");
					String medicineTypeName = rs.getString("MEDICINE_TYPE_NAME");
					
					medicine = new Medicine(id, name, details, price, quantity, expiryDate, storeId, storeName, typeId, medicineTypeName);
				}
				
			} catch(Exception e) {
				System.out.println(e);
			}
			
			return medicine;
		}

		public List<Medicine> retreiveMedicines(){
			
			List<Medicine> medicines = new ArrayList<Medicine>();
			
			try(Connection con = DatabaseConnection.getConnection(); PreparedStatement statement = con.prepareStatement(SELECT_ALL_MEDICINES)){
				ResultSet rs = statement.executeQuery();
				while(rs.next()) {
					int id = rs.getInt("MEDICINE_ID");
					String name = rs.getString("MEDICINE_NAME");
					String details = rs.getString("MEDICINE_DETAILS");
					double price = rs.getDouble("MEDICINE_PRICE");
					int quantity = rs.getInt("MEDICINE_QUANTITY");
					String expiryDate = DateHelper.formatDate(rs.getString("MEDICINE_EXPIRY_DATE"));
					int storeId = rs.getInt("STORE_ID");
					String storeName = rs.getString("STORE_NAME");
					int typeId = rs.getInt("MEDICINE_TYPE_ID");
					String medicineTypeName = rs.getString("MEDICINE_TYPE_NAME");
					
					Medicine medicine = new Medicine(id, name, details, price, quantity, expiryDate, storeId, storeName, typeId, medicineTypeName);
					medicines.add(medicine);
				}
				
			} catch(Exception e) {
				System.out.println(e);
			}
			
			return medicines;
			
		}

		public boolean updateMedicine(Medicine medicine) {
			
			boolean rowUpdated = false;
			
			try(Connection con = DatabaseConnection.getConnection(); PreparedStatement statement = con.prepareStatement(UPDATE_MEDICINE_BY_ID)){
				
				statement.setString(1, medicine.getName());
				statement.setString(2, medicine.getDetails());
				statement.setDouble(3, medicine.getPrice());
				statement.setInt(4, medicine.getQuantity());
				statement.setString(5, medicine.getExpiryDate());
				statement.setInt(6, medicine.getStoreId());
				statement.setInt(7, medicine.getMedicineTypeId());
				statement.setInt(8, medicine.getId());
				
				rowUpdated = statement.executeUpdate() > 0;
				commit();
				
			} catch(Exception e) {
				System.out.println(e);
			}
			
			return rowUpdated;
			
		}
		
		public boolean deleteMedicineById(int id) {
			
			boolean rowDeleted = false;
			
			try(Connection con = DatabaseConnection.getConnection(); PreparedStatement statement = con.prepareStatement(DELETE_BY_ID)){
				
				statement.setInt(1, id);
				rowDeleted = statement.executeUpdate() > 0;
				commit();
				
			} catch(Exception e) {
				System.out.println(e);
			}
			
			return rowDeleted;
			
		}
		private void commit() {
			try(Connection con = DatabaseConnection.getConnection(); PreparedStatement statement = con.prepareStatement(COMMIT)){
				
				statement.execute();
				
			} catch(Exception e) {
				System.out.println(e);
			}
	
		}
		
		public List<MedicineType> retrieveMedicineTypes() {
			List<MedicineType> medicineTypes = new ArrayList<MedicineType>();
			
			try(Connection con = DatabaseConnection.getConnection(); PreparedStatement statement = con.prepareStatement(SELECT_ALL_MEDICINE_TYPES)){
				
				ResultSet rs = statement.executeQuery();
				while(rs.next()) {
					int id = rs.getInt("ID");
					String medicineTypeName = rs.getString("MEDICINE_TYPE_NAME");
					String description = rs.getString("DESCRIPTION");
					
					MedicineType medicineType = new MedicineType(id, medicineTypeName, description);
					medicineTypes.add(medicineType);
				}
				
			} catch(Exception e) {
				System.out.println(e);
			}
			
			return medicineTypes;
		}
		
		private int getLastRow() {
			
			int id = 0;
			
			try(Connection con = DatabaseConnection.getConnection(); PreparedStatement statement = con.prepareStatement(SELECT_LAST_ROW_ID)) {
				
				ResultSet rs = statement.executeQuery();
				while(rs.next()) {
					id = rs.getInt("ID");
				}
				
			} catch(Exception e) {
				System.out.println(e);
			}
			
			return id;
			
		}
}
