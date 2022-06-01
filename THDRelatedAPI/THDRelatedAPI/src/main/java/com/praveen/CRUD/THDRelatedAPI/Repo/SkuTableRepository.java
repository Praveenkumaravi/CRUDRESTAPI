package com.praveen.CRUD.THDRelatedAPI.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.praveen.CRUD.THDRelatedAPI.Entity.SkuTable;

@Repository
public interface SkuTableRepository extends JpaRepository<SkuTable, Integer> {
	@Query(value = "SELECT * FROM SKU_Table s WHERE " + "s.SKU_NAME LIKE CONCAT('%',:query,'%')"
			+ "Or s.SKU_COST LIKE CONCAT('%',:query,'%')", nativeQuery = true)
	List<SkuTable> searchProduct(String query);
}
