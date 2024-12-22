package Finance;

import java.util.Date;
import Enums.OrderType;
import Users.Employee;

public class Report {

    private String title;
    private String content;
    private String idFrom;
    private Date date;
    private String status; 
    private OrderType type;
    private Employee handler;

    public Report(String title, String content, String idFrom, Date date, OrderType type, Employee handler) {
        this.title = title;
        this.content = content;
        this.idFrom = idFrom;
        this.date = date;
        this.type = type;
        this.handler = handler;
        this.status = "pending"; 
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public OrderType getReportType() {
        return type;
    }

    public void setReportType(OrderType type) {
        this.type = type;
    }

    public Employee getHandler() {
        return handler;
    }

    public void setHandler(Employee handler) {
        this.handler = handler;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (status.equals("pending") || status.equals("approved") || status.equals("rejected")) {
            this.status = status;
        } else {
            throw new IllegalArgumentException("Invalid status: " + status);
        }
    }

    @Override
    public String toString() {
        return "Report{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", idFrom='" + idFrom + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", type=" + type +
                ", handler=" + handler +
                '}';
    }
}
