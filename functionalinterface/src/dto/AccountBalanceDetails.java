package dto;
import java.math.BigInteger;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class AccountBalanceDetails {
	
	private String accountNumber;
	private String accountRelationship;
	private String productName;;
	private String accountType;
	private String productCode;
	private List<Balance> amounts;
	private List<Holdings> holdings;
	private BigInteger accountNo;
}
