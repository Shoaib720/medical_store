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
import ml.hadiya.models.Store;
import ml.hadiya.models.StoreType;

@SuppressWarnings("serial")
@WebServlet("/editStore")
public class EditStoreServlet extends HttpServlet {
	
	StoreDAO storeDao;
	
	public void init() {
		storeDao = new StoreDAO();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		if(session.getAttribute("username") != null) {
			
			int storeId = Integer.parseInt(req.getParameter("id"));
			
			Store store = storeDao.retreiveStoreById(storeId);
			List<StoreType> storeTypes = storeDao.retrieveStoreTypes();
			
			if(store != null && storeTypes != null) {
				RequestDispatcher rd = req.getRequestDispatcher("store-form.jsp");
				req.setAttribute("storeTypes", storeTypes);
				req.setAttribute("store", store);
				rd.forward(req, res);
			}
			else {
				RequestDispatcher rd = req.getRequestDispatcher("listStores");
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
