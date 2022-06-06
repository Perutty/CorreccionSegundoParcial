package co.empresa.segundoparcial.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.empresa.segundoparcial.modelo.Bill;
import co.empresa.segundoparcial.modelo.Usuario;
import co.empresa.segundoparcial.util.ConexionPostgreSQL;

public class BillDaoPostgreSQL implements BillDao {
	
private ConexionPostgreSQL conexion;
	
	private static final String INSERT_BILL_SQL = "INSERT INTO bill(id, date_bill, user_id, value, type, observation) VALUES (?,?,?,?,?,?);";
	private static final String DELETE_BILL_SQL = "DELETE FROM bill WHERE id = ?;";
	private static final String SELECT_BILL_BY_ID = "SELECT * FROM bill WHERE id = ?;";
	private static final String SELECT_ALL_BILLS = "SELECT * FROM bill WHERE user_id = ?;";

	
	public BillDaoPostgreSQL() {
		this.conexion = ConexionPostgreSQL.getConexion();
	}
	
	
	public void insert(Bill bill) throws SQLException{
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(INSERT_BILL_SQL);
			preparedStatement.setInt(1, bill.getId());
			preparedStatement.setDate(2, (Date) bill.getDate_bill());
			preparedStatement.setInt(3, bill.getUser_id());
			preparedStatement.setInt(3, bill.getValue());
			preparedStatement.setInt(3, bill.getType());
			preparedStatement.setString(3, bill.getObservation());
			conexion.execute();
		}catch (SQLException e) {
			
		}
	}
	
	public void delete(int id) throws SQLException{
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(DELETE_BILL_SQL);
			preparedStatement.setInt(1, id);
			
			conexion.execute();
		}catch (SQLException e){
		
		}
	}
	
	public Bill select(Integer id){
		Bill b = null;
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(SELECT_BILL_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet rs = conexion.query();
			
			while(rs.next()) {
				Date date = rs.getDate("date_bill");
				int user_id = rs.getInt("user_id");
				int value = rs.getInt("value");
				int type = rs.getInt("type");
				String obs = rs.getString("observation");
				b = new Bill(date,user_id,value,type,obs);
			}
			
		}catch(SQLException e) {
			
		}
		return b;
 	}
	
	public List<Bill> selectAll(){
		List <Bill> bills = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(SELECT_ALL_BILLS);
			ResultSet rs = conexion.query();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				Date date = rs.getDate("date_bill");
				int user_id = rs.getInt("user_id");
				int value = rs.getInt("value");
				int type = rs.getInt("type");
				String obs = rs.getString("observation");
				bills.add(new Bill(id, date, user_id, value, type, obs));
			}
			
		}catch(SQLException e) {
			
		}
		
		return bills;
 	}
}
