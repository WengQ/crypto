#Base64原理
有多种实现：
- JDK 是Oracle（Sun）公司实现的
- Commons Codec 是Apache旗下的一款开源软件
- Bouncy Castle

建议使用后两种方法，实现更简单。
需要注意的是Commons Codec 和 Bouncy Castle 
对于Base64编解码的实现方式并不一样。
Base64本身没有编解码的标准，所以不可混用，具体需要根据实际场景选择。
