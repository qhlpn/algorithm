package bak.offer;

// 给定一个数组 A[0,1,...,n-1]
// 请构建一个数组 B[0,1,...,n-1]
// 其中 B 中的元素 B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]
// 不能使用除法。

public class _66_ConstuctArray {

    // 思路一:
    //      暴力 O(N2)

    // 思路二:
    //      要降低时间复杂度，可通过提高空间复杂度
    //      存储 上三角 和 下三角
    public int[] multiply(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        if(length != 0 ){
            B[0] = 1;
            //计算下三角连乘
            for(int i = 1; i < length; i++){
                B[i] = B[i-1] * A[i-1];
            }
            int temp = 1;
            //计算上三角
            for(int j = length-2; j >= 0; j--){
                temp *= A[j+1];
                B[j] *= temp;
            }
        }
        return B;
    }

}
