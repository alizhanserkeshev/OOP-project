package Research;

import java.util.Date;

class ResearchPaper {
    private String title;
    private String authors;
    private String journal;
    private int citations;
    private int pages;
    private Date publicationDate;

    public ResearchPaper(String title, String authors, String journal, int citations, int pages, Date publicationDate) {
        this.title = title;
        this.authors = authors;
        this.journal = journal;
        this.citations = citations;
        this.pages = pages;
        this.publicationDate = publicationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public int getCitations() {
        return citations;
    }

    public void setCitations(int citations) {
        this.citations = citations;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getCitation(String format) {
        if (format.equalsIgnoreCase("Plain Text")) {
            return String.format("%s, %s, %s, %d citations, %d pages, %s", 
                                 authors, title, journal, citations, pages, publicationDate);
        } else if (format.equalsIgnoreCase("Bibtex")) {
            return String.format("@article{%s, author = {%s}, title = {%s}, journal = {%s}, year = {%tY}}", 
                                 title, authors, title, journal, publicationDate);
        } else {
            throw new IllegalArgumentException("Unsupported format. Use 'Plain Text' or 'Bibtex'.");
        }
    }

    @Override
    public String toString() {
        return "ResearchPaper{" +
               "title='" + title + '\'' +
               ", authors='" + authors + '\'' +
               ", journal='" + journal + '\'' +
               ", citations=" + citations +
               ", pages=" + pages +
               ", publicationDate=" + publicationDate + '}';
    }
}
