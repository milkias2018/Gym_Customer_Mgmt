package develop.gym.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import develop.gym.entity.Membership;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MembershipDto {
    @JsonProperty("id")
    private String id;
    @JsonProperty("membershipType")
    private String membershipType;
    @JsonProperty("membershipPeriod")
    private String membershipPeriod;
    @JsonProperty("costPerMonth")
    private double costPerMonth;
    @JsonProperty("groupTrainingIncluded")
    private boolean groupTrainingIncluded;
    @JsonProperty("membershipStatus")
    private String membershipStatus;

    public MembershipDto(String id, String membershipType, String membershipPeriod, double costPerMonth, boolean groupTrainingIncluded, String membershipStatus) {
        this.id = id;
        this.membershipType = membershipType;
        this.membershipPeriod = membershipPeriod;
        this.costPerMonth = costPerMonth;
        this.groupTrainingIncluded = groupTrainingIncluded;
        this.membershipStatus = membershipStatus;
    }

    public MembershipDto() {
    }

    public static Membership convertToEntity(MembershipDto membershipDto) {
        if (membershipDto != null) {
            Membership membership = new Membership(membershipDto.getId(), membershipDto.getMembershipType(), membershipDto.getMembershipPeriod(), membershipDto.getCostPerMonth(),
                    membershipDto.isGroupTrainingIncluded(), membershipDto.getMembershipStatus());
            return membership;
        }
        return null;
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
