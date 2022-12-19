package db;

import java.sql.*;

public class DataBase {
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String login = "postgres";
    private static final String password = "Jashtykketty";

    public static Connection connection(){
        Connection connect = null;
        try {
            connect = DriverManager.getConnection(url,login,password);
            System.out.println("connected to the postgres succesfully");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return connect;
    }
    public static void createTable() throws SQLException {
        Connection connect = connection();
        Statement statement = connect.createStatement();
        String SQL = "CREATE TABLE IF NOT EXISTS developers" +
                "(id  INTEGER NOT NULL," +
                "name VARCHAR (50)," +
                "salary INTEGER NOT NULL," +
                "PRIMARY KEY (id))";
        statement.executeUpdate(SQL);
        System.out.println("Table successfully created");
    }
    public static void  addDeveloper(int id,String name, int salary) {
        String SQL = "insert into developers(id,name,salary) values(?,?,?)";
        try (Connection connect = connection();
        PreparedStatement statement = connect.prepareStatement(SQL)){
            statement.setInt(1,id);
            statement.setString(2,name);
            statement.setInt(3,salary);
            statement.executeUpdate();
            System.out.println(name + "successfully added");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void getAllDevelopers(){
        String SQL = "SELECT * FROM Developers";
        try (Connection connect = connection();
        Statement statement = connect.createStatement();
        ResultSet resultSet = statement.executeQuery(SQL)){
            while (resultSet.next()){
                System.out.println(resultSet.getInt("id")+ " " +
                        resultSet.getString("name") + " "+
                        resultSet.getInt("salary"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
