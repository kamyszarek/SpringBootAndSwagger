package pl.arkadiusz.mySpringProject1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.arkadiusz.mySpringProject1.model.Address;
import pl.arkadiusz.mySpringProject1.model.Facture;

import java.util.List;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {

    List<Facture> findAllByUserIdIn(List<Long> ids);
}
