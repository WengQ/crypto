#哈希算法

###MD算法族
都生成128位的摘要信息

- MD2   JDK实现
- MD4   JDK没有提供实现，需要借助Bouncy Castle实现
- MD5   JDK实现
    
JDK生成的摘要信息是字节数组，转成16进制的字符串需要借助第三方库的类方法（如CommonsCodec的Hex类的.encodeHexString()方法，或者
BC库Hex类的toHexString()方法等）。
Bouncy Castle和Commons Codec都支持16进制字符串的摘要信息。

JDK可以调用addProvider(new BouncyCastleProvider())来添加BC提供商，也可以使用配置文件的方式（Java\jdk1.8.0_131\jre\lib\security\java.security）
然后正常调用MD4就像本身就支持MD4算法一样。

Commons Codec也只支持MD2，MD5摘要算法，因为CC源码是对Security包内方法的封装，本质上还是调用JDK实现的，但是更好写（一行就够了）。

总结：CC比JDK简洁，BC补充了JDK没有的MD4
###SHA算法族
- 
- 


###MAC
