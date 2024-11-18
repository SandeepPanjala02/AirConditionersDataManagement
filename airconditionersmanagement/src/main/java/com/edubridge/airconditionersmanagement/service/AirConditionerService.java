package com.edubridge.airconditionersmanagement.service;

import java.util.List;

import com.edubridge.airconditionersmanagement.dao.AirConditionerDao;
import com.edubridge.airconditionersmanagement.model.AirConditioner;

public class AirConditionerService implements AirConditionerServiceI {
	private AirConditionerDao dao;
	
	public AirConditionerService() {
		dao = new AirConditionerDao();
	}
	

	@Override
	public void addairconditioner(AirConditioner airconditioner) {
		dao.addairconditioner(airconditioner);
	}

	@Override
	public List<AirConditioner> getAllAirConditioners() {
		
		return dao.getAllAirConditioners();
	}

	@Override
	public AirConditioner getAirConditionerById(Integer id) {
	
		return dao.getAirConditionerById(id);
	}

	@Override
	public void UpdateAirConditioner(AirConditioner airconditioner) {
		dao.UpdateAirConditioner(airconditioner);
		
	}

	@Override
	public void deleteAirConditioner(Integer id) {
		dao.deleteAirConditioner(id);
		
	}

	@Override
	public void deleteAllAirConditioners() {
		dao.deleteAllAirConditioners();
		
	}

}
