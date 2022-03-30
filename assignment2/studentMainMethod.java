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
			
			System.out.print("1. Save data to database \n2. Get data from database \nPlease choose: ");
			int choose = scan.nextInt();
			
			if(choose == 1) {
				
				//Get data from user
				System.out.println("\nInsert student data");
				System.out.print("Student ID: ");
				int studentId = scan.nextInt();
				
				System.out.print("Name: ");
				String name = scan.next();
				
				System.out.print("Department: ");
				String department = scan.next();
				
				System.out.print("Math mark: ");
				int mathMark = scan.nextInt();
				
				System.out.print("Science mark: ");
				int scienceMark = scan.nextInt();
				
				//Send data to Controller class
				controller.saveData(studentId, name, department, mathMark, scienceMark);
				
			}else if(choose == 2) {
				
				//Get student id from user
				System.out.print("\nEnter student id: ");
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
