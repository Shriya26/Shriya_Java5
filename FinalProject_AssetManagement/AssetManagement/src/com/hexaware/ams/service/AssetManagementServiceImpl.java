package com.hexaware.ams.service;
/*
 * @Author:Ganga & Shriya
 * Desp: Service implementation
 * Date: 21st Oct 24
 */

import java.sql.Date;
import java.util.List;
import com.hexaware.ams.dao.AssetMangementDaoImpl;
import com.hexaware.ams.dao.IAssetManagementDao;
import com.hexaware.ams.entity.AssetAllocation;
import com.hexaware.ams.entity.Assets;
import com.hexaware.ams.entity.MaintenanceRecords;
import com.hexaware.ams.entity.Reservations;
import com.hexaware.ams.exception.AssetNotFoundException;
import com.hexaware.ams.exception.AssetNotMaintainException;

public class AssetManagementServiceImpl implements IAssetManagementService{
	private IAssetManagementDao dao;
	public AssetManagementServiceImpl()
	{
		dao=new AssetMangementDaoImpl();
		
	}

	@Override
	public boolean addAsset(Assets asset) {
		return dao.addAsset(asset);	
	}

	@Override
	public boolean updateAsset(Assets asset) {
		
		return dao.updateAsset(asset);
	}

	@Override
	public boolean deleteAsset(int assetId) {
		boolean delete =dao.deleteAsset(assetId);
		if(!delete) {

			try {

				throw new AssetNotFoundException();

			} catch (Exception e) {

				System.err.println("Assets Not Found Eid " + assetId);
			}

		}
		return delete;
	}

	@Override
	public boolean allocateAsset(int assetId, int employeeId, Date allocationDate) {
		return dao.allocateAsset(assetId, employeeId, allocationDate);
	}

	@Override
	public boolean deallocateAsset(int assetId, int employeeId, Date returnDate) {
		return dao.deallocateAsset(assetId, employeeId, returnDate);
	}

	@Override
	public boolean performMaintenance(int assetId, Date maintenanceDate, String description, double cost) throws AssetNotFoundException{
		return dao.performMaintenance(assetId,maintenanceDate,description,cost );
	}
	
	
	@Override
	public boolean withdrawReservation(int reservationId) {
		return dao.withdrawReservation(reservationId);
	}
	
public static boolean vaildateAsset(Assets  asset) {
		
		
		boolean flag=false;
		
		if(asset.getAssetId()>0 && asset.getName().length()>2 && asset.getType().length()>2 && asset.getSerialNumber()>1000 && asset.getOwnerId()>100) {
			
			flag=true;
		}
		return flag;
	}

public static boolean validateAssetDelete(Assets  asset) {
boolean flag=false;

if(asset.getAssetId()>0 ) {
	
	flag=true;
}
return flag;
}

public static boolean vaildateAssetAllocation(AssetAllocation allocate) {
boolean flag=false;

if(allocate.getAssetId()>0 && allocate.getEmployeeId()>100 ) {
	flag=true;
	
}
return flag;
}

public static boolean vaildatewithdrawReservation(Reservations reservations) {
boolean flag=false;

if(reservations.getReservationId()>20000 ) {
	flag=true;
	
}
return flag;
}

public static boolean vaildateRecords(MaintenanceRecords records) {
	
	
	boolean flag=false;
	
	if(records.getAssetId()>0 && records.getDescription().length()>2 ) {
		
		flag=true;
	}
	return flag;
}

@Override
public boolean reserveAsset(int assetId, int employeeId, Date reservationDate, Date startDate, Date endDate,
		String status) {
	return dao.reserveAsset(assetId, employeeId, reservationDate, startDate, endDate, status);
}

public static boolean vaildateReservation(Reservations reservation) {
	
	
	boolean flag=false;
	
	if(reservation.getAssetId()>0 && reservation.getEmployeeId()>100  ) {
		
		flag=true;
	}
	return flag;
}

@Override
public boolean maintenanceDate(MaintenanceRecords assetId) throws AssetNotMaintainException {
	boolean records=dao.maintenanceDate(assetId);
	if (!dao.maintenanceDate(assetId)) {
        throw new AssetNotMaintainException("The asset has not been maintained in the last 2 years. " + assetId); 
    }

    return records;
}


}
