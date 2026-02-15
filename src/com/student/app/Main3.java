package com.student.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main3 {

	private static List<Student> studentList;

	public static void main(String[] args) {
		System.out.println("********* Student Management System *********");
		System.out.println("********* Welcome ********* ");
		studentList = new ArrayList<Student>();

		Student s1;
		s1 = new Student("Sameer Ahmed", 26, "S-12");
		s1.enrollCourse("Java");
		s1.enrollCourse("DSA");
		s1.enrollCourse("c#");

		Student s2 = new Student("Adil", 19, "S-23");
		s2.enrollCourse("Java");

		Student s3 = new Student("Suhail", 27, "S-33");
		s3.enrollCourse("Devops");

		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		
		Student result =findStudentById("S-33");
		System.out.println("Result " + result);
		sortByName();
	}

	private static void sortByName() {
		Comparator<Student> studentNameComparator = (o1,o2) -> o1.getName().compareTo(o2.getName());
			
			/*
			 * @Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareTo(o2.getName());//Here comparison will happen lexographically
			}
		};
		*
		*/
		
		Collections.sort(studentList,studentNameComparator);
		System.out.println(studentList);
		
	}

	public static Student findStudentById(String studentId) {
		
       Student result =null ;//explicit initialization
       try {
      result = studentList.stream().filter(x ->x.getStudentId().equalsIgnoreCase(studentId)).findFirst()
        .orElseThrow(()-> new RuntimeException("No data found!!!"));
        
        
	}
       catch(RuntimeException e) {
    	   System.err.println("Student with ID "+studentId+" not found!!");
       }
       return result;
       }

}
