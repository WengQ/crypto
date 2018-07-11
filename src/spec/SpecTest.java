package spec;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class SpecTest {
    /**
     * 测试结果：由KeyGenerator产生的SecretKey和由SecretKeySpec还原byte[]得到的SecretKey是equal的，但不是同一个引用，非==的。
     * 那么SecretKeySpec的作用是什么？因为KeyGenerator生成的密钥是系统随机的，测试过程中每次都不一样
     * SecretKeySpec可以指定byte[]，这样每次生成的密钥都是一样的。
     * @param args
     * @throws Exception
     */
    public static void main (String args[]) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("RC2");
        SecretKey secretKey = keyGenerator.generateKey();

        byte[] keyEncoded = secretKey.getEncoded();
        SecretKey secretKey1 = new SecretKeySpec(keyEncoded,"RC2");

        System.out.println(secretKey == secretKey1);
    }
}
