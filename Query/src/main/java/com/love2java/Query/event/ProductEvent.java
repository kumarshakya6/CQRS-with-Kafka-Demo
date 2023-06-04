package com.love2java.Query.event;

import com.love2java.Query.entity.Product;

public class ProductEvent {
	private String type;
    private Product product;
    
    public ProductEvent() {}
    public ProductEvent(String type,Product product){
 
        this.type = type;
        this.product = product;
    }
    
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
     
}
