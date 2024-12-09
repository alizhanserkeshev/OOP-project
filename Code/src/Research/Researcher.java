package Research;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Researcher {
    private String name;
    private String title; 
    private int hIndex;
    private List<ResearchPaper> researchPapers;
    private List<ResearchProject> researchProjects;

    public Researcher(String name, String title) {
        this.name = name;
        this.title = title;
        this.hIndex = 0; 
        this.researchPapers = new ArrayList<>();
        this.researchProjects = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getHIndex() {
        return hIndex;
    }

    public void addResearchPaper(ResearchPaper paper) {
        this.researchPapers.add(paper);
        calculateHIndex();
    }

    public void addResearchProject(ResearchProject project) {
        this.researchProjects.add(project);
    }

    public void printPapers(Comparator<ResearchPaper> comparator) {
        List<ResearchPaper> sortedPapers = new ArrayList<>(researchPapers);
        sortedPapers.sort(comparator);

        System.out.println("Research papers for " + name + " (" + title + "):");
        for (ResearchPaper paper : sortedPapers) {
            System.out.println(paper);
        }
    }

    public void calculateHIndex() {
        List<Integer> citations = new ArrayList<>();
        for (ResearchPaper paper : researchPapers) {
            citations.add(paper.getCitations());
        }
        Collections.sort(citations, Collections.reverseOrder());

        int h = 0;
        for (int i = 0; i < citations.size(); i++) {
            if (citations.get(i) >= i + 1) {
                h = i + 1;
            } else {
                break;
            }
        }
        this.hIndex = h;
    }

    public void printResearchProjects() {
        System.out.println("Research projects for " + name + " (" + title + "):");
        for (ResearchProject project : researchProjects) {
            System.out.println(project);
        }
    }

    @Override
    public String toString() {
        return "Researcher{" +
               "name='" + name + '\'' +
               ", title='" + title + '\'' +
               ", hIndex=" + hIndex +
               ", researchPapers=" + researchPapers +
               ", researchProjects=" + researchProjects +
               '}';
    }
}
