import com.arm4j.weixin.exception.WeiXinRequestException;
import com.arm4j.weixin.request.WeiXinAccessTokenRequest;
import org.testng.annotations.Test;

public class TestWeiXinAccessTokenRequest {

    @Test
    public void TestWeiXinAccessTokenRequest() throws WeiXinRequestException {
        String token = WeiXinAccessTokenRequest.request(
                "client_credential",
                "wx4458e6569617498d",
                "dbe4e50e8465023eee2a489216870375");
        System.out.println(token);
    }

}
