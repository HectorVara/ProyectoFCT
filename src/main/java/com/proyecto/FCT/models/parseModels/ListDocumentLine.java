package com.proyecto.FCT.models.parseModels;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
