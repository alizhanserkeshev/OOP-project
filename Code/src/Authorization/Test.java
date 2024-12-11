package Authorization;
import java.sql.Date;

import java.util.Map.Entry;
import java.util.Vector;

import Database.Data;
import Users.*;
import Enums.*;
import SystemParts.*;



public class Test {

	public static void main(String[] args) throws Exception {
		Admin admin = new Admin("admin", "777", "alizhan", "Serkeshev", "22B030441", EmployeePost.ADMIN, 124000, Date.valueOf("2023-03-22"));
		
		User u = new Researcher("salman", "1234", "Salmahodga", "Madaminov", "23B031355");
		
		User u1 = new Researcher("ruslan", "1234", "Ruslan", "Baidaev", "23B031237");

		admin.addUser(u, "777");
		admin.addUser(u1, "777");
		Data.database.users.add(new Researcher("login1", "password1", "name1", "surname1", "id1"));
		Data.database.users.add(new Researcher("login1", "password1", "name2", "surname2", "id1"));
		Data.database.serialize(Data.database);

		Data deserializedData = Data.database.deserialize();
		System.out.println(deserializedData.deserialize());

		Session session = new Session();
		session.login(admin.showDatabase(), "salman", "1234");

		Researcher currentUser = (Researcher) session.getCurrentUser();
		System.out.println(currentUser);
		
		
		//Checking for news
		
//		NewsSection newsSection = new NewsSection();
//		News newsLessonPostponed = new News("LESSON POSTPONED, Hangi", "Because of my business trip, tomorrow lessons will " +
//				"be postponed to unknown date", Date.valueOf("2023-12-25"), NewsType.PPONE);
//		News newsSomeRes = new News("RESEAAAARCH!", "Some research happened, go check", Date.valueOf("2023-12-23"), NewsType.RES);
//		newsSection.addNews(newsLessonPostponed);
//		newsSection.addNews(newsSomeRes);
//		newsSection.writeComment(newsSomeRes, "WOW, what a news about some research!", "Azamat", Date.valueOf("2023-12-24"));
//		newsSection.writeComment(newsLessonPostponed, "Ok", "Anonim", Date.valueOf("2023-12-25"));
//		newsSection.writeComment(newsSomeRes, "Cool research", "Tramp", Date.valueOf("2023-12-25"));
//		newsSection.viewNews();
		
		
		
		//User u2 = new Manager("salman", "1111", "Salmahodga", "Madaminov", "23B031355", EmployeePost.MANAGER, 78000, Date.valueOf("2023-01-02"), ManagerType.OFFICE_REGISTRATION);
		//admin.addUser(u2, "777");
		
		
		//Session session = new Session();
		//session.login(admin.showDatabase() , "salman", "1111");
		//Manager currentUser = (Manager)session.getCurrentUser();
		
		//currentUser.addCourses(new Course("OOP", "CSCI2106", 5, Faculty.SITE, CourseType.MAJOR));
		//System.out.println(currentUser.getCourses());

		//session.logout();
		//currentUser = (Manager) session.getCurrentUser();
		//System.out.println(currentUser);


		//System.out.println("System of mark is starting");
		//Mark firstAttestationMark = new Mark();
		//firstAttestationMark.setType(AttestationType.FIRST);
		//firstAttestationMark.defineMark(25);
		//System.out.println("First Attestation Mark: " + firstAttestationMark);


		//Mark secondAttestationMark = new Mark();
		//secondAttestationMark.setType(AttestationType.SECOND);
		//secondAttestationMark.defineMark(32);
		//System.out.println("Second Attestation Mark: " + secondAttestationMark);

		//Mark finalExamMark = new Mark();
		//finalExamMark.setType(AttestationType.EXAM);
		//finalExamMark.defineMark(30);
		//System.out.println("Final Exam Mark: " + finalExamMark);


		//double totalGrade = firstAttestationMark.addGrade() + secondAttestationMark.addGrade() + finalExamMark.addGrade();
		//System.out.println("Total Grade: " + totalGrade);

		//Mark overallMark = new Mark();
		//overallMark.defineMark(totalGrade);
		//overallMark.transformMark();
		//System.out.println("Overall GPA: " + overallMark.getGpa());
		//System.out.println("Letter of GPA" + " " + overallMark.getIteralMark());
		
		
		//Admin admin2 = new Admin("admin", "777", "Alizhan", "Serkeshev", "22B030441", EmployeePost.ADMIN, 777007, Date.valueOf("2023-03-22"));

		//Teacher teacher = new Teacher("teacher1", "password", "Alice", "Smith", "T456", EmployeePost.TEACHER, 50000, new Date(11, 11, 11), "Computer Science", TeacherRank.LECTURER, 4.5);

		//admin2.addUser(teacher, "777");

		//Session session2 = new Session();

		//session2.login(admin2.showDatabase(), "teacher1", "password");

		//Course course = new Course("Programming 101", "CS101", 1, Faculty.SITE, CourseType.MAJOR);

		//Student student = new Student("student1", "password", "John", "Doe", "S123", 19, Degree.BACHELOR, 2, "Computer Science", Faculty.SITE, 3.5, "Good standing", null, 11);
		//course.teaches(teacher);
		//student.registerToCourse(course);
		//double point = 25;
		//AttestationType type = AttestationType.FIRST;
		//teacher.putMark(course, student, point, type);
		//System.out.println("Student's Marks:");
		//for (Entry<Course, Mark> entry : student.getMarks().entrySet()) {
			//Course courseEntry = entry.getKey();
			//Mark markEntry = entry.getValue();
			//System.out.println("Course: " + courseEntry.getName() + ", Mark: " + markEntry);
	//	}	

		//session2.logout();
		//currentUser.makeResearchPaper("Clean Code", Date.valueOf("2023-03-03"), 50, "AlmatyKitap", "pakita");
		//currentUser.makeResearchPaper("Retake", Date.valueOf("2023-01-03"), 40, "Atamura", "pakita");
		//currentUser.printPapersByPublishedDate();
		//currentUser.printPapersByArticleLength();
		//currentUser.getCitation(0, "Bibtex");
		//currentUser.joinParticipant(u1);
		//currentUser.viewParticipantsOfProject();
		//session.logout();
		//currentUser = (Researcher) session.getCurrentUser();
		//System.out.println(currentUser);

}
	
}

