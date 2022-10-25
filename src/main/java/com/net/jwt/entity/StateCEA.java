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
//@Table(name = "ref_state_CEA")
public class StateCEA extends BaseEntity {

    @JoinColumn(name = "ref_state_CEA_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private StateCEA parent;

    @Column(name = "code")
    private String code;

    @Column(name = "section")
    private String section;

    @Column(name = "name")
    private String name;
}
