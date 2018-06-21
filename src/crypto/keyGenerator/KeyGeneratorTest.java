package crypto.keyGenerator;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

public class KeyGeneratorTest {
    //实例化keyGenerator对象并且指定算法。
    KeyGenerator keyGenerator;

    {
        try {
            keyGenerator = KeyGenerator.getInstance("HmacMD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    //使用密钥生成器产生SecretKey对象
    SecretKey secretKey = keyGenerator.generateKey();


}
