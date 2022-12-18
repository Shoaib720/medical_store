package ml.hadiya.controllers;
import java.io.IOException;

import java.util.List;

import ml.hadiya.daos.MedicineDAO;
import ml.hadiya.daos.StoreDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ml.hadiya.models.Medicine;
import ml.hadiya.models.MedicineType;
import ml.hadiya.models.Store;

@SuppressWarnings("serial")
@WebServlet("/editMedicine")
public class EditMedicineServlet extends HttpServlet {

	MedicineDAO medicineDao;
	StoreDAO storeDao;
	
	public void init() {
		medicineDao = new MedicineDAO();
		storeDao = new StoreDAO();
	}
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		HttpSession session = req.getSession();
		if(session.getAttribute("username") != null) {
			
			int medicineId = Integer.parseInt(req.getParameter("id"));
			
			Medicine medicine = medicineDao.retreiveMedicineById(medicineId);
			List<MedicineType> medicineTypes = medicineDao.retrieveMedicineTypes();
			List<Store> stores = storeDao.retreiveStores();
			
			if(medicine != null && medicineTypes != null && stores != null) {
				RequestDispatcher rd = req.getRequestDispatcher("medicine-form.jsp");
				req.setAttribute("medicine", medicine);
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
