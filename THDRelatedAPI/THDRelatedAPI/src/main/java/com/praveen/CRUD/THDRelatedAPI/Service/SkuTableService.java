package com.praveen.CRUD.THDRelatedAPI.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praveen.CRUD.THDRelatedAPI.Entity.SkuTable;
import com.praveen.CRUD.THDRelatedAPI.Repo.SkuTableRepository;
import com.praveen.CRUD.THDRelatedAPI.custom.exception.BusinessException;

@Service
public class SkuTableService implements SkuTableServiceInterface {
	@Autowired
	private SkuTableRepository skutablerepository;

	@Override
	public SkuTable addproduct(SkuTable skutable) {

		if (skutable.getName().isEmpty() || skutable.getName().length() == 0) {
			throw new BusinessException("601", "The product name is empty");
		}
		try {
			SkuTable savedProduct = skutablerepository.save(skutable);
			return savedProduct;
		} catch (IllegalArgumentException e) {
			throw new BusinessException("602", "The product is null");
		} catch (Exception e) {
			throw new BusinessException("603", "Something went wrong while adding the product");
		}
	}

	@Override
	public List<SkuTable> getProducts() {
		try {
			List<SkuTable> listOfProducts = skutablerepository.findAll();
			if (listOfProducts.isEmpty())
				throw new BusinessException("604", "The skutable as no products");
			return listOfProducts;
		} catch (Exception e) {
			throw new BusinessException("605", "Something went wrong while getting the products ");
		}
	}

	@Override
	public SkuTable getProductById(int id) {
		try {
			return skutablerepository.findById(id).get();
		} catch (NoSuchElementException e) {
			throw new BusinessException("606", "The given id is not found in the skutable ");
		}
	}

	@Override
	public List<SkuTable> searchProduct(String query) {

		List<SkuTable> products = skutablerepository.searchProduct(query);
		return products;

	}
}
