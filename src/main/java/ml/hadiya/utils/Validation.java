package ml.hadiya.utils;
import ml.hadiya.daos.StoreDAO;
import ml.hadiya.models.Medicine;
public class Validation {
	
	private static StoreDAO storeDao;

	public static boolean isEmailValid(String email) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return email.matches(regex);
	}
	
	public static boolean isUsernameUnique(String username) {
		storeDao = new StoreDAO();
		return !storeDao.doesUsernameExist(username);
	}
	
	public static boolean isMedicineValid(Medicine medicine) {
		
		if(medicine.getPrice() < 0 || medicine.getQuantity() < 0 ) {
			return false;
		}
		return true;
		
	}
	
}
