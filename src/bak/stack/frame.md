### 递归
场景

### 单调栈（栈内元素单调）
场景：数组中向右找到第一个比当前大（或小）的数字，此时栈中元素只要小（或大）于遍历到的值，则表明找到，弹出栈。
```java
for (int i = 0; i < arr.length; i++) {
    int current = arr[i];
    while (!stack.isEmpty() && arr[stack.peek()] < current) {
        int lidx = stack.pop();
        res[lidx] = i - lidx;
    }
    stack.push(i);
}
while (!stack.isEmpty()) {
    res[stack.pop()] = 0;
}
```