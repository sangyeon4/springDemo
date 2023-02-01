import java.sql.SQLException;

public class PostgresSqlManager {
    public static void main(String[] args) throws SQLException {
        PostgresSqlDemo manager = new PostgresSqlDemo();

        manager.getConnection();
        manager.add();
        System.out.println(manager.select());
        manager.update();
        //manager.delete();

        manager.closeConnection();      // 연결 해제// 재연결
    }

}
