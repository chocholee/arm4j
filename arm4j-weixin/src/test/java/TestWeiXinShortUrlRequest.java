import com.arm4j.weixin.exception.WeiXinRequestException;
import com.arm4j.weixin.request.accesstoken.WeiXinAccessTokenRequest;
import com.arm4j.weixin.request.shorturl.WeiXinShortUrlRequest;
import com.arm4j.weixin.request.shorturl.entity.ShortUrlEntity;
import org.testng.annotations.Test;

public class TestWeiXinShortUrlRequest {

    @Test
    public void TestShortUrl() throws WeiXinRequestException {
        String token = WeiXinAccessTokenRequest.request(
                "client_credential",
                "wx4458e6569617498d",
                "dbe4e50e8465023eee2a489216870375");
        System.out.println("token: " + token);

        ShortUrlEntity entity = new ShortUrlEntity();
        entity.setAction("long2short");
        entity.setLongUrl("http://www.baidu.com");

        String shortUrl = WeiXinShortUrlRequest.request(token, entity);
        System.out.println(shortUrl);
    }

}
