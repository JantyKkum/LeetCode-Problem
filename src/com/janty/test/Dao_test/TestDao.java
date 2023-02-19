package com.janty.test.Dao_test;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 简义涛
 * @version V1.0
 */
public class TestDao {
    @Test
    public void testGoodsDao() throws SQLException {
        GoodsDao goodsDao = new GoodsDao();
        //查询
        String sql = "select * from goods where id >= ? ";
        List<Goods> goods = goodsDao.queryMultiply(sql, Goods.class,1);
        System.out.println("======");
        for (Goods good : goods) {
            System.out.println(good);
        }

    }
}
