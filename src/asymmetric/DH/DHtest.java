package asymmetric.DH;

import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

public class DHtest {
    public static void main(String[] args) throws Exception{
        //构建甲方密钥对
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DH");
        keyPairGenerator.initialize(1024);
        KeyPair keyPair = keyPairGenerator.genKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        //由甲方构建乙方的密钥对
        DHParameterSpec dhParameterSpec = ((DHPublicKey) publicKey).getParams();
    }
}
