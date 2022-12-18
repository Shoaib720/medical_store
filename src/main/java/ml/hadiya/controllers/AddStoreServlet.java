package ml.hadiya.controllers;

import java.io.IOException;
import java.util.List;



import ml.hadiya.daos.StoreDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ml.hadiya.models.StoreType;

@SuppressWarnings("serial")
@WebServlet("/addStore")
public class AddStoreServlet extends HttpServlet{
	
	private StoreDAO storeDao;

	public void init() {
		storeDao = new StoreDAO();
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		if(session.getAttribute("username") != null) {
			List<StoreType> storeTypes = storeDao.retrieveStoreTypes();
			
			if(storeTypes != null) {
				RequestDispatcher rd = req.getRequestDispatcher("store-form.jsp");
				req.setAttribute("storeTypes", storeTypes);
				rd.forward(req, res);
			}
			else {
				RequestDispatcher rd = req.getRequestDispatcher("ListStoresServlet");
				req.setAttribute("error", "Unable to fetch the store data!");
				rd.forward(req, res);
			}
		}
		else {
			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			rd.forward(req, res);
		}
		
	}
	
}
