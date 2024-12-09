package Research;

import java.util.ArrayList;
import java.util.List;

class ResearchProject {
    private String topic;
    private List<ResearchPaper> publishedPapers;
    private List<Researcher> participants;

    public ResearchProject(String topic) {
        this.topic = topic;
        this.publishedPapers = new ArrayList<>();
        this.participants = new ArrayList<>();
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public List<ResearchPaper> getPublishedPapers() {
        return publishedPapers;
    }

    public List<Researcher> getParticipants() {
        return participants;
    }

    public void addPaper(ResearchPaper paper) {
        this.publishedPapers.add(paper);
    }

    public void addParticipant(Employee employee) throws ImposterException {
        if (!(employee instanceof Researcher)) {
            throw new ImposterException("Employee is not a Researcher and cannot join the Research Project.");
        }
        participants.add((Researcher) employee);
    }

    public void printParticipants() {
        System.out.println("Participants in project \"" + topic + "\":");
        for (Researcher researcher : participants) {
            System.out.println(researcher.getName());
        }
    }

    public void printPapers() {
        System.out.println("Published papers for project \"" + topic + "\":");
        for (ResearchPaper paper : publishedPapers) {
            System.out.println(paper);
        }
    }

    @Override
    public String toString() {
        return "ResearchProject{" +
               "topic='" + topic + '\'' +
               ", publishedPapers=" + publishedPapers +
               ", participants=" + participants +
               '}';
    }
}
