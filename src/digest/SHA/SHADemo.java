package digest.SHA;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA224Digest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.MessageDigest;
import java.security.Security;

public class SHADemo {
    private static String src = "sha digest algorithms";

    public static void main(String args[]) throws Exception {
        jdkSHA1();
        bcSHA1();
        ccSHA();
        bcSHA224();
        jdkWithBCSHA224();

    }
    //jdkSHA1
    public static void jdkSHA1() throws Exception {
        MessageDigest sha1 = MessageDigest.getInstance("SHA");
        sha1.update(src.getBytes());
        System.out.println("jdk sha1: " + Hex.encodeHexString(sha1.digest()));
    }
    //bcSHA1
    public static void bcSHA1() {
        Digest digest = new SHA1Digest();
        digest.update(src.getBytes(), 0, src.getBytes().length);
        byte[] sha1 = new byte[digest.getDigestSize()];
        digest.doFinal(sha1, 0);
        System.out.println("BC  sha1: " + org.bouncycastle.util.encoders.Hex.toHexString(sha1));
    }
    //bcSHA224
    public static void bcSHA224() {
        Digest digest = new SHA224Digest();
        digest.update(src.getBytes(), 0, src.getBytes().length);
        byte[] sha224 = new byte[digest.getDigestSize()];
        digest.doFinal(sha224, 0);
        System.out.println("BC  sha224: " + org.bouncycastle.util.encoders.Hex.toHexString(sha224));
    }
    //jdk & BC
    public static void jdkWithBCSHA224() throws Exception{
        Security.addProvider(new BouncyCastleProvider());
        MessageDigest sha224 = MessageDigest.getInstance("SHA224");
        byte[] digest = sha224.digest(src.getBytes());
        System.out.println("jdkBC sha224: "+Hex.encodeHexString(digest));
    }

    //ccSHA
    public static void ccSHA(){
        System.out.println("CC  sha1: " + DigestUtils.sha1Hex(src.getBytes()));
        System.out.println("CC  sha1: " + DigestUtils.sha1Hex(src));
    }
}