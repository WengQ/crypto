package security.signedObject;

import java.security.*;

public class SignedObjectTest {
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
        //----------------------------以下开始不同--------------------------------------
        //实例化SignedObject对象
        SignedObject signedObject = new SignedObject(data,privateKey,signature);
        //获得签名值
        byte[] sign = signedObject.getSignature();
        //获得验证结果
        boolean status = signedObject.verify(publicKey,signature);
        System.out.println(status);
    }
}
