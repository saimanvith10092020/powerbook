package com.edubridge.powerbook;
import java.util.List;
import java.util.Scanner;

import com.edubridge.powerbook.dao.PowerbankDao;
import com.edubridge.powerbook.dao.PowerbankDaoImpl;
import com.edubridge.powerbook.model.Powerbank;

/**
 * Hello world!
 *
 */
public class App 
    {
    	public static void main( String[] args )
        {
            PowerbankDao dao = new PowerbankDaoImpl();
            
    		Scanner in = new Scanner(System.in);
            
            while(true) {
                System.out.println("-----------------------");
                System.out.println("MY CONTACT APP");
                System.out.println("-----------------------");
                System.out.println(" 1. ADD POWERBANK");
                System.out.println(" 2. VIEW ALL POWERBANKS");
                System.out.println(" 3. SEARCH POWERBANK");
                System.out.println(" 4. UPDATE POWERBANK");
                System.out.println(" 5. DELETE POWERBANK");
                System.out.println(" 6. DELETE ALL POWERBANKS");
                System.out.println(" 0. EXIT");
                System.out.println("----------------------");
                System.out.println("PLEASE CHOOSE OPTION :");
                System.out.println("----------------------");

                int option = in.nextInt();
          	  //id,name,price,quantity,brand,discription,colors
                switch (option) {
                    case 1:
                        System.out.println("please enter powerbank id");
                        int id = in.nextInt();
                        System.out.println("please enter powerbank name");
                        String name = in.next();
                        System.out.println("please enter powerbank price");
                        float price = in.nextFloat();
                        System.out.println("please enter powerbank quantity");
                        Long quantity = in.nextLong();
                        System.out.println("please enter powerbank brand");
                        String brand = in.next();
                        System.out.println("please enter powerbank discription");
                        String discription = in.next();
                        System.out.println("please enter powerbank color");
                        String color = in.next();
                        
                        Powerbank newPowerbank = new Powerbank();
                        newPowerbank.setId(id);
                        newPowerbank.setName(name);
                        newPowerbank.setPrice(price);
                        newPowerbank.setQuantity(quantity);
                        newPowerbank.setBrand(brand);
                        newPowerbank.setDiscription(discription);
                        newPowerbank.setColor(color);
                        
                        int status = dao.addPowerbank(newPowerbank);
                        if(status >= 1) {
                            System.out.println("New Powerbank Saved...!!");
                        } else {
                            System.out.println("Something went wrong...!!");
                        }
                        break;
                        
                    case 2:
                        List<Powerbank> powerbanks = dao.getAllPowerbanks();
                        if(powerbanks.size() != 0) {
                            for(Powerbank powerbank : powerbanks) {
                                System.out.println("-----------------------------------------------");
                                System.out.println(powerbank.getId() + "\t" + powerbank.getName() + "\t" + powerbank.getPrice() + "\t" +
                                powerbank.getQuantity()+ "\t" + powerbank.getBrand()+ "\t" + powerbank.getDiscription()+ "\t" + powerbank.getColor());
                            }
                        } else {
                            System.out.println("No powerbank found");
                        }
                        break;
                        
                    case 3:
                        System.out.println("Please enter the name to search:");
                        String searchName = in.next();
                        Powerbank powerbank = dao.getPowerbank(searchName);
                        if(powerbank != null) {
                            System.out.println("Powerbank found: ");
                            System.out.println(powerbank.getId() + "\t" + powerbank.getName() + "\t" + powerbank.getPrice() + "\t" +
                            powerbank.getQuantity()+ "\t" + powerbank.getBrand()+ "\t" + powerbank.getDiscription()+ "\t" + powerbank.getColor());
                        } else {
                            System.out.println("Powerbank not found.");
                        }
                        break;
                        
                    case 4:
                        System.out.println("Please enter the name of the contact to update:");
                        String updateName = in.next();
                        Powerbank existingDetails = dao.getPowerbank(updateName);
                        if(existingDetails != null) {
                        	System.out.println("please enter powerbank id");
                            int newid = in.nextInt();
                            System.out.println("please enter powerbank price");
                            float newprice = in.nextFloat();
                            System.out.println("please enter powerbank quantity");
                            Long newquantity = in.nextLong();
                            System.out.println("please enter powerbank brand");
                            String newbrand = in.next();
                            System.out.println("please enter powerbank discription");
                            String newdiscription = in.next();
                            System.out.println("please enter powerbank color");
                            String newcolor = in.next();
                            
                            existingDetails.setId(newid);
                            existingDetails.setPrice(newprice);
                            existingDetails.setQuantity(newquantity);
                            existingDetails.setBrand(newbrand);
                            existingDetails.setDiscription(newdiscription);
                            existingDetails.setColor(newcolor);
                            
                            int updateStatus = dao.updatePowerbank(existingDetails);
                            if(updateStatus >= 1) {
                                System.out.println("Powerbank updated successfully!");
                            } else {
                                System.out.println("Update failed.");
                            }
                        } else {
                            System.out.println("powerbank not found.");
                        }
                        break;
                        
                    case 5:
                        System.out.println("Please enter the name of the powerbank to delete:");
                        String deleteName = in.next();
                        int deleteStatus = dao.deletePowerbank(deleteName);
                        if(deleteStatus >= 1) {
                            System.out.println("powerbank deleted successfully!");
                        } else {
                            System.out.println("Delete failed.");
                        }
                        break;
                        
                    case 6:
                        System.out.println("Are you sure you want to delete all powerbank? (yes/no)");
                        String confirmation = in.next();
                        if(confirmation.equalsIgnoreCase("yes")) {
                            dao.deleteAllPowerbanks();
                            System.out.println("All powerbank deleted successfully!");
                        } else {
                            System.out.println("Delete all powerbank operation cancelled.");
                        }
                        break;
                        
                    case 0:
                        System.out.println("Bye..!!");
                        System.exit(0);
                        
                    default:
                        System.out.println("Please enter a valid option.");
                        break;
                }
            }
        }
}
