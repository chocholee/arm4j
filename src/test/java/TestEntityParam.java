import com.arm4j.core.DefaultEntityParam;
import com.arm4j.core.DefaultURLParam;
import com.arm4j.core.Param;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestEntityParam {

    @Test
    public void TestParam() {
        Param param = new DefaultEntityParam("test entity");
        Assert.assertNotNull(param);
        Assert.assertNotNull(param.getParam());
        System.out.println(param.getParam());
    }

    @Test
    public void TestRefactorEntityParam() {
        class RefactorEntityParam extends DefaultEntityParam {
            // TODO 自定义
            private String age;
            private String name;

            public RefactorEntityParam(String age, String name) {
                this.age = age;
                this.name = name;
            }

            // TODO 统一调配方法
            @Override
            public String getParam() {
                return new DefaultURLParam
                        .Builder()
                        .add("name", name)
                        .add("age", age)
                        .build()
                        .getParam();
            }
        }

        Param param = new RefactorEntityParam("lee", "21");
        Assert.assertNotNull(param);
        System.out.println(param.getParam());
    }

}
