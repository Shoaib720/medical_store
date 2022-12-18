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

@SuppressWarnings("serial")
@WebServlet("/listStores")
public class ListStoresServlet extends HttpServlet {
	
	private StoreDAO storeDao;
	
	public void init() {
		storeDao = new StoreDAO();
	}
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		if(session.getAttribute("username") != null) {
			
			List<Store> stores = storeDao.retreiveStores();
			
			RequestDispatcher rd = req.getRequestDispatcher("store-list.jsp");
			req.setAttribute("storesList", stores);
			rd.forward(req, res);
			
		}
		else {
			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			rd.forward(req, res);
		}
		
	}
}
