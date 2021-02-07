package dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Holdings {

	private String holdingName;
	private String holdingType;
	private String holdingCode;
	private String holdingCcy;
	private String holdingCodeType;
	private String balanceType;
	private InnerBalances balances;
}
