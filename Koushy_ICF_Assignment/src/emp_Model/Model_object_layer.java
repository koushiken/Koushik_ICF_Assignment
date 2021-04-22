package emp_Model;
public class Model_object_layer extends Object implements Comparable<Model_object_layer> {
		private int id;            //NO INSERTION
		private int emp_id;       //NO INSERTION
		private String first_name;  //1
		private String last_name;   //2
		private String start_date;  //3
		private String end_date;    //4
		private String role;        //5
		private String dept;		//6
		private String status;		//7
		private String dob;			//8
		private String rep_mgr;		//9
		private String gender;		//10
		private String blood_grp;	//11
		private String address;		//12
		
		public Model_object_layer()
		{
			
		}
		public Model_object_layer(String first_name, String last_name, String start_date, String end_date, String role,
				String dept, String status, String dob, String rep_mgr, String gender, String blood_grp,
				String address) //for accessing Model storage instantaneously
		{
			super();
			this.first_name = first_name;
			this.last_name = last_name;
			this.start_date = start_date;
			this.end_date = end_date;
			this.role = role;
			this.dept = dept;
			this.status = status;
			this.dob = dob;
			this.rep_mgr = rep_mgr;
			this.gender = gender;
			this.blood_grp = blood_grp;
			this.address = address;
		}
		public int getId() {
			return id;
		}
		public int getEmp_id() {
			return emp_id;
		}
		
		public String getFirst_name() {
			return first_name;
		}
		public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}
		public String getLast_name() {
			return last_name;
		}
		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}
		public String getStart_date() {
			return start_date;
		}
		public void setStart_date(String start_date) {
			this.start_date = start_date;
		}
		public String getEnd_date() {
			return end_date;
		}
		public void setEnd_date(String end_date) {
			this.end_date = end_date;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public String getDept() {
			return dept;
		}
		public void setDept(String dept) {
			this.dept = dept;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getDob() {
			return dob;
		}
		public void setDob(String dob) {
			this.dob = dob;
		}
		public String getRep_mgr() {
			return rep_mgr;
		}
		public void setRep_mgr(String rep_mgr) {
			this.rep_mgr = rep_mgr;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getBlood_grp() {
			return blood_grp;
		}
		public void setBlood_grp(String blood_grp) {
			this.blood_grp = blood_grp;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		@Override
		public int hashCode() {
			
			return id;
		}
		@Override
		public boolean equals(Object obj) {
			Model_object_layer m1=(Model_object_layer)obj;  //Downcasting
			Integer emp_id=m1.getEmp_id(); //stored in DB
			Integer emp_id1=this.emp_id;  //passed from Front End
			boolean b1=emp_id.equals(emp_id1);   //Comparision purpose during login and getting a user through emp_id
			return b1;
		}
		@Override
		public int compareTo(Model_object_layer mod_obj) //data flowing from front end
		{
		Model_object_layer u1 = mod_obj;
		
		String e1 = u1.getFirst_name();
		String e2 = this.first_name;
		
		int res = e1.compareTo(e2);   //Data will be sorted according to alphabetical order when retrieved from TreeSet
		return res;
	}
}
