package crypto.keyAgreement;

import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class KeyAgreementTest {
    public static void main (String[] args) throws Exception{
        /*
        * 2个人各持有一对密钥，然后用自己的私钥执行init，再用对方的公钥执行doPhase，完成DH密钥交换。
        * 本例用keyPair2的持有者作为本人
        * */
        //DH算法密钥对生成
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DH");
        //生成2个密钥对
        KeyPair keyPair1 = keyPairGenerator.genKeyPair();
        KeyPair keyPair2 = keyPairGenerator.genKeyPair();
        //实例化KeyAgreement对象,参数指定是KeyPairGenerator的算法
        KeyAgreement keyAgreement = KeyAgreement.getInstance(keyPairGenerator.getAlgorithm());

        //用自己的私钥初始化KeyAgreement对象，然后用对方的公钥执行doPhase
        keyAgreement.init(keyPair2.getPrivate());
        keyAgreement.doPhase(keyPair1.getPublic(),true);

        //获得公共的传输密钥,指定传输密钥类型为DES
        SecretKey secretKey = keyAgreement.generateSecret("DES");

        System.out.println(secretKey);
    }
}
