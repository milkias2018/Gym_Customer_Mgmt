package develop.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "BOOKING")
public class Booking implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID")
    private UUID id;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private GroupTraining groupTraining;
    @Column(name = "QUEUE_NUMBER")
    private int queueNumber;
    @Column(name = "DATE")
    private LocalDate date;
    @Column(name = "TIME_FROM")
    private LocalDate timeFrom;
    @Column(name = "TIME_UNTIL")
    private LocalDate timeUntil;

    public Booking(UUID id, Customer customer, GroupTraining groupTraining, int queueNumber, LocalDate date, LocalDate timeFrom, LocalDate timeUntil) {
        this.id = id;
        this.customer = customer;
        this.groupTraining = groupTraining;
        this.queueNumber = queueNumber;
        this.date = date;
        this.timeFrom = timeFrom;
        this.timeUntil = timeUntil;
    }

    public Booking() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public GroupTraining getGroupTraining() {
        return groupTraining;
    }

    public void setGroupTraining(GroupTraining groupTraining) {
        this.groupTraining = groupTraining;
    }

    public int getQueueNumber() {
        return queueNumber;
    }

    public void setQueueNumber(int queueNumber) {
        this.queueNumber = queueNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(LocalDate timeFrom) {
        this.timeFrom = timeFrom;
    }

    public LocalDate getTimeUntil() {
        return timeUntil;
    }

    public void setTimeUntil(LocalDate timeUntil) {
        this.timeUntil = timeUntil;
    }
}
