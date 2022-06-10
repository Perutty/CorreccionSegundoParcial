package co.empresa.segundoparcial.modelo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	private String username;
	private String email;  
	private String pass;
	 
	public Usuario(String username, String pass) {
		this.username = username;
		this.pass = pass;
		
	}
	
	public Usuario(String username, String email, String pass) {
		this.username = username;
		this.email = email;
		this.pass = pass;
		
	}

	public Usuario(int id, String username, String pass) {
		this.id = id;
		this.username = username;
		this.pass = pass;
	}
}

	