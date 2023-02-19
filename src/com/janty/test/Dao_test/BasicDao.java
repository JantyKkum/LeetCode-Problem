package com.janty.test.Dao_test;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 简义涛
 * @version V1.0
 */
public class BasicDao<T> {
    private QueryRunner qr = new QueryRunner();

    //DML单行
    @Test
    public int update(String sql,Object... parameters){
        Connection connection = null;
        try {
            connection = JDBCUtils_Druid.getConnection();
            int updateAffected = qr.update(sql,parameters);
            return updateAffected;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                JDBCUtils_Druid.close(null,null,connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    //Select多行
    public List<T> queryMultiply(String sql, Class<T> aclass, Object...parameters){
        Connection connection = null;
        try {
            connection = JDBCUtils_Druid.getConnection();
            return qr.query(connection,sql, new BeanListHandler<T>(aclass),parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                JDBCUtils_Druid.close(null,null,connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    //    查询单行单列的方法,即返回单值的方法
    public Object queryScalar(String sql, Object... parameters) throws SQLException {
        Connection connection = null;
        try {
            connection = JDBCUtils_Druid.getConnection();
            return qr.query(connection, sql, new ScalarHandler(), parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e); //将编译异常->运行异常 ,抛出
        } finally {
            JDBCUtils_Druid.close(null, null, connection);
        }
    }

}
