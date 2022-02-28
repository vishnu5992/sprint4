package controller;
import java.util.Scanner;
import dao.AdminDao;
import model.AdminModel;
import service.AdminDetails;
public class MainController {

	public static void main(String[] args) throws ClassNotFoundException {
	   AdminDetails ad = new AdminDetails();
	   AdminDao adminDao = new AdminDao();
	   System.out.println("THEATER MANAGEMENT SYSTEM");
        boolean Login = true;
        while(Login) {
        	System.out.println("\n1)Enter \n2)Exit");
        	Scanner sc = new Scanner(System.in);
        	int option = Integer.parseInt(sc.nextLine());
        	switch(option) {
        	case 1:{
        		System.out.println("\n Admin Name: ");
        		String Name= sc.nextLine();
        		System.out.println("Passsword:");
        		String pwd = sc.nextLine();
        		if(Name.equals("vishnusankar")&&pwd.equals("7992"));{
        			System.out.println("Sucessfully Logged In");
        			 boolean temp = true;
        			 while(temp) {
        				 System.out.println("Choose the action to be performed");
        				 System.out.println("\n 1 Add movie Id  \n 2) view movies \n 3)Update  \n 4)Delete \n 5)Exit");
        				 boolean flag = true;
        				 int operation = 0;
        				 while(flag) {
        					 try {
        						 operation = Integer.parseInt(sc.nextLine());
        						 flag = false;
        					 }catch (Exception e) {
        						 System.out.println("Enter correct Number");
        						 flag = true;
        					 }
        				 }
        				 switch(operation) {
        				      ///ADD Movie///
        				 case 1:{
        					 System.out.println("How Many movies want to add");
        					 int AdminAdd = Integer.parseInt(sc.nextLine());
        					   int MovieId = 0;
        					   String MovieName,ActorName,ActressName,TheaterName,Location,Time;
        					   for(int i=0; i<AdminAdd;i++) {
        						   boolean id = true;
        						   while(id) {
        							   try {
        								  System.out.println("MovieId:"); 
        								  MovieId = Integer.parseInt(sc.nextLine());
        								  id= false;
        							   }catch(NumberFormatException e) {
        								   System.out.println("Enter Integer Type only");
        								   id= true;
        							   }
        						   }
        						   System.out.println("Movie Name:");
        						   MovieName = sc.nextLine();
        						   System.out.println("Actor Name:");
        						   ActorName = sc.nextLine();
        						   System.out.println("Actress Name:");
        						   ActressName = sc.nextLine();
        						   System.out.println("Theater Name:");
        						   TheaterName = sc.nextLine();
        						   System.out.println("Location:");
        						   Location = sc.nextLine();
        						   System.out.println("Time");
        						   Time = sc.nextLine();
        						   
                            AdminModel admin = new AdminModel(MovieId,MovieName,ActorName,ActressName,TheaterName,Location,Time);
                              ad.AddAdminModel(admin);
                                 
        					   }
        				   break;
        				 }
        				 ////view///
        				 case 2:{
        	                adminDao.ViewAdminModel();
        	                 break;
        				 }
        				 //////////update/////
        				 case 3:{
        					 System.out.println("\n Enter the Id  to Upadte:");
        					 int UpdateMovieId = Integer.parseInt(sc.nextLine());
        					 boolean flag1= true;
        					 System.out.println("\n select any one of them to update");
        					 try {
        						 while(flag1) {
        							 System.out.println("\n 1)MovieName \n2)ActorName \n3)ActressName \n 4)TheaterName \n5)Location \n 6)Time \n7)Exit" );
        							 int Update = Integer.parseInt(sc.nextLine());
        							 switch(Update) {
        							 case 1:{
        								 System.out.println("\nEnter movie Name to update");
        								 String newMovieName = sc.nextLine();
        						 adminDao.UpdateAdminModel(Update,UpdateMovieId,newMovieName);
        								 break;
        							 }
        							 case 2:{
        								 System.out.println("\nEnter  ActorName to update");
        								 String newActorMovieName = sc.nextLine();
        								 adminDao.UpdateAdminModel(Update,UpdateMovieId,newActorMovieName);
        								 break;

        							 }
        							 case 3:{
        								 System.out.println("\nEnter ActressName to update");
        								 String newActressMovieName = sc.nextLine();
        								 adminDao.UpdateAdminModel(Update,UpdateMovieId,newActressMovieName);
        								 break;

        							 }
        							 case 4:{
        								 System.out.println("\nEnter  TheaterName to update");
        								 String newTheaterName = sc.nextLine();
        								 adminDao.UpdateAdminModel(Update,UpdateMovieId,newTheaterName);
        								 break;

        							 }
        							 case 5:{
        								 System.out.println("\nEnter Location to update");
        								 String newLocation= sc.nextLine();
        								 adminDao.UpdateAdminModel(Update,UpdateMovieId,newLocation);
        								 break;

        							 }
        							 case 6:{
        								 System.out.println("\nEnter Time to update");
        								 String newTime= sc.nextLine();
        								 adminDao.UpdateAdminModel(Update,UpdateMovieId,newTime);
        								 break;

        							 }

        							 case 7:{
        								 flag1= false;
        								 break;
        							 }
        							 }
        							
        						 }
        					 }catch(NumberFormatException e){
        						 System.out.println("\nEnter the correct number");
        						 flag1 = true;
        					 }
        					 break;
        				 }
        				 ////////////////Delete/////////
        				 case 4:{
        					 System.out.println("\n Enter the MovieId to be delete the record");
        					 int DeleteMovieId = 0;
        					 boolean flag2= true;
        					 while(flag2) {
        						 try {
        							 DeleteMovieId = Integer.parseInt(sc.nextLine());
        							 flag2 =false;
        						 }catch(NumberFormatException e) {
        							 System.out.println("Enter the correctNumber");
        							 flag2= true;
        						 }
        						 
        					 }
        					 adminDao.DeleteAdminModel(DeleteMovieId);
        					 break;
        				 }
        				 /////////////Exit////////
        				 case 5:{
        					 temp = false;
        					 break;
        				     }
        				 }
        				 
        			 }
        			
        		  }
      
             	}
        	}
        }
	}

}
