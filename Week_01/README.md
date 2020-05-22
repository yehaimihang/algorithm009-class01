# 学习笔记

#### 1）数组、链表、跳表

- ##### 数组基本操作的时间复杂度

   ```java
   insert			O(n)
   delete			O(n)
   prepend			O(1)
   append			O(1)
   lookup			O(1)
   ----------->	插入删除慢，随机访问快
   ```

- ##### 普通链表基本操作的时间复杂度

   ```java
   insert			O(1)
   delete			O(1)
   prepend			O(1)
   append			O(1)
   lookup			O(n) 
   ----------->	插入删除快，随机访问慢
   ```

- ##### 跳表(skip list) 1989年出现

   跳表是一种  插入/删除/搜索  都是O(log n)的数据结构。

   Redis、LevelDB中有应用

   原理：添加多级索引（升纬），空间换时间。

- ##### 源码

   1. [Java 源码分析（ArrayList）](http://developer.classpath.org/doc/java/util/ArrayList-source.html)

      ```java
      //添加元素：分配10（默认）个对象空间
      //private static final int DEFAULT_CAPACITY = 10;
      public boolean add(E e) {
              ensureCapacityInternal(size + 1);  // Increments modCount!!
              elementData[size++] = e;
              return true;
      }
      //扩容：会按照1.5倍增长（10->15->22...）
      private void grow(int minCapacity) {
              // overflow-conscious code
              int oldCapacity = elementData.length;
              int newCapacity = oldCapacity + (oldCapacity >> 1);
              if (newCapacity - minCapacity < 0)
                  newCapacity = minCapacity;
              if (newCapacity - MAX_ARRAY_SIZE > 0)
                  newCapacity = hugeCapacity(minCapacity);
              // minCapacity is usually close to size, so this is a win:
              elementData = Arrays.copyOf(elementData, newCapacity);
      }
      ```

      

   2. [Java 源码分析（LinkedList）](http://developer.classpath.org/doc/java/util/LinkedList-source.html)

      ```java
      /**
       * 双向链表
       */
      transient int size = 0;
      
      //Pointer to first node.
      transient Node<E> first;
      
      //Pointer to last node.
      transient Node<E> last;
      
      private static class Node<E> {
              E item;
              Node<E> next;
              Node<E> prev;
      
              Node(Node<E> prev, E element, Node<E> next) {
                  this.item = element;
                  this.next = next;
                  this.prev = prev;
              }
      }
      ```

- ##### 算法题解题心得

   1. 双指针的使用

      指针从**两头**（i=0,j=array.length-1）作为起始点，根据逻辑判断下一步移动左或右指针（一次走一步）。

      参考例题：[盛最多水的容器](https://leetcode-cn.com/problems/container-with-most-water/)

      ------

      指针都从**左边**（i=0,j=0）作为起始点，先移动 i 指针，根据逻辑判断何时移动 j ，注意 i=j 的情况。

      参考例题：[移动零](https://leetcode-cn.com/problems/move-zeroes/)

   2. Hash 的使用

      遍历数组，将数组值、索引放到 HashMap ，相当于多一个维度做逻辑处理。

      参考例题：[两数之和](https://leetcode-cn.com/problems/two-sum/)

#### 2）栈和队列

- ##### 用 add first 或 add last 这套新的 API 改写 Deque 的代码

  -

- ##### 源码

  1. Java源码分析（Queue）

     ```java
     
     ```

  2. Java源码分析（Priority Queue）

     ```java
     
     ```

     