package com.edubridge.airconditionersmanagement;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

import com.edubridge.airconditionersmanagement.utils.HibernateUtils;
import com.edubridge.airconditionersmanagement.model.AirConditioner;
import com.edubridge.airconditionersmanagement.service.AirConditionerService;

public class AcMainApp {
	public static void main(String[] args) {
		int option ;
		Scanner in = new Scanner(System.in);
		AirConditionerService service = new AirConditionerService();
		String  brand = null;
		String model = null;
		Double price = 0.0;
		Double powerRating =0.0;
	
	
	
		  do {
	            System.out.println("\nAir Conditioners Management");
	            System.out.println("==============================");
	            System.out.println("1. Add Air Conditioner");
	            System.out.println("2. View All Air Conditioners");
	            System.out.println("3. Search AirConditiner");
	            System.out.println("4. Update Air Conditioner");
	            System.out.println("5. Delete Air Conditioner");
	            System.out.println("6. Delete All AirConditioners");
	            System.out.println("0. Exit");
	            System.out.print("Enter your option: ");
		        option = in.nextInt();
		        
		        switch (option) {
				case 1:
					System.out.println("Add New AirConditioner");
					System.out.println("------------");
					System.out.println("Enter AirConditioner Brand: ");
					brand = in.next();
					System.out.println("Enter AirConditioner Model: ");
					model = in.next();
					System.out.println("Enter AirConditioner Price: ");
					price = in.nextDouble();
					System.out.println("Enter AirConditioner PowerRating");
					powerRating = in.nextDouble();
					

					AirConditioner airconditioner = new AirConditioner();
					airconditioner.setBrand(brand);
					airconditioner.setModel(model);
					airconditioner.setPrice(price);
					airconditioner.setPowerRating(powerRating);
					
					service.addairconditioner(airconditioner);
					System.out.println("Air Conditioner added successfully!");
					break;

				case 2:
					System.out.println("View All AirConditioners");
					System.out.println("-----------------");
					List<AirConditioner> airconditioners = service.getAllAirConditioners();
					if (airconditioners.size() !=0) {
						for (AirConditioner ac :airconditioners ) {
							System.out.println(ac.getId() + "\t" + ac.getBrand() + "\t" + ac.getModel() + "\t" + ac.getPrice() +"\t" + ac.getPowerRating());
						}
					} else {
						System.out.println("no airconditioners found");
					}
					
					break;
					

				case 3:
					System.out.println("Search airconditioner");
					System.out.println("---------------");
					System.out.println("Please enter airconditioner id: ");
					int id = in.nextInt();
					AirConditioner ac = service.getAirConditionerById(id);
					if (ac != null) {
						System.out.println("AiConditioner brand:"+ ac.getBrand());
						System.out.println("AirConditioner model:"+ ac.getModel());
						System.out.println("AirConditioner price: " + ac.getPrice());
						System.out.println("AirConditioner powerRating:"+ ac.getPowerRating());
					} else {
						System.out.println("No airconditioner found with id: " + id);
					}
					break;
					
				case 4:
					System.out.println("Update AirConditioner Details");
					System.out.println("----------------------");
					System.out.println("Enter AirConditioner Id: ");
					int updatedId = in.nextInt();
					System.out.println("Enter AirConditioner brand: ");
					brand = in.next();
					System.out.println("Enter AirCOnditioner Model: ");
					model = in.next();
					System.out.println("Enter AirConditioner Price: ");
					price = in.nextDouble();
					System.out.println("Enter AirCondiitioner powerRating: ");
					powerRating = in.nextDouble();
					
					
					AirConditioner updatedAirConditioner = new AirConditioner();
					updatedAirConditioner.setId(updatedId);
					updatedAirConditioner.setBrand(brand);
					updatedAirConditioner.setModel(model);
					updatedAirConditioner.setPrice(price);
					updatedAirConditioner.setPowerRating(powerRating);
					
					service.UpdateAirConditioner(updatedAirConditioner);
					System.out.println("Air Conditioner update successfully");
					break;
					
				case 5:
					System.out.println("Delete AirCondtioner");
					System.out.println("--------------");
					System.out.println("Please enter airconditioner id: ");
					int deleteid = in.nextInt();
					service.deleteAirConditioner(deleteid);	
					System.out.println("Air Conditioner deleted successfully!");
					break;

				case 6:
					System.out.println("Are sure delete all AirConditioners? [Y/N]");
					String confirm = in.next();
					if(confirm.equalsIgnoreCase("Y")) {
						service.deleteAllAirConditioners()	;		
						System.out.println("All Air Conditioners delted successfully!");
					}
					break;
					
				case 0:
					System.out.println("Bye!!!");
					System.exit(0);
					break;
					
				default:
					System.out.println("Please choose a Valid option: ");
					break;
				}

			} while (option != 0);
		  
		 
		}


}
