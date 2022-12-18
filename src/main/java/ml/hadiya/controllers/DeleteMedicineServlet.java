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

@SuppressWarnings("serial")
@WebServlet("/deleteMedicine")
public class DeleteMedicineServlet extends HttpServlet {

MedicineDAO medicineDao;
	
	public void init() {
		medicineDao = new MedicineDAO();
	}
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		HttpSession session = req.getSession();
		if(session.getAttribute("username") != null) {
			
			int medicineId = Integer.parseInt(req.getParameter("id"));
			
			boolean result = medicineDao.deleteMedicineById(medicineId);
			if(result) {
				res.sendRedirect("medicines");
			}
			else {
				RequestDispatcher rd = req.getRequestDispatcher("medicines");
				req.setAttribute("error", "Unable to delete medicine data!");
				rd.forward(req, res);
			}
			
		}
		else {
			res.sendRedirect("index.jsp");
		}
		
	}
	
}
