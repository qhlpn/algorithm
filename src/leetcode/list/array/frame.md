# List

#### 双指针

+ **快慢指针**

  if else if : 快指针 **持续** 往前走，慢指针 **满足条件时** 往前走

+ **首位夹击**

  left++; right--;

+ **二分查找**

  ```java
  //  ∵ int right = nums.length - 1; 
  //  ∴ 搜索范围是 [left, right]，从而 [left + 1, left] 为空
  //  ∴ while (left <= right)  
  int binarySearch(int[] nums, int target) {
  	int left = 0;
  	int right = nums.length - 1; // 固定
   	while (left <= right) { 
      	int mid = left + (right - left) / 2;  // 固定
      	if (nums[mid] == target)   // three condition
          	return mid;       // in
      	else if (nums[mid] < target)
          	left = mid + 1; // in
      	else if (nums[mid] > target)
         		right = mid - 1; // in
  	} 
      return -1;
  }
  ```

#### 遍历并收集信息
