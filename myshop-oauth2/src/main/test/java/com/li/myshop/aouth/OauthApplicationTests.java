package com.li.myshop.aouth;

import com.alibaba.fastjson.JSON;
import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OauthApplicationTests {

    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    @Test
    public void test(){
        String encode = passwordEncoder.encode("123465");
        System.out.println(encode);
    }

    /**
     * 测试OkHttp
     */
    @Test
    public void testOkHttp() throws IOException {
       String url = "https://www.baidu.com";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        Response execute = call.execute();
        System.out.println(execute.body().string());
    }
    @Test
    public void testPost() throws IOException {
        String url="http://localhost:9001/oauth/token";
        OkHttpClient client = new OkHttpClient();
        FormBody body = new FormBody.Builder()
                .add("username", "liyanming")
                .add("password", "123465")
                .add("grant_type", "password")
                .add("client_id", "client")
                .add("client_secret", "secret")
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Call call = client.newCall(request);
        Response execute = call.execute();
        Map parse = (Map) JSON.parse(execute.body().string());
        String access_token = parse.get("access_token").toString();
        System.out.println(access_token);
    }
}
