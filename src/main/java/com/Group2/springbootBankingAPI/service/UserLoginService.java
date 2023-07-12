package com.Group2.springbootBankingAPI.service;

import com.Group2.springbootBankingAPI.entity.Masteruser;
import com.Group2.springbootBankingAPI.entity.UserLogin;
import com.Group2.springbootBankingAPI.repository.BankingRepo;
import com.Group2.springbootBankingAPI.repository.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service

public class UserLoginService
{
    @Autowired
    UserLoginRepository userLoginRepository;

    @Autowired
    BankingRepo bankingRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String  LoginRegistration(UserLogin userLogin){

       // Masteruser masteruser=this.bankingRepo.findById(userId).orElseThrow(
           //     () -> new RuntimeException("User not found"));

       // userLogin.setMasteruser(masteruser);
        userLogin.setPassword(passwordEncoder.encode(userLogin.getPassword()));
        UserLogin userLogin1 =  userLoginRepository.save(userLogin);
        return "User Registered Successfully";
    }
}
