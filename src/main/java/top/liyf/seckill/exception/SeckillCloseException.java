package top.liyf.seckill.exception;

/**
 * @Author: liyf
 * @Description: 秒杀关闭异常
 * @Date: Created in 2018/3/22/ 10:16
 * @Modified By:
 */
public class SeckillCloseException extends SeckillException {

    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
