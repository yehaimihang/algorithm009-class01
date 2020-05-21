# 学习笔记

#### 1）数组、链表、跳表

1. ##### 数组基本操作的时间复杂度

   insert				 O(n)

   delete				O(n)

   prepend			O(1)

   append			  O(1)

   lookup			   O(1)

   ----------->	插入删除慢，随机访问快

2. ##### 普通链表基本操作的时间复杂度

   insert				  O(1)

   delete				  O(1)

   prepend			  O(1)

   append			   O(1)

   lookup				O(n) 

   ----------->	插入删除快，随机访问慢

3. ##### 跳表(skip list) 1989年出现

   跳表是一种  插入/删除/搜索  都是O(log n)的数据结构。

   Redis、LevelDB中有应用

   原理：添加多级索引（升纬），空间换时间。

4. ##### 课后参考

   1. [Java 源码分析（ArrayList）](http://developer.classpath.org/doc/java/util/ArrayList-source.html)
   2. [Linked List 的标准实现代码](http://www.geeksforgeeks.org/implementing-a-linked-list-in-java-using-class/)
   3. [Linked List 示例代码](http://www.cs.cmu.edu/~adamchik/15-121/lectures/Linked Lists/code/LinkedList.java)
   4. [Java 源码分析（LinkedList）](http://developer.classpath.org/doc/java/util/LinkedList-source.html)
   5. [ LRU 缓存机制](http://leetcode-cn.com/problems/lru-cache)
   6. [为啥 Redis 使用跳表（Skip List）而不是使用 Red-Black？](http://www.zhihu.com/question/20202931)

5. ##### Array 练习

   1. [两数之和](https://leetcode-cn.com/problems/two-sum/)（近半年内，字节跳动在面试中考查此题达到 152 次）
   2. [盛最多水的容器](https://leetcode-cn.com/problems/container-with-most-water/)（腾讯、百度、字节跳动在近半年内面试常考）
   3. [移动零](https://leetcode-cn.com/problems/move-zeroes/)（华为、字节跳动在近半年内面试常考）
   4. [爬楼梯](https://leetcode.com/problems/climbing-stairs/)（阿里巴巴、腾讯、字节跳动在半年内面试常考）
   5. [三数之和](https://leetcode-cn.com/problems/3sum/)（国内、国际大厂历年面试高频老题）

6. ##### LinkedList 练习

   1. [反转链表](https://leetcode.com/problems/reverse-linked-list/)（字节跳动、亚马逊在半年内面试常考）
   2. [两两交换链表中的节点](https://leetcode.com/problems/swap-nodes-in-pairs)（阿里巴巴、字节跳动在半年内面试常考）
   3. [环形链表](https://leetcode.com/problems/linked-list-cycle)（阿里巴巴、字节跳动、腾讯在半年内面试常考）
   4. [环形链表 II](https://leetcode.com/problems/linked-list-cycle-ii)
   5. [K 个一组翻转链表](https://leetcode.com/problems/reverse-nodes-in-k-group/)（字节跳动、猿辅导在半年内面试常考）

7. 

   