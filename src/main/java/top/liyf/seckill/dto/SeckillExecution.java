package top.liyf.seckill.dto;

import lombok.Data;
import top.liyf.seckill.entity.SuccessKilled;
import top.liyf.seckill.enums.SeckillStateEnum;

/**
 * 封装秒杀执行后结果
 */
@Data
public class SeckillExecution {

    private long seckillId;

    //秒杀执行结果状态
    private  int state;

    //状态表示
    private String stateInfo;

    //秒杀成功对象
    private SuccessKilled successKilled;

    public SeckillExecution(long seckillId, SeckillStateEnum stateEnum) {
        this.seckillId = seckillId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    public SeckillExecution(long seckillId, SeckillStateEnum stateEnum, SuccessKilled successKilled) {

        this.seckillId = seckillId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.successKilled = successKilled;
    }
}
