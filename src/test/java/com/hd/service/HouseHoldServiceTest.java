package com.hd.service;

import com.hd.model.Household;
import com.hd.repository.HouseholdRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class HouseHoldServiceTest {

    @InjectMocks
    HouseHoldService service;

    @Mock
    HouseholdRepository repo;

    Household house;

    private List<Household> homes;
    @Before
    public void setUp(){
        house = new Household();
        homes = Collections.singletonList(house);
        Mockito.when(repo.findAll()).thenReturn(homes);
    }
    @Test
    public void test_calls_findALl(){
        List<Household> households = service.get();
        assertEquals(households, homes);
        verify(repo).findAll();
    }





}