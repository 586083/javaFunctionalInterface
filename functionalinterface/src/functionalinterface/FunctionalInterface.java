package functionalinterface;

import java.util.ArrayList;
import java.util.List;

import dto.AccountBalanceDetails;
import dto.Holdings;
import dto.Response;
import dto.StatementBalanaceResponse;

public class FunctionalInterface {
	
	public static void main(String args[]) {
		StatementBalanaceResponse input=prepareInput();
		Command<StatementBalanaceResponse, String, Response> utFromCPF=new ProduceByProductsFromProducts();
		Command<Response, String, Response> utFromCpfHoldings=new ExtractHoldingFromProdcut();
		Response output=utFromCpfHoldings.handle(utFromCPF.handle(input, "cpfis"), "unitTrust");
		System.out.println(output);
	}
	
	public static StatementBalanaceResponse prepareInput() {
		StatementBalanaceResponse object=new StatementBalanaceResponse();
		object.setFisp("7335");
		object.setResMessage("Succesful'");
		List<Response> products=new ArrayList<>();
		
		Response cpfis=new Response();
		cpfis.setProductName("cpfis");
		cpfis.setProductType("cpfis");
		List<AccountBalanceDetails> accountBalance=new ArrayList<AccountBalanceDetails>();
		
		//Account1
		AccountBalanceDetails account1=new AccountBalanceDetails();
		List<Holdings> account1holdings=new ArrayList<Holdings>();
		Holdings holdings11=new Holdings();
		holdings11.setHoldingType("unitTrust");
		account1holdings.add(holdings11);
		Holdings holdings21=new Holdings();
		holdings21.setHoldingType("equity");
		account1holdings.add(holdings21);
		account1.setHoldings(account1holdings);
		
		//Account2
		AccountBalanceDetails account2=new AccountBalanceDetails();
		List<Holdings> account2holdings=new ArrayList<Holdings>();
		Holdings holdings12=new Holdings();
		holdings12.setHoldingType("unitTrust");
		account2holdings.add(holdings12);
		Holdings holdings22=new Holdings();
		holdings22.setHoldingType("equity");
		account2holdings.add(holdings22);
		account2.setHoldings(account2holdings);
		
		accountBalance.add(account1);
		accountBalance.add(account2);
		cpfis.setAccountBalances(accountBalance);
		
		
		products.add(cpfis);
		
		object.setProducts(products);
		return object;
	}
}
