package crypto.keyGenerator;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.NoSuchAlgorithmException;

public class KeyGeneratorTest {
    public static void main(String[] args) throws Exception{

        //实例化keyGenerator对象并且指定算法。
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
        //使用密钥生成器产生SecretKey对象
        SecretKey secretKey = keyGenerator.generateKey();
        //获得秘密密钥的密钥编码字节数组
        byte[] key = secretKey.getEncoded();
        System.out.println(secretKey);

        //---------密钥的字节数组可能用于传输之类的
        //---------接收方可以根据密钥的字节数组 使用 SecretKeyFactory来还原秘密密钥

        //构建DESKeySpec对象
        DESKeySpec desKeySpec = new DESKeySpec(key);
        //实例化SecretKeyFactory对象
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");
        //生成SecretKey对象
        SecretKey secretKey1 = secretKeyFactory.generateSecret(desKeySpec);
        //打印出来的secretKey对象和编码前的是同一个对象。
        System.out.println(secretKey1);
    }


}
