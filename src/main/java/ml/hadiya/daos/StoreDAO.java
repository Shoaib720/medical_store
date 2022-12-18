package ml.hadiya.daos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import ml.hadiya.models.Credentials;

import ml.hadiya.models.Store;
import ml.hadiya.models.StoreType;
import ml.hadiya.utils.DatabaseConnection;
public class StoreDAO 
{
	private static final String INSERT_STORE = "insert into medical_store (STORE_NAME, USERNAME, PASSWORD, STORE_EMAIL_ID, MOBILE_NUMBER, ADDRESS_1, ADDRESS_2, STORE_LICENSE, STORE_TYPE_ID, STORE_REGISTRATION_NO, ID) values (?,?,?,?,?,?,?,?,?,?,?)";
//	private static final String SELECT_STORE_BY_ID = "select STORE_NAME, USERNAME, STORE_EMAIL_ID, MOBILE_NUMBER, ADDRESS_1, ADDRESS_2, STORE_LICENCE, STORE_TYPE_ID, STORE_REGISTRATION_NO from medical_store where ID = ?";
	private static final String SELECT_STORE_BY_ID = "select store.id as store_id, store_name, username, password, store_email_id, mobile_number, address_1, address_2, store_license, type.id as store_type_id, type_name as store_type_name, store_registration_no from medical_store store inner join store_type type on store.store_type_id = type.id where store.id = ?";
	private static final String SELECT_ALL_STORES = "select store.id as store_id, store_name, username, password, store_email_id, mobile_number, address_1, address_2, store_license, type.id as store_type_id, type_name as store_type_name, store_registration_no from medical_store store inner join store_type type on store.store_type_id = type.id";
	private static final String UPDATE_STORE_BY_ID = "update medical_store set STORE_NAME = ?, USERNAME = ?, PASSWORD = ?, STORE_EMAIL_ID = ?, MOBILE_NUMBER = ?, ADDRESS_1 = ?, ADDRESS_2 = ?, STORE_LICENSE = ?, STORE_TYPE_ID = ?, STORE_REGISTRATION_NO = ? where ID = ?";
	private static final String DELETE_STORE_BY_ID = "delete from medical_store where ID = ?";
	private static final String SELECT_ALL_STORE_TYPES = "select * from store_type";
	private static final String SELECT_USERNAME = "select username from medical_store where username = ?";
	private static final String SELECT_CREDENTIALS_BY_USERNAME = "select PASSWORD from medical_store where username = ?";
	private static final String SELECT_LAST_ROW_ID = "select * from (select ID from medical_store order by ID desc) where rownum < 2";
	private static final String COMMIT = "commit";
	
	public boolean insertStore(Store store) {
		boolean rowInserted = false;
		try(Connection con = DatabaseConnection.getConnection(); PreparedStatement statement = con.prepareStatement(INSERT_STORE)){
			
			int storeId = getLastRow() + 1;
			statement.setString(1, store.getStoreName());
			statement.setString(2, store.getUsername());
			statement.setString(3, store.getPassword());
			statement.setString(4, store.getStoreEmailId());
			statement.setString(5, store.getMobile());
			statement.setString(6, store.getAddress1());
			statement.setString(7, store.getAddress2());
			statement.setInt(8, store.getStoreLicense());
			statement.setInt(9, store.getStoreTypeId());
			statement.setString(10, store.getStoreRegistrationNumber());
			statement.setInt(11, storeId);
			rowInserted = statement.executeUpdate() > 0;
			commit();
			
		} catch(Exception e) {
			System.out.println(e);
		}
		return rowInserted;
	}
	
