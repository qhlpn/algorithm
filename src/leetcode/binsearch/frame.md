#### 寻找一个数

```java
//  ∵ int right = nums.length - 1; 
//  ∴ 搜索范围是 [left, right]，闭区间
//  ∴ [left + 1, left] 为空
//  ∴ while (left <= right)  
int binarySearch(int[] nums, int target) {
	int left = 0;
    int right = nums.length - 1; // 注意
	while (left <= right) {
		int mid = left + (right - left) / 2;  // 固定的
		if (nums[mid] == target)   // if elseif elseif 写全情况
			return mid;		// 注意
		else if (nums[mid] < target)
			left = mid + 1; // 注意 + 1  (因为是闭区间)
		else if (nums[mid] > target)
			right = mid - 1; // 注意 - 1 (因为是闭区间)
	} 
    return -1;
}
```

#### 寻找左侧边界

```java
int left_bound(int[] nums, int target) {
	int left = 0, right = nums.length - 1;
	// 搜索区间为 [left, right]
	while (left <= right) {
		int mid = left + (right - left) / 2;
		if (nums[mid] == target) {
            // 继续收缩右侧边界 [left, mid-1]
			right = mid - 1;
		} else if (nums[mid] > target) {
			// 搜索区间变为 [left, mid-1]
			right = mid - 1;
		} else if (nums[mid] < target) {
			// 搜索区间变为 [mid+1, right]
			left = mid + 1;
		}
	} 
    // 检查出界情况
	if (left >= nums.length || nums[left] != target)
		return -1;
	return left;
}
```
