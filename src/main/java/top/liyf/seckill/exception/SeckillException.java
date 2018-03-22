package top.liyf.seckill.exception;

/**
 * @Author: liyf
 * @Description: 秒杀相关业务异常
 * @Date: Created in 2018/3/22/ 11:11
 * @Modified By:
 */
public class SeckillException extends RuntimeException {

    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
