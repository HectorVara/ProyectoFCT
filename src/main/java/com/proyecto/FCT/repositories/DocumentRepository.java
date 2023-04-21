package com.proyecto.FCT.repositories;

import com.proyecto.FCT.models.persistenceModels.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}
