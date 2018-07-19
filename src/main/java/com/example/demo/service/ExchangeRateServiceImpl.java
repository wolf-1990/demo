package com.example.demo.service;


import com.example.demo.entity.ExchangeRate;


import com.example.demo.entity.ResultError;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {
    protected static final Logger logger = LoggerFactory.getLogger(ExchangeRateServiceImpl.class);
    public ExchangeRate ExchangeRateConversion(String from, String to, int amount) {
        ExchangeRate error = new ExchangeRate();
        String [] strs={"CNY","USD","JPY","EUR","GBP"};
        //验证参数
       if(StringUtils.isEmpty(from)){
           logger.error("源货币不能为null");
           error.setErrorCode("1001");
           return error;
       }
        int i = Arrays.binarySearch(strs, from);
        if(i<0){
            logger.error("源货币不提供此种货币转换");
            error.setErrorCode("1004");
            return error;
       }
       if(StringUtils.isEmpty(to)){
           logger.error("目标货币不能为null");
           error.setErrorCode("1002");
           return error;
       }
        int j = Arrays.binarySearch(strs, from);
        if(j<0){
            logger.error("目标货币不提供此种货币转换");
            error.setErrorCode("1005");
            return error;
        }
       if(amount == 0){
           logger.error("请输入有效值（不能为0）");
           error.setErrorCode("1003");
           return error;
       }
       //通过调用百度汇率接口获取汇率值
        String url="http://api.k780.com:88/?app=finance.rate&scur="+from+"&tcur="+to+"&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4";
        //查找两者之间的汇率
       String exchangeRate = getExchangeRate(url);
       BigDecimal rate = BigDecimal.valueOf(Double.parseDouble(exchangeRate));
       BigDecimal multiply = rate.multiply(new BigDecimal(amount));
        //封装到对象中
        ExchangeRate er = new ExchangeRate(multiply,rate,from,to);
        return er;
    }
    //返回汇率
    private String  getExchangeRate(String url) {
        InputStreamReader insr = null;
        HttpURLConnection conn = null;
        BufferedReader br = null;
        String data = null;
        String str = "";
        String exchangeRate = "";
        try {
            URL url1 = new URL(url);
            conn = (HttpURLConnection) url1.openConnection();
            if (conn != null) {
                insr = new InputStreamReader(conn.getInputStream(), "UTF-8");
                br = new BufferedReader(insr);
                StringBuilder sb = new StringBuilder("");
                while ((data = br.readLine()) != null) {
                    sb.append(data.trim());
                }
                str = sb.toString();
            }
            JSONObject jsonObj = JSONObject.fromObject(str);
            JSONObject result = jsonObj.getJSONObject("result");
            exchangeRate = (String)result.get("rate");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exchangeRate;
    }
}
