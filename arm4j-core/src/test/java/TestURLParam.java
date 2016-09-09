import com.arm4j.core.DefaultURLParam;
import com.arm4j.core.Param;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestURLParam {

    @Test
    public void TestParam() {
        DefaultURLParam param = new DefaultURLParam
                .Builder()
                .add("name", "lee")
                .add("age", "21")
                .add("#us")
                .build();
        Assert.assertNotNull(param);
        Assert.assertNotNull(param.getParam());
        System.out.println(param.getParam());

        System.out.println("asc: " + param.asc().getParam());
        System.out.println("desc: " + param.desc().getParam());
    }

    @Test
    public void TestRefactorURLParam() {
        class RefactorURLParam extends DefaultURLParam {
            // TODO 自定义
            @Override
            public String getParam() {
                // TODO 必须重写此方法，统一调配
                return null;
            }
        }
        Assert.assertNull(new RefactorURLParam().getParam());
    }

}
