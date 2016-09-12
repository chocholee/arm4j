import com.arm4j.weixin.exception.WeiXinRequestException;
import com.arm4j.weixin.request.accesstoken.WeiXinAccessTokenRequest;
import com.arm4j.weixin.request.getcallbackip.WeiXinGetCallbackIpRequest;
import org.testng.annotations.Test;

public class TestWeiXinGetCallbackIPRequest {

    @Test
    public void TestWeiXinGetCallbackIPRequest() throws WeiXinRequestException {
        String token = WeiXinAccessTokenRequest.request(
                "client_credential",
                "wx4458e6569617498d",
                "dbe4e50e8465023eee2a489216870375");
        System.out.println("token: " + token);

        String[] ipList = WeiXinGetCallbackIpRequest.request(token);
        System.out.println(ipList.length);
    }

}
