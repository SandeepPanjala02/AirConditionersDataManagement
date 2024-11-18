package com.edubridge.airconditionersmanagement.service;

import java.util.List;

import com.edubridge.airconditionersmanagement.model.AirConditioner;

public interface AirConditionerServiceI {
	void addairconditioner(AirConditioner airconditioner);
    List<AirConditioner> getAllAirConditioners();
    AirConditioner getAirConditionerById(Integer id);
    void UpdateAirConditioner(AirConditioner airconditioner);
    void deleteAirConditioner(Integer id);
    void deleteAllAirConditioners();
    
	

}
