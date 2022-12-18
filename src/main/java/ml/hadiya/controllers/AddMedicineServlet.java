package ml.hadiya.controllers;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ml.hadiya.models.MedicineType;
import ml.hadiya.models.Store;

import java.io.IOException;
import java.util.List;

import ml.hadiya.daos.MedicineDAO;
import ml.hadiya.daos.StoreDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/addMedicine")
public class AddMedicineServlet extends HttpServlet {

	MedicineDAO medicineDao;
	StoreDAO storeDao;
	
	public void init() {
		medicineDao = new MedicineDAO();
		storeDao = new StoreDAO();
	}
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		HttpSession session = req.getSession();
		if(session.getAttribute("username") != null) {
			
			List<MedicineType> medicineTypes = medicineDao.retrieveMedicineTypes();
			List<Store> stores = storeDao.retreiveStores();
			
			if(medicineTypes != null && stores != null) {
				RequestDispatcher rd = req.getRequestDispatcher("medicine-form.jsp");
				req.setAttribute("medicineTypes", medicineTypes);
				req.setAttribute("stores", stores);
				rd.forward(req, res);
			}
			else {
				res.sendRedirect("medicines");
			}
			
		}
		else {
			res.sendRedirect("index.jsp");
		}
		
	}
	
}
