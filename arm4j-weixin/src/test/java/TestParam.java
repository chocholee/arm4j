import com.arm4j.core.DefaultURLParam;

public class TestParam {

    public static void main(String[] args) {
        DefaultURLParam.Builder builder = new DefaultURLParam.Builder().add("key", "123").add("value", "321");
        System.out.println();

        DefaultURLParam.Builder builder1 = new DefaultURLParam.Builder().add("key1", "123").add("value1", "321");
        System.out.println();
    }

}
