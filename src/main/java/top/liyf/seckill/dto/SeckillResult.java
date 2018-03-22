package top.liyf.seckill.dto;

import lombok.Data;

/**
 * @Author: liyf
 * @Description: 所有ajax请求返回类型，封装json结果
 * @Date: Created in 2018/3/22/ 23:47
 * @Modified By:
 */
@Data
public class SeckillResult<T> {

    private boolean success;

    private T data;

    private String error;

    public SeckillResult(boolean success, String error) {
        this.success = success;
        this.error = error;
    }

    public SeckillResult(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

}
