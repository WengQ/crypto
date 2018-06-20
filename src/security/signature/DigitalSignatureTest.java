package security.signature;


import java.security.*;

public class DigitalSignatureTest {
    public static void main(String[] args) throws Exception {
        //原始消息，待被签名
        byte[] data = "I'm wengqi".getBytes();
        //工厂模式实例化密钥对生成器，指定算法，初始化密钥长度
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA");
        keyPairGenerator.initialize(1024);
        //获取密钥对，获取公私密钥
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();
        //工厂模式实例化签名对象，用私钥初始化，更新要签名的数据
        Signature signature = Signature.getInstance(keyPairGenerator.getAlgorithm());
        signature.initSign(privateKey);
        signature.update(data);
        //获得签名
        byte[] sign = signature.sign();
        //初始化用于验证的签名对象，更新要验证的数据
        signature.initVerify(publicKey);
        signature.update(data);
        //获得验证结果
        boolean status = signature.verify(sign);

        System.out.println(status);
    }
}
