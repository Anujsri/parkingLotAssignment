package com.classKlap.parkingLotAssignment;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

/** The purpose of this class to register user defined command using spring shell  **/
@ShellComponent
public class MyCommands {
	
	/** Creating vehicle object to access it's variable and methods **/
	Vehicle vehicle  = new Vehicle();
	
	@ShellMethod(value = "Total slots available", key = "create_parking_lot")
	public void createSlots(int totalSlots) {
		vehicle.totalSlots = totalSlots;
		System.out.println("Created a parking lot with " + vehicle.totalSlots + " slots");
	}
	
	/** method for adding a vehicle to Parking lot **/
	@ShellMethod("Allot a slot to vehicle for parking")
	public String park(String reg_number, String colorName,String type) {
		Vehicle v = new Vehicle(reg_number, colorName,type);
		int alottedSlot = vehicle.addParking(v);
		if(alottedSlot > 0)
			return String.format("Allocated slot number: %d",alottedSlot );
		else
			return "Sorry, parking lot is full";
	}
	
	/** method for leaving a vehicle from Parking lot **/
	@ShellMethod("Leave Parking Lot")
	public void leave(int slotNum) {
		if(vehicle.count != 0) {
            if(slotNum > vehicle.totalSlots) {
            	System.out.println("Not found");
            }else {
           	 	vehicle.leaveParking(slotNum);
           	 System.out.println("Slot number " + slotNum + " is free");
            }
		}else {
			System.out.println("There is no vehicle in parking lot, All slots are free!");
		}
	}
	
	
	@ShellMethod("Gives Registration numbers of all cars of a particular colour.")
	public String registration_numbers_for_cars_with_colour(String colorName) {
		String registrationNums = vehicle.registrationNumByColor(colorName);
		return String.format(registrationNums);
	}
	
	@ShellMethod("Gives Registration numbers of a particular vehicle type.")
	public String registration_numbers_for_vehicle_type(String VehicleType) {
		String registrationNums = vehicle.registrationNumByVehicleType(VehicleType);
		return String.format(registrationNums);
	}
	
	@ShellMethod("Gives Slot number in which a car with a given registration number is parked.")
	public String slot_number_for_registration_number(String reg_number) {
		int SlotNum = vehicle.getSlotNumByReg(reg_number);
		if(SlotNum == 0)
			return "Not Found";
		else
			return Integer.toString(SlotNum);
	}
	
	@ShellMethod("Gives Slot numbers of vehicle type")
	public void slot_number_for_vehicle_type(String vehicleType) {
		vehicle.getSlotsNumByVehicleType(vehicleType);
		
	}
	
	@ShellMethod("Gives Slot numbers of all slots where a car of a particular colour is parked.")
	public void slot_numbers_for_cars_with_colour(String colorName) {
		 vehicle.getSlotsByColor(colorName);
		
	}
	
	@ShellMethod("Status of Parking Lot")
	public void status() {
		vehicle.parkingStatus();
	}
	
	@ShellMethod("Totle vehicle parked in Parking Lot")
	public int total_vehicle_parked() {
		int totalVehicle = vehicle.totalVehicleParked();
		return totalVehicle;
	}
}

