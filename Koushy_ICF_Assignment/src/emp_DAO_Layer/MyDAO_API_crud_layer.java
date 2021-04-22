package emp_DAO_Layer;


	import java.io.IOException;
	import java.sql.SQLException;
	//import java.util.List;
	import java.util.Set;

	import emp_Model.Model_object_layer;

	public interface MyDAO_API_crud_layer {
		
	   public void initDB()throws SQLException,IOException;  //INITIALIZE
	   
	   public int insert(Model_object_layer mol)throws SQLException; //CREATE
	   
	   public Model_object_layer getEmpByemp_id(int emp_id)throws SQLException;  //READ
	   
	   public Set<Model_object_layer> getAllEmployeesSortByfirst_name() throws SQLException;  //READ ALL
	   
	   public int update(int emp_id, String start_date, String end_date, String role, String dept, String status,
				String rep_mgr, String address) throws SQLException; //UPDATE
	
	   public int deleteByemp_id(int emp_id) throws SQLException;  //DELETE
	   
	   public int deleteAll() throws SQLException;//DELETE ALL
	   
	   public void closeDB()throws SQLException;  //CLOSE

	}
