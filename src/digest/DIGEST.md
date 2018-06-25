#哈希算法
JDK实现Hash算法用的都是MessageDigest类，通过不同参数的getInstance()来实现不同的对象。
    
    `MessageDigest md5 = MessageDigest.getInstance("MD5");`
BC和CC则分别使用Digest接口的不同实现和DigestUtils类下封装的不同方法来实现。
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

Commons Codec也只支持MD2，MD5摘要算法，因为CC源码是对Security包内方法的封装，本质上还是调用JDK实现的，
但是更好写,CC的摘要方法支持String类型的参数，输出也是String，一行完事。

总结：CC比JDK简洁，BC补充了JDK没有的MD4

应用：注册账号时在数据库存储“用户名-密码MD5值”的键值对，然后登陆的时候计算密钥的MD5放入请求中，服务器根据用户名找到摘要，即可验证，且无需将密码存放在服务器数据库中。
###SHA算法族
固定长度的摘要信息（数字即长度）
- SHA-1（160位）JDK实现
- SHA-2（224，256，384，512）224由BC实现，其余JDK有实现。

同MD算法一样，CC提供简化实现，BC补充实现。

应用：传输原文+摘要+timeStamp，防止过程中的中间人攻击。

###MAC消息摘要算法
- MAC(message authentication code)
- HMAC(keyed-hash message authentication code)含有密钥的散列函数算法

融合了MD，SHA
- MD系列：HmacMD2，4，5 （都是128位）
- SHA系列：HmacSHA1，224，256，384，512

JDK没有实现HmacMD2，4以及HmacSHA224，由BC补充，其余都实现了

MAC算法和前面2个摘要算法是有区别的。首先，MAC是有密钥的。
故需要KeyGenerator类来产生密钥。


###应用
- secureCRT

- MAC算法在消息传递中的应用：

    1.发送方公布消息摘要算法

    2.发送方构建密钥

    3.发送密钥

    4.对发送的消息计算MAC

    5.发送MAC，发送消息

    6.接收方验证消息和MAC是否对应

###其它消息摘要算法
- RipeMD
- Tiger
- Whirlpool
- GOST3411

这些都只有BC的实现。

