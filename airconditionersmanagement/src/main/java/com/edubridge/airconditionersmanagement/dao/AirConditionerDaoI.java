package com.edubridge.airconditionersmanagement.dao;

import java.util.List;


import com.edubridge.airconditionersmanagement.model.AirConditioner;

public interface AirConditionerDaoI {
	void addairconditioner(AirConditioner airconditioner);
    List<AirConditioner> getAllAirConditioners();
    AirConditioner getAirConditionerById(Integer id);
    void UpdateAirConditioner(AirConditioner airconditioner);
    void deleteAirConditioner(Integer id);
    void deleteAllAirConditioners();
    
	

}
