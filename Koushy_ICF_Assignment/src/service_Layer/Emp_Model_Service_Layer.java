package service_Layer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
//import java.util.List;
import java.util.Set;

import emp_DAO_Layer.MySQL_layer;
import emp_Model.Model_object_layer;

public class Emp_Model_Service_Layer {

	private MySQL_layer ms = new MySQL_layer();
	
	public void loginByAdmin(Integer entEmp_id) throws SQLException, IOException
	{
		 /*Step1 : getEMpByEmp_id(emp_id) --> 
		Step2 : get emp_id from the ResultSet(DataBase)
		Step3 : compare entEmp_id with employee id
		Step4 : if->match-> login done
		          ->not match -> invalid id
		*/
		ms.initDB();
		Model_object_layer mol  = ms.getEmpByemp_id(entEmp_id);
		
		Integer dbempid = mol.getEmp_id();
		
		if(entEmp_id.equals(dbempid))
			System.out.println("Logged in");
		else
			System.out.println("Invalid Employee ID");
		ms.closeDB();
	}
	public void create_NewEmp(Model_object_layer mol1) throws SQLException, IOException
	{
		ms.initDB();
		int count = ms.insert(mol1);
		
		if(count > 0)
			System.out.println("Employee Profile Created");
		else
			System.out.println("Error whil Creating Employee Profile");
		ms.closeDB();
	}
	public void editEmpProfileByemp_id(int emp_id,String start_date,String end_date,String role,
			String dept,String status,String rep_mgr,String address) throws SQLException,IOException
	{
		ms.initDB();
		int count = ms.update(emp_id,start_date, end_date,role,
        		dept,status,rep_mgr,address);
		
		if(count > 0)
			System.out.println("Employee Profile updated with Employee_id"+emp_id);
		else
			System.out.println("Error while updating Employee Profile with Employee_id"+emp_id);
		ms.closeDB();
	}
	public void deleteEmpProfileByemp_id(int entEmp_id) throws SQLException,IOException
	{
         ms.initDB();
		int count = ms.deleteByemp_id(entEmp_id);
		
		if(count > 0)
			System.out.println("Employee Profile DELETED with Employee_id"+entEmp_id);
		else
			System.out.println("Error while deleting Employee Profile with Employee_id"+entEmp_id);
		ms.closeDB();
	  }
	public void deleteEntiremp_Details() throws SQLException,IOException
	{
         ms.initDB();
		int count = ms.deleteAll();
		if(count > 0)
			System.out.println("All Employee Profiles DELETED");
		else
			System.out.println("Error while deleting Employee Details");
		ms.closeDB();
	  }
	public void showAllEmpDetails() throws SQLException,IOException
	{
	    ms.initDB();
	    Set<Model_object_layer> mol  = ms.getAllEmployeesSortByfirst_name();
	    mol.forEach(Employees -> System.out.println(Employees));
		ms.closeDB();
	}
	public void search_emp(int emp_id) throws SQLException, IOException
	{
		HashMap<Integer,Model_object_layer>  empTable= ms.getEmpTable();
		Model_object_layer mol = empTable.get(emp_id);
		if(mol!=null)
		{
	     System.out.println("Employee found from Result Cache Table");   ///Caching
		 //System.out.println(mol);		 
		}
		else
		{
			 ms.initDB();
			 Model_object_layer mol1=ms.getEmpByemp_id(emp_id);
			 ms.closeDB();
			 if(mol1!=null)
			 {
			 System.out.println("Employee found from DB");
			// System.out.println(mol1);
			 }
			 else
				 System.out.println("Employee not found");
		}
	}
	
	public void logout() throws SQLException
	{
	  ms.closeDB();
	}
	}