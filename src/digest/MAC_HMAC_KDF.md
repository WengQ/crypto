# MAC & HMAC & KDF
## Def
- MAC: Message authentication codes
- HMAC: hash-based message authentication code
- KDF: key derivation functions

MAC是一种数字认证码，类似于数字签名，但是MAC需要双方预先共享一个key。

MAC算法近似于带密钥的hash算法，产生的结果也是不可逆推的随机值，如果使用现有的hash算法，则MAC成为HMAC，除了hash算法，也可以使用其它的算法。

部分可认证加密算法中集成了MAC算法，如AES—GCM
## Mechanism
### MAC使用场景
#### 1.Authenticate message
- 双方都事先持有相同的密钥（pre-shared secret key）并且都能看到传递的消息明文。
- 消息格式：plainText || MAC
- 接收方使用收到的消息（plainText || MAC）得到明文plainText，配合密钥计算MAC。`auth_code = MAC(key, plainText)`

场景一接收方想要验证明文消息的完整性，发送方直接传输明文，不适用于明文需要保密的情况。

#### 2.Authenticated Encryption
- 双方持有相同的password，用password派生密钥key，key用于计算MAC。
- cipherText = enc(plainText, key)
- auth_code = MAC(plainText, key)
- 传输消息格式：cipherText || auth_code，即enc(plainText, key) || MAC(plainText, key)
- 接受方用password派生密钥key，plainText' = dec(cipherText, key)，auth_code' = MAC(plainText', key)
- 若auth_code' == auth_code，则说明原文完整且password正确。

场景二收发双方用于可认证完整性的加密传输信息，用法类似于AES-GCM等加密方法。

#### 3.MAC-Based Pseudo-Random Generator
特定salt不变，随机seed，每一轮计算出伪随机数，然后作为下一轮新的seed
- next_seed = MAC(salt, seed)

## HMAC
HMAC是MAC算法最常见的实现方式之一。

### 注意！
HMAC的实现方式并不仅仅是用Hash算法计算msg和key，形如SHA256（msg || key）这种做法是错误的，
