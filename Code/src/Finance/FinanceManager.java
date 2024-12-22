package Finance;

import java.sql.Date;
import java.util.Vector;

import Enums.EmployeePost;
import Users.Employee;

class FinanceManager extends Employee {

    private String email;
    private String department;
    private Vector<Report> reports;

    public FinanceManager(String login, String password, String name, String surname, String id, EmployeePost post, int salary, Date hireDate, String email, String department) {
        super(login, password, name, surname, id, post, salary, hireDate);
        this.email = email;
        this.department = department;
        this.reports = new Vector<>();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
    public Vector<Report> getReports() {
        return reports;
    }
    
    public void addReport(Report report) {
        reports.add(report);
    }

    public void analyzeReports() {
        for (Report report : reports) {
            System.out.println("Analyzing report: " + report.getTitle());
        }
    }

    public void managePayment(String employeeId, double amount) {
        System.out.println("Processing payment of " + amount + " for employee ID: " + employeeId);
    }

    public void createPaymentPlan(String employeeId, boolean isApproved) {
        if (isApproved) {
            System.out.println("Payment plan created for employee ID: " + employeeId);
        } else {
            System.out.println("Payment plan creation failed for employee ID: " + employeeId);
        }
    }
}
