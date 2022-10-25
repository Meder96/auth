package com.net.jwt.entity;


import com.net.jwt.enums.LegalPersonType;
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
//@Table(name = "legal_person")
public class LegalPerson extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "full_address")
    private String fullAddress;

    @Column(name = "inn")
    private String inn;

    @JoinColumn(name = "sti_organization_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Dictionary stiOrganization;

    @Column(name = "social_fund_number")
    private String socialFundNumber;

    @Column(name = "is_resident")
    private Boolean isResident;

    @Column(name = "okpo")
    private String okpo;

    @JoinColumn(name = "legal_form_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Dictionary legalFormClassification;

    @Column(name = "category")
    private String category;

    @JoinColumn(name = "ref_state_cea_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private StateCEA stateCEA;

    @Column(name = "is_registered")
    private Boolean isRegistered = false;

    @JoinColumn(name = "creator_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private LegalPerson creator;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private LegalPerson parent;

    @Column(name = "type")
    private LegalPersonType type;

    @Column(name = "is_blocked")
    private Boolean isBlocked = false;

    @Column(name = "block_description")
    private String blockDescription;
}
