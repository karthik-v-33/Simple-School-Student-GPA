package BasicShowJDBC;

import java.sql.*;

public class SchoolDemo {

	public static void main(String[] args) throws Exception {
		//readRecord();
		//insertRecord();
		//insertVarRecord();
		//insertUsingPst();
		//delete();
		//update();
		//storedProcedure3();
		//autoCommitDemo();
		batchCommit();
	}
	// it is for display
	public static void readRecord() throws Exception {
		String url = "jdbc:mysql://localhost:3306/SchoolDemo";
		String userName = "root";
		String password = "3310";
		String query = "select * from Students;";
		Connection con = DriverManager.getConnection(url, userName, password);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);

		while (rs.next()) {
			System.out.println("Id : " + rs.getInt(1));
			System.out.println("Name : " + rs.getString(2));
			System.out.println("GPA : " + rs.getDouble(3));
		}
		con.close();
	}
	// insert values
	/*
	 * public static void insertRecord() throws Exception { 
	 * String url ="jdbc:mysql://localhost:3306/SchoolDemo"; 
	 * String userName = "root"; 
	 * String password = "3310"; 
	 * String query ="insert into Students values (6,'Ajay',9.2);"; 
	 * Connection con =DriverManager.getConnection(url, userName, password); 
	 * Statement st =con.createStatement(); 
	 * int row = st.executeUpdate(query);
	 * System.out.println("Number of rows added : " + row); 
	 * con.close(); }
	 */
	
	// insertvar values
	/*public static void insertVarRecord() throws Exception {
		String url = "jdbc:mysql://localhost:3306/SchoolDemo";
		String userName = "root";
		String password = "3310";
		int id = 7;
		String name = "Vishnu";
		double gpa = 9.5;
		String query = "insert into Students values (" + id + ",'" + name + "'," + gpa + ");";
		Connection con = DriverManager.getConnection(url, userName, password);
		Statement st = con.createStatement();
		int row = st.executeUpdate(query);
		System.out.println("Number of rows added : " + row);
		con.close();
	}*/
	
	// insert using prepared statement
	/*public static void insertUsingPst() throws Exception {
		String url = "jdbc:mysql://localhost:3306/SchoolDemo";
		String userName = "root";
		String password = "3310";
		int id = 8;
		String name = "Varun";
		double gpa = 9.3;
		String query = "insert into Students values (?,?,?);";
		Connection con = DriverManager.getConnection(url, userName, password);
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1,id);
		pst.setString(2,name);
		pst.setDouble(3,gpa);
		int row = pst.executeUpdate();
		System.out.println("Number of rows added : " + row);
		con.close();
	}*/
	
	// delete
	/*public static void delete() throws Exception {
		String url = "jdbc:mysql://localhost:3306/SchoolDemo";
		String userName = "root";
		String password = "3310";
		int id =8;
		String query = "delete from Students where std_id="+id;
		Connection con = DriverManager.getConnection(url, userName, password);
		Statement st =con.createStatement(); 
		int row = st.executeUpdate(query);
		System.out.println("Number of rows added : " + row); 
		con.close();
	}*/
	
	// update
	/*public static void update() throws Exception {
		String url = "jdbc:mysql://localhost:3306/SchoolDemo";
		String userName = "root";
		String password = "3310";
		String query = "update Students set gpa = 9.8 where std_id = 7";
		Connection con = DriverManager.getConnection(url, userName, password);
		Statement st =con.createStatement(); 
		int row = st.executeUpdate(query);
		System.out.println("Number of rows added : " + row); 
		con.close();
	}*/
	
	// stored procedure without parameter
	/*public static void storedProcedure() throws Exception {
		String url = "jdbc:mysql://localhost:3306/SchoolDemo";
		String userName = "root";
		String password = "3310";
		Connection con = DriverManager.getConnection(url, userName, password);
		CallableStatement cst = con.prepareCall("{call stdStudents()}");
		ResultSet rs = cst.executeQuery();

		while (rs.next()) {
			System.out.println("Id : " + rs.getInt(1));
			System.out.println("Name : " + rs.getString(2));
			System.out.println("GPA : " + rs.getDouble(3));
		}
		con.close();
	}*/
	
	// stored procedure with parameter
	/*public static void storedProcedure2() throws Exception {
		String url = "jdbc:mysql://localhost:3306/SchoolDemo";
		String userName = "root";
		String password = "3310";
		int id = 1;
		Connection con = DriverManager.getConnection(url, userName, password);
		CallableStatement cst = con.prepareCall("{call stdStudentsById(?)}");
		cst.setInt(1, id);
		ResultSet rs = cst.executeQuery();
		
		while (rs.next()) {
			System.out.println("Id : " + rs.getInt(1));
			System.out.println("Name : " + rs.getString(2));
			System.out.println("GPA : " + rs.getDouble(3));
		}
		con.close();
	}*/
	
	// stored procedure with parameter to get name
	/*public static void storedProcedure3() throws Exception {
		String url = "jdbc:mysql://localhost:3306/SchoolDemo";
		String userName = "root";
		String password = "3310";
		int id = 1;
		Connection con = DriverManager.getConnection(url, userName, password);
		CallableStatement cst = con.prepareCall("{call stdNameById(?,?)}");
		cst.setInt(1, id);
		cst.registerOutParameter(2, Types.VARCHAR);
		cst.executeUpdate();
		System.out.println(cst.getString(2));
		
		con.close();
	}*/
	
	// commit and autocommit
	// when no commit is mentioned autocommit will execute and even one statement is correct it will execute.
	// when autocommit is set to false it will check and update until everything is clear
	// autocommit is set to false means commit is also should be there other wise code will a trash
	/*
	 * public static void commitDemo() throws Exception {
		String url = "jdbc:mysql://localhost:3306/SchoolDemo";
		String userName = "root";
		String password = "3310";
		
		String query1 = "update Students set gpa = 9.7 where std_id =1";
		String query2 = "update Students set gpa = 9.7 where std_id =2";
		Connection con = DriverManager.getConnection(url, userName, password);
		Statement st = con.createStatement();
		int row1 = st.executeUpdate(query1);
		System.out.println("Updated row1 : " + row1);
		int row2 = st.executeUpdate(query2);
		System.out.println("Updated row2 : " + row2);
		
		con.close();
	}*/
	
	/*public static void autoCommitDemo() throws Exception {
		String url = "jdbc:mysql://localhost:3306/SchoolDemo";
		String userName = "root";
		String password = "3310";
		
		String query1 = "update Students set gpa = 9.5 where std_id =1";
		// update spelling mistake
		String query2 = "updat Students set gpa = 9.5 where std_id =2";
		Connection con = DriverManager.getConnection(url, userName, password);
		// if one query fails nothing will be updated
		con.setAutoCommit(false);
		Statement st = con.createStatement();
		int row1 = st.executeUpdate(query1);
		System.out.println("Updated row1 : " + row1);
		int row2 = st.executeUpdate(query2);
		System.out.println("Updated row2 : " + row2);
		// if autocommit is set mean sure to set commit also
		if(row1>0 && row2>0)
			con.commit();
		con.close();
	}*/
	
	// batch
	/*public static void batchDemo() throws Exception {
		String url = "jdbc:mysql://localhost:3306/SchoolDemo";
		String userName = "root";
		String password = "3310";
		
		String query1 = "update Students set gpa = 9.5 where std_id =1";
		String query2 = "update Students set gpa = 9.6 where std_id =2";
		String query3 = "update Students set gpa = 9.7 where std_id =3";
		String query4 = "update Students set gpa = 9.8 where std_id =4";
		Connection con = DriverManager.getConnection(url, userName, password);
		Statement st = con.createStatement();
		st.addBatch(query1);
		st.addBatch(query2);
		st.addBatch(query3);
		st.addBatch(query4);
		
		int [] batch = st.executeBatch();
		for(int i : batch) {
			System.out.println("Updated row : " + i);
		}
		con.close();
	}*/
	
	// batch with commit and rollback
	public static void batchCommit() throws Exception {
		String url = "jdbc:mysql://localhost:3306/SchoolDemo";
		String userName = "root";
		String password = "3310";
		
		String query1 = "update Students set gpa = 9.4 where std_id =1";
		String query2 = "update Students set gpa = 9.5 where std_id =2";
		String query3 = "update Students set gpa = 9.5 where std_id =3";
		// update mistake
		String query4 = "updat Students set gpa = 9.6 where std_id =4";
		Connection con = DriverManager.getConnection(url, userName, password);
		con.setAutoCommit(false);
		Statement st = con.createStatement();
		st.addBatch(query1);
		st.addBatch(query2);
		st.addBatch(query3);
		st.addBatch(query4);
		
		int [] batch = st.executeBatch();
		for(int i : batch) {
			if(i>0)
				continue;
			else
				con.rollback();//if query is wrong it will go back to start point
		}
		con.commit();
		con.close();
	}
	
}
