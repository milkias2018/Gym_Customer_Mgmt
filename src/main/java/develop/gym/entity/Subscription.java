package develop.gym.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SUBSCRIPTIONS")
public class Subscription implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID")
    private String id;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Customer customer;
    @Column(name = "MEMBERSHIP_TYPE")
    private String membershipType;
    @Column(name = "MEMBERSHIP_PERIOD")
    private String membershipPeriod;
    @Column(name = "COST_PER_MONTH")
    private double costPerMonth;
    @Column(name = "GROUP_TRAINING")
    private boolean groupTrainingIncluded;
    @Column(name = "MEMBERSHIP_STATUS")
    private String membershipStatus;

    public Subscription(String id, Customer customer, String membershipType, String membershipPeriod, double costPerMonth, boolean groupTrainingIncluded, String membershipStatus) {
        this.id = id;
        this.customer = customer;
        this.membershipType = membershipType;
        this.membershipPeriod = membershipPeriod;
        this.costPerMonth = costPerMonth;
        this.groupTrainingIncluded = groupTrainingIncluded;
        this.membershipStatus = membershipStatus;
    }

    public Subscription() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public String getMembershipPeriod() {
        return membershipPeriod;
    }

    public void setMembershipPeriod(String membershipPeriod) {
        this.membershipPeriod = membershipPeriod;
    }

    public double getCostPerMonth() {
        return costPerMonth;
    }

    public void setCostPerMonth(double costPerMonth) {
        this.costPerMonth = costPerMonth;
    }

    public boolean isGroupTrainingIncluded() {
        return groupTrainingIncluded;
    }

    public void setGroupTrainingIncluded(boolean groupTrainingIncluded) {
        this.groupTrainingIncluded = groupTrainingIncluded;
    }

    public String getMembershipStatus() {
        return membershipStatus;
    }

    public void setMembershipStatus(String membershipStatus) {
        this.membershipStatus = membershipStatus;
    }
}
