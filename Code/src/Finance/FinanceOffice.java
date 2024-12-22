package Finance;

import java.util.Date;
import java.util.Vector;
import Users.Employee;
import Users.Student;
import Enums.OrderType;

public class FinanceOffice {

    private int officeId;
    private int budget;
    private String phoneNumber;
    private FinanceManager manager;

    public FinanceOffice(int officeId, int budget, String phoneNumber, FinanceManager manager) {
        this.officeId = officeId;
        this.budget = budget;
        this.phoneNumber = phoneNumber;
        this.manager = manager;
    }

    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public FinanceManager getManager() {
        return manager;
    }

    public void setManager(FinanceManager manager) {
        this.manager = manager;
    }


    public void managePayments(Student student, int amount) {
        if (budget >= amount) {
            budget -= amount;
            System.out.println("Payment of " + amount + " processed for student: " + student.getName());
        } else {
            System.out.println("Insufficient budget to process payment.");
        }
    }

    public Report prepareReport(String title, String content, Employee sender, OrderType orderType) {
        Date date = new Date();
        Report report = new Report(title, content, sender.getId(), date, orderType, sender);
        System.out.println("Report prepared: " + title);
        return report;
    }

    public boolean handleRetakePayments(Student student, int fee) {
        if (student.getBalance() >= fee) {
            student.setBalance(student.getBalance() - fee);
            budget += fee;
            System.out.println("Retake payment of " + fee + " processed for student: " + student.getName());
            return true;
        } else {
            System.out.println("Insufficient balance for student: " + student.getName());
            return false;
        }
    }

    public boolean verifyRetakeEligibility(Student student) {
        boolean eligible = student.getGpa() >= 2.0;
        System.out.println("Student " + student.getName() + (eligible ? " is eligible " : " is not eligible ") + "for retake.");
        return eligible;
    }

    public void displayOfficeInfo() {
        System.out.println("Finance Office ID: " + officeId);
        System.out.println("Budget: " + budget);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Manager: " + (manager != null ? manager.getName() : "No manager assigned"));
    }
}
