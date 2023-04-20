package com.proyecto.FCT.models.parseModels;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name="ListDocumentLine")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListDocumentLine  {
    @XmlElement(name="DocumentLine")
    private List<Line> lines;

    public ListDocumentLine(List<Line> lines) {
        this.lines= lines;
    }

    public ListDocumentLine() {
    }

    public List<Line> getLines() {
        return lines;
    }

    public void setLines(List<Line> lines) {
        this.lines= lines;
    }
}
