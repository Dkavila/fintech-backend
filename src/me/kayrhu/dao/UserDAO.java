package src.me.kayrhu.dao;

import src.me.kayrhu.model.UserModel;

import java.sql.*;

public class UserDAO {

    public static boolean deleteUser(int id) {
        String sql = "DELETE FROM t_sif_usuario WHERE cd_usuario = " + id;
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

    public static UserModel getUser(int id){
        String sql = "SELECT * FROM t_sif_usuario WHERE cd_usuario = " + id;
        UserModel user = new UserModel();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM96045", "031201");
            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery(sql);

            user = new UserModel(
                    id,
                    result.getString("nm_completo"),
                    result.getString("nm_usuario"),
                    result.getDate("dt_nascimento"),
                    result.getString("tp_gender"),
                    result.getString("tx_email"),
                    result.getString("tx_senha")
            );

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found!");
        } catch (Exception e){
            System.out.println("Error 404");
            e.printStackTrace();
        }

        return user;
    }

    public static boolean verifyUser(String email, String password){
        String sql = "SELECT * FROM t_sif_usuario WHERE tx_email = " + email + " AND tx_senha = " + password;
        boolean userExists = false;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM96045", "031201");
            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery(sql);

            userExists = result.next();

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found!");
        } catch (Exception e){
            System.out.println("Error 404");
            e.printStackTrace();
        }

        return userExists;

    }

    public static UserModel insertUser(UserModel user) {
        String sql = "INSERT INTO t_sif_usuario(cd_usuario, nm_completo, nm_usuario, dt_nascimento, tp_genero, tx_emaill, tx_senha)" +
                " VALUES (t_sif_sequence_usuario.NEXTVAL, ?, ?, ?, ?, ?, ?)";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM96045", "031201");
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, user.getUserName());
            statement.setString(2, user.getNickName());
            statement.setDate(3, (Date)user.getBirthDate());
            statement.setString(4, user.getGender());
            statement.setString(5, user.getEmail());
            statement.setString(6, user.getPassword());

            statement.execute();

            connection.close();

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found!");
        } catch (Exception e){
            System.out.println("Error 404");
            e.printStackTrace();
        }

        return user;
    }

}