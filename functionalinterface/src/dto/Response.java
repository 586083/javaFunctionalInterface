package dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class Response {

	private String productType;
	private String productName;
	private String respCode;
	private String respMessage;
	private List<AccountBalanceDetails> accountBalances;
	private List<Response> productResp;
	
}
