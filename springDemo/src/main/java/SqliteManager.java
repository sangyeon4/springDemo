import java.sql.SQLException;
public class SqliteManager {

    public static void main(String[] args) throws SQLException {
        SqliteDemo manager = new SqliteDemo();

        manager.getConnection();
        manager.add();
        System.out.println(manager.select());
        manager.update();
        manager.delete();

        manager.closeConnection();      // 연결 해제// 재연결
    }


}
