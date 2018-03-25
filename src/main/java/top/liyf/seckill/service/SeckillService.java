package top.liyf.seckill.service;

import top.liyf.seckill.dto.Exposer;
import top.liyf.seckill.dto.SeckillExecution;
import top.liyf.seckill.entity.Seckill;
import top.liyf.seckill.exception.RepeatKillException;
import top.liyf.seckill.exception.SeckillCloseException;
import top.liyf.seckill.exception.SeckillException;

import java.util.List;

public interface SeckillService {

    List<Seckill> getSeckillList();

    Seckill getById(long seckillId);

    /**
     * 秒杀开启时输出秒杀接口地址，
     * 否则输出系统时间和秒杀时间
     *
     * @param seckillId
     * @return
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     *
     * @param seckillID
     * @param userPhone
     * @param md5
     * @return
     * @throws SeckillException
     * @throws RepeatKillException
     * @throws SeckillCloseException
     */
    SeckillExecution executeSeckill(long seckillID, long userPhone, String md5)
            throws SeckillException, RepeatKillException, SeckillCloseException;

    /**
     *
     * @param seckillID
     * @param userPhone
     * @param md5
     * @return
     * @throws SeckillException
     * @throws RepeatKillException
     * @throws SeckillCloseException
     */
    SeckillExecution executeSeckillProceDure(long seckillID, long userPhone, String md5);
}
