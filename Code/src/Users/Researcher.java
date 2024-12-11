package Users;

import java.util.Collections;
import java.util.Date;
import Research.ResearchPaper;
import Research.ResearchProject;
import Comparators.ArticleLengthComparator;
import Comparators.PublishedDateComparator;
import Database.Data;
import Exceptions.ImposterException;
import Exceptions.NoSuchFormatException;

public class Researcher extends User{

	public Researcher(String login, String password, String name, String surname, String id) {
		super(login, password, name, surname, id);
	}
	
	public String toString() {
		return super.toString();
	}
	
	public boolean equals(Object o) {
	        if(!super.equals(o)) return false;
	     
	        Researcher r = (Researcher)o;
	        return this.getLogin().equals(r.getLogin()) && this.getPassword().equals(r.getPassword());
	}
	 
	Data database = new Data();
	 
	public void makeResearchPaper(String topic, Date date, int pages, String publisher, String authors) {
		 ResearchPaper paper = new ResearchPaper(topic, date, pages, publisher, authors);
		 database.papers.add(paper);
	}
	 
	public void printPapersByArticleLength() {
		ArticleLengthComparator c = new ArticleLengthComparator();
		Collections.sort(database.papers, c);
		System.out.println(database.papers);
	} 
	
	public void printPapersByPublishedDate() {
		PublishedDateComparator c = new PublishedDateComparator();
		Collections.sort(database.papers, c);
		System.out.println(database.papers);
	}
	
	public void joinParticipant(User u) throws ImposterException {
		ImposterException.checkParticipant(u);
		Researcher r = (Researcher) u;
		database.participants.add(r);
	}
	
	public void viewParticipantsOfProject() {
		System.out.println(database.participants);
	}
	
}
