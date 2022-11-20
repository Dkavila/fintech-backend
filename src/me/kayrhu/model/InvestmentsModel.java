package src.me.kayrhu.model;

import java.util.Date;

public class InvestmentsModel {
    private int investmentId;
    private int userCode;
    private String financialApplicant;
    private float applicantValue;
    private String bank;
    private Date investmentDate;
    private Date investmentDueDate;

    public InvestmentsModel(){}

    public InvestmentsModel(int investmentId, int userCode, String financialApplicant, float applicantValue, String bank, Date investment, Date investmentDueDate) {
        this.investmentId = investmentId;
        this.userCode = userCode;
        this.financialApplicant = financialApplicant;
        this.applicantValue = applicantValue;
        this.bank = bank;
        this.investmentDate = investment;
        this.investmentDueDate = investmentDueDate;
    }

    public int getInvestmentId() {
        return investmentId;
    }

    public void setInvestmentId(int investmentId) {
        this.investmentId = investmentId;
    }

    public int getUserCode() {
        return userCode;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public String getFinancialApplicant() {
        return financialApplicant;
    }

    public void setFinancialApplicant(String financialApplicant) {
        this.financialApplicant = financialApplicant;
    }

    public float getApplicantValue() {
        return applicantValue;
    }

    public void setApplicantValue(float applicantValue) {
        this.applicantValue = applicantValue;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public Date getInvestmentDate() {
        return investmentDate;
    }

    public void setInvestment(Date investment) {
        this.investmentDate = investment;
    }

    public Date getInvestmentDueDate() {
        return investmentDueDate;
    }

    public void setInvestmentDueDate(Date investmentDueDate) {
        this.investmentDueDate = investmentDueDate;
    }

    @Override
    public java.lang.String toString() {
        return "InvestmentsModel{" +
                "investmentId='" + investmentId + '\'' +
                "userCode='" + userCode + '\'' +
                "financialApplicant='" + financialApplicant + '\'' +
                ", applicantValue=" + applicantValue +
                ", bank='" + bank + '\'' +
                ", investment=" + investmentDate +
                ", investmentDueDate=" + investmentDueDate +
                '}';
    }
}