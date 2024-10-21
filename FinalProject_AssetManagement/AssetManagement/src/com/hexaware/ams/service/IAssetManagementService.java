package com.hexaware.ams.service;

import java.sql.Date;
import java.util.List;

import com.hexaware.ams.entity.Assets;
import com.hexaware.ams.entity.MaintenanceRecords;
import com.hexaware.ams.entity.Reservations;
import com.hexaware.ams.exception.AssetNotFoundException;
import com.hexaware.ams.exception.AssetNotMaintainException;

public interface IAssetManagementService {
	boolean addAsset(Assets asset);
	boolean updateAsset(Assets asset);
	boolean deleteAsset(int assetId) throws AssetNotFoundException;
	boolean allocateAsset(int assetId, int employeeId, Date 
			allocationDate) ;
	boolean deallocateAsset(int assetId, int employeeId, Date 
			returnDate);
	boolean performMaintenance(int assetId, Date maintenanceDate, 
			String description, double cost) throws AssetNotFoundException;
	boolean reserveAsset(int assetId, int employeeId, Date 
			reservationDate, Date startDate, Date endDate,String status);
	boolean withdrawReservation(int reservationId);
	boolean maintenanceDate(MaintenanceRecords assetId) throws AssetNotMaintainException;


}