	public Store retreiveStoreById(int id) {
		
		Store store = null;
		try(Connection con = DatabaseConnection.getConnection(); PreparedStatement statement = con.prepareStatement(SELECT_STORE_BY_ID)){
			
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				int storeId = rs.getInt("STORE_ID");
				String storeName = rs.getString("STORE_NAME");
				String userName = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				String storeEmail = rs.getString("STORE_EMAIL_ID");
				String mobile = rs.getString("MOBILE_NUMBER");
				String address1 = rs.getString("ADDRESS_1");
				String address2 = rs.getString("ADDRESS_2");
				int license = rs.getInt("STORE_LICENSE");
				int storeTypeId = rs.getInt("STORE_TYPE_ID");
				String storeTypeName = rs.getString("STORE_TYPE_NAME");
				String registrationNo = rs.getString("STORE_REGISTRATION_NO");
				
				store = new Store(storeId, storeName, userName, password, storeEmail, mobile, address1, address2, license, storeTypeId, storeTypeName, registrationNo);
			}
			
		} catch(Exception e) {
			System.out.println(e);
		}
		return store;
		
	}

	public List<Store> retreiveStores(){
		List<Store> stores = new ArrayList<Store>();
		
		try(Connection con = DatabaseConnection.getConnection(); PreparedStatement statement = con.prepareStatement(SELECT_ALL_STORES)){
			
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				int storeId = rs.getInt("STORE_ID");
				String storeName = rs.getString("STORE_NAME");
				String userName = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				String storeEmail = rs.getString("STORE_EMAIL_ID");
				String mobile = rs.getString("MOBILE_NUMBER");
				String address1 = rs.getString("ADDRESS_1");
				String address2 = rs.getString("ADDRESS_2");
				int license = rs.getInt("STORE_LICENSE");
				int storeTypeId = rs.getInt("STORE_TYPE_ID");
				String storeTypeName = rs.getString("STORE_TYPE_NAME");
				String registrationNo = rs.getString("STORE_REGISTRATION_NO");
				
				Store store = new Store(storeId, storeName, userName, password, storeEmail, mobile, address1, address2, license, storeTypeId, storeTypeName, registrationNo);
				stores.add(store);
				
			}
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return stores;
	}
	
	public boolean updateStore(Store store) {
		
		boolean rowUpdated = false;
		
		try(Connection con = DatabaseConnection.getConnection(); PreparedStatement statement = con.prepareStatement(UPDATE_STORE_BY_ID)){
			
			statement.setString(1, store.getStoreName());
			statement.setString(2, store.getUsername());
			statement.setString(3, store.getPassword());
			statement.setString(4, store.getStoreEmailId());
			statement.setString(5, store.getMobile());
			statement.setString(6, store.getAddress1());
			statement.setString(7, store.getAddress2());
			statement.setInt(8, store.getStoreLicense());
			statement.setInt(9, store.getStoreTypeId());
			statement.setString(10, store.getStoreRegistrationNumber());
			statement.setInt(11, store.getId());
			rowUpdated = statement.executeUpdate() > 0;
			commit();
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return rowUpdated;
		
	}

	public boolean deleteStore(int id) {
		
		boolean rowDeleted = false;
		
		try(Connection con = DatabaseConnection.getConnection(); PreparedStatement statement = con.prepareStatement(DELETE_STORE_BY_ID)){
			
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
			commit();
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return rowDeleted;	
    }
	public List<StoreType> retrieveStoreTypes() {
		List<StoreType> storeTypes = new ArrayList<StoreType>();
		
		try(Connection con = DatabaseConnection.getConnection(); PreparedStatement statement = con.prepareStatement(SELECT_ALL_STORE_TYPES)){
			
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("ID");
				String typeName = rs.getString("TYPE_NAME");
				
				StoreType storeType = new StoreType(id, typeName);
				storeTypes.add(storeType);
			}
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return storeTypes;
	}
	public boolean doesUsernameExist(String username) {
		
		boolean doesExist = false;
		try(Connection con = DatabaseConnection.getConnection(); PreparedStatement statement = con.prepareStatement(SELECT_USERNAME)){
			
			statement.setString(1, username);
			ResultSet rs = statement.executeQuery();
			doesExist = rs.next();
			
		} catch(Exception e) {
			System.out.println(e);
		}
		return doesExist;
		
	}
	public Credentials retrieveCredentials(String username) {
		Credentials credentials = null;
		try(Connection con = DatabaseConnection.getConnection(); PreparedStatement statement = con.prepareStatement(SELECT_CREDENTIALS_BY_USERNAME)){
			
			statement.setString(1, username);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String password = rs.getString("PASSWORD");
				credentials = new Credentials(username, password);
			}
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return credentials;
	}
	private void commit() {
		try(Connection con = DatabaseConnection.getConnection(); PreparedStatement statement = con.prepareStatement(COMMIT)){
			
			statement.execute();
			
		} catch(Exception e) {
			System.out.println(e);
		}
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

	