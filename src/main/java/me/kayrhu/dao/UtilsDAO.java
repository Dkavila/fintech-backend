package me.kayrhu.dao;

public class UtilsDAO {
    public static java.sql.Date convertToSQLDate(java.util.Date date){
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        return sqlDate;
    }
}
