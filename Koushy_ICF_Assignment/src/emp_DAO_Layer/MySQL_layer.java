package emp_DAO_Layer;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

import emp_Model.Model_object_layer;

public class MySQL_layer implements MyDAO_API_crud_layer {
	
	private String url;
	private String dbname;
	private String dbusername;
	private String dbuserpwd;
	private Statement stmt;
	private PreparedStatement pms;
	private Connection con;

	private String insertEmp = "insert into usersdb.icfdb values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";  //CREATE
	private String getEmpInfo = "select * from usersdb.icfdb where emp_id = ?";              //READ
	private String getAllEmpInfo = "select * from usersdb.icfdb";                          //READ ALL
	private String editEmpDetailsByemp_id="update usersdb.icfdb set start_date=?,end_date=?,role=?,dept=?,status=?,rep_mgr=?,address=? where emp_id=?";       //UPDATE
	
	private String deleteEmpDetailsByemp_id = "delete from usersdb.icfdb where emp_id = ?";     //DELETE
	private String deleteAllEmpDetails="truncate table usersdb.icfdb";                         //DELETE ALL
	
	private HashMap<Integer,Model_object_layer> empTable = new HashMap<Integer,Model_object_layer>();
	
	
	public HashMap<Integer,Model_object_layer> getEmpTable()
	{
		return empTable;
	}
	
	@Override
	public void initDB() throws SQLException, IOException {
		
		Properties dbProps1 = new Properties();
		
		String path1 = "/Users/koushik/git/Koushik_ICF_Assignment/Koushy_ICF_Assignment/DBConfigPropertiesFile";
		
		FileInputStream fis1 = new FileInputStream(path1);
		
		dbProps1.load(fis1);
		
		url = dbProps1.getProperty("url","");
		dbname = dbProps1.getProperty("dbname","");
		dbusername = dbProps1.getProperty("dbusername","");
		dbuserpwd = dbProps1.getProperty("dbuserpwd","");
		
		con = DriverManager.getConnection(url + dbname, dbusername, dbuserpwd);
		stmt = con.createStatement();
	}
	@Override
	public int insert(Model_object_layer mol) throws SQLException {
		pms = con.prepareStatement(insertEmp);
		pms.setInt(1, mol.getId());
		pms.setInt(2, mol.getEmp_id());
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
	public Model_object_layer getEmpByemp_id(int emp_id) throws SQLException {
		
		pms = con.prepareStatement(getEmpInfo);
		pms.setInt(1, emp_id);

		ResultSet rs = pms.executeQuery();
		rs.next();

		Model_object_layer mol1 = new Model_object_layer();
		
		mol1.setId(rs.getInt(1));
		mol1.setEmp_id(rs.getInt(2));
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

		return mol1;
	}
	@Override
	public Set<Model_object_layer> getAllEmployeeSortby_first_name() throws SQLException {
			pms=con.prepareStatement(getAllEmpInfo);
			ResultSet rs=pms.executeQuery();
			Set<Model_object_layer> mol_set=new TreeSet<Model_object_layer>();
			while (rs.next()) 
			{
				int columnIndex = 1;

				Model_object_layer mol = new Model_object_layer();
				
				mol.setId(rs.getInt(columnIndex));
				mol.setEmp_id(rs.getInt(columnIndex++));
				mol.setFirst_name(rs.getString(columnIndex++));  //3
				mol.setLast_name(rs.getString(columnIndex++)); //4
				mol.setStart_date(rs.getString(columnIndex++));  //5
				mol.setEnd_date(rs.getString(columnIndex++));  //6
				mol.setRole(rs.getString(columnIndex++)); //7
				mol.setDept(rs.getString(columnIndex++)); //8
				mol.setStatus(rs.getString(columnIndex++)); //9
				mol.setDob(rs.getString(columnIndex++)); //10
				mol.setRep_mgr(rs.getString(columnIndex++)); //11
				mol.setGender(rs.getString(columnIndex++));  //12
				mol.setBlood_grp(rs.getString(columnIndex++)); //13
				mol.setAddress(rs.getString(columnIndex++)); //14
				mol_set.add(mol);
			}
			return mol_set;
		}
	@Override
	public int update(int emp_id,String start_date,String end_date,String role,String dept,String status,String rep_mgr,String address) throws SQLException {
			pms = con.prepareStatement(editEmpDetailsByemp_id);
			pms.setInt(8,emp_id);
			pms.setString(1,start_date);
			pms.setString(2,end_date);
			pms.setString(3,role);
			pms.setString(4,dept);
			pms.setString(5,status);
			pms.setString(6,rep_mgr);
			pms.setString(7,address);
			int count  = pms.executeUpdate();
			return count;
	}
	@Override
	public int deleteByemp_id(int emp_id) throws SQLException {
		pms = con.prepareStatement(deleteEmpDetailsByemp_id);
		pms.setInt(1,emp_id);
		int count  = pms.executeUpdate();
		return count;
	}
	@Override
	public void deleteAll() throws SQLException {
		pms = con.prepareStatement(deleteAllEmpDetails);
		pms.executeUpdate();
	}
	@Override
	public void closeDB() throws SQLException {
		con.close();
		
	}
}

