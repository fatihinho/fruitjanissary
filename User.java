package sample;

import java.sql.SQLException;

public class User {

    private String username;
    private int userScore;

    User() {
        if (DBController.isValid()) {
            this.username = Login.getTextUsername();
        }
    }

    User(String username, int userScore) {
        this.username = username;
        this.userScore = userScore;
    }

    public String getUsername() {
        return username;
    }

    public void setUserScore() {
        this.userScore = Game.currScore;
    }

    public int getUserScore() {
        return userScore;
    }

    public void setLeaderboard() throws SQLException {
        DBController.setLeaderboardDB(getUsername(), getUserScore());
    }
}