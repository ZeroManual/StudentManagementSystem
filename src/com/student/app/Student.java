package com.student.app;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {

	String name;
	int age;
	String StudentId;
	List<String> courses;

	public Student(String name, int age, String studentId) {
		super();
		if (validateAge(age) && validateName(name) && validateStudentId(studentId)) {
			this.name = name;
			this.age = age;
			this.StudentId = studentId;
			courses = new ArrayList<String>();// Initialization of courses!!
		}
	}

	private boolean validateStudentId(String studentId) {
		String studentIdRegex = "S-[0-9]+$";// S-123
		Pattern studentIdPattern = Pattern.compile(studentIdRegex);
		Matcher studentIdMatcher = studentIdPattern.matcher(studentId);
		if (studentIdMatcher.matches()) {
			return true;
		} else {
			System.err.println("Invalid Student Id.. use the format S-123");
		}
		return false;

	}

	public void enrollCourse(String course) {
		if(validateCourseName(course)) {
		if (!courses.contains(course)) {
			courses.add(course);
			System.out.println("Student enrolled to " + course + " Successfully!!");
			
		} else {
			System.err.println("Student is already enrolled in to the course " + course);
		}
	}
	}

	public void printStudentInfo() {
		System.out.println(" ========== Student Information  ==========  ");
		System.out.println("Student Name: " + name);
		System.out.println("Student Age: " + age);
		System.out.println("Student Id: " + StudentId);
		System.out.println("Enrolled For: " + courses);
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", StudentId=" + StudentId + ", courses=" + courses + "]";
	}
	// Validation methods

	public boolean validateAge(int age) {

		if (age >= 19 && age <= 35) {
			return true;
		} else {
			System.err.println("Invalid age!!! Student age needs to be between 19 and 35");
			return false;
		}
	}

	public boolean validateName(String name) {
		// sameer, here ^ denotes that the name which is a string is starting with
		// alphabets both Upper and lower
		// and can have spaces in between the name which is acheieved by //s
		// and the name can have firstName, lastName and surname which are like
		// combinations and can be achieved by
		// + sign and ending of regex should always be with $ symbol
		String nameRegex = "^[a-zA-Z\\s]+$";
		Pattern namePattern = Pattern.compile(nameRegex);
		Matcher nameMatcher = namePattern.matcher(name);

		if (nameMatcher.matches()) {

			return true;
		} else {
			System.err.println("Invalid name please enter Alphabets only");
			return false;
		}

	}
	
	public boolean validateCourseName(String course) {
		if(course.equalsIgnoreCase("Java") || course.equalsIgnoreCase("DSA") || course.equalsIgnoreCase("Devops")) 
		{
			return  true;
		}
		else {
			System.err.println("Invalid cousrse name please select courses from the list!! [Java,DSA,Devops]");
			return false;
		}
		
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getStudentId() {
		return StudentId;
	}

	public List<String> getCourses() {
		return courses;
	}
	
	
	
	
	
	
}
