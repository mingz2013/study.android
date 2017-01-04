package com.example.zhaojm.a03_coolweather.util;

/**
 * Created by zhaojm on 15/12/15.
 */
public interface HttpCallbackListener {
    void onFinish(String response);
    void onError(Exception e);
}
