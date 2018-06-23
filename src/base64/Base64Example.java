package base64;

import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

public class Base64Example {
    private static String src = "Base64 encode using different ways";

    public static void main(String[] args) throws Exception{
        //jdkBase64();
        //commonsCodecBase64();
        bouncyCastleBase64();
    }
    //JDK的方法完成Base64的加解密
    public static void jdkBase64() throws IOException {
        BASE64Encoder encoder = new BASE64Encoder(); //字符串要使用getBytes()方法变成字节数组才能被编码
        String code = encoder.encode(src.getBytes());//encode方法把字节数组编码成base64字符串
        System.out.println("base64 encode:" + code);

        BASE64Decoder decoder = new BASE64Decoder();
        byte[] plainText = decoder.decodeBuffer(code);//decodeBuffer方法把字符串解码成字节数组
        //打印字节数组用String类构造方法即可
        System.out.println("base64 decode:" + new String(plainText));
    }

    //CommonsCodec的方式完成Base64的加解密
    public static void commonsCodecBase64() {
        //不同之处：encodeBase64()返回值还是byte[],若想返回字符串则使用encodeBase64String()
        byte[] code = Base64.encodeBase64(src.getBytes());
        System.out.println("base64 encode:" + new String(code));

        byte[] plainText = Base64.decodeBase64(code);
        System.out.println("base64 decode:" + new String(plainText));
    }

    //CommonsCodec的方式完成Base64的加解密
    public static void bouncyCastleBase64() {
        byte[] code = org.bouncycastle.util.encoders.Base64.encode(src.getBytes());
        System.out.println("base64 encode:" + new String(code));

        byte[] plainText = org.bouncycastle.util.encoders.Base64.decode(code);
        System.out.println("base64 decode:" + new String(plainText));
    }
}
