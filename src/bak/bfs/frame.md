**广度搜索（最短路径 / 最小操作次数）**

>BFS 和 DFS 均可实现最短路径
>BFS 空间复杂度⾼，时间复杂度低，DFS 则相反

``` java
// 计算从起点 start 到终点 target 的最近距离
int BFS(Node start, Node target) {
    Queue<Node> q; // 核⼼数据结构
    Set<Node> visited; // 避免⾛回头路
    q.offer(start); // 将起点加⼊队列
    visited.add(start);
    int step = 0; // 记录扩散的步数
    while (q not empty) {    // （重点）
        // 当前步伐关联的所有节点 （重点）
        int sz = q.size();
        // 将当前队列中的所有节点向四周扩散 （重点）
        for (int i = 0; i < sz; i++) {
            Node cur = q.poll();
            /* 划重点： 这⾥判断是否到达终点 */
            if (cur is target)
                return step;
            /* 将 cur 的相邻节点加⼊队列 */
            for (Node x : cur.adj())
                if (x not in visited) {
                    q.offer(x);
                    visited.add(x);
                }
		} 
        /* 划重点： 更新步数在这⾥ */
        step++;
	}
}
```

