import com.arm4j.weixin.exception.WeiXinRequestException;
import com.arm4j.weixin.request.accesstoken.WeiXinAccessTokenRequest;
import com.arm4j.weixin.request.user.WeiXinUserInfoBatchGetRequest;
import com.arm4j.weixin.request.user.WeiXinUserInfoGetRequest;
import com.arm4j.weixin.request.user.WeiXinUserInfoUpdateRemarkRequest;
import com.arm4j.weixin.request.user.WeiXinUserListGetRequest;
import com.arm4j.weixin.request.user.entity.UserInfoBatchGetEntity;
import com.arm4j.weixin.request.user.entity.UserInfoEntity;
import com.arm4j.weixin.request.user.response.UserListResponse;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestWeiXinUserInfoRequest {

    @Test
    public void TestUpdateRemark() throws WeiXinRequestException {
        String token = WeiXinAccessTokenRequest.request(
                "client_credential",
                "wx4458e6569617498d",
                "dbe4e50e8465023eee2a489216870375");
        System.out.println("token: " + token);

        WeiXinUserInfoUpdateRemarkRequest.request(token, "oGOUTs5EKpj6yb3KAgd3YCOJL0c8", "天下第一帅");
    }

    @Test
    public void TestUserInfoGet() throws WeiXinRequestException {
        String token = WeiXinAccessTokenRequest.request(
                "client_credential",
                "wx4458e6569617498d",
                "dbe4e50e8465023eee2a489216870375");
        System.out.println("token: " + token);

        UserInfoEntity result = WeiXinUserInfoGetRequest.request(token, "oGOUTs5EKpj6yb3KAgd3YCOJL0c8");
        System.out.println(result);
    }

    @Test
    public void TestUserInfoBatchGet() throws WeiXinRequestException {
        String token = WeiXinAccessTokenRequest.request(
                "client_credential",
                "wx4458e6569617498d",
                "dbe4e50e8465023eee2a489216870375");
        System.out.println("token: " + token);

        UserInfoBatchGetEntity entity1 = new UserInfoBatchGetEntity();
        entity1.setOpenId("oGOUTs5EKpj6yb3KAgd3YCOJL0c8");
        entity1.setLang("zh_CN");

        UserInfoBatchGetEntity entity2 = new UserInfoBatchGetEntity();
        entity2.setOpenId("oGOUTs98quXJxdTK96cN9FabD8EQ");

        List<UserInfoBatchGetEntity> entities = new ArrayList<>();
        entities.add(entity1);
        entities.add(entity2);

        List<UserInfoEntity> result = WeiXinUserInfoBatchGetRequest.request(token, entities);
        System.out.println(result);
    }

    @Test
    public void TestUserListGet() throws WeiXinRequestException {
        String token = WeiXinAccessTokenRequest.request(
                "client_credential",
                "wx4458e6569617498d",
                "dbe4e50e8465023eee2a489216870375");
        System.out.println("token: " + token);

        UserListResponse result = WeiXinUserListGetRequest.request(token, "oGOUTs5EKpj6yb3KAgd3YCOJL0c8");
        System.out.println(result);
    }

}
