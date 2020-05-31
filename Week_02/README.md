# 学习笔记

##### 1）哈希表、映射、集合

- **HashMap数据结构**

  数组+链表+红黑树（JDK1.8增加了红黑树部分）

  ![](E:\IDEspace\geekclass\algorithm009-class01\Week_02\images\HashMap.png)

  > https://pic1.zhimg.com/80/8db4a3bdfb238da1a1c4431d2b6e075c_720w.png

- **HashMap的 Java1.8实现**

  从源码可知，HashMap类中有一个非常重要的字段，就是 Node[] table，即哈希桶数组，明显它是一个Node的数组：

```java
//Node是HashMap的一个内部类，实现了Map.Entry接口，本质是就是一个映射(键值对)。
static class Node<K,V> implements Map.Entry<K,V> {
        final int hash;    //用来定位数组索引位置
        final K key;
        V value;
        Node<K,V> next;   //链表的下一个node

        Node(int hash, K key, V value, Node<K,V> next) { ... }
        public final K getKey(){ ... }
        public final V getValue() { ... }
        public final String toString() { ... }
        public final int hashCode() { ... }
        public final V setValue(V newValue) { ... }
        public final boolean equals(Object o) { ... }
}
```

​		从HashMap的默认构造函数源码可知，构造函数就是对下面几个字段进行初始化：

```java
int threshold;             // 所能容纳的key-value对极限 
final float loadFactor;    // 负载因子 threshold = length * Load factor
int modCount;  			   // 记录HashMap内部结构发生变化的次数
int size;				   // 实际存在的键值对数量
/**
 * Constructs an empty <tt>HashMap</tt> with the default initial capacity
 * (16) and the default load factor (0.75).
 */
public HashMap() {
	this.loadFactor = DEFAULT_LOAD_FACTOR; // all other fields defaulted
}
```

​	put

```java
public V put(K key, V value) {
    return putVal(hash(key), key, value, false, true);
}

final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
    	//判断键值对数组table[i]是否为空或为null，否则执行resize()进行扩容；
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
        else {
            Node<K,V> e; K k;
            //判断table[i]的首个元素是否和key一样，如果相同直接覆盖value
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            //判断table[i] 是否是红黑树，如果是红黑树，则直接在树中插入键值对
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        //链表长度大于8转换为红黑树进行处理
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    //key已经存在直接覆盖value
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
    	//插入成功后，判断实际存在的键值对数量size是否超多了最大容量threshold，如果超过，进行扩容
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
}
```

##### 2）树、二叉树、二叉搜索树

```java
//树
public class TreeNode { 
	public int val; 
	public TreeNode left, right; 
	public TreeNode(int val) { 
 		this.val = val; 
 		this.left = null; 
 		this.right = null; 
	} 
}
/** 树的遍历
 *	1.前序（Pre-order）：根-左-右
 *	2.中序（In-order）：左-根-右
 *	3.后序（Post-order）：左-右-根
 */
```

- **二叉搜索树**

1. 左子树上**所有结点**的值均小于它的根结点的值； 

2. 右子树上**所有结点**的值均大于它的根结点的值； 

3. 以此类推：左、右子树也分别为二叉查找树。 （这就是 重复性！）

   中序遍历：升序

   查询、插入操作：log(n)

##### 3）堆、二叉堆、图 

- **堆 Heap**

  Heap：可以迅速找到一堆数中的最大或最小值的数据结构。

  根节点最大：大顶堆（大根堆）

  根节点最小：小顶堆（小根堆）

  不同堆的实现：https://en.wikipedia.org/wiki/Heap_(data_structure)

- **二叉堆**（**BinaryHeap**）

  完全二叉树

  树中任意节点的值总是 >= 其子节点的值

  Java实现：

- **图**

  Graph(V, E)

  V - vertex：点

  > 1.度 - 入度和出度

  > 2.点与点之间：连通与否

  E - edge：边

  > 1.有向无向（单行线）

  > 2.权重（边长）

  

  

