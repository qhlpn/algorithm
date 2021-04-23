### 滑动窗口

> 先窗口膨胀（右侧）至到满足条件；再窗口收缩（左侧）并更新指标。
>
> 重点是：写出判断窗口是否满足条件的函数

```java
int left = 0;
int right = 0;
while (right < s.size()) {
    window.add(s[right]);          // 窗口右侧加入的数据
    right++;                       // 增大窗口
    while (window needs shrink) {  // 窗口满足条件时开始收缩
        window.remove(s[left]);     // 窗口左侧移除的数据
        left++;                    // 缩小窗口
    }
}
```

