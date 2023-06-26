package rw.rca.next.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.rca.next.models.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByCode(String code);
}
