package top.liyf.seckill.dao;

import top.liyf.seckill.entity.Seckill;

import java.util.Date;
import java.util.List;

public interface SeckillDao {

    /**
     * 减库存
     *
     * @param seckillId
     * @param killTime
     * @return
     */
    int reduceNumber(long seckillId, Date killTime);

    /**
     *
     * @param seckillId
     * @return
     */
    Seckill queryById(long seckillId);

    /**
     *
     * @param offset
     * @param limit
     * @return
     */
    List<Seckill> queryAll(int offset, int limit);
}
