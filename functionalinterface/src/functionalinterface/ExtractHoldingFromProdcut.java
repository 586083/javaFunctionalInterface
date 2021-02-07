package functionalinterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import dto.AccountBalanceDetails;

import dto.Response;


public class ExtractHoldingFromProdcut implements  Command<Response,String, Response>{

	@Override
	public Response handle(Response req, String headers) {
		/**
		req.getAccountBalances().stream().map(accounts->{
			accounts.getHoldings().stream()
			.filter( holdings -> !holdings.getHoldingType().equals(headers))
			.collect(Collectors.toList());
			accounts.setAmounts(null);
			return accounts;
		}).collect(Collectors.toList());*/
		
		
		try {
			Optional.ofNullable(req.getAccountBalances())
			.map(obj-> { //account list is not empty
				List<AccountBalanceDetails> invalidAccount=new ArrayList<>();
				//iterate and check the list of invalid accounts
				obj.listIterator().forEachRemaining(account -> {
					account.setAmounts(null);//setting balance null
					try {
						Optional.ofNullable(account.getHoldings())
						.map(holdingsList->{//holding is not null
							holdingsList.removeIf(holding -> !holding.getHoldingType().equals(headers));
								if(holdingsList.isEmpty()) {
									invalidAccount.add(account);//if holding available but no UT holding remove account
								}
								return holdingsList;
						})
						.orElseThrow(RuntimeException::new); 
					}catch(Exception e) {
						invalidAccount.add(account);//if holding list is null remove that account
					}
				
				});
				//remove all invalid accounts
				obj.removeAll(invalidAccount);
				
				//check if account list is empty 
				//mean none of the account has UT holdings
				if(obj.size() == 0) {
					throw new RuntimeException();//throw exception to make product null
				}
				return obj;
			})
			.orElseThrow(RuntimeException::new); //if accounts list is empty then make products as null
		}catch(Exception e) {
			req=null;
		}
		
		/**
		Optional.ofNullable(req).ifPresent(notNullProduct->{
			Optional.ofNullable(notNullProduct.getAccountBalances()).ifPresent(listOfNotNullAcctBal->{
				listOfNotNullAcctBal.stream().forEach(account->{
					Optional.ofNullable(account).ifPresent(notNullAccount->{
						notNullAccount.setAmounts(null);
						Optional.ofNullable(notNullAccount.getHoldings()).ifPresent(notNullHoldingList->{
							notNullHoldingList.removeIf(holdings -> !holdings.getHoldingType().equals(headers));
						});
					});
				});
			});
		});*/
		return req;
	}
	
	
}
