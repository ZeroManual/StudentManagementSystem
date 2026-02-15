package com.student.app;

public class Main {

	public static void main(String[] args) {
		System.out.println("********* Student Management System *********");
		System.out.println("********* Welcome ********* ");
		
		Student s1;
		s1 = new Student("Sameer Ahmed",26,"S-12");
		s1.enrollCourse("Java");
		s1.enrollCourse("DSA");
		s1.enrollCourse("c#");
		
		s1.printStudentInfo();
		//System.out.println(s1);
		
		Student s2 = new Student("Adil", 19,"S-23");
		s2.enrollCourse("Java");
		//System.out.println(s2);
		s2.printStudentInfo();
		
		Student s3 = new Student("Suhail", 27,"S-33");
		s2.enrollCourse("Devops");
		//System.out.println(s3);
		s3.printStudentInfo();
	}

}
