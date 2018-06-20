package security.timeStamp;

import java.io.FileInputStream;
import java.security.Timestamp;
import java.security.cert.CertPath;
import java.security.cert.CertificateFactory;
import java.util.Date;

public class TimeStampTest {
    public static void main(String[] args) throws Exception{
        //获得CertificateFactory对象，指定证书类型为X.509
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X509");
        //生成证书路径对象，以供时间戳对象初始化使用
        CertPath certPath = certificateFactory.generateCertPath(new FileInputStream("C://"));
        //构建时间戳需要提供时间和签名证书路径2个参数
        Timestamp timestamp = new Timestamp(new Date(),certPath);
    }

}
