package co.empresa.segundoparcial.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.empresa.segundoparcial.dao.BillDao;
import co.empresa.segundoparcial.dao.BillDaoFactory;
import co.empresa.segundoparcial.dao.UsuarioDaoFactory;
import co.empresa.segundoparcial.modelo.Bill;
import co.empresa.segundoparcial.modelo.Usuario;

/**
 * Servlet implementation class BillServlet
 */
@WebServlet("/BillServlet")
public class BillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private BillDao billDao;

	public BillServlet() {
		super();
    // TODO Auto-generated constructor stub
	}
	
	public void init(ServletConfig config) throws ServletException {
		this.billDao = BillDaoFactory.getBillDao("postgresql");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String action = request.getServletPath();
		
		try {
			switch(action) {
			case "/newBill":
				showNewForm(request, response);
				break;
			case "/insert":
				insertarBill(request,response);
			default:
				listBills(request, response);
		}
	}catch(SQLException e) {
			throw new ServletException(e);
}
}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("registrarBill.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertarBill(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, SQLException, IOException {
		
		String observation = request.getParameter("observation");
		int value = Integer.parseInt(request.getParameter("value"));
		
		Bill bill = new Bill(value, observation);
		billDao.insert(bill);
		
		response.sendRedirect("list");
	}
	
	private void listBills(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, SQLException, IOException{
		
		List<Bill> listBills = billDao.selectAll();
		request.setAttribute("listBills", listBills);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
		dispatcher.forward(request, response);
		
	}

}
