#### 快慢指针

if else if : 快指针 **持续** 往前走，慢指针 **满足条件时** 往前走



#### 二分法

+ 寻找一个数

  ``` java
  //  ∵ int right = nums.length - 1; 
  //  ∴ 搜索范围是 [left, right]，从而 [left + 1, left] 为空
  //  ∴ while (left <= right)  
  int binarySearch(int[] nums, int target) {
   int left = 0;
      int right = nums.length - 1; // 固定
   while (left <= right) { 
      int mid = left + (right - left) / 2;  // 固定
      if (nums[mid] == target)   // if elseif elseif 写全情况
         return mid;       // in
      else if (nums[mid] < target)
         left = mid + 1; // in
      else if (nums[mid] > target)
         right = mid - 1; // in
   } 
      return -1;
  }
  ```

+ 寻找左侧边界

  ``` java
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

  