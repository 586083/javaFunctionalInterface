package dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Balance {

	private String amountType;
	private BigDecimal amount;
	private String ccy;
	private Date date;
	private String description;
}
