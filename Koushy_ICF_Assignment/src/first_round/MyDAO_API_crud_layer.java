package first_round;


	import java.io.IOException;
	import java.sql.SQLException;
	import java.util.List;
	import java.util.Set;

	import first_round.User_Model_Service_Layer;

	public interface MyDAO_API_crud_layer {
	   public void initDB()throws SQLException,IOException;
	   
	   public int insert(Model_object_layer mol)throws SQLException;
	   
	   public int update(Model_object_layer mol)throws SQLException;
	
	   public int deleteByemp_id(Model_object_layer first_name)throws SQLException;
	   
	   public Model_object_layer getEmpByemp_id(String Email)throws SQLException;
	   
	   public Set<Model_object_layer> getAllEmployeesSortByfirst_name() throws SQLException;
	   
	   public void closeDB()throws SQLException;
	}
