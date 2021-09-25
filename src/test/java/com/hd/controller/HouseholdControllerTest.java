package com.hd.controller;

import com.hd.model.Household;
import com.hd.service.HouseHoldService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class HouseholdControllerTest {

    @InjectMocks
    private HouseholdController controller;

    @Mock
    private HouseHoldService service;

    private Household house;
    @Before
    public void setup(){
        house = new Household();
        Mockito.when(service.get()).thenReturn(Collections.singletonList(house));
        Mockito.when(service.save(house)).thenReturn(house);
    }

    @Test
    public void testgetAllHouseholds(){
        ResponseEntity<List<Household>> allHouseholds = controller.getAllHouseholds();
        assertEquals(allHouseholds.getStatusCode(), HttpStatus.OK);
        assertEquals(allHouseholds.getBody(), Collections.singletonList(house));
        Mockito.verify(service).get();
    }

    @Test
    public void testCreateNewHousehold(){
        ResponseEntity<List<Household>> allHouseholds = controller.getAllHouseholds();
        assertEquals(allHouseholds.getStatusCode(), HttpStatus.OK);
        assertEquals(allHouseholds.getBody(), house);
        Mockito.verify(service).save(house);
    }


}