``` java
void traverse(TreeNode root) {
    // 前序遍历
    traverse(root.left)    // root.left
    // 中序遍历 
    traverse(root.right)   // root.right
    // 后序遍历
}
```

``` java
private int index = 0;
void buildTree(int[] nums) {
    int num = nums[index];
    TreeNode node = new TreeNode(num)
    if (num == 0) {
        return null;
    } else {
        node.value = num;
        node.left = buildTree(nums, index++);
        node.right = buildTree(nums, index++);
        return node;
    }
}
```

