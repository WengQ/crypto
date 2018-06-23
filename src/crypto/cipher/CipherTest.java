package crypto.cipher;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/*
* 用Cipher类完成密钥的包装与解包装
* */
public class CipherTest {
    public static void main(String[] args) throws Exception{
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
        SecretKey secretKey = keyGenerator.generateKey();


        //实例化Cipher对象，初始化为DES算法
        Cipher cipher = Cipher.getInstance("DES");
        //初始化为包装模式
        cipher.init(Cipher.WRAP_MODE,secretKey);
        //包装密钥
        byte[] wrappedKey = cipher.wrap(secretKey);
        //初始化解包Cipher对象
        cipher.init(Cipher.UNWRAP_MODE,secretKey);

    }
}
