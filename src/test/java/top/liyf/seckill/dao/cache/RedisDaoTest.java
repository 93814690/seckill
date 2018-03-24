package top.liyf.seckill.dao.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.liyf.seckill.dao.SeckillDao;
import top.liyf.seckill.entity.Seckill;

import static org.junit.Assert.*;

/**
 * @Author: liyf
 * @Description:
 * @Date: Created in 2018/3/24/ 12:15
 * @Modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class RedisDaoTest {

    @Autowired
    private RedisDao redisDao;

    @Autowired
    private SeckillDao seckillDao;

    private long id = 1000;

    @Test
    public void testSeckill() throws Exception {

        Seckill seckill = redisDao.getSeckill(id);
        if (seckill == null) {
            seckill = seckillDao.queryById(id);
            if (seckill != null) {
                String result = redisDao.putSeckill(seckill);
                System.out.println("result = " + result);
                seckill = redisDao.getSeckill(id);
                System.out.println("seckill = " + seckill);
            }
        }
    }

}