package co.empresa.segundoparcial.dao;


public class BillDaoFactory {

	public static BillDao getBillDao(String type) {
		
		switch(type)
		{
			
		case "postgresql":
			return new BillDaoPostgreSQL();
			
		default:
			break;
		}
		return null;
	}
	
}