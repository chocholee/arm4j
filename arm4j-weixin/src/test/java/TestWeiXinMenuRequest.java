import com.alibaba.fastjson.JSON;
import com.arm4j.weixin.exception.WeiXinRequestException;
import com.arm4j.weixin.request.accesstoken.WeiXinAccessTokenRequest;
import com.arm4j.weixin.request.menu.entity.MenuButtonEntity;
import com.arm4j.weixin.request.menu.entity.MenuEntity;
import com.arm4j.weixin.request.menu.entity.MenuMatchRuleEntity;
import com.arm4j.weixin.request.menu.*;
import com.arm4j.weixin.request.menu.response.MenuResponse;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestWeiXinMenuRequest {

    @Test
    public void TestCreate() throws WeiXinRequestException {
        String token = WeiXinAccessTokenRequest.request(
                "client_credential",
                "wx4458e6569617498d",
                "dbe4e50e8465023eee2a489216870375");
        System.out.println("token: " + token);

        MenuButtonEntity scanCodeSubEntity1 = new MenuButtonEntity();
        scanCodeSubEntity1.setName("扫码带提示");
        scanCodeSubEntity1.setType("scancode_waitmsg");
        scanCodeSubEntity1.setKey("rselfmenu_0_0");

        MenuButtonEntity scanCodeSubEntity2 = new MenuButtonEntity();
        scanCodeSubEntity2.setName("扫码推事件");
        scanCodeSubEntity2.setType("scancode_push");
        scanCodeSubEntity2.setKey("rselfmenu_0_1");

        List<MenuButtonEntity> scanCodeSubEntities = new ArrayList<>();
        scanCodeSubEntities.add(scanCodeSubEntity1);
        scanCodeSubEntities.add(scanCodeSubEntity2);

        MenuButtonEntity scanCode = new MenuButtonEntity();
        scanCode.setName("扫码");
        scanCode.setSubButton(scanCodeSubEntities);

        MenuButtonEntity picSubEntity1 = new MenuButtonEntity();
        picSubEntity1.setName("系统拍照发图");
        picSubEntity1.setType("pic_sysphoto");
        picSubEntity1.setKey("rselfmenu_1_0");

        MenuButtonEntity picSubEntity2 = new MenuButtonEntity();
        picSubEntity2.setName("拍照或者相册发图");
        picSubEntity2.setType("pic_photo_or_album");
        picSubEntity2.setKey("rselfmenu_1_1");

        MenuButtonEntity picSubEntity3 = new MenuButtonEntity();
        picSubEntity3.setName("微信相册发图");
        picSubEntity3.setType("pic_weixin");
        picSubEntity3.setKey("rselfmenu_1_2");

        List<MenuButtonEntity> picSubEntities = new ArrayList<>();
        picSubEntities.add(picSubEntity1);
        picSubEntities.add(picSubEntity2);
        picSubEntities.add(picSubEntity3);

        MenuButtonEntity pic = new MenuButtonEntity();
        pic.setName("发图");
        pic.setSubButton(picSubEntities);

        MenuButtonEntity location = new MenuButtonEntity();
        location.setName("发送位置");
        location.setType("location_select");
        location.setKey("rselfmenu_2_0");

        MenuButtonEntity media = new MenuButtonEntity();
        media.setName("图片");
        media.setType("media_id");
        media.setMediaId("uwKXhoxRnhxqICRAd7CCTJykcLONgxVgs-D3uO8djFk");

        MenuButtonEntity view = new MenuButtonEntity();
        view.setName("图文消息");
        view.setType("view_limited");
        view.setMediaId("uwKXhoxRnhxqICRAd7CCTLiL7jKn3IRheMSUbQa55EI");

        List<MenuButtonEntity> buttonEntities = new ArrayList<>();
//        buttonEntities.add(scanCode);
        buttonEntities.add(pic);
//        buttonEntities.add(location);
        buttonEntities.add(media);
        buttonEntities.add(view);

        MenuEntity menuEntity = new MenuEntity();
        menuEntity.setButtons(buttonEntities);

        boolean result = WeiXinMenuCreateRequest.request(token, menuEntity);
        System.out.println(result);
    }

    @Test
    public void TestGet() throws WeiXinRequestException {
        String token = WeiXinAccessTokenRequest.request(
                "client_credential",
                "wx4458e6569617498d",
                "dbe4e50e8465023eee2a489216870375");
        System.out.println("token: " + token);

        MenuResponse response = WeiXinMenuGetRequest.request(token);
        System.out.println(JSON.toJSONString(response));
    }

    @Test
    public void TestDelete() throws WeiXinRequestException {
        String token = WeiXinAccessTokenRequest.request(
                "client_credential",
                "wx4458e6569617498d",
                "dbe4e50e8465023eee2a489216870375");
        System.out.println("token: " + token);

        boolean result = WeiXinMenuDeleteRequest.request(token);
        System.out.println(result);
    }

    @Test
    public void TestAddConditional() throws WeiXinRequestException {
        String token = WeiXinAccessTokenRequest.request(
                "client_credential",
                "wx4458e6569617498d",
                "dbe4e50e8465023eee2a489216870375");
        System.out.println("token: " + token);

        MenuButtonEntity scanCodeSubEntity1 = new MenuButtonEntity();
        scanCodeSubEntity1.setName("扫码带提示");
        scanCodeSubEntity1.setType("scancode_waitmsg");
        scanCodeSubEntity1.setKey("rselfmenu_0_0");

        MenuButtonEntity scanCodeSubEntity2 = new MenuButtonEntity();
        scanCodeSubEntity2.setName("扫码推事件");
        scanCodeSubEntity2.setType("scancode_push");
        scanCodeSubEntity2.setKey("rselfmenu_0_1");

        List<MenuButtonEntity> scanCodeSubEntities = new ArrayList<>();
        scanCodeSubEntities.add(scanCodeSubEntity1);
        scanCodeSubEntities.add(scanCodeSubEntity2);

        MenuButtonEntity scanCode = new MenuButtonEntity();
        scanCode.setName("苹果系统");
        scanCode.setSubButton(scanCodeSubEntities);

        List<MenuButtonEntity> buttonEntities = new ArrayList<>();
        buttonEntities.add(scanCode);

        MenuMatchRuleEntity rule = new MenuMatchRuleEntity();
//        rule.setSex("1");
//        rule.setCountry("中国");
//        rule.setLanguage("zh_CN");
        rule.setClientPlatformType("1");

        MenuEntity menuEntity = new MenuEntity();
        menuEntity.setButtons(buttonEntities);
        menuEntity.setMenuMatchRuleEntity(rule);

        String result = WeiXinMenuAddConditionalRequest.request(token, menuEntity);
        System.out.println(result);
    }

    @Test
    public void TestDelConditional() throws WeiXinRequestException {
        String token = WeiXinAccessTokenRequest.request(
                "client_credential",
                "wx4458e6569617498d",
                "dbe4e50e8465023eee2a489216870375");
        System.out.println("token: " + token);

        MenuEntity menuEntity = new MenuEntity();
        menuEntity.setMenuId("428149018");
        boolean result = WeiXinMenuDelConditionalRequest.request(token, menuEntity);
        System.out.println(result);
    }

}
