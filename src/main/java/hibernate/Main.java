package hibernate;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import hibernate.utils.HibernateUtils;

public class Main {
			public static void main(String [] args) {
				 Scanner sc = new Scanner(System.in);
				SessionFactory sfactory = HibernateUtils.getSessionFactory();
		
				StudentOperations sto = new StudentOperations(sfactory);
//				sto.createStudent();
//			    sto.DeleteStudent();
//				sto.updateStudent();
//				sto.DisplayStudent();
//				sfactory.close();
				
				while(true) {
				System.out.println(  "\n Enter an Option : \n 1. Create student \n 2. Update Student \n 3. Delete Student \n 4. DisplayStudent ");
				System.out.println("\n");
				int opt = sc.nextInt();
				switch(opt) {
				case 1:
					sto.createStudent();
					break;
				case 2 :
					sto.updateStudent();
					break;
				case 3 : 
					sto.DeleteStudent();
					break;
				case 4 : 
					sto.DisplayStudent();
					break;
					default : 
						break;
				}
				}
					
				
			
			}		
}
