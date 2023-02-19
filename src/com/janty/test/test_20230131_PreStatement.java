package com.janty.test;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.Properties;

/**
 * @author 简义涛
 * @version V1.0
 */
public class test_20230131_PreStatement {
    @Test
    public void connect02() throws SQLException, ClassNotFoundException {
        //1.获取连接
        Class<Driver> aClass = (Class<Driver>) Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/db2";
        String user = "root";
        String password = "j123";
        Connection connect = DriverManager.getConnection(url,user,password);
        System.out.println(connect);

        //2.sql语句
//        String sql = "create table admin (id int, name varchar(32))";
//        String sql = "update `admin`set `name` = ? where id = ? ";
//        String sql = "delete from  `admin` where id = ?";
        String sql = "select * from  `admin`";
        PreparedStatement preparedStatement = connect.prepareStatement(sql);

//        preparedStatement.setString(1,"King");
//        preparedStatement.setString(1,"3");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id =resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.println(id+"\t"+ name);
        }
        System.out.println("影响：" );

        //3.关闭连接
        preparedStatement.close();
        connect.close();
        System.out.println("关闭连接");
    }
    public static void main(String[] args) throws Exception {
        //1.获取连接
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:sql://localhost:3306/db2";
        String user = "root";
        String password = "j123";
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);

        //2.sql语句
        String sql = "create table admin (id int, name varchar(32))";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("影响:"+preparedStatement.executeUpdate());

        //3.关闭连接
        preparedStatement.close();
        connection.close();
        System.out.println("关闭连接");

    }
}
