package develop.gym.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Customer customer;
    @Column(name = "SUBSCRIPTION_TYPE")
    private String subscriptionType;
    @Column(name = "SUBSCRIPTION_PERIOD")
    private String subscriptionPeriod;
    @Column(name = "COST_PER_MONTH")
    private double costPerMonth;
    @Column(name = "GROUP_TRAINING")
    private boolean groupTrainingIncluded;
    @Column(name = "SUBSCRIPTION_STATUS")
    private String subscriptionStatus;

    public Subscription(Customer customer, String subscriptionType, String subscriptionPeriod, double costPerMonth, boolean groupTrainingIncluded, String subscriptionStatus) {
        this.customer = customer;
        this.subscriptionType = subscriptionType;
        this.subscriptionPeriod = subscriptionPeriod;
        this.costPerMonth = costPerMonth;
        this.groupTrainingIncluded = groupTrainingIncluded;
        this.subscriptionStatus = subscriptionStatus;
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

    public String getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(String subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public String getSubscriptionPeriod() {
        return subscriptionPeriod;
    }

    public void setSubscriptionPeriod(String subscriptionPeriod) {
        this.subscriptionPeriod = subscriptionPeriod;
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

    public String getSubscriptionStatus() {
        return subscriptionStatus;
    }

    public void setSubscriptionStatus(String subscriptionStatus) {
        this.subscriptionStatus = subscriptionStatus;
    }
}
