package com.indusfo.springboootdemo_user.utils.responUtil;


import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Map;

import static com.indusfo.springboootdemo_user.utils.responUtil.CodeEnums.*;


/**
 * 统一处理ResponseData
 */
public class ResponseData<T> implements Serializable {


    /**
     * 错误提示信息
     */
    private String msg = "";

    /**
     * 错误的参数代码
     */
    private int code;

    /**
     * 存储的数据
     */
    private T data;

    /**
     * 返回数据条数
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public T getData() {
        return data;
    }

    private ResponseData() {

    }

    public ResponseData(CodeEnums codeEnums) {
        this.msg = codeEnums.getMsg();
        this.code = codeEnums.getCode();
    }

    public Object readResolve() {
        return this;
    }

    /**
     * 返回成功标识
     *
     * @param data 需要返回的数据
     * @param <E>  返回给前端的数据
     * @return
     */
    public static <E> ResponseData success(E data) {
        ResponseData ResponseData = new ResponseData(SUCCESS);
        ResponseData.data = data;
        return ResponseData;

    }

    /**
     * 返回成功标识 没有数据返回
     *
     * @return
     */
    public static ResponseData success() {
        ResponseData ResponseData = new ResponseData(SUCCESS);
        ResponseData.data = new JSONObject();
        return ResponseData;

    }


    /**
     * 返回成功信息 返回成功的自定义数据
     *
     * @param msg 自定义的成功信息
     * @return
     */
    public static ResponseData success(String msg) {
        ResponseData ResponseData = new ResponseData(SUCCESS);
        ResponseData.data = new JSONObject();
        ResponseData.msg = msg;
        return ResponseData;
    }

    /**
     * 返回成功消息和数据
     *
     * @param data 响应数据
     * @param msg 响应消息
     * @param <E>
     * @return
     */
    public static <E> ResponseData success(E data, String msg) {
        ResponseData ResponseData = new ResponseData(SUCCESS);
        ResponseData.data = data;
        ResponseData.msg = msg;
        return ResponseData;
    }

    /**
     * 返回成功消息和数据
     *
     * @param data 响应数据
     * @param msg 响应消息
     * @param <E>
     * @return
     */
    public static <E> ResponseData success(E data, String msg,Integer count) {
        ResponseData ResponseData = new ResponseData(SUCCESS);
        ResponseData.data = data;
        ResponseData.msg = msg;
        ResponseData.count= count;
        return ResponseData;
    }
    /**
     * 返回成功消息和数据
     *
     * @param data 响应数据
     * @param <E>
     * @return
     */
    public static <E> ResponseData success(E data,Integer count) {
        ResponseData ResponseData = new ResponseData(SUCCESS);
        ResponseData.data = data;
        ResponseData.count= count;
        return ResponseData;
    }


    /**
     * 返回成功标识
     *
     * @param data 需要返回的数据
     * @param <E>  返回给前端的数据
     * @return
     */
    public static <E> ResponseData success(CodeEnums codeEnums, E data) {
        ResponseData ResponseData = new ResponseData(codeEnums);
        ResponseData.data = data;
        return ResponseData;

    }


    /**
     * 返回成功标识
     * 返回map集合
     *
     * @return
     */
    public static ResponseData successByMap(Map<String, Object> map) {
        ResponseData ResponseData = new ResponseData(SUCCESS);
        ResponseData.data = map;
        return ResponseData;

    }

    /**
     * 返回失败的标识
     *
     * @param data 需要返回的数据
     * @return
     */
    public static <E> ResponseData error(E data) {
        ResponseData ResponseData = new ResponseData(FAIL);
        ResponseData.data = data;
        return ResponseData;

    }


    /**
     * 返回失败的标识
     *
     * @param data 需要返回的数据
     * @return
     */
    public static <E> ResponseData error(CodeEnums codeEnums, E data) {
        ResponseData ResponseData = new ResponseData(codeEnums);
        ResponseData.data = data;
        return ResponseData;

    }


    /**
     * 返回失败的标识
     *
     * @return
     */
    public static ResponseData errorByArray() {

        ResponseData ResponseData = new ResponseData(FAIL);
        ResponseData.data = new JSONObject();
        return ResponseData;

    }

    /**
     * 返回自定义的标识
     *
     * @return
     */
    public static ResponseData ResponseData(CodeEnums codeEnums) {
        ResponseData ResponseData = new ResponseData(codeEnums);
        ResponseData.data = new JSONObject();
        return ResponseData;

    }

    /**
     * 返回自定义的标识
     *
     * @return
     */
    public static <E> ResponseData ResponseData(CodeEnums codeEnums, E data) {
        ResponseData ResponseData = new ResponseData(codeEnums);
        ResponseData.data = data;
        return ResponseData;

    }

    /**
     * 返回错误
     *
     * @return
     */
    public static ResponseData error() {
        ResponseData ResponseData = new ResponseData(FAIL);
        ResponseData.data = new JSONObject();
        return ResponseData;

    }

    /**
     * 错误提示
     *
     * @param msg 错误信息
     * @return
     */
    public static ResponseData errorMsg(String msg) {
        ResponseData ResponseData = new ResponseData(FAIL);
        ResponseData.data = new JSONObject();
        ResponseData.msg = msg;
        return ResponseData;
    }


    /**
     * 返回禁止的标识
     *
     * @return
     */
  /*  public static ResponseData fail() {
        ResponseData ResponseData = new ResponseData(FAIL_CODE);
        ResponseData.data = new JSONObject();
        return ResponseData;

    }*/

    /**
     * 返回服务器出错的标识
     *
     * @return
     */
   /* public static ResponseData crash() {
        ResponseData ResponseData = new ResponseData(SERVICE_CRASH);
        ResponseData.data = new JSONObject();
        return ResponseData;

    }*/


    /**
     * 返回服务器需要重试的标识
     *
     * @return
     */
    public static ResponseData retry() {
        ResponseData ResponseData = new ResponseData(SERVICE_RETRY);
        ResponseData.data = new JSONObject();
        return ResponseData;

    }


    /**
     * 返回请求太频繁需要验证
     *
     * @return
     */
    public static ResponseData validate() {
        ResponseData ResponseData = new ResponseData(SERVICE_VALIDATE);
        ResponseData.data = new JSONObject();
        return ResponseData;

    }





}
