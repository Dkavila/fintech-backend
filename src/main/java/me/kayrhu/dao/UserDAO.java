package me.kayrhu.dao;

import me.kayrhu.model.UserModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    UserDAO(){}

    public static List<UserModel> getAllUsers(){
        String sql = "SELECT * FROM t_sif_usuario";
        List users = new ArrayList<UserModel>();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM96045", "031201");
            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                UserModel budgetModel = new UserModel(
                        result.getInt("cd_usuario"),
                        result.getString("nm_completo"),
                        result.getString("nm_usuario"),
                        result.getDate("dt_nascimento"),
                        result.getString("tp_genero"),
                        result.getString("tx_emaill"),
                        result.getString("tx_senha")
                );
                users.add(budgetModel);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found!");
        } catch (Exception e){
            System.out.println("Error 404");
            e.printStackTrace();
        }

        return users;

    }
    public static boolean deleteUser(int id) {
        String sql = "DELETE FROM t_sif_usuario WHERE cd_usuario = " + id;
        boolean deleted = false;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM96045", "031201");
            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery(sql);
            connection.close();
            deleted = true;
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found!");
        } catch (Exception e){
            System.out.println("Error 404");
            e.printStackTrace();
        }
        return deleted;
    }

    public static UserModel getUser(int id){
        String sql = "SELECT * FROM t_sif_usuario WHERE cd_usuario = " + id;
        UserModel user = new UserModel();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM96045", "031201");
            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery(sql);
            if(result.next()) {
                user = new UserModel(
                        id,
                        result.getString("nm_completo"),
                        result.getString("nm_usuario"),
                        result.getDate("dt_nascimento"),
                        result.getString("tp_genero"),
                        result.getString("tx_emaill"),
                        result.getString("tx_senha")
                );
            }

            connection.close();

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found!");
        } catch (Exception e){
            System.out.println("Error 404");
            e.printStackTrace();
        }

        return user;
    }

    public static UserModel verifyUser(String email, String password){
        String sql = "SELECT * FROM t_sif_usuario WHERE 'tx_emaill' = '" + email + "' AND tx_senha = '" + password + "'";
        UserModel user = new UserModel();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM96045", "031201");
            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery(sql);
            if (result.next()){
                user = new UserModel(
                        result.getInt("cd_usuario"),
                        result.getString("nm_completo"),
                        result.getString("nm_usuario"),
                        result.getDate("dt_nascimento"),
                        result.getString("tp_genero"),
                        result.getString("tx_emaill"),
                        result.getString("tx_senha")
                );
            }

            connection.close();

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found!");
        } catch (Exception e){
            System.out.println("Error 404");
            e.printStackTrace();
        }

        return user;

    }

    public static boolean insertUser(UserModel user) {
        String sql = "INSERT INTO t_sif_usuario(cd_usuario, nm_completo, nm_usuario, dt_nascimento, tp_genero, tx_emaill, tx_senha)" +
                " VALUES (t_sif_sequence_usuario.NEXTVAL, ?, ?, ?, ?, ?, ?)";
        boolean success = false;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM96045", "031201");
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, user.getUserName());
            statement.setString(2, user.getNickName());
            statement.setDate(3, UtilsDAO.convertToSQLDate(user.getBirthDate()));
            statement.setString(4, user.getGender());
            statement.setString(5, user.getEmail());
            statement.setString(6, user.getPassword());

            success = statement.execute();

            connection.close();

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found!");
        } catch (Exception e){
            System.out.println("Error 404");
            e.printStackTrace();
        }

        return success;
    }

}