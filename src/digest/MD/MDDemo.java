package digest.MD;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD4Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.MessageDigest;
import java.security.Security;

public class MDDemo {

    private static String src = "MD digest algorithms";

    public static void main(String args[]) throws Exception{
        jdkMD2();
        ccMD2();

        jdkMD5();
        bcMD5();
        ccMD5();
        bcMD4();
        jdkWithBCMD4();

    }
    //JDK实现MD5算法
    public static void jdkMD5() throws Exception{
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] digest = md5.digest(src.getBytes());
        //说明：jdkMD5算法生成的摘要是字节数组，不能将其转换为16进制的字符串。
        //此处需要借助第三方库的类方法（CommonsCodec的Hex类的方法）来把字节数组转成16进制的字符串，再打印。
        //System.out.println(new String(digest));//无法打印
        System.out.println("JDK MD5 : "+Hex.encodeHexString(digest));
    }
    //JDK实现MD2算法
    public static void jdkMD2() throws Exception{
        MessageDigest md2 = MessageDigest.getInstance("MD2");
        byte[] digest = md2.digest(src.getBytes());
        System.out.println("JDK MD2 : "+Hex.encodeHexString(digest));
    }
    //JDK+BouncyCastle实现MD4算法
    public static void jdkWithBCMD4() throws Exception{
        //添加BC提供商
        Security.addProvider(new BouncyCastleProvider());
        //正常调用MD4就像jdk本身就支持MD4算法一样
        MessageDigest md4 = MessageDigest.getInstance("MD4");
        byte[] digest = md4.digest(src.getBytes());
        System.out.println("J&BC MD4 : "+Hex.encodeHexString(digest));
    }

    //BouncyCastle实现MD4
    public static void bcMD4() {
        Digest md4 = new MD4Digest();
        md4.update(src.getBytes(),0,src.getBytes().length);
        //生成和摘要一样长的字节数组md4Digest用于存放md4摘要
        byte[] md4Digest = new byte[md4.getDigestSize()];
        md4.doFinal(md4Digest,0);
        //此处使用BC库Hex类的toHexString方法。
        System.out.println("BC MD4: " + org.bouncycastle.util.encoders.Hex.toHexString(md4Digest));
    }

    //BouncyCastle实现MD5
    public static void bcMD5() {
        Digest md5 = new MD5Digest();
        md5.update(src.getBytes(),0,src.getBytes().length);
        //生成和摘要一样长的字节数组md4Digest用于存放md4摘要
        byte[] md5Digest = new byte[md5.getDigestSize()];
        md5.doFinal(md5Digest,0);
        //此处使用BC库Hex类的toHexString方法。
        System.out.println("BC MD5: " + org.bouncycastle.util.encoders.Hex.toHexString(md5Digest));
    }

    //CommonsCodec实现MD5
    public static void ccMD5(){
        System.out.println("CC MD5: " + DigestUtils.md5Hex(src.getBytes()));
    }
    //CommonsCodec实现MD2
    public static void ccMD2(){
        System.out.println("CC MD2: " + DigestUtils.md2Hex(src.getBytes()));
    }
}
