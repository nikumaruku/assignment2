package assignment2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class studentController {

		private static studentModel model = new studentModel();
		private studentView view;
		
		//Constructor
		public studentController(studentModel model, studentView view){
			this.model = model;
			this.view = view;
		}
		
		//Read data from database
		public void readData(int studentId) throws SQLException{       
			
			Connection conn = null;
			
			String connectionURL = "jdbc:mysql://localhost:3306/db1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=TRUE&useSSL=FALSE";
			
			conn = DriverManager.getConnection(connectionURL, "root", "Nikumaruku21");
			
			// create a Statement from the connection
			Statement statement = conn.createStatement();
			
			// Retrieve results from the table
			ResultSet rs = statement.executeQuery ("Select * from studentmarks"); 
			
			// Count columns
			ResultSetMetaData rsmd =rs.getMetaData(); 
			int i =rsmd.getColumnCount( );
					
			// Insert records to Model class
			while(rs.next( ) ) { 
				for(int j=1; j<=i; j++) 
				{ 
					if(Integer.valueOf(rs.getString( 1)) == studentId) {
						if(j == 1)
							model.setId(Integer.valueOf(rs.getString( j)));
						else if(j == 2)
							model.setName(rs.getString( j));
						else if(j == 3)
							model.setDepartment(rs.getString( j));
						else if(j == 4)
							model.setMathMark(Integer.valueOf(rs.getString( j)));
						else if(j == 5)
							model.setScience(Integer.valueOf(rs.getString( j)));
						else if(j == 6)
							model.setBiology(Integer.valueOf(rs.getString( j)));
				}}
			}
			updateView();
		}
		
		//Send data to View class
		public void updateView(){                
	        view.printStudentMarks(model.getId(), model.getName(), model.getDepartment(), model.getMath(), model.getScience(), model.getBiology());
	     }
		
		//Save data to database
		public void saveData(int id, String name, String department, int math, int science, int biology) throws SQLException {
			
			Connection conn = null;
			
			String connectionURL = "jdbc:mysql://localhost:3306/db1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=TRUE&useSSL=FALSE";
			
			conn = DriverManager.getConnection(connectionURL, "root", "Nikumaruku21");
			
			// create a Statement from the connection
			Statement statement = conn.createStatement();
			
			// insert the data into database
			statement.executeUpdate("INSERT INTO studentmarks VALUES (" + id + ", '"+ name + "', '" +
			department + "', " + math + ", " + science + ", " + biology + ")");

	}

}
