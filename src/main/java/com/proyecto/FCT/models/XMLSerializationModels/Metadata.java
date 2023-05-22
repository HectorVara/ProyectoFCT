package com.proyecto.FCT.models.XMLSerializationModels;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Metadata")
@XmlAccessorType(XmlAccessType.FIELD)
public class Metadata {
    @XmlElement(name="IdStore")
    private String IdStore;
    @XmlElement(name = "SessionDate")
    private String SessionDate;

    public String getIdStore() {
        return IdStore;
    }

    public void setIdStore(String idStore) {
        IdStore = idStore;
    }

    public String getSessionDate() {
        return SessionDate;
    }

    public void setSessionDate(String sessionDate) {
        SessionDate = sessionDate;
    }

    public Metadata(String idStore, String sessionDate) {
        IdStore = idStore;
        SessionDate = sessionDate;
    }
}
