package top.liyf.seckill.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.liyf.seckill.dto.Exposer;
import top.liyf.seckill.dto.SeckillExecution;
import top.liyf.seckill.entity.Seckill;
import top.liyf.seckill.exception.RepeatKillException;
import top.liyf.seckill.exception.SeckillCloseException;
import top.liyf.seckill.service.SeckillService;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: liyf
 * @Description:
 * @Date: Created in 2018/3/22/ 17:48
 * @Modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-service.xml","classpath:spring/spring-dao.xml"})
public class SeckillServiceImplTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckillList() {
        List<Seckill> seckillList = seckillService.getSeckillList();
        logger.info("list = {}", seckillList);
    }

    @Test
    public void getById() {
        long id = 1000;
        Seckill seckill = seckillService.getById(id);
        logger.info("seckill = {}", seckill);

    }

    @Test
    public void exportSeckill() {
        long id = 1000;
        long phone = 13525151514L;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        if (exposer.isExposed()) {
            logger.info("exposer = {}", exposer);
            String md5 = exposer.getMd5();
            try {
                SeckillExecution seckillExecution = seckillService.executeSeckill(id, phone, md5);
                logger.info("result = {}", seckillExecution);
            } catch (RepeatKillException e) {
                logger.error(e.getMessage());
            } catch (SeckillCloseException e) {
                logger.error(e.getMessage());
            }

        } else {
            logger.warn("exposer = {}", exposer);
        }
    }

}