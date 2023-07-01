package com.Group2.springbootBankingAPI.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "master_user")
@Data
public class Masteruser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    private String first_name;
    private String last_name;
    private String dob;
//    @Column(nullable = false, length = 100)
    private String permanent_add;
//    @Column(nullable = true, length = 100)
    private String residential_add;
    private String role;
//    private String city;
//    private String state;
//    private int pin_code;
//    private String ph_no;
//    private String email;
//    private String password;
//    private boolean user_stat;
//    private boolean kyc_stat;

    // foreign key coding
//    One to one mapping user ID
 @OneToOne(mappedBy = "masteruser",cascade = CascadeType.ALL)
   private Kycdetails kycdetails;

   // @OneToMany (mappedBy="post",cascade=CascadeType.ALL)

   // private List<Comment> comments = new ArrayList<>();


}
