package ml.hadiya.controllers;

import java.io.IOException;


import ml.hadiya.daos.StoreDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/deleteStore")
public class DeleteStoreServlet extends HttpServlet {
	
	private StoreDAO storeDao;

	public void init() {
		storeDao = new StoreDAO();
	}
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		if(session.getAttribute("username") != null) {
			
			int storeId = Integer.parseInt(req.getParameter("id"));
			
			Boolean isDeleted = storeDao.deleteStore(storeId);
			
			if(isDeleted) {
				RequestDispatcher rd = req.getRequestDispatcher("listStores");
				rd.forward(req, res);
			}
			else {
				RequestDispatcher rd = req.getRequestDispatcher("listStores");
				req.setAttribute("error", "Unable to delete the store!");
				rd.forward(req, res);
			}
			
		}
		else {
			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			rd.forward(req, res);
		}
		
	}
	
}
