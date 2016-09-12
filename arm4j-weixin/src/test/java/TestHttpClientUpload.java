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

public class TestHttpClientUpload {

    public static void main(String[] args) throws IOException, WeiXinRequestException {
        String token = WeiXinAccessTokenRequest.request(
                "client_credential",
                "wx4458e6569617498d",
                "dbe4e50e8465023eee2a489216870375");
        System.out.println("token: " + token);

        HttpPost post = new HttpPost("https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=" + token + "&type=image");
        File file = new File("F:/image1.jpg");
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        builder.addBinaryBody("media", file, ContentType.DEFAULT_BINARY, "image1.jpg");
//
        HttpEntity entity = builder.build();
        post.setEntity(entity);
//        post.addHeader("Content-Disposition", "form-data;name=\"media\";filename=\"image1\"");
//        post.addHeader("Content-Type", "application/octet-stream");
        HttpResponse response = HttpClientUtil.getHttpClient().execute(post);
        System.out.println();
    }

}
