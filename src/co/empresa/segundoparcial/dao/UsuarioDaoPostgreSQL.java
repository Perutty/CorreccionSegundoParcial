package co.empresa.segundoparcial.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.empresa.segundoparcial.modelo.Usuario;
import co.empresa.segundoparcial.util.ConexionPostgreSQL;

public class UsuarioDaoPostgreSQL implements UsuarioDao {

	private ConexionPostgreSQL conexion;
	
	private static final String INSERT_USUARIO_SQL = "INSERT INTO users(username, email, pass) VALUES (?,?,?);";
	private static final String UPDATE_USUARIO_SQL = "UPDATE users SET username = ?,email = ?, pass = ? WHERE id = ?;";
	private static final String DELETE_USUARIO_SQL = "DELETE FROM users WHERE id = ?;";
	private static final String SELECT_USUARIO_BY_CREDENTIAL = "SELECT * FROM users WHERE username = ? AND pass = ?;";
	private static final String SELECT_ALL_USUARIOS = "SELECT * FROM users;";
	
	public UsuarioDaoPostgreSQL() {
		this.conexion = ConexionPostgreSQL.getConexion();
	}
	
	public void insert(Usuario usuario) throws SQLException{
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(INSERT_USUARIO_SQL);
			preparedStatement.setString(1, usuario.getUsername());
			preparedStatement.setString(2, usuario.getEmail());
			preparedStatement.setString(3, usuario.getPass());
			conexion.execute();
		}catch (SQLException e) {
			
		}
	}
	
	
	public void update(Usuario usuario) throws SQLException{
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(UPDATE_USUARIO_SQL);
			preparedStatement.setString(1, usuario.getUsername());
			preparedStatement.setString(2, usuario.getEmail());
			preparedStatement.setString(3, usuario.getPass());
			preparedStatement.setInt(4, usuario.getId());
			conexion.execute();
		}catch (SQLException e) {
			
		}
	}
	
	public void delete(int id) throws SQLException{
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(DELETE_USUARIO_SQL);
			preparedStatement.setInt(1, id);
			
			conexion.execute();
		}catch (SQLException e){
		
		}
	}
	
	public List<Usuario> selectAll(){
		List <Usuario> usuarios = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(SELECT_ALL_USUARIOS);
			ResultSet rs = conexion.query();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String email = rs.getString("email");
				String pass = rs.getString("pass");
				usuarios.add(new Usuario(id, username, email, pass));
			}
			
		}catch(SQLException e) {
			
		}
		
		return usuarios;
 	}
	
	public Usuario select(String username, String pass){
		Usuario u = null;
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(SELECT_USUARIO_BY_CREDENTIAL);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, pass);
			ResultSet rs = conexion.query();
			
			while(rs.next()) {
				String user = rs.getString("username");
				String p = rs.getString("pass");
				u = new Usuario(user, p);
			}
			
		}catch(SQLException e) {
			
		}
		return u;
 	}

}
