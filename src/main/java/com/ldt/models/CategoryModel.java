package com.ldt.models;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CategoryModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private int categoryid;
    private String categoryname;
    private String images;
    private int status;
}
