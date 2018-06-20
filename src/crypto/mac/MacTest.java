package crypto.mac;


import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;

public class MacTest {
    public static void main(String[] args) throws Exception {
        //原始消息，待被签名
        byte[] data = "I'm wengqi".getBytes();
        //工厂模式实例化密钥生成器keyGenerator，指定算法
        KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
        //获取秘密密钥
        SecretKey secretKey = keyGenerator.generateKey();
        //构建Mac对象
        Mac mac = Mac.getInstance(secretKey.getAlgorithm());
        //初始化Mac对象
        mac.init(secretKey);
        //获得经过安全消息摘要之后的信息
        byte[] output = mac.doFinal(data);
    }
}
