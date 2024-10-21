package com.hexaware.ams.ui;
/*
 * @Author:Ganga & Shriya
 * Desp: UserInterface implementation
 * Date: 21st Oct 24
 */
import com.hexaware.ams.service.IAssetManagementService;

import com.hexaware.ams.entity.AssetAllocation;
import com.hexaware.ams.entity.Assets;
import com.hexaware.ams.entity.MaintenanceRecords;
import com.hexaware.ams.entity.Reservations;
import com.hexaware.ams.exception.AssetNotFoundException;
import com.hexaware.ams.exception.AssetNotMaintainException;
import com.hexaware.ams.service.AssetManagementServiceImpl;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class AssetManagementApp {
	static Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) {
		boolean flag=true;
		IAssetManagementService service = new AssetManagementServiceImpl();
		while(flag) {
			System.out.println("Welcome to Digital Asset Management System");
			System.out.println("1.Add Asset:");
			System.out.println("2.Update Asset:");
			System.out.println("3.Delete Asset:");
			System.out.println("4.Allocate Asset:");
			System.out.println("5.Deallocate Asset:");
			System.out.println("6.Perform maintenance Asset:");
			System.out.println("7.Reserve Asset:");
			System.out.println("8.Withdraw Reservation:");
			System.out.println("9.Maintenance Date");
			System.out.println("0.Exit");
			
			int choice=scanner.nextInt();
			
			switch(choice) {
			case 1:
                      Assets asset=readAssetData();
				boolean isValid = AssetManagementServiceImpl.vaildateAsset(asset);

				if (isValid) {
					boolean success = service.addAsset(asset);
					int count = success ? 1 : 0;
					if (count > 0) {

						System.out.println("Asset added successfully..");
					}
					else {
						System.err.println("Asset Adding  Failed...");
					}
				} else {
					System.err.println("Invalid Employee Data");
				}
				break;
			case 2:
				Assets assetUpdate=updateAssetData();
					boolean success2 = service.updateAsset(assetUpdate);
					int count1 = success2 ? 1 : 0;
					if (count1 > 0) {

						System.out.println("update successfully..");	
					}
					else {
						System.err.println("update  Failed...");
					}

				
				break;
			case 3:
				Assets assetDelete=deleteAssetData();
				boolean isValid2 = AssetManagementServiceImpl.validateAssetDelete(assetDelete);
				if (isValid2) {
					boolean success = service.deleteAsset(assetDelete.getAssetId());
					
					if (success) {
						System.out.println("deleted successfully..");
					}
					else {
						System.err.println("delete  Failed...");
					}
				} 
				break;
			case 4:
				AssetAllocation assetAdd=addAssetData();
				boolean isValid3 = AssetManagementServiceImpl.vaildateAssetAllocation(assetAdd);
				if (isValid3) {
					boolean success = service.allocateAsset(assetAdd.getAssetId(),assetAdd.getEmployeeId(),assetAdd.getAllocationDate());
					int count = success ? 1 : 0;
					if (count > 0) {

						System.out.println("Allocated successfully..");
						
					}
					else {

						System.err.println("Allocation  Failed...");

					}

				} else {

					System.err.println("Invalid  Data");

				}
				
				break;
			case 5:
				AssetAllocation assetDeallocate=deallocateAssetData();
					boolean success1 = service.deallocateAsset(assetDeallocate.getAssetId(),assetDeallocate.getEmployeeId(),
							assetDeallocate.getReturnDate());
					int count2 = success1 ? 1 : 0;
					if (count2 > 0) {
						System.out.println("Deallocated successfully..");
					}
					else {
						System.err.println("Deallocation  Failed...");
					}
				break;
				
			case 6:
				MaintenanceRecords records=readRecordData();
				boolean isValid4 = AssetManagementServiceImpl.vaildateRecords(records);

				if (isValid4) {
					boolean success = service.performMaintenance(records.getAssetId(),records.getMaintenanceDate(),records.getDescription(),
							records.getCost());
					int count = success ? 1 : 0;
					if (count > 0) {

						System.out.println("Record added successfully..");
					}
					else {
						System.err.println("Record Adding  Failed...");
					}
				} else {
					System.err.println("Invalid  Data");
				}
				break;
				
			case 7:
				Reservations reservation=readReservationData();
				boolean isValid5 = AssetManagementServiceImpl.vaildateReservation(reservation);

				if (isValid5) {
					boolean success = service.reserveAsset(reservation.getAssetId(),reservation.getEmployeeId(),reservation.getReservationDate(),
							reservation.getStartDate(),reservation.getEndDate(),reservation.getStatus());
					int count = success ? 1 : 0;
					if (count > 0) {

						System.out.println("Reserved successfully..");
					}
					else {
						System.err.println("ReservationFailed...");
					}
				} else {
					System.err.println("Invalid Data");
				}

 			    break;
				
			case 8:
				Reservations reservationWithdraw=withdrawReservationData();
				boolean isValid6 = AssetManagementServiceImpl.vaildatewithdrawReservation(reservationWithdraw);
				if (isValid6) {
					boolean success = service.withdrawReservation(reservationWithdraw.getReservationId());
					int count = success ? 1 : 0;
					if (count > 0) {
						System.out.println("Withdraw successfully..");
					}
					else {
						System.err.println("Withdraw  Failed...");
					}
				} else {
					System.err.println("Invalid  Data");
				}
				break;
			case 9:
				MaintenanceRecords assetId = getAssetIdFromUser();
				try {				    
				    boolean isMaintained = service.maintenanceDate(assetId);				    				  
				    if (isMaintained) {
				        System.out.println("Asset maintenance is up to date.");
				    } else {
				        System.out.println("Asset has not been maintained in the last 2 years.");
				    }
				} catch (AssetNotMaintainException e) {
				    // Handle the specific case where the asset has not been maintained
				    System.err.println("Error: " + e.getMessage()); // This will be the message from the exception
				} 
				 catch (Exception e) {
				    // Handle any other unexpected exceptions
				    System.err.println("An unexpected error occurred: " + e.getMessage());
				}
				break;
			case 0:
				flag = false;			
				System.out.println("Thank you");
		
		default:
			break;
			}
		}
			
		}
	
	public static Assets readAssetData(){
		Assets  asset=new Assets();
		
		System.out.println("Enter AssetID=");
		asset.setAssetId(scanner.nextInt());
		System.out.println("Enter  Name=");
		asset.setName(scanner.next());
		System.out.println("Enter Type=");
		asset.setType(scanner.next());
		System.out.println("Enter SerialNumber=");
		asset.setSerialNumber(scanner.nextInt());
 
		System.out.println("Enter date=");
		String inputDate=scanner.next();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try {
            // Parse the input string into a Date object
            java.util.Date parsedDate = formatter.parse(inputDate);
            // Convert to java.sql.Date and set to asset
            asset.setPurchaseDate(new Date(parsedDate.getTime()));
            System.out.println("You entered the date: " + asset.getPurchaseDate());
        } catch (ParseException e) {
            System.err.println("Invalid date format. Please enter the date in the format yyyy-MM-dd.");
            return null; 
            }
		System.out.println("Enter Location=");
		asset.setLocation(scanner.next());
		System.out.println("Enter Status=");
		asset.setStatus(scanner.next());
		System.out.println("Enter Owner Id=");
		asset.setOwnerId(scanner.nextInt());
			
		return asset;
	}
	public static Assets updateAssetData(){
		Assets  asset=new Assets();		
		System.out.println("Enter AssetID=");
		asset.setAssetId(scanner.nextInt());
		System.out.println("Enter  Name=");
		asset.setName(scanner.next());
		
		return asset;
		
	}
	public static Assets deleteAssetData() {
		Assets asset=new Assets();
		System.out.println("Enter AssetID=");
		asset.setAssetId(scanner.nextInt());
		
		return asset;
		
	}
	public static AssetAllocation addAssetData(){
		AssetAllocation allocate=new AssetAllocation();
		System.out.println("Enter AssetID=");
		allocate.setAssetId(scanner.nextInt());
		System.out.println("Enter EmployeeID=");
		allocate.setEmployeeId(scanner.nextInt());
		System.out.println("Enter Allocation date=");
		String inputDate=scanner.next();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try {
            java.util.Date parsedDate = formatter.parse(inputDate);
            allocate.setAllocationDate(new Date(parsedDate.getTime()));
            System.out.println("You entered the date: " + allocate.getAllocationDate());
        } catch (ParseException e) {
            System.err.println("Invalid date format. Please enter the date in the format yyyy-MM-dd.");
            return null; 
            }
		
		
		return allocate;
}

