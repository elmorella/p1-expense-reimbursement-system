package model;

import javax.persistence.*;

@Entity
@Table(name = "ers_tickets")
public class ErsTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ticket_id", nullable = false)
    private int ticketId;
    private String Category;
    private double amount;
    private String status;
    private int empId;

    public ErsTicket() {
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketNumber(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "ErsTicket{" +
                "ticketId = " + ticketId +
                ", Category = '" + Category + '\'' +
                ", amount = " + amount +
                ", status = '" + status + '\'' +
                ", empId = " + empId +
                '}';
    }
}
