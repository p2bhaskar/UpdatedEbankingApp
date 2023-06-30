package com.Group2.springbootBankingAPI.repository;

import com.Group2.springbootBankingAPI.entity.Masteruser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankingRepo extends JpaRepository<Masteruser, Integer> {
}


