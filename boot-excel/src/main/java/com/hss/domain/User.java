package com.hss.domain;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class User{

    private Long id;

    private String name;

    private Date birthday;
}
