package com.Group2.springbootBankingAPI.controller;

import com.Group2.springbootBankingAPI.dto.AuthRequest;
import com.Group2.springbootBankingAPI.dto.KycdetailsDto;
import com.Group2.springbootBankingAPI.dto.MasteruserDto;

import com.Group2.springbootBankingAPI.entity.UserLogin;
import com.Group2.springbootBankingAPI.service.BankingService;
import com.Group2.springbootBankingAPI.service.JwtService;
import com.Group2.springbootBankingAPI.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class BankingController {

    @Autowired
    BankingService bankingService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    UserLoginService userLoginService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/userRegistration")
    public String UserRegistration(@RequestBody UserLogin userLogin){
        return this.userLoginService.LoginRegistration(userLogin);

    }



    @PostMapping("/createUser/{userLoginId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public MasteruserDto BankingSave(@RequestBody MasteruserDto masteruser,@PathVariable Long userLoginId)
    {
        return bankingService.SaveUser(masteruser,userLoginId);
    }

    @PostMapping("/{userId}/createKyc")
    public ResponseEntity<KycdetailsDto> createKyc(@RequestBody KycdetailsDto kycdetailsDto, @PathVariable Integer userId)
    {
        KycdetailsDto createdKyc =  this.bankingService.SaveKyc(kycdetailsDto,userId);
        return new ResponseEntity<KycdetailsDto>(createdKyc, HttpStatus.CREATED);
    }

    @GetMapping ("/getUsers")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<MasteruserDto> getAllUsers()
    {
         return this.bankingService.getAllUser();

    }

    @GetMapping ("/{userId}")
    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
    public MasteruserDto getUserById(@PathVariable Integer userId)
    {
        return this.bankingService.getUserId(userId);

    }

    @GetMapping ("/getKycdetails")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<KycdetailsDto> getAllKycdetails()
    {
        return this.bankingService.getAllKycdetails();

    }

    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest)
    {
        Authentication authentication = authenticationManager.authenticate
                (new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated())
        {
            return jwtService.generateToken(authRequest.getUsername());
        } else
        {
            throw new UsernameNotFoundException("invalid user request !");
        }

    }
}

