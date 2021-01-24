package com.silentao.parsley.common.vo;

import com.silentao.parsley.common.enums.ParsleyResponseEnum;
import lombok.Getter;

import java.util.List;

/**
 * @Description 系统请求响应VO类
 * @Author Silence
 * @Date 2021/1/23 21:44
 **/
@Getter
public class ParsleyResponseVO<T> {

    /**
     * 状态码
     */
    private int code;

    /**
     * 状态信息
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;

    /**
     * 当前页
     */
    private int current;

    /**
     * 总页数
     */
    private int total;

    /**
     * 数据
     */
    private List<T> list;

    private ParsleyResponseVO() {
        this.code = ParsleyResponseEnum.SUCCESS.getCode();
        this.message = ParsleyResponseEnum.SUCCESS.getMessage();
    }

    private ParsleyResponseVO(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private ParsleyResponseVO(T data) {
        this.code = ParsleyResponseEnum.SUCCESS.getCode();
        this.message = ParsleyResponseEnum.SUCCESS.getMessage();
        this.data = data;
    }

    private ParsleyResponseVO(int current, int total, List<T> list) {
        this.code = ParsleyResponseEnum.SUCCESS.getCode();
        this.message = ParsleyResponseEnum.SUCCESS.getMessage();
        this.current = current;
        this.total = total;
        this.list = list;
    }

    /**
     * 请求成功
     * @return
     */
    public static ParsleyResponseVO getSuccessInstance() {
        return new ParsleyResponseVO();
    }

    /**
     * 请求成功
     * @param data
     * @return
     */
    public static <T> ParsleyResponseVO<T> getSuccessInstance(T data) {
        return new ParsleyResponseVO<T>(data);
    }

    /**
     * 请求成功
     * @param current
     * @param total
     * @param list
     * @param <T>
     * @return
     */
    public static <T> ParsleyResponseVO<T> getSuccessInstance(int current, int total, List<T> list) {
        return new ParsleyResponseVO<T>(current, total, list);
    }

    /**
     * 请求失败
     * @param code
     * @param message
     * @return
     */
    public static ParsleyResponseVO getFailedInstance(int code, String message) {
        return new ParsleyResponseVO(code, message);
    }

    public boolean isSuccess() {
        return this.code == 0;
    }
}
