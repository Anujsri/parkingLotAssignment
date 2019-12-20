package com.classKlap.parkingLotAssignment;
import com.classKlap.parkingLotAssignment.Vehicle;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/** The purpose of this class to run the test cases **/
@ContextConfiguration(classes = ParkingLotAssignmentApplicationTests.class)
@SpringBootTest
class ParkingLotAssignmentApplicationTests {
	
	/** Creating vehicle object to access it's variable and methods **/
	Vehicle vehicle = new Vehicle();
	
	
	/** Creating method to test, slot is created or not **/
	@Test
	void createSlot() {
		vehicle.totalSlots = 3;
		assert(true);
	}
	
	/** Creating method to test, to add a vehicle in parking lot **/
	@Test
	void addParkingTest() {
		vehicle.totalSlots = 3;
		Vehicle v = new Vehicle("abcd","white","car");
		int a = vehicle.addParking(v);
		if(a == 1)
			assert(true);
		else
			assert(false);
	}
	
	/** Creating method to test, to leave a vehicle in parking lot **/
	@Test
	void leaveParkingTest() {
		vehicle.totalSlots = 3;
		Vehicle v1 = new Vehicle("abcd","white","car");
		Vehicle v2 = new Vehicle("bcde","blue","suv");
		Vehicle v3 = new Vehicle("cdef","white","hv");
		vehicle.addParking(v1);
		vehicle.addParking(v2);
		vehicle.addParking(v3);
		int a = vehicle.leaveParking(2);
		if(a == 2)
			assert(true);
		else
			assert(false);
	}
	
	
	/** Creating method to test, registration Number By Color is working or not **/
	@Test
	void registrationNumByColor() {
		vehicle.totalSlots = 3;
		Vehicle v1 = new Vehicle("abcd","white","car");
		Vehicle v2 = new Vehicle("bcde","blue","suv");
		Vehicle v3 = new Vehicle("cdef","white","hv");
		vehicle.addParking(v1);
		vehicle.addParking(v2);
		vehicle.addParking(v3);
		String regNums = vehicle.registrationNumByColor("white").replaceAll(" ","").replaceAll(",","");
		char tempArray[] = regNums.toCharArray(); 
        Arrays.sort(tempArray); 
		if((new String(tempArray)).equals("abccddef")) 
			assert(true);
		else
			assert(false);
		
	}
	
	/** Creating method to test, registration Number By vehicle type is working or not **/
	@Test
	void registrationNumByVehicleType() {
		vehicle.totalSlots = 3;
		Vehicle v1 = new Vehicle("abcd","white","car");
		Vehicle v2 = new Vehicle("bcde","blue","suv");
		Vehicle v3 = new Vehicle("cdef","white","hv");
		vehicle.addParking(v1);
		vehicle.addParking(v2);
		vehicle.addParking(v3);
		String regNums = vehicle.registrationNumByVehicleType("car").replaceAll(" ","").replaceAll(",","");
		char tempArray[] = regNums.toCharArray(); 
        Arrays.sort(tempArray); 
		if((new String(tempArray)).equals("abcd")) 
			assert(true);
		else
			assert(false);
		
	}
	
	/** Creating method to test, get Slot Number By Registration is working or not **/
	@Test
	void getSlotNumByRegTest() {
		vehicle.totalSlots = 3;
		Vehicle v1 = new Vehicle("abcd","white","car");
		Vehicle v2 = new Vehicle("bcde","blue","suv");
		Vehicle v3 = new Vehicle("cdef","white","hv");
		int a = vehicle.addParking(v1);
		vehicle.addParking(v2);
		vehicle.addParking(v3);
		int b= vehicle.getSlotNumByReg("abcd");
		if(a==b)
			assert(true);
		else
			assert(false);
			
	}
	
	/** Creating method to test, parking status of Parking lon **/
	@Test
	void parkingStatustest(){
		vehicle.totalSlots = 3;
		Vehicle v1 = new Vehicle("abcd","white","car");
		Vehicle v2 = new Vehicle("bcde","blue","suv");
		Vehicle v3 = new Vehicle("cdef","white","hv");
		vehicle.addParking(v1);
		vehicle.addParking(v2);
		vehicle.addParking(v3);
		vehicle.parkingStatus();
		assert(true);
	}
	
	/** Creating method to test, get Slots By Color is working or not**/
	@Test
	void getSlotsByColorTest() {
		vehicle.totalSlots = 3;
		Vehicle v1 = new Vehicle("abcd","white","car");
		Vehicle v2 = new Vehicle("bcde","blue","suv");
		Vehicle v3 = new Vehicle("cdef","white","hv");
		vehicle.addParking(v1);
		vehicle.addParking(v2);
		vehicle.addParking(v3);
		ArrayList<Integer> slotNumbers = vehicle.getSlotsByColor("white");
		ArrayList<Integer> list2 =new ArrayList<Integer>();
		list2.add(1);
		list2.add(3);
		System.out.println(slotNumbers);
		System.out.println(list2);
		if(slotNumbers.equals(list2))
			assert(true);
		else
			assert(false);
		
	}
	
	
	/** Creating method to test, get Slots By Color is working or not**/
	@Test
	void getSlotsByVehicleType() {
		vehicle.totalSlots = 3;
		Vehicle v1 = new Vehicle("abcd","white","car");
		Vehicle v2 = new Vehicle("bcde","blue","suv");
		Vehicle v3 = new Vehicle("cdef","white","hv");
		vehicle.addParking(v1);
		vehicle.addParking(v2);
		vehicle.addParking(v3);
		ArrayList<Integer> slotNumbers = vehicle.getSlotsNumByVehicleType("car");
		ArrayList<Integer> list2 =new ArrayList<Integer>();
		list2.add(1);
		System.out.println(slotNumbers);
		System.out.println(list2);
		if(slotNumbers.equals(list2))
			assert(true);
		else
			assert(false);
		
	}
	

}
