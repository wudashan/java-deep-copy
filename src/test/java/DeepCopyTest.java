import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import model.Address;
import model.User;
import org.apache.commons.lang.SerializationUtils;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertNotSame;

public class DeepCopyTest {

    @Test
    public void constructorCopy() {

        Address address = new Address("杭州", "中国");
        User user = new User("大山", address);

        // 通过构造函数进行深拷贝
        User copyUser = new User(user.getName(), new Address(address.getCity(), address.getCountry()));

        // 修改源对象的值
        user.getAddress().setCity("深圳");

        // 检查两个对象的值不同
        assertNotSame(user.getAddress().getCity(), copyUser.getAddress().getCity());

    }

    @Test
    public void cloneCopy() throws CloneNotSupportedException {

        Address address = new Address("杭州", "中国");
        User user = new User("大山", address);

        // 调用clone()方法进行深拷贝
        User copyUser = user.clone();

        // 修改源对象的值
        user.getAddress().setCity("深圳");

        // 检查两个对象的值不同
        assertNotSame(user.getAddress().getCity(), copyUser.getAddress().getCity());

    }

    @Test
    public void serializableCopy() {

        Address address = new Address("杭州", "中国");
        User user = new User("大山", address);

        // 使用序列化进行深拷贝
        User copyUser = (User) SerializationUtils.clone(user);

        // 修改源对象的值
        user.getAddress().setCity("深圳");

        // 检查两个对象的值不同
        assertNotSame(user.getAddress().getCity(), copyUser.getAddress().getCity());

    }

    @Test
    public void gsonCopy() {

        Address address = new Address("杭州", "中国");
        User user = new User("大山", address);

        // 使用Gson进行深拷贝
        Gson gson = new Gson();
        User copyUser = gson.fromJson(gson.toJson(user), User.class);

        // 修改源对象的值
        user.getAddress().setCity("深圳");

        // 检查两个对象的值不同
        assertNotSame(user.getAddress().getCity(), copyUser.getAddress().getCity());

    }

    @Test
    public void jacksonCopy() throws IOException {

        Address address = new Address("杭州", "中国");
        User user = new User("大山", address);

        // 使用Jackson进行深拷贝
        ObjectMapper objectMapper = new ObjectMapper();
        User copyUser = objectMapper.readValue(objectMapper.writeValueAsString(user), User.class);

        // 修改源对象的值
        user.getAddress().setCity("深圳");

        // 检查两个对象的值不同
        assertNotSame(user.getAddress().getCity(), copyUser.getAddress().getCity());

    }

}
