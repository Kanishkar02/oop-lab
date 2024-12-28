package project;
import java.sql.*;

public class MySQLConnectionDemo {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/experiment";
        String user = "root";
        String password = "kanishkar123456";
        String query = "SELECT * FROM details";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
            }

            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
