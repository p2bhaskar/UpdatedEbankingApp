package com.Group2.springbootBankingAPI.dto;

import com.Group2.springbootBankingAPI.entity.Kycdetails;
import com.Group2.springbootBankingAPI.entity.UserLogin;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class MasteruserDto
{
    private int user_id;
    private String first_name;
    private String last_name;
    private String dob;
    private String permanent_add;
    private String residential_add;
  //  private String role;
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

    //private KycdetailsDto kycdetailsDto;

    private UserLogin userLogin;

}
