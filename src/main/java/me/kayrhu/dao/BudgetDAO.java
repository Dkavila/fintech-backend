package me.kayrhu.dao;

import me.kayrhu.model.BudgetCategory;
import me.kayrhu.model.BudgetModel;
import org.springframework.context.annotation.Bean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BudgetDAO {

    BudgetDAO(){}
    public static boolean deleteBudget(int id) {
        String sql = "DELETE FROM t_sif_orcamento WHERE cd_orcamento = " + id;
        boolean deleted = false;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM96045", "031201");
            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery(sql);
            deleted = true;
            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found!");
        } catch (Exception e){
            System.out.println("Error 404");
            e.printStackTrace();
        }
        return deleted;
    }

    public static BudgetModel getBudget(int id){
        String sql = "SELECT * FROM t_sif_orcamento WHERE cd_orcamento = " + id;
        BudgetModel budgetModel = new BudgetModel();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM96045", "031201");
            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery(sql);
            if(result.next()) {
                budgetModel = new BudgetModel(
                        id,
                        result.getInt("cd_usuario"),
                        result.getFloat("vl_orcamento"),
                        BudgetCategory.valueOf(result.getString("in_categoria")),
                        result.getDate("dt_orcamento"),
                        result.getString("tx_descricao")
                );
            }
            connection.close();

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found!");
        } catch (Exception e){
            System.out.println("Error 404");
            e.printStackTrace();
        }

        return budgetModel;
    }

    public static List<BudgetModel> getAllBudgets(int userCode){
        String sql = "SELECT * FROM t_sif_orcamento WHERE cd_usuario = " + userCode;
        List budgets = new ArrayList<BudgetModel>();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM96045", "031201");
            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                BudgetModel budgetModel = new BudgetModel(
                        result.getInt("cd_orcamento"),
                        result.getInt("cd_usuario"),
                        result.getFloat("vl_orcamento"),
                        BudgetCategory.valueOf(result.getString("in_categoria")),
                        result.getDate("dt_orcamento"),
                        result.getString("tx_descricao")
                );
                budgets.add(budgetModel);
            }
            connection.close();

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found!");
        } catch (Exception e){
            System.out.println("Error 404");
            e.printStackTrace();
        }

        return budgets;

    }

    public static BudgetModel insertBudget(BudgetModel budgetModel) {
        String sql = "INSERT INTO t_sif_orcamento(cd_orcamento, cd_usuario, vl_orcamento, dt_orcamento, in_categoria, tx_descricao)" +
                    " VALUES (t_sif_sequence_orcamento.NEXTVAL, ?, ?, ?, ?, ?)";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM96045", "031201");
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, budgetModel.getUserCode());
            statement.setFloat(2, budgetModel.getbudgetValue());
            statement.setDate(3, UtilsDAO.convertToSQLDate(budgetModel.getbudgetDate()));
            statement.setString(4, budgetModel.getCategory().toString());
            statement.setString(5, budgetModel.getDescription());

            statement.execute();

            connection.close();

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found!");
        } catch (Exception e){
            System.out.println("Error 404");
            e.printStackTrace();
        }

        return budgetModel;
    }

    public static BudgetModel updateBudget(BudgetModel budgetModel){
        String sql = "UPDATE t_sif_orcamento SET" +
                " cd_usuario = " + budgetModel.getUserCode() +
                " vl_orcamento = " + budgetModel.getbudgetValue() +
                " dt_orcamento = " + UtilsDAO.convertToSQLDate(budgetModel.getbudgetDate()) +
                " in_categoria = " + budgetModel.getCategory() +
                " tx_descricao = " + budgetModel.getDescription() +
                " WHERE cd_usuario = " + budgetModel.getBudgetId();
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM96045", "031201");
            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery(sql);
            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found!");
        } catch (Exception e){
            System.out.println("Error 404");
            e.printStackTrace();
        }
        return budgetModel;
    }
}
