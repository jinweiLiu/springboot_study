package demo.entity;

import lombok.Data;

@Data
public class ExceptionRes {
    /**
     * 异常码
     */
    protected String code;

    /**
     * 异常信息
     */
    protected String msg;

    public ExceptionRes() {
        this.code = "200";
        this.msg = "操作成功";
    }

    public ExceptionRes(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
