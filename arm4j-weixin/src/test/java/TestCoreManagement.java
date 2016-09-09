import com.arm4j.core.HttpURLConnFactoryManager;
import com.arm4j.weixin.WeiXinCoreManagement;
import org.testng.annotations.Test;

public class TestCoreManagement {

    @Test
    public void TestCoreManagement() {
        HttpURLConnFactoryManager coreManagement = WeiXinCoreManagement.getInstance();
        System.out.println();
    }

}
