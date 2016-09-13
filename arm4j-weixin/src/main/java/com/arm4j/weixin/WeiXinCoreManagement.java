package com.arm4j.weixin;

import com.arm4j.core.HttpURLConnFactory;
import com.arm4j.core.HttpURLConnFactoryManager;

import java.util.HashMap;
import java.util.Map;

/**
 * 微信核心管理工具(单例)
 *
 * @author liwenhe
 */
@SuppressWarnings("unchecked")
public class WeiXinCoreManagement {

    private static final Map factoryPool = new HashMap<String, HttpURLConnFactory>();

    // 初始化默认参数
    static {
        // 获取access_token接口
        HttpURLConnFactory accessTokenFactory   = new HttpURLConnFactory(WeiXinToken.ACCESS_TOKEN.getName());
        factoryPool.put(WeiXinToken.ACCESS_TOKEN, accessTokenFactory);

        // 获取微信服务器ip接口
        HttpURLConnFactory getCallbackIpFactory = new HttpURLConnFactory(WeiXinToken.GET_CALLBACK_IP.getName());
        factoryPool.put(WeiXinToken.GET_CALLBACK_IP, getCallbackIpFactory);

        // 菜单相应接口(创建、查询)
        HttpURLConnFactory menuCreateFactory                    = new HttpURLConnFactory(WeiXinToken.MENU_CREATE.getName());
        HttpURLConnFactory menuGetFactory                       = new HttpURLConnFactory(WeiXinToken.MENU_GET.getName());
        HttpURLConnFactory menuDeleteFactory                    = new HttpURLConnFactory(WeiXinToken.MENU_DELETE.getName());
        HttpURLConnFactory menuAddConditionalFactory            = new HttpURLConnFactory(WeiXinToken.MENU_ADD_CONDITIONAL.getName());
        HttpURLConnFactory menuDelConditionalFactory            = new HttpURLConnFactory(WeiXinToken.MENU_DEL_CONDITIONAL.getName());
        factoryPool.put(WeiXinToken.MENU_CREATE, menuCreateFactory);
        factoryPool.put(WeiXinToken.MENU_GET, menuGetFactory);
        factoryPool.put(WeiXinToken.MENU_DELETE, menuDeleteFactory);
        factoryPool.put(WeiXinToken.MENU_ADD_CONDITIONAL, menuAddConditionalFactory);
        factoryPool.put(WeiXinToken.MENU_DEL_CONDITIONAL, menuDelConditionalFactory);

        // 临时素材(上传、获取)
        HttpURLConnFactory mediaUploadFactory                   = new HttpURLConnFactory(WeiXinToken.MEDIA_UPLOAD.getName());
        HttpURLConnFactory mediaGetFactory                      = new HttpURLConnFactory(WeiXinToken.MEDIA_GET.getName());
        HttpURLConnFactory mediaUploadImgFactory                = new HttpURLConnFactory(WeiXinToken.MEDIA_UPLOAD_IMG_TO_URL.getName());
        factoryPool.put(WeiXinToken.MEDIA_UPLOAD, mediaUploadFactory);
        factoryPool.put(WeiXinToken.MEDIA_GET, mediaGetFactory);
        factoryPool.put(WeiXinToken.MEDIA_UPLOAD_IMG_TO_URL, mediaUploadImgFactory);

        // 添加永久素材(添加图文素材、更新图文素材、上传素材、获取素材、删除素材、获取素材总数、批量获取素材)
        HttpURLConnFactory materialAddNewsFactory               = new HttpURLConnFactory(WeiXinToken.MATERIAL_ADD_NEWS.getName());
        HttpURLConnFactory materialUpdateNewsFactory            = new HttpURLConnFactory(WeiXinToken.MATERIAL_UPDATE_NEWS.getName());
        HttpURLConnFactory materialAddMaterialFactory           = new HttpURLConnFactory(WeiXinToken.MATERIAL_ADD_MATERIAL.getName());
        HttpURLConnFactory materialGetMaterialFactory           = new HttpURLConnFactory(WeiXinToken.MATERIAL_GET_MATERIAL.getName());
        HttpURLConnFactory materialDelMaterialFactory           = new HttpURLConnFactory(WeiXinToken.MATERIAL_DEL_MATERIAL.getName());
        HttpURLConnFactory materialGetMaterialCountFactory      = new HttpURLConnFactory(WeiXinToken.MATERIAL_GET_MATERIAL_COUNT.getName());
        HttpURLConnFactory materialBatchGetMaterialFactory      = new HttpURLConnFactory(WeiXinToken.MATERIAL_BATCH_GET_MATERIAL.getName());
        factoryPool.put(WeiXinToken.MATERIAL_ADD_NEWS, materialAddNewsFactory);
        factoryPool.put(WeiXinToken.MATERIAL_UPDATE_NEWS, materialUpdateNewsFactory);
        factoryPool.put(WeiXinToken.MATERIAL_ADD_MATERIAL, materialAddMaterialFactory);
        factoryPool.put(WeiXinToken.MATERIAL_GET_MATERIAL, materialGetMaterialFactory);
        factoryPool.put(WeiXinToken.MATERIAL_DEL_MATERIAL, materialDelMaterialFactory);
        factoryPool.put(WeiXinToken.MATERIAL_GET_MATERIAL_COUNT, materialGetMaterialCountFactory);
        factoryPool.put(WeiXinToken.MATERIAL_BATCH_GET_MATERIAL, materialBatchGetMaterialFactory);

        // 用户标签管理(创建、获取、编辑、删除、获取粉丝、获取用户身上标签、批量为用户打标签、批量为用户取消标签)
        HttpURLConnFactory tagsCreateFactory                    = new HttpURLConnFactory(WeiXinToken.TAGS_CREATE.getName());
        HttpURLConnFactory tagsGetFactory                       = new HttpURLConnFactory(WeiXinToken.TAGS_GET.getName());
        HttpURLConnFactory tagsUpdateFactory                    = new HttpURLConnFactory(WeiXinToken.TAGS_UPDATE.getName());
        HttpURLConnFactory tagsDeleteFactory                    = new HttpURLConnFactory(WeiXinToken.TAGS_DELETE.getName());
        HttpURLConnFactory tagsUserGetFactory                   = new HttpURLConnFactory(WeiXinToken.TAGS_USER_GET.getName());
        HttpURLConnFactory tagsGetIdListFactory                 = new HttpURLConnFactory(WeiXinToken.TAGS_GETIDLIST.getName());
        HttpURLConnFactory tagsMembersBatchTaggingFactory       = new HttpURLConnFactory(WeiXinToken.TAGS_MEMBERS_BATCHTAGGING.getName());
        HttpURLConnFactory tagsMembersBatchUnTaggingFactory     = new HttpURLConnFactory(WeiXinToken.TAGS_MEMBERS_BATCHUNTAGGING.getName());
        factoryPool.put(WeiXinToken.TAGS_CREATE, tagsCreateFactory);
        factoryPool.put(WeiXinToken.TAGS_GET, tagsGetFactory);
        factoryPool.put(WeiXinToken.TAGS_UPDATE, tagsUpdateFactory);
        factoryPool.put(WeiXinToken.TAGS_DELETE, tagsDeleteFactory);
        factoryPool.put(WeiXinToken.TAGS_USER_GET, tagsUserGetFactory);
        factoryPool.put(WeiXinToken.TAGS_GETIDLIST, tagsGetIdListFactory);
        factoryPool.put(WeiXinToken.TAGS_MEMBERS_BATCHTAGGING, tagsMembersBatchTaggingFactory);
        factoryPool.put(WeiXinToken.TAGS_MEMBERS_BATCHUNTAGGING, tagsMembersBatchUnTaggingFactory);

        // 用户信息(设置用户备注名、获取用户基本信息、批量获取用户信息、获取用户列表)
        HttpURLConnFactory userInfoUpdateRemarkFactory          = new HttpURLConnFactory(WeiXinToken.USER_INFO_UPDATE_REMARK.getName());
        HttpURLConnFactory userInfoGetFactory                   = new HttpURLConnFactory(WeiXinToken.USER_INFO_GET.getName());
        HttpURLConnFactory userInfoBatchGetFactory              = new HttpURLConnFactory(WeiXinToken.USER_INFO_BATCH_GET.getName());
        HttpURLConnFactory userListGetFactory                   = new HttpURLConnFactory(WeiXinToken.USER_LIST_GET.getName());
        factoryPool.put(WeiXinToken.USER_INFO_UPDATE_REMARK, userInfoUpdateRemarkFactory);
        factoryPool.put(WeiXinToken.USER_INFO_GET, userInfoGetFactory);
        factoryPool.put(WeiXinToken.USER_INFO_BATCH_GET, userInfoBatchGetFactory);
        factoryPool.put(WeiXinToken.USER_LIST_GET, userListGetFactory);

        // 长链接转短链接接口
        HttpURLConnFactory shortUrlFactory      = new HttpURLConnFactory(WeiXinToken.SHORT_URL.getName());
        factoryPool.put(WeiXinToken.SHORT_URL, shortUrlFactory);

        //  二维码(创建、查看)
        HttpURLConnFactory qrCodeCreateFactory  = new HttpURLConnFactory(WeiXinToken.QRCODE_CREATE.getName());
        HttpURLConnFactory qrCodeShowFactory    = new HttpURLConnFactory(WeiXinToken.QRCODE_SHOW.getName());
        factoryPool.put(WeiXinToken.QRCODE_CREATE, qrCodeCreateFactory);
        factoryPool.put(WeiXinToken.QRCODE_SHOW, qrCodeShowFactory);
    }

    private static WeiXinCoreManagement instance = null;

    private HttpURLConnFactoryManager connFactoryManager = null;

    private WeiXinCoreManagement() {
        this.connFactoryManager = new HttpURLConnFactoryManager(factoryPool);
    }

    public static HttpURLConnFactoryManager getInstance() {
        if (null == instance) {
            synchronized (WeiXinCoreManagement.class) {
                if (null == instance) {
                    instance = new WeiXinCoreManagement();
                    return instance.connFactoryManager;
                }
            }
        }
        return instance.connFactoryManager;
    }
}