public static AssetAllocation deallocateAssetData(){
	AssetAllocation deallocate=new AssetAllocation();
	System.out.println("Enter Return date=");
	String inputDate=scanner.next();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    try {
        java.util.Date parsedDate = formatter.parse(inputDate);
        deallocate.setReturnDate(new Date(parsedDate.getTime()));
        System.out.println("You entered the date: " + deallocate.getReturnDate());
    } catch (ParseException e) {
        System.err.println("Invalid date format. Please enter the date in the format yyyy-MM-dd.");
        return null; 
        }
	return deallocate;
}

public static Reservations withdrawReservationData() {
	Reservations reservation=new Reservations();
	System.out.println("Enter ReservationID=");
	reservation.setReservationId(scanner.nextInt());
	
	return reservation;
}

public static MaintenanceRecords readRecordData(){
	MaintenanceRecords records=new MaintenanceRecords();
	
	System.out.println("Enter AssetID=");
	records.setAssetId(scanner.nextInt());
	System.out.println("Enter date=");
	String inputDate=scanner.next();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    try {
        java.util.Date parsedDate = formatter.parse(inputDate);
        records.setMaintenanceDate(new Date(parsedDate.getTime()));
        System.out.println("You entered the date: " + records.getMaintenanceDate());
    } catch (ParseException e) {
        System.err.println("Invalid date format. Please enter the date in the format yyyy-MM-dd.");
        return null; 
        }
	System.out.println("Enter description=");
	records.setDescription(scanner.next());
	System.out.println("Enter cost=");
	records.setCost(scanner.nextDouble());
		
	return records;
}

