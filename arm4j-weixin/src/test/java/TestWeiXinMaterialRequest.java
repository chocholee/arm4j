import com.arm4j.weixin.exception.WeiXinRequestException;
import com.arm4j.weixin.request.accesstoken.WeiXinAccessTokenRequest;
import com.arm4j.weixin.request.material.*;
import com.arm4j.weixin.request.material.entity.MediaEntity;
import com.arm4j.weixin.request.material.entity.MediaType;
import com.arm4j.weixin.request.material.entity.NewsEntity;
import com.arm4j.weixin.request.material.response.CountResponse;
import com.arm4j.weixin.request.material.response.MediaResponse;
import com.arm4j.weixin.request.material.response.VideoResponse;
import com.arm4j.weixin.request.material.response.batchget.BatchGetResponse;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TestWeiXinMaterialRequest {

    @Test
    public void TestUpload() throws WeiXinRequestException {
        String token = WeiXinAccessTokenRequest.request(
                "client_credential",
                "wx4458e6569617498d",
                "dbe4e50e8465023eee2a489216870375");
        System.out.println(token);

        MediaEntity entity = new MediaEntity();
        entity.setName("media");
        entity.setFile(new File("F:/image1.jpg"));

        MediaResponse response = WeiXinTmpMediaUploadRequest.request(token, MediaType.IMAGE, entity);
        System.out.println();
    }

    @Test
    public void TestGet() throws WeiXinRequestException {
        String token = WeiXinAccessTokenRequest.request(
                "client_credential",
                "wx4458e6569617498d",
                "dbe4e50e8465023eee2a489216870375");
        System.out.println(token);

        MediaEntity entity = new MediaEntity();
        entity.setName("media");
        entity.setFile(new File("F:/image1.jpg"));

        BufferedImage bufferedImage = WeiXinTmpMediaGetRequest.request(token, "O4hRSVDGE8Gjt5bQuxYYIujI1_jhRzfEp93-dB51rHn2Xim4KgNzAN4GZxf-hFtF");
        System.out.println();
    }

    @Test
    public void TestUploadImgToURL() throws WeiXinRequestException {
        String token = WeiXinAccessTokenRequest.request(
                "client_credential",
                "wx4458e6569617498d",
                "dbe4e50e8465023eee2a489216870375");
        System.out.println(token);

        MediaEntity entity = new MediaEntity();
        entity.setName("media");
        entity.setFile(new File("F:/image1.jpg"));

        String response = WeiXinMediaUploadImgToUrlRequest.request(token, entity);
        System.out.println();
    }

    @Test
    public void TestAddMaterial() throws WeiXinRequestException {
        String token = WeiXinAccessTokenRequest.request(
                "client_credential",
                "wx4458e6569617498d",
                "dbe4e50e8465023eee2a489216870375");
        System.out.println(token);

        MediaEntity entity = new MediaEntity();
        entity.setName("media");
        entity.setFile(new File("F:/15223011696871426367.jpg"));
        entity.setTitle("赵丽颖");

        MediaResponse response = WeiXinMaterialAddMaterialRequest.request(token, MediaType.IMAGE, entity);
        System.out.println();
    }

    @Test
    public void TestAddNews() throws WeiXinRequestException {
        String token = WeiXinAccessTokenRequest.request(
                "client_credential",
                "wx4458e6569617498d",
                "dbe4e50e8465023eee2a489216870375");
        System.out.println(token);

        NewsEntity entity = new NewsEntity();
        entity.setTitle("她真的太漂亮了1");
        entity.setAuthor("李文禾");
        entity.setContent(".....11111111111111");
        entity.setDigest("她真的太漂亮了1");
        entity.setShowCoverPic(1);
        entity.setThumbMediaId("uwKXhoxRnhxqICRAd7CCTCuLNvOyP8hdOVhOjeMMciA");

        List<NewsEntity> newsEntities = new ArrayList<>();
        newsEntities.add(entity);

        String response = WeiXinMaterialAddNewsRequest.request(token, newsEntities);
        System.out.println(response);
    }

    @Test
    public void TestDel() throws WeiXinRequestException {
        String token = WeiXinAccessTokenRequest.request(
                "client_credential",
                "wx4458e6569617498d",
                "dbe4e50e8465023eee2a489216870375");
        System.out.println(token);

        WeiXinMaterialDelMaterialRequest.request(token, "uwKXhoxRnhxqICRAd7CCTOU-pbalYwlYzwxBBEnO4rM");
    }

    @Test
    public void TestUpdateNews() throws WeiXinRequestException {
        String token = WeiXinAccessTokenRequest.request(
                "client_credential",
                "wx4458e6569617498d",
                "dbe4e50e8465023eee2a489216870375");
        System.out.println(token);

        NewsEntity entity = new NewsEntity();
        entity.setTitle("她真的太漂亮了2");
        entity.setAuthor("李文禾");
        entity.setContent(".....2222222222222222222");
        entity.setDigest("她真的太漂亮了2");
        entity.setShowCoverPic(1);
        entity.setThumbMediaId("uwKXhoxRnhxqICRAd7CCTCuLNvOyP8hdOVhOjeMMciA");

        WeiXinMaterialUpdateMaterialRequest.request(token, "uwKXhoxRnhxqICRAd7CCTLiL7jKn3IRheMSUbQa55EI", 0, entity);
    }

    @Test
    public void TestGetMaterial() throws WeiXinRequestException, IOException {
        String token = WeiXinAccessTokenRequest.request(
                "client_credential",
                "wx4458e6569617498d",
                "dbe4e50e8465023eee2a489216870375");
        System.out.println(token);

        List<NewsEntity> newsEntities = WeiXinMaterialGetMaterialRequest.request(token, "uwKXhoxRnhxqICRAd7CCTLiL7jKn3IRheMSUbQa55EI");
        System.out.println(newsEntities);

        VideoResponse response = WeiXinMaterialGetMaterialRequest.request(token, "8QZrcaDFjcHlcKLHwHCZkFgVuRkT4PdCJIn1eX5vO1w");
        System.out.println(response);

        InputStream is = WeiXinMaterialGetMaterialRequest.request(token, "hzNgKFoaHLTkPNsDzOljmyxJUYortFERZkZeMmpxvdg");
        BufferedImage bufferedImage = ImageIO.read(is);
        System.out.println();
    }

    @Test
    public void TestGetCount() throws WeiXinRequestException {
        String token = WeiXinAccessTokenRequest.request(
                "client_credential",
                "wx4458e6569617498d",
                "dbe4e50e8465023eee2a489216870375");
        System.out.println(token);

        CountResponse response = WeiXinMaterialGetMaterialCountRequest.request(token);
        System.out.println(response);
    }

    @Test
    public void TestBatchGet() throws WeiXinRequestException {
        String token = WeiXinAccessTokenRequest.request(
                "client_credential",
                "wx4458e6569617498d",
                "dbe4e50e8465023eee2a489216870375");
        System.out.println(token);

        BatchGetResponse response = WeiXinMaterialBatchGetMaterialRequest.request(token, MediaType.NEWS, 0, 20);
        System.out.println(response);
    }

}
