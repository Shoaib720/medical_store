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
import ml.hadiya.models.Credentials;

@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	StoreDAO storeDao;
	
	public void init() {
		storeDao = new StoreDAO();
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		if(username == "" || username == null || password == "" || password == null) {
			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			req.setAttribute("error", "Fields can't be empty!");
			rd.forward(req, res);
		}
		else {
			Credentials credentials = storeDao.retrieveCredentials(username);
			if(credentials != null) {
				if(password.equals(credentials.getPassword())) {
					HttpSession session = req.getSession();
					session.setAttribute("username", username);
					res.sendRedirect("listStores");
				} else {
					req.setAttribute("error", "Invalid Credentials");
					RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
					rd.forward(req, res);
				}
			}
			else {
				req.setAttribute("error", "User not found!");
				RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
				rd.forward(req, res);
			}
		}
		
	}
	
}
