package com.janty.test;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

/**
 * @author 简义涛
 * @version V1.0
 */
public class test_20230130_JDBC {

    //方式一
    @Test
    public void connect01() throws SQLException {
        com.mysql.jdbc.Driver driver;
        driver = new com.mysql.jdbc.Driver();
        String url = "jdbc:mysql://localhost:3306/db1";
        Properties info = new Properties();
        info.setProperty("user","root");
        info.setProperty("password","j123");
        Connection connect = driver.connect(url, info);
        System.out.println(connect);
    }

    //方式四
    @Test
    public void connect04() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<Driver> aClass = (Class<Driver>) Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/db1";
        String user = "root";
        String password = "j123";
        Connection connect = DriverManager.getConnection(url,user,password);
        System.out.println(connect);
    }

    //方式五
    @Test
    public void connect05() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\com\\jianyitao\\leetcode\\editor\\cn\\doc\\jdbctest.properties"));
        String url = (String)properties.get("url");
        String user = (String)properties.get("user");
        String password = (String)properties.get("password");
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);

//        String sql = "create table test(id int,name varchar(255),age int)";
//        String sql = "insert into test values (001,'howard',26)";
//        String sql = "insert into test values (2,'小明',13),(3,'sam',28),(4,'Amily',23)";
//        String sql = "update test set name = 'Daming' where id = 2 ";
//        String sql = "delete from  test where id = 3 ";
        String sql = "insert into test values (003,'Lily',29)";
        Statement statement = connection.createStatement();
        int rows = statement.executeUpdate(sql);
        System.out.println(rows);

    }



    @Test
    void preparedStatement() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\com\\jianyitao\\leetcode\\editor\\cn\\doc\\jdbctest.properties"));
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        Class<?> aClass = Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);


    }

    @Test
        public static void main(String[] args) {

        }
        public static int getValue() {
            int i = 1;
            try {
                i = 4;
                return i;
            } finally{
                i++;
                return i;
            }
        }




}
