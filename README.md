# 常用密码学算法原理以及实现

##Diffie-Hellman密钥交换原理##
- 1）选择大素数p，选择一个整数m∈{2，3，……，p-2}，p，m公开
- 2）Alice和Bob分别随机选择a，b∈{2，3，……，p-2}，a，b是各自的私钥，保密
- 3）分别计算m^aA mod p，m^bB mod p,A,B为各自的公钥，公开
- 4）Alice把A发给Bob，Bob把B发给Alice，（A，B，p）公开
- 5）Alice计算B^a  k mod p , A^b  k mod p，

如此就得到了公共密钥k

##RSA加密与解密##

RSA公钥为(n，e)，私钥为(d)

生成密钥对过程：
- 1.选择2个大素数p，q
- 2.计算n=p*q
- 3.计算φ(n)= (p-1)(q-1)
- 4.选择公开指数e∈{ 1,2，……，φ(n)-1 }，且e要满足gcd(e，φ(n))=1
- 5.计算d，d为e模φ(n)的逆元。即d*e  1 mod φ(n)

加解密过程：
RSA加密：给定公钥(n,e)=kpub  ,和明文x，则加密函数为：
y  x^e mod n，其中x，y属于整数环

RSA解密：给定私钥dpr以及y，则解密函数为：
x  y^d mod n，其中x，y属于整数环
