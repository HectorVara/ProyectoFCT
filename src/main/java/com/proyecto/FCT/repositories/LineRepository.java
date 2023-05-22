package com.proyecto.FCT.repositories;
import com.proyecto.FCT.models.persistenceModels.Line;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LineRepository extends JpaRepository<Line,Long> {
    @Query(value="SELECT * FROM LINEAS L WHERE L.DOCUMENT_ID=?1",nativeQuery = true)
    List<Line> findByDocument(Long id);

}
