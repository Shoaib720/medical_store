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
import ml.hadiya.models.Store;
import ml.hadiya.utils.Validation;

@SuppressWarnings("serial")
@WebServlet("/insertStore")
public class InsertStoreServlet extends HttpServlet{
	
	private StoreDAO storeDao;

	public void init() {
		storeDao = new StoreDAO();
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		if(session.getAttribute("username") != null) {
			
			String name = req.getParameter("store-name");
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String emailId = req.getParameter("email");
			String mobileNo = req.getParameter("mobile");
			String registrationNo = req.getParameter("registration-number");
			int license = Integer.parseInt(req.getParameter("license"));
			int storeTypeId = Integer.parseInt(req.getParameter("store-type"));
			String address1 = req.getParameter("address1");
			String address2 = req.getParameter("address2");
			
			if(Validation.isEmailValid(emailId) && Validation.isUsernameUnique(username)) {
				Store store = new Store(name, username, password, emailId, mobileNo, address1, address2, license, storeTypeId, registrationNo);
				boolean isInserted = storeDao.insertStore(store);
				if(isInserted) {
					RequestDispatcher rd = req.getRequestDispatcher("listStores");
					rd.forward(req, res);
				}
				else {
					RequestDispatcher rd = req.getRequestDispatcher("listStores");
					req.setAttribute("error", "Unable to insert the store data!");
					rd.forward(req, res);
				}
			}
			else {
				RequestDispatcher rd = req.getRequestDispatcher("listStores");
				req.setAttribute("error", "Input fields validation failed!");
				rd.forward(req, res);
			}
			
		}
		else {
			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			rd.forward(req, res);
		}
		
	}
	
}
