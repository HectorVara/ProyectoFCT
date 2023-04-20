package com.proyecto.FCT.models.parseModels;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="DocumentLine")
@XmlAccessorType(XmlAccessType.FIELD)
public class Line {
    @XmlElement(name = "LineNumber")
    private String lineNumber;
    @XmlElement(name = "UnitGross")
    private String unitGross;
    @XmlElement(name = "TotalGross")
    private String totalGross;
    @XmlElement(name = "UnitInputPrice")
    private String unitInputPrice;
    @XmlElement(name = "UnitOriginalPrice")
    private String unitOriginalPrice;
    @XmlElement(name = "UnitMasterPrice")
    private String unitMasterPrice;
    @XmlElement(name = "Code")
    private String code;
    @XmlElement(name = "IdProductType")
    private String idProductType;
    @XmlElement(name = "Model")
    private String model;
    @XmlElement(name = "Quality")
    private String quality;
    @XmlElement(name = "Color")
    private String color;
    @XmlElement(name = "Size")
    private String size;



    public Line() {
    }

    public Line(String lineNumber, String unitGross, String totalGross, String unitInputPrice, String unitOriginalPrice, String unitMasterPrice, String code, String idProductType, String model, String quality, String color, String size) {

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
