package com.gym.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gym.entity.Customer;
import com.gym.entity.Subscription;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SubscriptionDto {

    @JsonProperty("subscriptionType")
    private String subscriptionType;
    @JsonProperty("subscriptionPeriod")
    private String subscriptionPeriod;
    @JsonProperty("costPerMonth")
    private double costPerMonth;
    @JsonProperty("groupTrainingIncluded")
    private boolean groupTrainingIncluded;
    @JsonProperty("subscriptionStatus")
    private String subscriptionStatus;

    public SubscriptionDto(String subscriptionType, String subscriptionPeriod, double costPerMonth, boolean groupTrainingIncluded, String subscriptionStatus) {
        this.subscriptionType = subscriptionType;
        this.subscriptionPeriod = subscriptionPeriod;
        this.costPerMonth = costPerMonth;
        this.groupTrainingIncluded = groupTrainingIncluded;
        this.subscriptionStatus = subscriptionStatus;
    }

    public SubscriptionDto() {
    }

    public static Subscription convertToEntity(Customer customer, SubscriptionDto subscriptionDto) {
        if (subscriptionDto != null) {
            return new Subscription(customer,
                    subscriptionDto.getSubscriptionType(),
                    subscriptionDto.getSubscriptionPeriod(),
                    subscriptionDto.getCostPerMonth(),
                    subscriptionDto.isGroupTrainingIncluded(),
                    subscriptionDto.getSubscriptionStatus());
        }
        return null;
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
