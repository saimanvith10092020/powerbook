package com.edubridge.powerbook.dao;

import java.util.List;

import com.edubridge.powerbook.model.Powerbank;

public interface PowerbankDao {
	
	int addPowerbank(Powerbank pb);
	List<Powerbank> getAllPowerbanks();
	Powerbank getPowerbank(String name);
	int updatePowerbank(Powerbank pb);
	int deletePowerbank(String name);
	void deleteAllPowerbanks();
	
}
