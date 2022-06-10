package co.empresa.segundoparcial.dao;


public class UsuarioDaoFactory {

	public static UsuarioDao getUsuarioDao(String type) {
		
		switch(type)
		{
			
		case "postgresql":
			return new UsuarioDaoPostgreSQL();
			
		default:
			break;
		}
		return null;
	}
	
}
