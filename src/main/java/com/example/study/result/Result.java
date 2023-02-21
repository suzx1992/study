package com.example.study.result;

//返回结果

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
@Data
@Accessors(chain = true)
@ApiModel(value = "接口返回对象", description = "接口返回对象")
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 成功标志
     */
    @ApiModelProperty(value = "成功标志")
    private boolean success = true;

    /**
     * 返回处理消息
     */
    @ApiModelProperty(value = "返回处理消息")
    private String message = "success";

    /**
     * 返回代码
     */
    @ApiModelProperty(value = "返回代码")
    private int code = HttpServletResponse.SC_OK;

    /**
     * 返回数据对象 data
     */
    @ApiModelProperty(value = "返回数据对象")
    private T result;

    /**
     * 时间戳
     */
    @ApiModelProperty(value = "时间戳")
    private long timestamp = System.currentTimeMillis();

    public Result() {
    }

    public static <T> Result<T> ok() {
        return new Result<>();
    }

    public static <T> Result<T> ok(T data) {
        Result<T> r = new Result<>();
        r.setResult(data);
        return r;
    }

    public static <T> Result<T> error(String msg) {
        return error(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, msg);
    }

    public static <T> Result<T> error(int code, String msg) {
        Result<T> r = new Result<>();
        r.setCode(code);
        r.setMessage(msg);
        r.setSuccess(false);
        return r;
    }

    public Result<T> success(String message) {
        this.message = message;
        return this;
    }

    public Result<T> error500(String message) {
        this.message = message;
        this.code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
        this.success = false;
        return this;
    }
}
