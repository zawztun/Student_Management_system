package hibernate;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import hibernate.entity.Student;

public class StudentOperations {
	private Scanner sc = new Scanner(System.in);
	
	SessionFactory factory;
	
	StudentOperations( SessionFactory sfactory){
		// this.session = sfactory.openSession();
		this.factory = sfactory;
	}

	public void createStudent() {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
	    
		String req = "Y";
		do {
			System.out.println("Enter Student's Name and Studant's Mark : ");
			String name = sc.next();
			int mark = sc.nextInt();
			
		Student st = new Student(name, mark);
		
		Serializable sid = session.save(st);
		
		
       System.out.println("student with student id: " + sid + " saved...");
		
		System.out.print("\ndo you want to save more students[Y/N]: ");
		req = sc.next();
		
		}while(req.equalsIgnoreCase("Y"));
		
		tx.commit();
		session.close();
		
	}
	
	public void updateStudent() {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
	    
		System.out.println("Enter You want to edit Student id , Name , and Mark");
		int id = sc.nextInt();
		String name = sc.next();
		int mark = sc.nextInt();
		
		Student st = new Student(id, name, mark);
		
		session.update(st);
		tx.commit();
		session.close();
		
	}
	
public void DeleteStudent() {
	Session session = factory.openSession();
	Transaction tx = session.beginTransaction();
	System.out.println("Enter You want to Delete Student id , Name , and Mark");
	int id = sc.nextInt();
	String name = sc.next();
	int mark = sc.nextInt();
	
	Student st = new Student(id, name, mark);
	
	Integer studMark = st.getStudentMark();
	
	if(studMark < 35) {
		session.delete(st);
		
		tx.commit();
		session.close();
		System.out.println("student Mark is Under  " + studMark + " Deleted...");	
	}else {
		tx.commit();	
		session.close();	
	}
}


public void DisplayStudent() {
	Session session = factory.openSession();

	Query<Student> q = session.createQuery("FROM Student");
	List<Student> ls = q.list();
	for(Student s : ls){
		System.out.println(s);
	}
	session.close();
	
}

}
