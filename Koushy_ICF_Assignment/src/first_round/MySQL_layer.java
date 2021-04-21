import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

import first_round.Model_object_layer;

public class MySQL_layer implements MyDAO_API_crud_layer {
	
	private String url;
	private String dbname;
	private String dbusername;
	private String dbuserpwd;
	private Statement stmt;
	private PreparedStatement pms;
	private Connection con;

	private String insertEmp = "insert into usersdb.icfdb values(?,?,?,?,?,?,?,?,?,?,?,?)";  //CREATE
	private String getEmpInfo = "select * from usersdb.icfdb where emp_id = ?";              //READ
	private String getAllEmpInfo = "select * from usersdb.icfdb";                          //READ ALL
	private String editEmpDetailsByfirst_name="update usersdb.icfdb set start_date=?,"
			+ "end_date=?,role=?,dept=?,status=?,rep_mgr=?,address=? where first_name=?";       //UPDATE
	
	private String deleteEmpDetailsByemp_id = "delete from usersdb.icfdb where emp_id = ?";     //DELETE
	private String deleteAllEmpDetails="truncate table usersdb.icfdb";                         //DELETE ALL
	
	@Override
	public void initDB() throws SQLException, IOException {
		
		Properties dbProps = new Properties();
		
		String path = "/Users/koushik/git/Koushik_ICF_Assignment/DBConfigPropertiesFile";
		
		FileInputStream fis = new FileInputStream(path);
		
		dbProps.load(fis);
		
		url = dbProps.getProperty("url","");
		dbname = dbProps.getProperty("dbname","");
		dbusername = dbProps.getProperty("dbusername","");
		dbuserpwd = dbProps.getProperty("dbuserpwd","");
		
		con = DriverManager.getConnection(url + dbname, dbusername, dbuserpwd);
		stmt = con.createStatement();
	}
	@Override
	public int insert(Model_object_layer mol) throws SQLException {
		pms = con.prepareStatement(insertEmp);
		int i=1;
		pms.setInt(1, i++);
		pms.setInt(2,1251);
		pms.setString(3,  mol.getFirst_name());
		pms.setString(4,  mol.getLast_name());
		pms.setString(5,  mol.getStart_date());
		pms.setString(6,  mol.getEnd_date());
		pms.setString(7,  mol.getRole());
		pms.setString(8,  mol.getDept());
		pms.setString(9,  mol.getStatus());
		pms.setString(10, mol.getDob());
		pms.setString(11, mol.getRep_mgr());
		pms.setString(12, mol.getGender());
		pms.setString(13, mol.getBlood_grp());
		pms.setString(14, mol.getAddress());
		
		int count = pms.executeUpdate();

		return count; //returns a countable value>0 if insertion done.
	}
	@Override
	public Model_object_layer getEmpByemp_id(String emp_id) throws SQLException {
		
		pms = con.prepareStatement(getEmpInfo);
		pms.setString(2, emp_id);

		ResultSet rs = pms.executeQuery();
		rs.next();

		Model_object_layer mol1 = new Model_object_layer();
	
		mol1.setFirst_name(rs.getString(3));
		mol1.setLast_name(rs.getString(4));
		mol1.setStart_date(rs.getString(5));
		mol1.setEnd_date(rs.getString(6));
		mol1.setRole(rs.getString(7));
		mol1.setDept(rs.getString(8));
		mol1.setStatus(rs.getString(9));
		mol1.setDob(rs.getString(10));
		mol1.setRep_mgr(rs.getString(11));
		mol1.setGender(rs.getString(12));
		mol1.setBlood_grp(rs.getString(13));
		mol1.setAddress(rs.getString(14));

		return u1;
		return Model_object_layer;
	}
	@Override
	public Set<Model_object_layer> getAllEmployeesSortByfirst_name() throws SQLException {
		
		return Set<Model_object_layer>;
	}
	@Override
	public int update(Model_object_layer mol) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int deleteByemp_id(Model_object_layer first_name) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void closeDB() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	

}

