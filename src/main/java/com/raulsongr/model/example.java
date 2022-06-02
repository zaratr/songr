package com.raulsongr.model;
/*

1. add @entity to our class
2. add @id and @generatedValue annotations
 */
import javax.persistence.*;
@Entity//in the back this will be implementing the database
public class example {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    //IF you need longer than 255 charachters, use thes 2 annothations
    //@Lob
    //@Type(type=

}

/*
*/