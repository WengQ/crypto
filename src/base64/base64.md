#Base64原理
一句话：8×3 = 4×6
###Base64算法的出现背景
邮件的历史问题，有些网关只支持ASCII的编码，故在传输的过程中编码成Base64的，
Base64只需要64个ASCII码，编码标准是RFC 2045.

有多种实现：
- JDK 是Oracle（Sun）公司实现的
- Commons Codec 是Apache旗下的一款开源软件
- Bouncy Castle

建议使用后两种方法，实现更简单。
需要注意的是Commons Codec 和 Bouncy Castle 
对于URL Base64编解码的实现方式并不一样。
Base64本身没有编解码的标准，所以不可混用，具体需要根据实际场景选择。

##Base64的应用场景
Email，密钥的存储，证书文件等

###衍生
Base16，Base32，URL Base64