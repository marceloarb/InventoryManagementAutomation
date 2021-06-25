package org.tgs_ct.probies.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.tgs_ct.probies.service.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

}
