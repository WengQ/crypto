# 常用密码学算法原理以及实现
##Diffie-Hellman密钥交换原理
- 1）选择大素数p，选择一个整数m∈{2，3，……，p-2}，p，m公开
- 2）Alice和Bob分别随机选择a，b∈{2，3，……，p-2}，a，b是各自的私钥，保密
- 3）分别计算m^aA mod p，m^bB mod p
- 4）Alice把A发给Bob，Bob把B发给Alice，（A，B，p）公开
- 5）Alice计算B^a  k mod p , A^b  k mod p，

如此就得到了公共密钥k

