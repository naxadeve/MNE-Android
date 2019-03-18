
package org.odk.collect.android.myapplication.activitygroup.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Activity {

    @SerializedName("activity_group")
    @Expose
    private Integer activityGroup;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("target_number")
    @Expose
    private Integer targetNumber;
    @SerializedName("target_unit")
    @Expose
    private String targetUnit;
    @SerializedName("start_date")
    @Expose
    private String startDate;
    @SerializedName("end_date")
    @Expose
    private String endDate;
    @SerializedName("id_string")
    @Expose
    private String form;
    @SerializedName("target_complete")
    @Expose
    private Boolean targetComplete;
    @SerializedName("beneficiary_level")
    @Expose
    private Boolean beneficiaryLevel;
    @SerializedName("published")
    @Expose
    private Boolean published;
    @SerializedName("target_met")
    @Expose
    private Boolean targetMet;

    public Integer getActivityGroup() {
        return activityGroup;
    }

    public void setActivityGroup(Integer activityGroup) {
        this.activityGroup = activityGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTargetNumber() {
        return targetNumber;
    }

    public void setTargetNumber(Integer targetNumber) {
        this.targetNumber = targetNumber;
    }

    public String getTargetUnit() {
        return targetUnit;
    }

    public void setTargetUnit(String targetUnit) {
        this.targetUnit = targetUnit;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public Boolean getTargetComplete() {
        return targetComplete;
    }

    public void setTargetComplete(Boolean targetComplete) {
        this.targetComplete = targetComplete;
    }

    public Boolean getBeneficiaryLevel() {
        return beneficiaryLevel;
    }

    public void setBeneficiaryLevel(Boolean beneficiaryLevel) {
        this.beneficiaryLevel = beneficiaryLevel;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public Boolean getTargetMet() {
        return targetMet;
    }

    public void setTargetMet(Boolean targetMet) {
        this.targetMet = targetMet;
    }

}
