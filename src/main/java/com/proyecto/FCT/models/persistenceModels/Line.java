package com.proyecto.FCT.models.persistenceModels;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name="lineas")
public class Line {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="line_id")
    private long line_id;
    @ManyToOne(cascade = CascadeType.ALL, optional = true,fetch = FetchType.LAZY)
    @JoinColumn(name="document_id", referencedColumnName = "id")
    @JsonIgnore
    private Document document;
    @Column(name="lineNumber")
    private String lineNumber;
    @Column(name="unitGross")
    private String unitGross;
    @Column(name="totalGross")
    private String totalGross;
    @Column(name="unitInputPrice")
    private String unitInputPrice;
    @Column(name="unitOriginalPrice")
    private String unitOriginalPrice;
    @Column(name="unitMasterPrice")
    private String unitMasterPrice;
    @Column(name="code")
    private String code;
    @Column(name="idProductType")
    private String idProductType;
    @Column(name="model")
    private String model;
    @Column(name="quality")
    private String quality;
    @Column(name="color")
    private String color;
    @Column(name="size")
    private String size;

    //Hacen falta dos constructores con parámetros. Uno con el id y otro si él
    public Line(long line_id, Document document, String lineNumber, String unitGross, String totalGross, String unitInputPrice, String unitOriginalPrice, String unitMasterPrice, String code, String idProductType, String model, String quality, String color, String size) {
        this.line_id = line_id;
        this.document = document;
        this.lineNumber = lineNumber;
        this.unitGross = unitGross;
        this.totalGross = totalGross;
        this.unitInputPrice = unitInputPrice;
        this.unitOriginalPrice = unitOriginalPrice;
        this.unitMasterPrice = unitMasterPrice;
        this.code = code;
        this.idProductType = idProductType;
        this.model = model;
        this.quality = quality;
        this.color = color;
        this.size = size;
    }

    public Line(Document document, String lineNumber, String unitGross, String totalGross, String unitInputPrice, String unitOriginalPrice, String unitMasterPrice, String code, String idProductType, String model, String quality, String color, String size) {
        this.document= document;
        this.lineNumber = lineNumber;
        this.unitGross = unitGross;
        this.totalGross = totalGross;
        this.unitInputPrice = unitInputPrice;
        this.unitOriginalPrice = unitOriginalPrice;
        this.unitMasterPrice = unitMasterPrice;
        this.code = code;
        this.idProductType = idProductType;
        this.model = model;
        this.quality = quality;
        this.color = color;
        this.size = size;
    }

    public Line() {
    }

    public long getLineId() {
        return line_id;
    }

    public void setLineId(long line_id) {
        this.line_id = line_id;
    }

    public Document getDocument() {
        return document;
    }
    public long getDocumentId(){ return document.getId();}

    public void setDocument(Document document) {
        this.document = document;
    }

    public String getLineNumber() {
        return lineNumber;
    }



    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getUnitGross() {
        return unitGross;
    }

    public void setUnitGross(String unitGross) {
        this.unitGross = unitGross;
    }

    public String getTotalGross() {
        return totalGross;
    }

    public void setTotalGross(String totalGross) {
        this.totalGross = totalGross;
    }

    public String getUnitInputPrice() {
        return unitInputPrice;
    }

    public void setUnitInputPrice(String unitInputPrice) {
        this.unitInputPrice = unitInputPrice;
    }

    public String getUnitOriginalPrice() {
        return unitOriginalPrice;
    }

    public void setUnitOriginalPrice(String unitOriginalPrice) {
        this.unitOriginalPrice = unitOriginalPrice;
    }

    public String getUnitMasterPrice() {
        return unitMasterPrice;
    }

    public void setUnitMasterPrice(String unitMasterPrice) {
        this.unitMasterPrice = unitMasterPrice;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIdProductType() {
        return idProductType;
    }

    public void setIdProductType(String idProductType) {
        this.idProductType = idProductType;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

}

