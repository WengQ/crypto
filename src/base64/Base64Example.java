package base64;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

public class Base64Example {
    private static String src = "Base64 encode using different ways";

    public static void main(String[] args) throws Exception{
        jdkBase64();
    }

    public static void jdkBase64() throws IOException {
        BASE64Encoder encoder = new BASE64Encoder(); //字符串要使用getBytes()方法变成字节数组才能被编码
        String code = encoder.encode(src.getBytes());//encode方法把字节数组编码成base64字符串
        System.out.println("base64 encode:" + code);

        BASE64Decoder decoder = new BASE64Decoder();
        byte[] plainText = decoder.decodeBuffer(code);//decodeBuffer方法把字符串解码成字节数组
        //打印字节数组用String类构造方法即可
        System.out.println("base64 decode:" + new String(plainText));
    }
}
