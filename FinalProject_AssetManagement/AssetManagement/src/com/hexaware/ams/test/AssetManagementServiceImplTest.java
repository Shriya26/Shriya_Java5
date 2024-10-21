package com.hexaware.ams.test;
/*
 * @Author:Ganga & Shriya
 * Desp: Testing
 * Date: 21st Oct 24
 */

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.hexaware.ams.entity.Assets;
import com.hexaware.ams.exception.AssetNotFoundException;
import com.hexaware.ams.service.AssetManagementServiceImpl;
import com.hexaware.ams.service.IAssetManagementService;


class AssetManagementServiceImplTest {
	static IAssetManagementService service;
	@BeforeAll
	public static void beforeAll() {
		service=new AssetManagementServiceImpl();
	}

	@Test
	void testAddAsset() {
		Assets asset =new Assets(16,"chair","furniture",1017,null,"office","inuse",103);
				boolean count=service.addAsset(asset);
         assertTrue(count);//"The asset should be added successfully");
         System.out.println("Asset added successfully");

	}
	@Test
	void testPerformMaintenance()
	{
		Date date=Date.valueOf("2024-02-28");
		boolean count=service.performMaintenance(3,date, "DeskRepair",3000.0);
		
		assertTrue(count,"The maintenanceRecords should be added successfully");
		System.out.println("maintenanceRecords added successfully");
	}
	
	@Test
	void testReserveAsset()
	{
		Date reservationDate=Date.valueOf("2024-02-28");
		Date startDate=Date.valueOf("2024-06-25");
		Date endDate=Date.valueOf("2024-06-27");
		
		
		boolean count=service.reserveAsset(2, 101, reservationDate, startDate, endDate, "approved");
		
		assertTrue(count,"The reservation should be added successfully");
		System.out.println("reservation added successfully");
		
	}
	
	@Test
	void testDeleteAsset_AssetNotFound() {
	int assetId = 999;  
    boolean exceptionThrown = false;
    try {
       
        service.deleteAsset(assetId);
    } catch (AssetNotFoundException e) {
        exceptionThrown = true;
        
        System.err.println("Exception caught: " + e.getMessage());
        assertEquals("Invalid Asset ID: " + assetId, e.getMessage());
    }
    assertTrue(exceptionThrown, "AssetNotFoundException should be thrown for non-existent asset ID");
    

	}

}
