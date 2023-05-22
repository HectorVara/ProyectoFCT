package com.proyecto.FCT.repositories;

import com.proyecto.FCT.models.persistenceModels.Document;
import com.proyecto.FCT.models.queryModels.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {

    @Query(value ="SELECT t.id as id,description as description, count(*) as total " +
            "FROM documents d,document_type t WHERE t.id=document_type_id AND id_store=?1 AND SUBSTRING(d.DATE,1,10)=?2" +
            " GROUP BY id,description" ,nativeQuery = true)
    List<ISales> sales(String idStore, String date);

    @Query(value="SELECT m.id as id,description as description, CAST(SUM(CAST(UNIT_AMOUNT AS DECIMAL(20,2))*sign)AS DECIMAL(20,2)) AS total FROM payments p, payment_media m, documents d" +
            " WHERE payment_media_id=m.id AND d.id_store=?1 AND SUBSTRING(D.DATE,1,10)=?2 AND p.document_id = d.id AND d.document_type_id > 4 GROUP BY  id,description",nativeQuery = true)
    List<IPayments> payments(String idStore, String date);
    @Query(value="select p.id as id,p.description as description, CAST(sum(cast(total_gross as decimal(20,2))*sign*sign_void)AS DECIMAL(20,2)) as total " +
            "FROM lineas l, product_type p, documents d where l.product_type_id=p.id and d.id_store=?1 AND SUBSTRING(d.DATE,1,10)=?2 " +
            "and l.document_id=d.id GROUP by id,description",nativeQuery = true)
    List<ICharges> charges(String idStore, String date);
    @Query(value="SELECT sum(cast(total_gross as decimal(20,2))*sign*sign_void) from lineas, documents d where id_store=?1 AND SUBSTRING(d.DATE,1,10)=?2 and d.id = document_id",nativeQuery = true)
    double totalCharges(String idStore, String date);
    @Query(value = "SELECT CAST(sum(cast(unit_amount as decimal(20,2))*sign)AS DECIMAL(20,2)) from payments p, documents d where id_store=?1 AND SUBSTRING(d.DATE,1,10)=?2 and d.id = document_id and d.document_type_id > 4", nativeQuery = true)
    double totalPayments(String idStore, String date);
    @Query(value = "SELECT * FROM DOCUMENTS WHERE ID_STORE=?1 AND SUBSTRING(DATE,1,10)=?2",nativeQuery = true)
    List<Document> getIdStoreAndDate(String idStore, String date);
    @Query(value="select p.id as id,p.description as description, CAST(sum(cast(total_gross as decimal(20,2))*sign*sign_void)AS DECIMAL(20,2)) as total " +
            "FROM lineas l, product_type p, documents d where l.product_type_id=p.id and d.id_store=?1 AND SUBSTRING(d.DATE,1,10)=?2 " +
            "and l.document_id=d.id GROUP by id,description",nativeQuery = true)
    List<ICobros> cobros(String idStore, String date);
    @Query(value="SELECT sum(cast(total_gross as decimal(20,2))*sign*sign_void) from lineas, documents d where id_store=?1 AND SUBSTRING(d.DATE,1,10)=?2 and d.id = document_id",nativeQuery = true)
    double totalCobros(String idStore, String date);


}
