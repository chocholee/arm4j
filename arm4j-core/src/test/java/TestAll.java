import com.arm4j.core.DefaultEntityParam;
import com.arm4j.core.DefaultURLParam;
import com.arm4j.core.HttpURLConnFactoryManager;
import com.arm4j.core.HttpURLConnRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.testng.annotations.Test;
import boot.Application;

public class TestAll {

    @Test
    public void TestAll() {
        // 启动spring web
        ApplicationContext ctx = SpringApplication.run(Application.class);
        HttpURLConnFactoryManager connFactoryManager = (HttpURLConnFactoryManager) ctx.getBean("connFactoryManager");

        // 测试带url参数的get请求
        HttpURLConnRequest requestGet = connFactoryManager.get("HelloGet")
                .createConn()
                .connect(
                        new DefaultURLParam
                                .Builder()
                                .add("name", "别说话")
                                .add("content", "吻我，我是GET")
                                .build());

        System.out.println(requestGet.doGet());

//      ========================================================================================================      //

        // 测试表单post请求
        HttpURLConnRequest requestPost = connFactoryManager.get("HelloPost")
                .createConn()
                .connect(
                        new DefaultURLParam
                                .Builder()
                                .add("name", "别说话")
                                .add("content", "吻我，我是POST")
                                .build());

        System.out.println(requestPost.doPost());

//      ========================================================================================================      //

        // 测试body post请求
        HttpURLConnRequest requestPostByBody = connFactoryManager.get("HelloPostByBody")
                .createConn()
                .connect(
                        new DefaultEntityParam("别说话，吻我，我是PostByBody"));

        System.out.println(requestPostByBody.doPost());

//      ========================================================================================================      //

        // 测试body post请求
        HttpURLConnRequest requestPostByFormAndBody = connFactoryManager.get("HelloPostByFormParamAndBody")
                .createConn()
                .connect(
                        new DefaultURLParam.Builder()
                                .add("name", "别说话")
                                .add("content", "吻我，我是表单参数")
                                .build(),
                        new DefaultEntityParam("别说话:吻我，我是Body"));

        System.out.println(requestPostByFormAndBody.doPost());
    }

}
