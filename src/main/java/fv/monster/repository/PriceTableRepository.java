package fv.monster.repository;

import fv.monster.model.PriceTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceTableRepository extends JpaRepository<PriceTable, Long> {

}
