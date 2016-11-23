import com.alibaba.fastjson.JSON;
import com.arm4j.weixin.exception.WeiXinRequestException;
import com.arm4j.weixin.request.accesstoken.WeiXinAccessTokenRequest;
import com.arm4j.weixin.request.group.*;
import com.arm4j.weixin.request.group.entity.GroupEntity;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liwenhe on 16/11/23.
 */
public class TestWeiXinGroupRequest {

    @Test
    public void TestCreate() throws WeiXinRequestException {
        String token = WeiXinAccessTokenRequest.request(
                "client_credential",
                "wx4458e6569617498d",
                "dbe4e50e8465023eee2a489216870375");
        System.out.println("token: " + token);

        GroupEntity group = new GroupEntity();
        group.setName("测试分组");
        GroupEntity groupEntity = WeiXinGroupsCreateRequest.request(token, group);
        System.out.println(JSON.toJSONString(groupEntity));
    }

    @Test
    public void TestGet() throws WeiXinRequestException {
        String token = WeiXinAccessTokenRequest.request(
                "client_credential",
                "wx4458e6569617498d",
                "dbe4e50e8465023eee2a489216870375");
        System.out.println("token: " + token);

        List<GroupEntity> groupEntities = WeiXinGroupsGetRequest.request(token);
        System.out.println(JSON.toJSONString(groupEntities));
    }

    @Test
    public void TestGetId() throws WeiXinRequestException {
        String token = WeiXinAccessTokenRequest.request(
                "client_credential",
                "wx4458e6569617498d",
                "dbe4e50e8465023eee2a489216870375");
        System.out.println("token: " + token);

        int groupId = WeiXinGroupsGetIdRequest.request(token, "oGOUTs98quXJxdTK96cN9FabD8EQ");
        System.out.println(groupId);
    }

    @Test
    public void TestUpdate() throws WeiXinRequestException {
        String token = WeiXinAccessTokenRequest.request(
                "client_credential",
                "wx4458e6569617498d",
                "dbe4e50e8465023eee2a489216870375");
        System.out.println("token: " + token);

        GroupEntity group = new GroupEntity();
        group.setId(173);
        group.setName("测试分组1");
        WeiXinGroupsUpdateRequest.request(token, group);
    }

    @Test
    public void TestMembersUpdate() throws WeiXinRequestException {
        String token = WeiXinAccessTokenRequest.request(
                "client_credential",
                "wx4458e6569617498d",
                "dbe4e50e8465023eee2a489216870375");
        System.out.println("token: " + token);

        WeiXinGroupsMembersUpdateRequest.request(token, "oGOUTs98quXJxdTK96cN9FabD8EQ", 0);
    }

    @Test
    public void TestMembersBatchUpdate() throws WeiXinRequestException {
        String token = WeiXinAccessTokenRequest.request(
                "client_credential",
                "wx4458e6569617498d",
                "dbe4e50e8465023eee2a489216870375");
        System.out.println("token: " + token);

        List<String> openIdList = new ArrayList<>();
        openIdList.add("oGOUTs98quXJxdTK96cN9FabD8EQ");
        WeiXinGroupsMembersBatchUpdateRequest.request(token, openIdList, 173);
    }

    @Test
    public void TestDelete() throws WeiXinRequestException {
        String token = WeiXinAccessTokenRequest.request(
                "client_credential",
                "wx4458e6569617498d",
                "dbe4e50e8465023eee2a489216870375");
        System.out.println("token: " + token);

        GroupEntity group = new GroupEntity();
        group.setId(174);
        WeiXinGroupsDeleteRequest.request(token, group);
    }

}
