### 链表

#### 翻转 / 交换：三下标

``` java
// 当下 + 前 + 后
ListNode before = null;
node = node.next;
ListNode next;
for (int i = left; i <= right; i++) {
    next = node.next; // snap 🎦
    node.next = before;
    before = node;
    node = next;
}
```

### 边车模式
