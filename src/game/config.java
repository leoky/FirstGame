package game;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Leonardy192.168.43.66
 */
public class config {

    static final String JDBC_DRIVER = "con.mysql.jdbc.Driver";
    static String DB_URl = "jdbc:mysql://localhost/pokemon";
    static final String USER = "root";
    static final String PASS = "abc";
    static String player = null;
    static String player2 = null;
    static String nowplayer = "";
    static String enemyplayer = null;
    static String pause = null;
    static String enter = "2";
    static String room = null;
    static String turn = null;
    Connection conn;
    Statement st;
    ResultSet rs;
    String sql;

    public static void setDB_URl(String url) {
        config.DB_URl = "jdbc:mysql://" + url + "/pokemon";
    }

    public static void getPlayer(String pplayer) {
        config.player = pplayer;
    }

    public static void getRoom(String rroom) {
        config.room = rroom;
    }

    public Connection getConnection() {
        try {
            conn = DriverManager.getConnection(config.DB_URl, config.USER, config.PASS);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void getUpdate() {
        try {
            conn = getConnection();
            st = conn.createStatement();
            sql = "SELECT player1, player2, enter FROM master WHERE id='" + config.room + "'";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                config.player = rs.getString("player1");
                config.player2 = rs.getString("player2");
                config.enter=rs.getString("enter");
                System.out.println(config.player);
                System.out.println(config.player2);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
