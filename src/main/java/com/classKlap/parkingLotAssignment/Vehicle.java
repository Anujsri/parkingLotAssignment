package com.classKlap.parkingLotAssignment;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/** The purpose of this class to to provide the utility for add,leave,totalVehicleParked for vehicle, and other class will use it **/
public class Vehicle {
    Scanner sc = new Scanner(System.in);
    String registration_number;
    String color;
    String type;
    int count = 0;
    int totalSlots;
    
    /** Creating  LinkedHashMap to store vehicle information**/
    LinkedHashMap < Integer, Vehicle > ht = new LinkedHashMap < Integer, Vehicle > ();

    Vehicle() {}
    
    /** constructor to initialize the vehicle class object **/
    Vehicle(String registration_number, String color,String type) {
        this.registration_number = registration_number;
        this.color = color;
        this.type = type;
    }
    
    public int addToHashMap(Vehicle v,int index) {
		ht.put(index, v);
		count = count + 1;
		return index;
    }

    /** Allot a slot to vehicle for parking **/
    public int addParking(Vehicle v) {
    	int alottedSlot = 0;
        for (int i = 1; i <= totalSlots; i++) {
            if (ht.containsKey(i) == false) {
            	if(i%3 == 1 && v.type.equalsIgnoreCase("car")) {
            		alottedSlot = addToHashMap(v,i);
                    break;
            	}	
            	if(i%3 == 2 && v.type.equalsIgnoreCase("suv")) {
            		alottedSlot = addToHashMap(v,i);
                    break;
            	}
            	if(i%3 == 0 && v.type.equalsIgnoreCase("hv")) {
            		alottedSlot = addToHashMap(v,i);
                    break;
            	}
            }
        }
        return alottedSlot;
    }

    
    /** method for leaving a vehicle from Parking lot **/
    public int  leaveParking(int slot) {
        ht.remove(slot);
        count = count - 1;
        return slot;
    }
    
    
    /** method to get total number of vehicle parked in Parking Lot **/
    public int totalVehicleParked() {
    	return count;
    }
    
    /**this method gives Registration numbers of all cars of a particular color.**/
    public String registrationNumByColor(String colorName) {
    	
    	ArrayList<String> registrationNumbers = new ArrayList<String>();
    	for(Map.Entry<Integer, Vehicle> entry:ht.entrySet()){     
            Vehicle v=entry.getValue();
            if(colorName.equalsIgnoreCase(v.color)) {
            	registrationNumbers.add(v.registration_number);   
            } 
        } 
    	return String.join(", ", registrationNumbers);

    }
    
    /**This method gives Slot number in which a car with a given registration number is parked. **/
    public int getSlotNumByReg(String registrationNum) {
    	int SlotNum = 0;

    	for(Map.Entry<Integer, Vehicle> entry:ht.entrySet()){     
            Vehicle v=entry.getValue();
            if(registrationNum.equalsIgnoreCase(v.registration_number)) {
            	SlotNum = entry.getKey(); 
            	break;
            }
        } 
    	return SlotNum;
    }
    
   
   /** This method gives Slot numbers of all slots where a car of a particular colour is parked.**/
   public ArrayList<Integer> getSlotsByColor(String color){
    	ArrayList<Integer> slotNumbers = new ArrayList<Integer>();
    	for(Map.Entry<Integer, Vehicle> entry:ht.entrySet()){     
            Vehicle v=entry.getValue(); 
            if(color.equalsIgnoreCase(v.color)) {
            	slotNumbers.add(entry.getKey()); 
            }
        }
    	printArraylist(slotNumbers);
    	return slotNumbers;
    }
   
   
   /** This method gives Slot numbers of all slots where a particular vehicle type is parked.**/
   public ArrayList<Integer> getSlotsNumByVehicleType(String vehicleType){
    	ArrayList<Integer> slotNumbers = new ArrayList<Integer>();
    	for(Map.Entry<Integer, Vehicle> entry:ht.entrySet()){     
            Vehicle v=entry.getValue(); 
            if(vehicleType.equalsIgnoreCase(v.type)) {
            	slotNumbers.add(entry.getKey()); 
            }
        }
    	printArraylist(slotNumbers);
    	return slotNumbers;
    }
    
   	/** This method provide the utility to get the status of Parking Lot **/
    public void parkingStatus() {
    	System.out.println("Slot No.\t Registration No\t Color\t Vehicle type");
    	for(Map.Entry<Integer, Vehicle> entry:ht.entrySet()){     
            Vehicle v=entry.getValue(); 
            System.out.println(entry.getKey() + "\t\t  "+ v.registration_number + "\t\t" + v.color + "\t\t" + v.type);
        } 
    }
    
    /** A method to print the arraylist of Integer **/
    public void printArraylist(ArrayList<Integer> arrList) {
    	int size = arrList.size();
    	if(size > 0) {
    		for(int i=0; i<size; i++) {
    			if(i== (size - 1))
    				System.out.print(arrList.get(i));
    			else
    				System.out.print(arrList.get(i) + " , ");
    		}
    		System.out.print("\n");
    	}else {
    		System.out.println("Not Found");
    	}
    	
    }  
}
