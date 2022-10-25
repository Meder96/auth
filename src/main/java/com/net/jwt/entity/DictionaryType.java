package com.net.jwt.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@Entity
//@Table(name = "dict_type")
public class DictionaryType extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "short_name")
    private String shortName;
}