public static Reservations readReservationData(){
	Reservations reservation=new Reservations();
	
	System.out.println("Enter AssetID=");
	reservation.setAssetId(scanner.nextInt());
	System.out.println("Enter employeeID=");
	reservation.setEmployeeId(scanner.nextInt());
	System.out.println("Enter reservation date=");
	String inputDate=scanner.next();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    try {
        // Parse the input string into a Date object
        java.util.Date parsedDate = formatter.parse(inputDate);
        // Convert to java.sql.Date and set to asset
        reservation.setReservationDate(new Date(parsedDate.getTime()));
        System.out.println("You entered the date: " + reservation.getReservationDate());
    } catch (ParseException e) {
        System.err.println("Invalid date format. Please enter the date in the format yyyy-MM-dd.");
        return null; 
        }
    System.out.println("Enter start date=");
	String inputDate1=scanner.next();
	SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");

    try {
        // Parse the input string into a Date object
        java.util.Date parsedDate = formatter.parse(inputDate);
        // Convert to java.sql.Date and set to asset
        reservation.setStartDate(new Date(parsedDate.getTime()));
        System.out.println("You entered the date: " + reservation.getStartDate());
    } catch (ParseException e) {
        System.err.println("Invalid date format. Please enter the date in the format yyyy-MM-dd.");
        return null; 
        }
    System.out.println("Enter end date=");
	String inputDate2=scanner.next();
	SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");

    try {
        // Parse the input string into a Date object
        java.util.Date parsedDate = formatter.parse(inputDate);
        reservation.setEndDate(new Date(parsedDate.getTime()));
        System.out.println("You entered the date: " + reservation.getEndDate());
    } catch (ParseException e) {
        System.err.println("Invalid date format. Please enter the date in the format yyyy-MM-dd.");
        return null; 
        }
    System.out.println("Enter status=");
	reservation.setStatus(scanner.next());
		
	return reservation;
}
public static MaintenanceRecords getAssetIdFromUser() {
	MaintenanceRecords asset=new MaintenanceRecords();
	System.out.println("Enter assetId");
	asset.setAssetId(scanner.nextInt());
	return asset;
}
}

	