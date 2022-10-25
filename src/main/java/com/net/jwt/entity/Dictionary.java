package com.net.jwt.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@Entity
//@Table(name = "dict")
public class Dictionary extends BaseEntity {

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "active")
    private Boolean active;

    @JoinColumn(name = "type")
    @ManyToOne(fetch = FetchType.LAZY)
    private DictionaryType type;

    @Column(name = "parent")
    private Integer parent;

    @Column(name = "old_id")
    private Integer oldId;

}
