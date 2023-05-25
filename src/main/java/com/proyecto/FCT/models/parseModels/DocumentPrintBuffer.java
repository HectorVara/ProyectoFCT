package com.proyecto.FCT.models.parseModels;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="DocumentPrintBuffer")
@XmlAccessorType(XmlAccessType.FIELD)
public class DocumentPrintBuffer {
    @XmlElement(name = "IdPrintBuffer")
    private String idPrintBuffer;
    @XmlElement(name="RReport")
    private String report;
    @XmlElement(name = "Extras")
    private String copies;
    @XmlElement(name="Station")
    private String station;
    @XmlElement(name="Data")
    private String data;

    public DocumentPrintBuffer(String idPrintBuffer, String report, String copies, String station, String data) {
        this.idPrintBuffer = idPrintBuffer;
        this.report = report;
        this.copies = copies;
        this.station = station;
        this.data = data;
    }

    public DocumentPrintBuffer(String data) {
        this.data = data;
    }

    public DocumentPrintBuffer() {
    }

    public String getIdPrintBuffer() {
        return idPrintBuffer;
    }

    public void setIdPrintBuffer(String idPrintBuffer) {
        this.idPrintBuffer = idPrintBuffer;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getCopies() {
        return copies;
    }

    public void setCopies(String copies) {
        this.copies = copies;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
