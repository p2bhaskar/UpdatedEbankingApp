package com.Group2.springbootBankingAPI.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "User_Login")
public class UserLogin
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String role;
    @OneToOne(mappedBy ="userLogin", cascade=CascadeType.ALL)

    @JsonIgnore
    private  Masteruser masteruser;
}
