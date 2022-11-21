package me.kayrhu.model;

import java.util.Date;

public class FinancialObjectiveModel {
    private int financialObjectiveId;
    private int userCode;
    private String objectiveName;
    private float objectiveValue;
    private String description;
    private Date objectiveGoal;

    public FinancialObjectiveModel(){}

    public FinancialObjectiveModel(int financialObjectiveId, int userCode, String objectiveName, float objectiveValue, String description, Date objectiveGoal) {
        this.financialObjectiveId = financialObjectiveId;
        this.userCode = userCode;
        this.objectiveName = objectiveName;
        this.objectiveValue = objectiveValue;
        this.description = description;
        this.objectiveGoal = objectiveGoal;
    }

    public int getFinancialObjectiveId() {
        return financialObjectiveId;
    }

    public void setFinancialObjectiveId(int financialObjectiveId) {
        this.financialObjectiveId = financialObjectiveId;
    }

    public int getUserCode() {
        return userCode;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public String getObjectiveName() {
        return objectiveName;
    }

    public void setObjectiveName(String objectiveName) {
        this.objectiveName = objectiveName;
    }

    public float getObjectiveValue() {
        return objectiveValue;
    }

    public void setObjectiveValue(float objectiveValue) {
        this.objectiveValue = objectiveValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getObjectiveGoal() {
        return objectiveGoal;
    }

    public void setObjectiveGoal(Date objectiveGoal) {
        this.objectiveGoal = objectiveGoal;
    }

    @Override
    public String toString() {
        return "FinancialObjectiveModel{" +
                "userCode='" + userCode + '\'' +
                "objectiveName='" + objectiveName + '\'' +
                ", objectiveValue=" + objectiveValue +
                ", description='" + description + '\'' +
                ", objectiveGoal=" + objectiveGoal +
                '}';
    }
}