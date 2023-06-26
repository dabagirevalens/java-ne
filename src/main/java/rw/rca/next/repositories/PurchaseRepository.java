package rw.rca.next.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.rca.next.models.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
