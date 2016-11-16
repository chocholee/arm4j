import com.arm4j.weixin.exception.WeiXinRequestException;
import com.arm4j.weixin.request.accesstoken.WeiXinAccessTokenRequest;
import com.arm4j.weixin.request.customservice.WeiXinCustomServiceKFAccountAddRequest;
import com.arm4j.weixin.request.customservice.WeiXinCustomServiceSendMessageRequest;
import com.arm4j.weixin.request.customservice.entity.KFAccountEntity;
import com.arm4j.weixin.request.customservice.entity.msg.text.KFAccountTextMsgEntity;
import com.arm4j.weixin.request.customservice.entity.msg.text.TextMsgEntity;
import org.testng.annotations.Test;

/**
 * Created by liwenhe on 16/11/16.
 */
public class TestWeiXinCustomServiceRequest {

    @Test
    private void TestAdd() throws WeiXinRequestException {
        String token = WeiXinAccessTokenRequest.request(
                "client_credential",
                "wx4458e6569617498d",
                "dbe4e50e8465023eee2a489216870375");
        System.out.println("token: " + token);

        KFAccountEntity kfAccountEntity = new KFAccountEntity();
        kfAccountEntity.setKfAccount("test1@gh_ad4593288265");
        kfAccountEntity.setNickname("客服1");
        kfAccountEntity.setPassword("202cb962ac59075b964b07152d234b70");
        boolean result = WeiXinCustomServiceKFAccountAddRequest.request(token, kfAccountEntity);
        System.out.println("result: " + result);
    }

    @Test
    private void TestSendMsg() throws WeiXinRequestException {
        String token = WeiXinAccessTokenRequest.request(
                "client_credential",
                "wx4458e6569617498d",
                "dbe4e50e8465023eee2a489216870375");
        System.out.println("token: " + token);

        TextMsgEntity textMsgEntity = new TextMsgEntity();
        textMsgEntity.setContent("我是李文禾");
        KFAccountTextMsgEntity kfAccountTextMsgEntity = new KFAccountTextMsgEntity();
        kfAccountTextMsgEntity.setText(textMsgEntity);
        kfAccountTextMsgEntity.setToUser("oGOUTs5EKpj6yb3KAgd3YCOJL0c8");
        boolean result = WeiXinCustomServiceSendMessageRequest.request(token, kfAccountTextMsgEntity);
        System.out.println("result: " + result);
    }

}
