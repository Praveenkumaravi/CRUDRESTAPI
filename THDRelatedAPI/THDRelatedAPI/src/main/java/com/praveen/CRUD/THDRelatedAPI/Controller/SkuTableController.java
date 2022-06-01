package com.praveen.CRUD.THDRelatedAPI.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.praveen.CRUD.THDRelatedAPI.Entity.SkuTable;
import com.praveen.CRUD.THDRelatedAPI.Service.SkuTableServiceInterface;
import com.praveen.CRUD.THDRelatedAPI.custom.exception.BusinessException;
import com.praveen.CRUD.THDRelatedAPI.custom.exception.ControllerException;

@RestController
@RequestMapping("/skutable")
public class SkuTableController {
	@Autowired
	private SkuTableServiceInterface skutableserviceinterface;

	private static final Logger LOGGER = LoggerFactory.getLogger(SkuTableController.class);

	@PostMapping("/addproduct")
	public ResponseEntity<?> addProduct(@RequestBody SkuTable skutable) {
		try {
			SkuTable productsaved = skutableserviceinterface.addproduct(skutable);
			return new ResponseEntity<SkuTable>(productsaved, HttpStatus.CREATED);
		} catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			ControllerException ce = new ControllerException("607", "Something went wrong in the controller layer");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/products")
	public ResponseEntity<?> getProducts() {
		try {
			List<SkuTable> listOfProducts = skutableserviceinterface.getProducts();
			return new ResponseEntity<List<SkuTable>>(listOfProducts, HttpStatus.OK);
		} catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			ControllerException ce = new ControllerException("608", "Something went wrong in the controller layer");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/product/{id}")
	public ResponseEntity<?> getProductById(@PathVariable("id") int id) {
		LOGGER.info("Finding product by skuid " + id);
		try {
			SkuTable product = skutableserviceinterface.getProductById(id);
			return new ResponseEntity<SkuTable>(product, HttpStatus.OK);
		} catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			ControllerException ce = new ControllerException("608", "Something went wrong in the controller layer");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/search")
	public ResponseEntity<?> searchProduct(@RequestParam("query") String query) {

		List<SkuTable> value = skutableserviceinterface.searchProduct(query);
		return ResponseEntity.ok(value);

	}
}

