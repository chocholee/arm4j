import com.arm4j.weixin.exception.WeiXinRequestException;
import com.arm4j.weixin.request.accesstoken.WeiXinAccessTokenRequest;
import com.arm4j.weixin.request.tags.*;
import com.arm4j.weixin.request.tags.entity.TagsEntity;
import com.arm4j.weixin.request.tags.response.TagsUserGetResponse;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestWeiXinTagsRequest {

    @Test
    public void TestCreate() throws WeiXinRequestException {
        String token = WeiXinAccessTokenRequest.request(
                "client_credential",
                "wx4458e6569617498d",
                "dbe4e50e8465023eee2a489216870375");
        System.out.println("token: " + token);

        TagsEntity entity = new TagsEntity();
        entity.setName("11");

        TagsEntity response = WeiXinTagsCreateRequest.request(token, entity);
        System.out.println(response);
    }

    @Test
    public void TestGet() throws WeiXinRequestException {
        String token = WeiXinAccessTokenRequest.request(
                "client_credential",
                "wx4458e6569617498d",
                "dbe4e50e8465023eee2a489216870375");
        System.out.println("token: " + token);

        List<TagsEntity> responses = WeiXinTagsGetRequest.request(token);
        System.out.println(responses);
    }

    @Test
    public void TestUpdate() throws WeiXinRequestException {
        String token = WeiXinAccessTokenRequest.request(
                "client_credential",
                "wx4458e6569617498d",
                "dbe4e50e8465023eee2a489216870375");
        System.out.println("token: " + token);

        TagsEntity entity = new TagsEntity();
        entity.setId(170);
        entity.setName("11");

        boolean result = WeiXinTagsUpdateRequest.request(token, entity);
        System.out.println(result);
    }

    @Test
    public void TestDelete() throws WeiXinRequestException {
        String token = WeiXinAccessTokenRequest.request(
                "client_credential",
                "wx4458e6569617498d",
                "dbe4e50e8465023eee2a489216870375");
        System.out.println("token: " + token);

        TagsEntity entity = new TagsEntity();
        entity.setId(170);

        boolean result = WeiXinTagsDeleteRequest.request(token, entity);
        System.out.println(result);
    }

    @Test
    public void TestUserGet() throws WeiXinRequestException {
        String token = WeiXinAccessTokenRequest.request(
                "client_credential",
                "wx4458e6569617498d",
                "dbe4e50e8465023eee2a489216870375");
        System.out.println("token: " + token);

        TagsUserGetResponse result = WeiXinTagsUserGetRequest.request(token, 2, null);
        System.out.println(result);
    }

    @Test
    public void TestTagsMembersBatchTagging() throws WeiXinRequestException {
        String token = WeiXinAccessTokenRequest.request(
                "client_credential",
                "wx4458e6569617498d",
                "dbe4e50e8465023eee2a489216870375");
        System.out.println("token: " + token);

        List<String> openIdList = new ArrayList<>();
        openIdList.add("oGOUTs5EKpj6yb3KAgd3YCOJL0c8");
        openIdList.add("oGOUTs98quXJxdTK96cN9FabD8EQ");

        boolean result = WeiXinTagsMembersBatchTaggingRequest.request(token, 169, openIdList);
        System.out.println(result);
    }

    @Test
    public void TestTagsMembersBatchUnTagging() throws WeiXinRequestException {
        String token = WeiXinAccessTokenRequest.request(
                "client_credential",
                "wx4458e6569617498d",
                "dbe4e50e8465023eee2a489216870375");
        System.out.println("token: " + token);

        List<String> openIdList = new ArrayList<>();
        openIdList.add("oGOUTs5EKpj6yb3KAgd3YCOJL0c8");
        openIdList.add("oGOUTs98quXJxdTK96cN9FabD8EQ");

        boolean result = WeiXinTagsMembersBatchTaggingRequest.request(token, 2, openIdList);
        System.out.println(result);
    }

    @Test
    public void TestTagsGetIdList() throws WeiXinRequestException {
        String token = WeiXinAccessTokenRequest.request(
                "client_credential",
                "wx4458e6569617498d",
                "dbe4e50e8465023eee2a489216870375");
        System.out.println("token: " + token);

        Integer[] result = WeiXinTagsGetIdListRequest.request(token, "oGOUTs5EKpj6yb3KAgd3YCOJL0c8");
        System.out.println(result);
    }

}
