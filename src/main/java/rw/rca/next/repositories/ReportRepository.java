package rw.rca.next.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.rca.next.models.Report;

public interface ReportRepository extends JpaRepository<Report, Long> {

}
