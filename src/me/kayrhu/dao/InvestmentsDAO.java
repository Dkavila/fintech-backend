package src.me.kayrhu.dao;

import src.me.kayrhu.model.InvestmentsModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvestmentsDAO {
    public static boolean deleteInvestment(int id) {
        String sql = "DELETE FROM t_sif_investimentos WHERE cd_investimento = " + id;
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

    public static InvestmentsModel getInvestment(int id){
        String sql = "SELECT * FROM t_sif_orcamento WHERE cd_orcamento = " + id;
        InvestmentsModel investment = new InvestmentsModel();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM96045", "031201");
            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery(sql);

            investment = new InvestmentsModel(
                    id,
                    result.getInt("cd_usuario"),
                    result.getString("nm_aplicacao_financeira"),
                    result.getFloat("vl_aplicacao"),
                    result.getString("nm_banco"),
                    result.getDate("dt_investimento"),
                    result.getDate("dt_vencimento_investimento")
            );

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found!");
        } catch (Exception e){
            System.out.println("Error 404");
            e.printStackTrace();
        }

        return investment;
    }

    public static List<InvestmentsModel> getAllInvestments(int userCode){
        String sql = "SELECT * FROM t_sif_investimentos WHERE cd_usuario = " + userCode;
        List investments = new ArrayList<InvestmentsModel>();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM96045", "031201");
            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                InvestmentsModel investment = new InvestmentsModel(
                        result.getInt("cd_investimento"),
                        result.getInt("cd_usuario"),
                        result.getString("nm_aplicacao_financeira"),
                        result.getFloat("vl_investimento"),
                        result.getString("nm_banco"),
                        result.getDate("dt_investimento"),
                        result.getDate("dt_vencimento_investimento")
                );
                investments.add(investment);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found!");
        } catch (Exception e){
            System.out.println("Error 404");
            e.printStackTrace();
        }

        return investments;

    }

    public static InvestmentsModel insertInvestment(InvestmentsModel investment) {
        String sql = "INSERT INTO t_sif_investimentos(cd_investimento, cd_usuario, nm_aplicacao_financeira, vl_aplicacao, nm_banco, dt_investimento, dt_vencimento_investimento)" +
                    " VALUES (t_sif_sequence_investimentos.NEXTVAL, ?, ?, ?, ?, ?, ?)";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM96045", "031201");
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, investment.getUserCode());
            statement.setFloat(2, investment.getApplicantValue());
            statement.setString(3, investment.getFinancialApplicant());
            statement.setString(4, investment.getBank());
            statement.setDate(5, (Date)investment.getInvestmentDate());
            statement.setDate(6, (Date)investment.getInvestmentDueDate());

            statement.execute();

            connection.close();

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found!");
        } catch (Exception e){
            System.out.println("Error 404");
            e.printStackTrace();
        }

        return investment;
    }

    public static InvestmentsModel updateInvestment(InvestmentsModel investment){
        String sql = "UPDATE t_sif_investimentos SET" +
                " cd_usuario = " + investment.getUserCode() +
                " nm_aplicacao_financeira = " + investment.getFinancialApplicant() +
                " dt_investimento = " + investment.getInvestmentDate() +
                " dt_vencimento_investimento = " + investment.getInvestmentDueDate() +
                " nm_banco = " + investment.getBank() +
                " vl_aplicacao = " + investment.getApplicantValue() +
                " WHERE cd_usuario = " + investment.getUserCode();
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
        return investment;
    }
}
