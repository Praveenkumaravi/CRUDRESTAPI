package com.praveen.CRUD.THDRelatedAPI;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;
import static org.junit.jupiter.api.Assertions.*;

import com.praveen.CRUD.THDRelatedAPI.Entity.SkuTable;

@SpringBootTest
class ThdRelatedApiApplicationTests {

	@Test
	public void testGetProductById() {
		RestTemplate resttemplate = new RestTemplate();
		SkuTable product = resttemplate.getForObject("http://localhost:9090/skutable/product/1", SkuTable.class);
		assertNotNull(product);
		assertEquals("Nokia 6.1 plus", product.getName());
	}

	@Test
	public void testCreateProduct() {
		RestTemplate resttemplate = new RestTemplate();
		SkuTable skuproduct = new SkuTable();
		skuproduct.setName("Samsung M30");
		skuproduct.setDescription("Awesome");
		skuproduct.setCost(20000);
		SkuTable newSkuProduct = resttemplate.postForObject("http://localhost:9090/skutable/addproduct", skuproduct,
				SkuTable.class);
		assertNotNull(newSkuProduct);
		assertEquals("Samsung M30", newSkuProduct.getName());

	}
}