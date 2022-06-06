package co.empresa.segundoparcial.dao;

import java.sql.SQLException;
import java.util.List;

import co.empresa.segundoparcial.modelo.Usuario;

public interface UsuarioDao {
	
	public void insert(Usuario usuario) throws SQLException;
	public Usuario select(String username, String pass);
	public List <Usuario> selectAll();
	public void delete(int id) throws SQLException;
	public void update(Usuario usuario) throws SQLException;

}
