package com.proyecto.FCT.repositories;
import com.proyecto.FCT.models.persistenceModels.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {
    @Query(value="SELECT * FROM PAYMENTS P WHERE P.DOCUMENT_ID=?1",nativeQuery = true)
    List<Payment> findByDocument(Long id);
}
