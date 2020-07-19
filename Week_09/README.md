# 学习笔记

##### 一、Atoi

实现atoi需要考虑下面这些场景：

- 输入正负号
- 开头有空格
- 转换后的数值超出int的表示范围
- 出错时返回0与正确转换0的区别
- 输入非数字
- 空字符串

```java
public int myAtoi(String str) {
 int index = 0, sign = 1, total = 0;
 //1. Empty string

 if(str.length() == 0) return 0;
 //2. Remove Spaces

 while(str.charAt(index) == ' ' && index < str.length())
 index ++;
 //3. Handle signs

 if(str.charAt(index) == '+' || str.charAt(index) == '-'){
 sign = str.charAt(index) == '+' ? 1 : -1;
 index ++;
 }
 
 //4. Convert number and avoid overflow

 while(index < str.length()){
 int digit = str.charAt(index) - '0';
 if(digit < 0 || digit > 9) break;
 //check if total will be overflow after 10 times and add digit

 if(Integer.MAX_VALUE/10 < total || 

 	 Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
 return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
 total = 10 * total + digit;
 index ++;
 }
 return total * sign; 
}
```

##### 二、字符串模式匹配

- 朴素模式匹配	BF(Brute-Force)

  基本思想是：**从主串的第一个字符起与子串的第一个字符进行比较，若相等，则继续逐对字符进行后续的比较；若不相等，则从主串第二个字符起与子串的第一个字符重新比较，以此类推，直到子串中每个字符依次和主串中的一个连续的字符序列相等为止，此时称为匹配成功。**如果不能在主串中找到与子串相同的字符序列，则匹配失败。BF算法是最原始、最暴力的求解过程，但也是其他匹配算法的基础。

- KMP模式匹配

  前缀：指字符串中除了最后一个字符以外，其余字符的全部头部顺序组合。

  后缀：指字符串中除了第一个字符以外，其余字符的全部尾部顺序组合。

  前后缀相同元素长度：指字符串所有的前缀与后缀字符依次相同的长度。

  KMP算法是对传统BF算法的改善：

  1. 本趟匹配失败

  2. 子串当前匹配失败字符之前的字符是匹配成功的

```java
/**
* 求出一个字符数组的next数组
* @param t 字符数组
* @return next 数组
*/
public static int[] getNextArrary(char[] t) {
    int[] next = new int[t.length];
    next[0] = -1;
    next[1] = 0;
    int k;
    for (int j=2;j<t.length;j++) {
        k = next[j-1];
        while (k!=-1) {
            if (t[j-1] == t[k]) {
                next[j] = k+1;
                break;
            } else {
                k = next[k];
            }
        }
    }
    return next;
}

/**
* 对主串S和模式串t进行KMP模式匹配
* @param s 主串
* @param t 模式串
* @return 
*/
public static int kmpMatch(String s, String t) {
    char[] s_arr = s.toCharArray();
    char[] t_arr = t.toCharArray();
    int[] next = getNextArray(t_arr);
    int i=0,j=0;
    while (i<s_arr.length && j<t_arr.length) {
        if (j == -1 || s_arr[i]==t_arr[j]) {
            i++;
            j++;
        } 
        else
            j = next[j];
    }
    if (j == t_arr.length) 
	    return i-j;    
	else
        return -1;
}
```

- Rabin-Karp

  算法的思想：

  1.假设子串的长度为 M (pat)，目标字符串的长度为 N (txt)

  2.计算子串的 hash 值 hash_pat

  3.计算目标字符串txt中每个长度为 M 的子串的 hash 值（共需要计算 N-M+1次）

  4.比较 hash 值：如果 hash 值不同，字符串必然不匹配; 如果 hash 值相同，还需要使用朴素算法再次判断

```java
public final static int D = 256;

public final static int Q = 9997;

static int RabinKarpSerach(String txt, String pat) {
 int M = pat.length();
 int N = txt.length();
 int i, j;
 int patHash = 0, txtHash = 0;
 for (i = 0; i < M; i++) {
 patHash = (D * patHash + pat.charAt(i)) % Q;
 txtHash = (D * txtHash + txt.charAt(i)) % Q;
 }
 int highestPow = 1; // pow(256, M-1)
 for (i = 0; i < M - 1; i++) 
 highestPow = (highestPow * D) % Q;
 for (i = 0; i <= N - M; i++) { // 枚举起点

 if (patHash == txtHash) {
 for (j = 0; j < M; j++) {
 if (txt.charAt(i + j) != pat.charAt(j))
 break;
 }
 if (j == M)
 return i;
 }
 if (i < N - M) {
 txtHash = (D * (txtHash - txt.charAt(i) * highestPow) + txt.charAt(i + M)) % Q;
 if (txtHash < 0)
 txtHash += Q;
 }
 }
 return -1; 
}
```

