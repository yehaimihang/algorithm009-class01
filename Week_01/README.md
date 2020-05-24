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

      参考例题：[盛最多水的容器](https://leetcode-cn.com/problems/container-with-most-water/)（标签：数组、双指针）

      指针都从**左边**（i=0,j=0）作为起始点，先移动 i 指针，根据逻辑判断何时移动 j ，注意 i=j 的情况。

      参考例题：[移动零](https://leetcode-cn.com/problems/move-zeroes/)（标签：数组、双指针）

   2. Hash 的使用

      遍历数组，将数组值、索引放到 HashMap ，相当于多一个维度做逻辑处理。

      参考例题：[两数之和](https://leetcode-cn.com/problems/two-sum/)（标签：数组、哈希表）

      ------

   3. 双指针

      辅助指针、指向链表

      参考例题：[反转链表](https://leetcode-cn.com/problems/reverse-linked-list/)

      参考例题：[两两交换链表中的节点](https://leetcode-cn.com/problems/swap-nodes-in-pairs/)

      ```java
      //两两交换链表中的节点，测试用例：1->2->3->4
      public ListNode swapPairs(ListNode head) {
              ListNode node = new ListNode(-1);
              ListNode res = node;	//记录输出
              while (head != null && head.next != null) {
                  /**下面两行代码解释：
                   * 1.让node帮记住 2 的位置
                   * 2.此时head可以操作: 1->3
                   */
                  node.next = head.next;
                  head.next = head.next.next;
                  //因为之前让node记住了 2 的位置，让node：2->1给res记录，此时链表结构：2->1->3->4
                  node.next.next = head;
      			/**下面两行代码解释：
      			 * 1.重复之前操作，node需要有一个前置节点，所以node保留: 1->3->4
      			 * 2.head保留: 3->4
      			 */
                  node = node.next.next;
                  head = head.next;
              }
              return res.next;
      }
      ```

      

#### 2）栈和队列

- ##### 用 add first 或 add last 这套新的 API 改写 Deque 的代码

  

- ##### 源码

  1. Java源码分析（Queue）

     ------

     ![](https://github.com/yehaimihang/algorithm009-class01/edit/master/Week_01/images/Queue.png)

     ------

     接口方法：

     ```java
     boolean  add(E e) //将指定的元素插入此队列（如果立即可行且不会违反容量限制），在成功时返回 true，如果当前没有可用的空间，则抛出 IllegalStateException。
     E        element() //获取，但是不移除此队列的头。
     boolean  offer(E e) //将指定的元素插入此队列（如果立即可行且不会违反容量限制），当使用有容量限制的队列时，此方法通常要优于 add(E)，后者可能无法插入元素，而只是抛出一个异常。
     E        peek() //获取但不移除此队列的头；如果此队列为空，则返回 null。
     E        poll() //获取并移除此队列的头，如果此队列为空，则返回 null。
     E        remove() //获取并移除此队列的头。
     ```

  2. Java源码分析（Priority Queue）

     Java中*PriorityQueue*实现了*Queue*接口，不允许放入`null`元素；其通过堆实现，具体说是通过完全二叉树（*complete binary tree*）实现的**小顶堆**（任意一个非叶子节点的权值，都不大于其左右子节点的权值），也就意味着可以通过数组来作为*PriorityQueue*的底层实现。

     ------

     ![](https://github.com/yehaimihang/algorithm009-class01/edit/master/Week_01/images/PriorityQueue.png)

     > 图片来自：https://www.cnblogs.com/Elliott-Su-Faith-change-our-life/p/7472265.html

     ```java
     //add、offer方法
     public boolean offer(E e) {
             if (e == null)
                 throw new NullPointerException();
             modCount++;
             int i = size;
             if (i >= queue.length)
                 grow(i + 1); //自动扩容
             size = i + 1;
             if (i == 0)
                 queue[0] = e;  //队列为空，则放在放在第一个位置
             else
                 siftUp(i, e);  //调整队列(待补充)
             return true;
     }
     //peek:直接返回队头元素
     public E peek() {
             return (size == 0) ? null : (E) queue[0];
     }
     //remove()和poll()方法的语义也完全相同，都是获取并删除队首元素，区别是当方法失败时前者抛出异常，后者返回null。
     public E poll() {
             if (size == 0)
                 return null;
             int s = --size;
             modCount++;
             E result = (E) queue[0];
             E x = (E) queue[s];
             queue[s] = null;
             if (s != 0)
                 siftDown(0, x);  //调整队列(待补充)
             return result;
     }
     ```

- **算法题解题心得**

  1. 双指针，头部指向第 1 个存放元素的位置，尾部指向下一个插入元素的位置

     参考例题：[设计循环双端队列](https://leetcode-cn.com/problems/design-circular-deque)

     国际网站top：[双链表设计](https://leetcode.com/problems/design-circular-deque/discuss/149371/Java-doubly-LinkedList-solution-very-straightforward)

     

