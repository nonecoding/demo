package com.example.demo.express.auth.service;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class id2demo {

	public static void main(String[] args) throws IOException {
        
        String url = "https://idenauthen.market.alicloudapi.com/idenAuthentication";
        // 获取appCode链接：https://market.console.aliyun.com/
        String appCode = "e1ff33s21dfg2s1dd2f1ff33fc60d7130";
        String name = "张三";
        String idNo = "320000198811110000";

        System.out.println(postData(appCode, url, name, idNo));
	}
	
	/**依赖的工具包有：okhttp-3.2.0.jar, okio-1.14.0.jar
	 * 工具包下载链接：https://download.csdn.net/download/ruidongjun007/88360015
	 * <dependency>
     *      <groupId>com.squareup.okhttp3</groupId>
     *      <artifactId>okhttp</artifactId>
     *      <version>3.2.0</version>
     *  </dependency>
     *  
     *  <dependency>
	 *  	<groupId>com.squareup.okio</groupId>
	 *  	<artifactId>okio</artifactId>
	 *  	<version>1.14.0</version>
	 *  </dependency>
	 */
	public static String postData(String appCode, String url, String name, String idNo) throws IOException {
		String result = "";
		RequestBody formBody = new FormBody.Builder().add("name", name).add("idNo", idNo).build();
		Request request = new Request.Builder().url(url).addHeader("Authorization", "APPCODE " + appCode).post(formBody).build();
		
		Call call = new OkHttpClient().newCall(request);
		Response response = null;
		try {
		    response = call.execute();
		} catch (IOException e) {
		    System.out.println("execute failed, message:" + e.getMessage());
		}
		
		assert response != null;
		if (!response.isSuccessful()) {      // 当返回结果发生错误时
		    // 状态码为403时一般是套餐包用尽，需续购；注意：续购不会改变秘钥（appCode），仅增加次数
		    // 续购链接：https://market.aliyun.com/products/57000002/cmapi025518.html
		    System.out.println("request failed----" + "返回状态码" + response.code()  + ",message:" + response.message());
		}
		result = response.body().string();    //此处不可以使用toString()方法，该方法已过期
		
		return result;
	}
}