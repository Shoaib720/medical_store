package ml.hadiya.controllers;
import java.io.IOException;

import ml.hadiya.daos.MedicineDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ml.hadiya.models.Medicine;
import ml.hadiya.utils.Validation;

@SuppressWarnings("serial")
@WebServlet("/updateMedicine")
public class UpdateMedicineServlet extends HttpServlet {

	MedicineDAO medicineDao;
	
	public void init() {
		medicineDao = new MedicineDAO();
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		HttpSession session = req.getSession();
		if(session.getAttribute("username") != null) {

			int medicineId = Integer.parseInt(req.getParameter("medicine-id"));
			String name = req.getParameter("name");
			String details = req.getParameter("details");
			String expiryDate = req.getParameter("expiry-date");
			double price = Double.parseDouble(req.getParameter("price"));
			int quantity = Integer.parseInt(req.getParameter("quantity"));
			int storeId = Integer.parseInt(req.getParameter("store"));
			int medicineTypeId = Integer.parseInt(req.getParameter("type"));
			
			Medicine medicine = new Medicine(name, details, price, quantity, expiryDate, storeId, medicineTypeId);
			medicine.setId(medicineId);
			
			if(Validation.isMedicineValid(medicine)) {
				boolean result = medicineDao.updateMedicine(medicine);
				if(result) {
					res.sendRedirect("medicines");
				}
				else {
					RequestDispatcher rd = req.getRequestDispatcher("medicines");
					req.setAttribute("error", "Unable to update medicine data!");
					rd.forward(req, res);
				}
			}
			else {
				RequestDispatcher rd = req.getRequestDispatcher("medicines");
				req.setAttribute("error", "Validation failed!");
				rd.forward(req, res);
			}
		}
		else {
			res.sendRedirect("index.jsp");
		}
		
	}
	
}
