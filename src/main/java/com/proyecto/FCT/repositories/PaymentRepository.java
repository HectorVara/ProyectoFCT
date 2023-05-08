package com.proyecto.FCT.repositories;
import com.proyecto.FCT.models.persistenceModels.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {

}
