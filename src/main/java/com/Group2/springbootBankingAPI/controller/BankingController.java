package com.Group2.springbootBankingAPI.controller;

import com.Group2.springbootBankingAPI.dto.KycdetailsDto;
import com.Group2.springbootBankingAPI.dto.MasteruserDto;
import com.Group2.springbootBankingAPI.entity.Kycdetails;
import com.Group2.springbootBankingAPI.entity.Masteruser;
import com.Group2.springbootBankingAPI.service.BankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class BankingController {

    @Autowired
    BankingService bankingService;



    @PostMapping("/createUser")
    public MasteruserDto BankingSave(@RequestBody MasteruserDto masteruser)
    {
        return bankingService.SaveUser(masteruser);
    }

    @PostMapping("/{userId}/createKyc")
    public ResponseEntity<KycdetailsDto> createKyc(@RequestBody KycdetailsDto kycdetailsDto, @PathVariable Integer userId)
    {
        KycdetailsDto createdKyc =  this.bankingService.SaveKyc(kycdetailsDto,userId);
        return new ResponseEntity<KycdetailsDto>(createdKyc, HttpStatus.CREATED);
    }

    @GetMapping ("/getUsers")
    public List<MasteruserDto> getAllUsers()
    {
         return this.bankingService.getAllUser();

    }

    @GetMapping ("/getKycdetails")
    public List<KycdetailsDto> getAllKycdetails()
    {
        return this.bankingService.getAllKycdetails();

    }
}

