package co.empresa.segundoparcial.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.empresa.segundoparcial.dao.BillDao;
import co.empresa.segundoparcial.dao.BillDaoFactory;
import co.empresa.segundoparcial.dao.UsuarioDao;
import co.empresa.segundoparcial.dao.UsuarioDaoFactory;
import co.empresa.segundoparcial.modelo.Bill;
import co.empresa.segundoparcial.modelo.Usuario;

/**
 * Servlet implementation class BillServlet
 */
@WebServlet(name="BillServlet", urlPatterns={"/BillServlet"})
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
		String action = request.getParameter("action");
		
		try {
			switch(action) {
			case "newBill":
				showNewForm(request, response);
				break;
			case "insert":
				insertarBill(request,response);
			case "list":
				listBills(request,response);
			case "delete":
				deleteBill(request,response);
			case "cerrar":
				cerrarSesion(request,response);
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
		
		Date dat = new Date();
		java.sql.Date sqlDate = new java.sql.Date(dat.getTime());
		
	    int uId = (int) request.getSession().getAttribute("uId");
	    
		String observation = request.getParameter("observation");
		int value = Integer.parseInt(request.getParameter("value"));
		int type = Integer.parseInt(request.getParameter("mov"));
		
		Bill bill = new Bill(uId,value, type, observation, sqlDate);
		billDao.insert(bill);
		request.getRequestDispatcher("BillServlet?action=list").forward(request,response);
	}
	
	private void deleteBill(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, SQLException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		billDao.delete(id);
		request.getRequestDispatcher("BillServlet?action=list").forward(request,response);
	}
	
	private void cerrarSesion(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, SQLException, IOException {
		
		request.getSession().invalidate();
		request.getRequestDispatcher("UsuarioServlet?action=logeo").forward(request,response);
	}
	
	private void listBills(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, SQLException, IOException{
		
		List<Bill> listBills = billDao.selectAll();
		List<Bill> listMostrar = new ArrayList<>();
		int user_id = (int) request.getSession().getAttribute("uId");
		listBills.forEach((billes) -> {
			if(billes.getUser_id() == user_id) {
				listMostrar.add(billes);
			}
		});
		request.getSession().setAttribute("listBills", listMostrar);
		
		request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		
	}

}
