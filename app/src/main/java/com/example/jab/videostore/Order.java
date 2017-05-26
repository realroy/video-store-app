import java.util.List;

public class Order {
	private List<Product> cartedProducts;
	private String customerId;
	
	public Order() {
		// TODO Auto-generated constructor stub	
	}
	
	public Order(List<Product> list, String customerId){
		cartedProducts = list;
		this.customerId = customerId;
	}
	
	public List<Product> getCartedProduct() {
		return cartedProducts;
	}

	public void setCartedProduct(List<Product> cartedProduct) {
		this.cartedProducts = cartedProduct;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
}
