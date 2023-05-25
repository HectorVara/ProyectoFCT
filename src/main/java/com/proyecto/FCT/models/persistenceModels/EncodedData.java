package com.proyecto.FCT.models.persistenceModels;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name="EncodedData")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class EncodedData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "encoded_data_id")
    private long encoded_data_id;
    @ManyToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "document_id")
    @JsonIgnore
    private Document document;
    @Column(name = "data", length = 100000)
    private String data;

    public EncodedData(long encoded_data_id, Document document, String data) {
        this.encoded_data_id = encoded_data_id;
        this.document = document;
        this.data = data;
    }

    public EncodedData() {
    }

    public long getEncoded_data_id() {
        return encoded_data_id;
    }

    public void setEncoded_data_id(long encoded_data_id) {
        this.encoded_data_id = encoded_data_id;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
