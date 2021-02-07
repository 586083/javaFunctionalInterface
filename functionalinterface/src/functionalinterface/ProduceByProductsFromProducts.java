package functionalinterface;



import dto.Response;
import dto.StatementBalanaceResponse;

public class ProduceByProductsFromProducts implements Command<StatementBalanaceResponse, String, Response>{

	@Override
	public Response handle(StatementBalanaceResponse req, String headers) {
		return req.getProducts()
				.stream()
				.filter(obj-> obj.getProductType().equals(headers))
				.findFirst()
				.get();
	}

	

}
