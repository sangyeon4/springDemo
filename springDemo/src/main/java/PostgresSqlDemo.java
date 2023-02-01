import java.sql.*;
import java.util.ArrayList;

public class PostgresSqlDemo {
    private static Connection conn = null;
    public static void closeConnection(){
        if(conn != null){
            try{
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    public static Connection getConnection(){
        if(conn == null){
            try{
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "anstkddus0614");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return conn;
    }

    public void add(){
        String sql = "INSERT INTO test VALUES(?,?)";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            String name = "문상연";
            int age = 24;
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<String> select(){
        ArrayList list = new ArrayList<>();
        String sql = "select * from test";
        ResultSet rs = null;
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString(1);
                int age = rs.getInt(2);
                list.add(name);
                list.add(age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public void update(){
        String sql = "update test set name = '지센문상연' where age = ? ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            int age = 24;
            ps.setInt(1, age);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete(){
        String sql = "delete from test where name = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            String name = "지센문상연";
            ps.setString(1, name);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
