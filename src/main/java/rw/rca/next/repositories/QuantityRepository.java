package rw.rca.next.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.rca.next.models.Product;
import rw.rca.next.models.Quantity;

public interface QuantityRepository extends JpaRepository<Quantity, Long> {
    Quantity getQuantityByProduct(Product product);
}
