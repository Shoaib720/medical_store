package ml.hadiya.controllers;

import java.io.IOException;
import java.util.List;

import ml.hadiya.daos.MedicineDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ml.hadiya.models.Medicine;

@SuppressWarnings("serial")
@WebServlet("/medicines")
public class MedicinesListServlet extends HttpServlet {

	MedicineDAO medicineDao;
	
	public void init() {
		medicineDao = new MedicineDAO();
	}
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		HttpSession session = req.getSession();
		if(session.getAttribute("username") != null) {
			
			List<Medicine> medicines = medicineDao.retreiveMedicines();
			if(medicines != null) {
				for(Medicine medicine: medicines) {
					medicine.setExpiryDate(medicine.getExpiryDate());
				}
			}
			
			RequestDispatcher rd = req.getRequestDispatcher("medicine-list.jsp");
			req.setAttribute("medicines", medicines);
			rd.forward(req, res);
			
		}
		else {
			res.sendRedirect("index.jsp");
		}
		
	}
	
}
