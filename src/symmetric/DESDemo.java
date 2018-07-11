package symmetric;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.Security;

public class DESDemo {
    private static String src = "symmetric algorithms";

    public static void main(String args[]) throws Exception{
        jdkDES();
        bcDES();
    }

    public static void jdkDES()throws Exception{
        //生成key
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
        keyGenerator.init(56);//初始化密钥长度为56
        SecretKey secretKey = keyGenerator.generateKey();
        byte[] key = secretKey.getEncoded();

        //key转换
        DESKeySpec desKeySpec = new DESKeySpec(key);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
        SecretKey convertedSecretKey = factory.generateSecret(desKeySpec);

        //加密
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE,convertedSecretKey);
        byte[] result = cipher.doFinal(src.getBytes());
        System.out.println("jdk des encrypt: "+ Hex.encodeHexString(result));

        //解密
        cipher.init(Cipher.DECRYPT_MODE,convertedSecretKey);
        byte[] result1 = cipher.doFinal(result);
        System.out.println("jdk des decrypt: "+new String(result1));//此处要转成String，因为原始数据就是字符串
    }


    //bcDES
    public static void bcDES() throws Exception{
        Security.addProvider(new BouncyCastleProvider());
        //以下同上,除了在KeyGenerator对象获取时需要指定Provider

        //生成key
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES","BC");
        //keyGenerator.getProvider();//此处可以打断点查看provider是否是BC
        keyGenerator.init(56);//初始化密钥长度为56
        SecretKey secretKey = keyGenerator.generateKey();
        byte[] key = secretKey.getEncoded();

        //key转换
        DESKeySpec desKeySpec = new DESKeySpec(key);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
        SecretKey convertedSecretKey = factory.generateSecret(desKeySpec);

        //加密
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE,convertedSecretKey);
        byte[] result = cipher.doFinal(src.getBytes());
        System.out.println("bc des encrypt: "+ Hex.encodeHexString(result));

        //解密
        cipher.init(Cipher.DECRYPT_MODE,convertedSecretKey);
        byte[] result1 = cipher.doFinal(result);
        System.out.println("bc des decrypt: "+new String(result1));//此处要转成String，因为原始数据就是字符串
    }
}
