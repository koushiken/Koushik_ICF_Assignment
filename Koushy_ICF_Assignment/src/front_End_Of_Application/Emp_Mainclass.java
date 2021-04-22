package front_End_Of_Application;

import java.util.Scanner;
import emp_Model.Model_object_layer;
import service_Layer.Emp_Model_Service_Layer;

public class Emp_Mainclass 
{
	public static void showMenu()
	{
		 Emp_Model_Service_Layer ems = new Emp_Model_Service_Layer();  //CREATE OBJECT OF SERVICE LAYER

		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. Menu");
		System.out.println("Any key to Exit");
		String optn = sc.next();
		
		if(optn.equals("1") == false)
		{
			System.out.println("Thank you");
			System.exit(0);
		}
		while(true) {
		try
		{
		  System.out.println("1. Create New Employee Account");
		  System.out.println("2. Login to Employee Account");
		  System.out.println("3. Edit  Employee Account");
		  System.out.println("4. Show All Employee Details");
		  //System.out.println("5. Show Profile");
		  System.out.println("Any Key for Logout");
		  
		  String choice = sc.next();
		 
		  switch(choice)
		  {
		  case "1" :Model_object_layer mol1= new Model_object_layer();
			        System.out.println("Enter First Name"); //1
			        mol1.setFirst_name(sc.next());
			        
			        System.out.println("Enter Last Name"); //2
			        mol1.setLast_name(sc.next());
			        
			        System.out.println("Enter Date of Joining"); //3
			        mol1.setStart_date(sc.next());
			        
			        System.out.println("Enter Date of exit");  //4
			        mol1.setEnd_date(sc.next());
			       
			        System.out.println("Enter Role");   //5
			        mol1.setRole(sc.next());
			        
			        System.out.println("Enter Department Name"); //6
			        mol1.setDept(sc.next()); 
			        
			        System.out.println("Enter Status");  //7
			        mol1.setStatus(sc.next());
			        
			        System.out.println("Enter Date of Birth"); //8
			        mol1.setDob(sc.next());
			        
			        System.out.println("Enter Reporting Manager Name"); //9
			        mol1.setRep_mgr(sc.next());
			        
			        System.out.println("Enter Gender"); //10
			        mol1.setGender(sc.next());
			        
			        System.out.println("Enter Employee Blood Group");  //11
			        mol1.setBlood_grp(sc.next()); 
			        
			        System.out.println("Enter Employee Address");    //12
			        mol1.setAddress(sc.next());
			        ems.create_NewEmp(mol1);
			        
			        break;	
		  
		  case "2": System.out.println("Enter Employee Id to login");
		  			ems.loginByAdmin(sc.next()); 
		  			break;
          
		  case "3": System.out.println("Enter Employee ID to delete Employee A/c");
		  			ems.deleteEmpProfileByemp_id(sc.nextInt());
					break;
					
		  case "4":	ems.deleteEntiremp_Details();
					break;
		
		  case "5": ems.showAllEmpDetails();
		  case "6":	
			  		System.out.println("Enter the Employee ID to Update");
			  		int emp_id=sc.nextInt();
			  		ems.search_emp(emp_id);
			  		System.out.println("Enter New Date of Joining");
			  		String start_date=sc.next();
				    System.out.println("Enter New Date of exit");
				    String end_date=sc.next();
				    System.out.println("Enter New Role");
				    String role=sc.next();
			  		System.out.println("Enter New Department Name");
			  		String dept=sc.next();
			  		System.out.println("Enter New Status");
			  		String status=sc.next();
				    System.out.println("Enter New Reporting Manager Name");
				    String rep_mgr=sc.next();
				    System.out.println("Enter New Employee Address");
				    String address=sc.next();
				    sc.close();
				    
				    ems.editEmpProfileByemp_id(emp_id,start_date,end_date,role,dept,status,rep_mgr,address);
				    break;
		  default :System.out.println("Admin logged Out"); 
	      System.exit(0);        
}	
		
}
		catch (Exception exc) 
		{
			exc.printStackTrace();
		}
		}
	}
	
public static void loadDummyData()
	{
		Emp_Model_Service_Layer ems = new Emp_Model_Service_Layer();
		
		int n=9;
		char ch='A';
		
		Model_object_layer mol = new Model_object_layer();
		
		for(int i=0; i<=n; i++)
		{
		try
		{
		  String fname = "user"+ch;
		  String lname = "Neegros"+i;
		  String start_date = "1"+i+"/04/2021";
		  String end_date = "Null";
		  String role="technician"+i;
		  String dept="Accounting "+ch++;
		  String status = "Active";
		  String dob="2"+i+"/08/1998";
		  String rep_mgr = "Scott9"+i;
		  String gender = "male";
		  String blood_grp = "NIL";
		  String adr="Bengaluru-56001"+i;
		  
		  mol.setFirst_name(fname);
		  mol.setLast_name(lname);
		  mol.setStart_date(start_date);
		  mol.setEnd_date(end_date);
		  mol.setRole(role);
		  mol.setDept(dept);
		  mol.setStatus(status);
		  mol.setDob(dob);
		  mol.setRep_mgr(rep_mgr);
		  mol.setGender(gender);
		  mol.setBlood_grp(blood_grp);
		  mol.setAddress(adr);
		  
		  ems.create_NewEmp(mol);
		  
		  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		}
	}
}
	
