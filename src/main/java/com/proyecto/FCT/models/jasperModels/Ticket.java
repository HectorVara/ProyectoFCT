package com.proyecto.FCT.models.jasperModels;

import lombok.Getter;
import lombok.Setter;

public class Ticket {

    @Getter @Setter String header;
    @Getter @Setter String body;
    @Getter @Setter String col_footer;
    @Getter @Setter String footer;
    @Getter @Setter String summary;

    public Ticket() {
    }


    public Ticket(String header, String body, String col_footer, String footer, String summary) {
        this.header = header;
        this.body = body;
        this.col_footer = col_footer;
        this.footer = footer;
        this.summary = summary;
    }
}
