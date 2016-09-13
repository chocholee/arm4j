import com.arm4j.core.DefaultURLParam;
import com.arm4j.core.HttpURLConn;
import com.arm4j.core.support.HttpClientUtil;
import com.arm4j.weixin.exception.WeiXinRequestException;
import com.arm4j.weixin.request.accesstoken.WeiXinAccessTokenRequest;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestHttpClientUpload {

    public static void main(String[] args) throws IOException, WeiXinRequestException {
        String token = WeiXinAccessTokenRequest.request(
                "client_credential",
                "wx4458e6569617498d",
                "dbe4e50e8465023eee2a489216870375");
        System.out.println("token: " + token);

        File file = new File("F:/image1.jpg");
        Map<String, Object> map = new HashMap<>();
        map.put("media", file);

        String result = new HttpURLConn("https://api.weixin.qq.com/cgi-bin/material/add_material", "utf-8")
                .connect(new DefaultURLParam.Builder()
                        .add("access_token", token)
                        .build())
                .upload(map);

        System.out.println(result);
    }

}
