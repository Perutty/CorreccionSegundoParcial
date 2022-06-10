package co.empresa.segundoparcial.modelo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bill {

	private Integer id;
	
	private Date date_bill;
	
	private Integer user_id;
	
	private Integer value;
	
	private Integer type;
	
	private String observation;
	
	
	public Bill(Integer user_id, Integer value, Integer type,
				String observation,Date date_bill){
		
		this.user_id = user_id;
		this.value = value;
		this.type = type;
		this.observation = observation;
		this.date_bill = date_bill;
	}
	
	public Bill(Integer user_id)
	{
		this.user_id = user_id;
	}
}
