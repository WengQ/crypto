# MAC & HMAC & KDF
## Def
- MAC: Message authentication codes
- HMAC: hash-based message authentication code
- KDF: key derivation functions

MAC��һ��������֤�룬����������ǩ��������MAC��Ҫ˫��Ԥ�ȹ���һ��key��

MAC�㷨�����ڴ���Կ��hash�㷨�������Ľ��Ҳ�ǲ������Ƶ����ֵ�����ʹ�����е�hash�㷨����MAC��ΪHMAC������hash�㷨��Ҳ����ʹ���������㷨��

���ֿ���֤�����㷨�м�����MAC�㷨����AES��GCM
## Mechanism
### MACʹ�ó���
#### 1.Authenticate message
- ˫�������ȳ�����ͬ����Կ��pre-shared secret key�����Ҷ��ܿ������ݵ���Ϣ���ġ�
- ��Ϣ��ʽ��plainText || MAC
- ���շ�ʹ���յ�����Ϣ��plainText || MAC���õ�����plainText�������Կ����MAC��`auth_code = MAC(key, plainText)`

����һ���շ���Ҫ��֤������Ϣ�������ԣ����ͷ�ֱ�Ӵ������ģ���������������Ҫ���ܵ������

#### 2.Authenticated Encryption
- ˫��������ͬ��password����password������Կkey��key���ڼ���MAC��
- cipherText = enc(plainText, key)
- auth_code = MAC(plainText, key)
- ������Ϣ��ʽ��cipherText || auth_code����enc(plainText, key) || MAC(plainText, key)
- ���ܷ���password������Կkey��plainText' = dec(cipherText, key)��auth_code' = MAC(plainText', key)
- ��auth_code' == auth_code����˵��ԭ��������password��ȷ��

�������շ�˫�����ڿ���֤�����Եļ��ܴ�����Ϣ���÷�������AES-GCM�ȼ��ܷ�����

#### 3.MAC-Based Pseudo-Random Generator
�ض�salt���䣬���seed��ÿһ�ּ����α�������Ȼ����Ϊ��һ���µ�seed
- next_seed = MAC(salt, seed)

## HMAC
HMAC��MAC�㷨�����ʵ�ַ�ʽ֮һ��

### ע�⣡
HMAC��ʵ�ַ�ʽ������������Hash�㷨����msg��key������SHA256��msg || key�����������Ǵ���ģ�
