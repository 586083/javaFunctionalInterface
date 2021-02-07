package dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StatementBalanaceResponse {

	private String fisp;
	private String respCode;
	private String resMessage;
	private String identity;
	private List <Response> products;
	
}
