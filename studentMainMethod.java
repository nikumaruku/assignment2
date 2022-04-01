package assignment2;

import java.sql.SQLException;
import java.util.Scanner;

public class studentMainMethod {

		public static void main(String[] args) throws SQLException {
			
			Scanner scan = new Scanner(System.in);
			
			//Initialize M-V-C classes
			studentModel model = new studentModel();
			studentView view = new studentView();
			studentController controller = new studentController(model, view);
			
			System.out.print("1) Save data to database \n2) Get data from database \nSelect Option: ");
			int choose = scan.nextInt();
			
			if(choose == 1) {
				
				//Get data from user
				System.out.println("\nINSERT DATA AS REQUESTED");
				System.out.print("Student ID: ");
				int studentId = scan.nextInt();
				
				System.out.println("Name: ");
				String name = scan.next();
				
				System.out.println("Department: ");
				String department = scan.next();
				
				System.out.println("Math mark: ");
				int mathMark = scan.nextInt();
				
				System.out.println("Science mark: ");
				int scienceMark = scan.nextInt();
				
				System.out.println("Biology mark: ");
				int biologyMark = scan.nextInt();
				
				//Send data to Controller class
				controller.saveData(studentId, name, department, mathMark, scienceMark, biologyMark);
				
			}else if(choose == 2) {
				
				//Get student id from user
				System.out.print("\nINPUT STUDENT ID: ");
				int studId = scan.nextInt();
				
				try {
					//Send student id to Controller class
					controller.readData(studId);
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

	}

}
