package com.arm4j.weixin.request.material;

import com.arm4j.core.DefaultURLParam;
import com.arm4j.weixin.WeiXinCoreManagement;
import com.arm4j.weixin.WeiXinToken;
import com.arm4j.weixin.exception.WeiXinRequestException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

@SuppressWarnings("unchecked")
public class WeiXinTmpMediaGetRequest {

    public static BufferedImage request(String accessToken, String mediaId) throws WeiXinRequestException {
        // 发送请求
        InputStream is = WeiXinCoreManagement.getInstance().get(WeiXinToken.MEDIA_GET)
                .createConn()
                .connect(
                        new DefaultURLParam.Builder()
                                .add("access_token", accessToken)
                                .add("media_id", mediaId)
                                .build()
                ).doGetAsStream();

        // 生成二维码图片
        try {
            BufferedImage tmpBufferedImage = ImageIO.read(is);
            BufferedImage bufferedImage = new BufferedImage(
                    tmpBufferedImage.getWidth(),
                    tmpBufferedImage.getHeight(),
                    BufferedImage.TYPE_INT_RGB);

            Graphics2D graphics2D = (Graphics2D) bufferedImage.getGraphics();
            graphics2D.drawImage(tmpBufferedImage, 0, 0, null);
            graphics2D.dispose();

            is.close();
            bufferedImage.flush();

            return bufferedImage;
        } catch (IOException e) {
            throw new WeiXinRequestException(e);
        }
    }

}
