package co.empresa.segundoparcial.dao;

import java.sql.SQLException;
import java.util.List;

import co.empresa.segundoparcial.modelo.Bill;
import co.empresa.segundoparcial.modelo.Usuario;

public interface BillDao {
	
	public void insert(Bill bill) throws SQLException;
	public List <Bill> selectAll();
	public void delete(int id) throws SQLException;

}
