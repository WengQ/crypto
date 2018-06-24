package digest.MAC;


import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class MacTest {

    //原始消息，待被hash
    static byte[] data = "mac algorithms".getBytes();

    public static void main(String[] args) throws Exception {
        jdkHmacMD5();
        bcHmacMD5();
    }

    public static void jdkHmacMD5() throws Exception{
        //工厂模式实例化密钥生成器keyGenerator，指定算法
        KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
        //获取秘密密钥
        SecretKey secretKey = keyGenerator.generateKey();
        //byte[] key = secretKey.getEncoded();
        byte[] key = Hex.decodeHex(new char[]{'a','a','a','a','a','a'});

        //根据密钥种子还原密钥???
        SecretKey restoreSecretKey = new SecretKeySpec(key,"HmacMD5");

        //构建Mac对象
        Mac mac = Mac.getInstance(secretKey.getAlgorithm());
        //初始化Mac对象
        mac.init(restoreSecretKey);
        //获得经过安全消息摘要之后的信息
        byte[] output = mac.doFinal(data);
        System.out.println("jdk HmacMD5: "+ Hex.encodeHexString(output));
    }

    public static void bcHmacMD5(){
        HMac hMac = new HMac(new MD5Digest());
        hMac.init(new KeyParameter(org.bouncycastle.util.encoders.Hex.decode("aaaaaa")));
        hMac.update(data,0,data.length);

        byte[] output = new byte[hMac.getMacSize()];
        hMac.doFinal(output, 0);

        System.out.println("bc HmacMD5: " + org.bouncycastle.util.encoders.Hex.toHexString(output));
    }
}
