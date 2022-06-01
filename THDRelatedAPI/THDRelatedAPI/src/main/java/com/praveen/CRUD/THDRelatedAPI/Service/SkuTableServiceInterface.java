package com.praveen.CRUD.THDRelatedAPI.Service;

import java.util.List;

import com.praveen.CRUD.THDRelatedAPI.Entity.SkuTable;

public interface SkuTableServiceInterface {

	public SkuTable addproduct(SkuTable skutable);

	public List<SkuTable> getProducts();

	public SkuTable getProductById(int id);
	
	public List<SkuTable> searchProduct(String query);

}

