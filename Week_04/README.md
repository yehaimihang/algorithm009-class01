# 学习笔记

1. ##### 深度优先搜索、广度优先搜索

- DFS（Deep First Search）深度优先搜索

  > 递归下去：则是以深度为准则，先一条路走到底，直到达到目标。这里称之为递归下去

  > 回溯上来：既没有达到目标又无路可走了，那么则退回到上一步的状态，走其他路。这便是回溯上来

  ```java
  void dfs(TreeNode root) {
      if (root == null) {
          return;
      }
      dfs(root.left);
      dfs(root.right);
  }
  ```

- BFS（Breath First Search）广度优先搜索

  > (wifi) 广度优先搜索较之深度优先搜索之不同在于，深度优先搜索旨在不管有多少条岔路，先一条路走到底，不成功就返回上一个路口然后就选择下一条岔路，而广度优先搜索旨在面临一个路口时，把所有的岔路口都记下来，然后选择其中一个进入，然后将它的分路情况记录下来，然后再返回来进入另外一个岔路，并重复这样的操作

  ```java
  // 二叉树的层序遍历
  void bfs(TreeNode root) {
      Queue<TreeNode> queue = new ArrayDeque<>();
      queue.add(root);
      while (!queue.isEmpty()) {
          int n = queue.size();
          for (int i = 0; i < n; i++) { 
              // 变量 i 无实际意义，只是为了循环 n 次
              TreeNode node = queue.poll();
              if (node.left != null) {
                  queue.add(node.left);
              }
              if (node.right != null) {
                  queue.add(node.right);
              }
          }
      }
  }
  ```

  应用场景：层序遍历、最短路径

1. ##### 贪心算法

   尽量使接下来面对的结果“最好”，得到的最终结果不一定是正确的。

   在某些条件下可以使用贪心算法：

   1.凑钱问题，纸币面额都是成倍数关系。

   > https://www.zhihu.com/question/23995189

   例题：

   1.[柠檬水找零](https://leetcode-cn.com/problems/lemonade-change/description/)

   2.[买卖股票的最佳时机 II ](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/)

   ```java
   //这道题 “贪心” 的地方在于，对于 “今天的股价 - 昨天的股价”，得到的结果有 3 种可能：（1）正数（2）0（3）负数。
   //贪心算法的决策是：只加正数。
   ```

   3.[分发饼干](https://leetcode-cn.com/problems/assign-cookies/description/)

   4.[模拟行走机器人](https://leetcode-cn.com/problems/walking-robot-simulation/description/)

   5.[跳跃游戏](https://leetcode-cn.com/problems/jump-game/)

   6.[跳跃游戏 II ](https://leetcode-cn.com/problems/jump-game-ii/)

2. ##### 二分查找

