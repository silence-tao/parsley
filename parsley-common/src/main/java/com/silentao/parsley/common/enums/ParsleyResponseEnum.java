package com.silentao.parsley.common.enums;

import lombok.Getter;

/**
 * @Description 系统请求响应状态枚举类
 * @Author Silence
 * @Date 2021/1/23 22:02
 **/
@Getter
public enum ParsleyResponseEnum {

    /**
     * 系统异常
     */
    EXCEPTION(-2, "系统异常"),

    /**
     * 请求失败
     */
    FAILED(-1, "请求失败"),

    /**
     * 请求成功
     */
    SUCCESS(0, "请求成功"),

    /**
     * 未登录
     */
    UN_LOGIN(1, "未登录"),

    /**
     * 没有访问权限
     */
    NO_AUTHORITY(2, "没有操作权限"),

    /**
     * 参数异常
     */
    PARAMETER_ERROR(3, "参数异常"),

    /**
     * 未知方法名
     */
    UNKNOWN(4, "未知方法名"),

    /**
     * 结果为空
     */
    EMPTY(5, "结果为空"),

    /**
     * 数据操作异常
     */
    DATA_MANIPULATION_EXCEPTION(6, "数据操作异常"),

    /**
     * 业务处理异常
     */
    SERVICE_PROCESS_EXCEPTION(7, "业务处理异常"),

    ;

    /**
     * 状态码
     */
    private int code;

    /**
     * 状态信息
     */
    private String message;

    ParsleyResponseEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
