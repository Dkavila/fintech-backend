package me.kayrhu.model;

import java.util.Date;

public class BudgetModel {
    private int budgetId;
    private int userCode;
    private float budgetValue;
    private Date budgetDate;
    private String description;
    private BudgetCategory category;

    public BudgetModel(){}

    public BudgetModel(int userCode, float budgetValue, BudgetCategory category, Date budgetDate, String description) {
        this.budgetId = -1;
        this.userCode = userCode;
        this.budgetValue = budgetValue;
        this.budgetDate = budgetDate;
        this.description = description;
    }

    public BudgetModel(int budgetId, int userCode, float budgetValue, BudgetCategory category, Date budgetDate, String description) {
        this.budgetId = budgetId;
        this.userCode = userCode;
        this.budgetValue = budgetValue;
        this.budgetDate = budgetDate;
        this.description = description;
    }

    public BudgetCategory getCategory() {
        return category;
    }

    public void setCategory(BudgetCategory category) {
        this.category = category;
    }

    public int getBudgetId() {
        return budgetId;
    }

    public void setBudgetId(int budgetId) {
        this.budgetId = budgetId;
    }

    public int getUserCode() {
        return userCode;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public float getbudgetValue() {
        return budgetValue;
    }

    public void setbudgetValue(float budgetValue) {
        this.budgetValue = budgetValue;
    }

    public Date getbudgetDate() {
        return budgetDate;
    }

    public void setbudgetDate(Date budgetDate) {
        this.budgetDate = budgetDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "budgetModel{" +
                "budgetId=" + budgetId +
                "userCode=" + userCode +
                "budgetValue=" + budgetValue +
                ", budgetDate=" + budgetDate +
                ", description='" + description + '\'' +
                '}';
    }
}