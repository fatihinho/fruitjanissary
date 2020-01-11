package sample;

import java.sql.*;

public class DBController {

    public static void setUsernameAndPasswordDB(String username, String password) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "120500");
            st = con.prepareStatement("INSERT INTO fruitjanissarydb.users (Username, Password) VALUES (?, ?)");
            st.setString(1, username);
            st.setString(2, password);
            st.executeUpdate();
            st.close();
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static boolean flag = false;

    public static boolean isValid() {
        getUsernameAndPasswordDB();
        return flag;
    }

    public static void getUsernameAndPasswordDB() {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "120500");
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM fruitjanissarydb.users");
            while (rs.next()) {
                try {
                    if (Login.getTextUsername().equals(rs.getString("Username")) && Login.getTextPassword().equals(rs.getString("Password"))) {
                        flag = true;
                        break;
                    }
                } catch (NullPointerException e) {
                    e.fillInStackTrace();
                }
            }
            rs.close();
            st.close();
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public static void setLeaderboardDB(String username, int score) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "120500");
            st = con.prepareStatement("INSERT INTO fruitjanissarydb.leaderboard (Username, Score) VALUES (?, ?)");
            st.setString(1, username);
            st.setInt(2, score);
            st.executeUpdate();
            st.close();
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}