package com.hd.service;

import com.hd.model.Household;
import com.hd.repository.HouseholdRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class HouseHoldService {

    private final HouseholdRepository householdRepository;

    public List<Household> get(){
        return householdRepository.findAll();
    }

    public Household save(Household household){
        log.info("saving household {}", household);
        return householdRepository.save(household);
    }

}
