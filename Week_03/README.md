# 学习笔记

##### 1）递归

- **递归模板**

```java
public void recur(int level, int param) {
    // terminator
    if (level > MAX_LEVEL) {
        //	process result
        return;
    }
    // process current logic
    process(level, param);
    
    // drill down
    recur(level+1, newParam);
    
    // restore current status
}
```

##### 2）分治

例题：[括号生成问题](https://leetcode-cn.com/problems/generate-parentheses/)

##### 3）回溯

例题1：[全排列](https://leetcode-cn.com/problems/permutations/)

例题2：[全排列2](https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/)

例题3：[组合](https://leetcode-cn.com/problems/combinations/)