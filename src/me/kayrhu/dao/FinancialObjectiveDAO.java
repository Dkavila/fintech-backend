package src.me.kayrhu.dao;

import src.me.kayrhu.model.FinancialObjectiveModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FinancialObjectiveDAO {
    public static boolean deleteFinancialObjective(int id) {
        String sql = "DELETE FROM t_sif_objetivos_financeiros WHERE cd_objetivo_financeiro = " + id;
        boolean deleted = false;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM96045", "031201");
            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery(sql);
            deleted = true;
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found!");
        } catch (Exception e){
            System.out.println("Error 404");
            e.printStackTrace();
        }
        return deleted;
    }

    public static FinancialObjectiveModel getFinancialObjective(int id){
        String sql = "SELECT * FROM t_sif_objetivos_financeiros WHERE cd_objetivo_financeiro = " + id;
        FinancialObjectiveModel financialObjective = new FinancialObjectiveModel();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM96045", "031201");
            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery(sql);

            financialObjective = new FinancialObjectiveModel(
                    id,
                    result.getInt("cd_usuario"),
                    result.getString("nm_objetivo"),
                    result.getFloat("vl_objetivo"),
                    result.getString("tx_descricao"),
                    result.getDate("dt_meta_objetivo")
            );

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found!");
        } catch (Exception e){
            System.out.println("Error 404");
            e.printStackTrace();
        }

        return financialObjective;
    }

    public static List<FinancialObjectiveModel> getAllFinancialObjectives(int userCode){
        String sql = "SELECT * FROM t_sif_objetivos_financeiros WHERE cd_usuario = " + userCode;
        List financialObjectives = new ArrayList<FinancialObjectiveModel>();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM96045", "031201");
            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                FinancialObjectiveModel financialObjective = new FinancialObjectiveModel(
                        result.getInt("cd_objetivo_financeiro"),
                        result.getInt("cd_usuario"),
                        result.getString("nm_objetivo"),
                        result.getFloat("vl_objetivo"),
                        result.getString("tx_descricao"),
                        result.getDate("dt_meta_objetivo")
                );
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found!");
        } catch (Exception e){
            System.out.println("Error 404");
            e.printStackTrace();
        }

        return financialObjectives;

    }

    public static FinancialObjectiveModel insertFinancialObjective(FinancialObjectiveModel financialObjective) {
        String sql = "INSERT INTO t_sif_objetivos_financeiros(cd_objetivo_financeiro, cd_usuario, nm_objetivo, vl_objetivo, tx_descricao, dt_meta_objetivo)" +
                    " VALUES (t_sif_sequence_objetivos_financeiros.NEXTVAL, ?, ?, ?, ?, ?)";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM96045", "031201");
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, financialObjective.getUserCode());
            statement.setString(2, financialObjective.getObjectiveName());
            statement.setFloat(3, financialObjective.getObjectiveValue());
            statement.setString(4, financialObjective.getDescription());
            statement.setDate(5, (Date)financialObjective.getObjectiveGoal());

            statement.execute();

            connection.close();

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found!");
        } catch (Exception e){
            System.out.println("Error 404");
            e.printStackTrace();
        }

        return financialObjective;
    }

    public static FinancialObjectiveModel updateFinancialObjective(FinancialObjectiveModel financialObjective){
        String sql = "UPDATE t_sif_objetivos_financeiros SET" +
                " cd_usuario = " + financialObjective.getUserCode() +
                " nm_objetivo = " + financialObjective.getObjectiveName() +
                " vl_objetivo = " + financialObjective.getObjectiveValue() +
                " tx_descricao = " + financialObjective.getDescription() +
                " dt_meta_objetivo = " + financialObjective.getObjectiveGoal() +
                " WHERE cd_usuario = " + financialObjective.getUserCode();
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM96045", "031201");
            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery(sql);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found!");
        } catch (Exception e){
            System.out.println("Error 404");
            e.printStackTrace();
        }
        return financialObjective;
    }
}
