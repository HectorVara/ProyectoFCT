package com.proyecto.FCT.repositories;

import com.proyecto.FCT.models.persistenceModels.Document;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
}
