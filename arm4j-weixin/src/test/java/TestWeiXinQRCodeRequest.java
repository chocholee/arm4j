import com.arm4j.weixin.exception.WeiXinRequestException;
import com.arm4j.weixin.request.accesstoken.WeiXinAccessTokenRequest;
import com.arm4j.weixin.request.qrcode.WeiXinQRCodeCreateRequest;
import com.arm4j.weixin.request.qrcode.WeiXinQRCodeShowRequest;
import com.arm4j.weixin.request.qrcode.entity.QRCodeActionEntity;
import com.arm4j.weixin.request.qrcode.entity.QRCodeEntity;
import com.arm4j.weixin.request.qrcode.entity.QRCodeSceneEntity;
import com.arm4j.weixin.request.qrcode.response.QRCodeResponse;
import com.arm4j.weixin.request.shorturl.WeiXinShortUrlRequest;
import com.arm4j.weixin.request.shorturl.entity.ShortUrlEntity;
import org.testng.annotations.Test;

import java.awt.image.BufferedImage;

public class TestWeiXinQRCodeRequest {

    @Test
    public void TestQRCodeCreate() throws WeiXinRequestException {
        String token = WeiXinAccessTokenRequest.request(
                "client_credential",
                "wx4458e6569617498d",
                "dbe4e50e8465023eee2a489216870375");
        System.out.println("token: " + token);

        QRCodeSceneEntity sceneEntity = new QRCodeSceneEntity();
        sceneEntity.setSceneId("123");

        QRCodeActionEntity actionEntity = new QRCodeActionEntity();
        actionEntity.setScene(sceneEntity);

        QRCodeEntity entity = new QRCodeEntity();
        entity.setActionName("QR_SCENE");
        entity.setExpireSeconds(604800);
        entity.setActionInfo(actionEntity);

        QRCodeResponse response = WeiXinQRCodeCreateRequest.request(token, entity);
        System.out.println(response);
    }

    @Test
    public void TestQRCodeShow() throws WeiXinRequestException {
        String token = WeiXinAccessTokenRequest.request(
                "client_credential",
                "wx4458e6569617498d",
                "dbe4e50e8465023eee2a489216870375");
        System.out.println("token: " + token);

        QRCodeSceneEntity sceneEntity = new QRCodeSceneEntity();
        sceneEntity.setSceneId("123");

        QRCodeActionEntity actionEntity = new QRCodeActionEntity();
        actionEntity.setScene(sceneEntity);

        QRCodeEntity entity = new QRCodeEntity();
        entity.setActionName("QR_SCENE");
        entity.setExpireSeconds(604800);
        entity.setActionInfo(actionEntity);

        QRCodeResponse response = WeiXinQRCodeCreateRequest.request(token, entity);
        System.out.println(response);

        BufferedImage bufferedImage = WeiXinQRCodeShowRequest.request(response.getTicket());
        System.out.println();
    }

}
