package com.Group2.springbootBankingAPI.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="Kycdetails")
@Data
public class Kycdetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int kyc_id;
    private String pan_no;
    private String aadhar_no;
    @Column(nullable = true, length = 64)
    private String cus_photo;


    @OneToOne
    private  Masteruser masteruser;



}
