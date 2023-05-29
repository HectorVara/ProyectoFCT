package com.proyecto.FCT.models.queryModels;

public interface ICharges {
    //Estas interfaces se ceran para almacenar los resultados de consultas SQL. Deberían poder guardarse
    //en objetos POJO, pero a mi solo me funcionaba así
    Integer getId();
    String getDescription();
    Double getTotal();
}
