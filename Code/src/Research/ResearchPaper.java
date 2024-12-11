package Research;

import java.io.Serializable;
import java.util.Date;

import Exceptions.NoSuchFormatException;

public class ResearchPaper implements Comparable<ResearchPaper>, Serializable{
	private String topic;
	private Date date;
	private int pages;
	private String publisher;
	private String authors;
	
	public ResearchPaper(String topic, Date date, int pages, String publisher, String authors) {
		super();
		this.topic = topic;
		this.date = date;
		this.pages = pages;
		this.publisher = publisher;
		this.authors = authors;
	}
	
	public String toString() {
		return "ResearchPaper [topic=" + topic + ", date=" + date + ", pages=" + pages + ", publisher=" + publisher
				+ ", authors=" + authors + "] \n";
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public String getCitation(String format) {
        if (format.equalsIgnoreCase("Plain Text")) {
            return String.format("%s, %s, %s, %d citations, %d pages, %s", 
                                 authors, title, journal, citations, pages, publicationDate);
        } else if (format.equalsIgnoreCase("Bibtex")) {
            return String.format("@article{%s, author = {%s}, title = {%s}, journal = {%s}, year = {%tY}}", 
                                 title, authors, title, journal, publicationDate);
        } else {
            throw new NoSuchFormatException("Unsupported format. Use 'Plain Text' or 'Bibtex'.");
        }
    }
	
	public int compareTo(ResearchPaper o) {
		if(this.getPages() > o.getPages()) return 1;
		if(this.getPages() < o.getPages()) return -1;
		return 0;
	}
	
}
