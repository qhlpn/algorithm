**最优子结构问题**
>  求最优需要：穷举

>  大范围包含小范围，子问题之间相互独立

> 步骤
>
> + 明确『**状态**』维度 🥠 明确『**DP**』含义 🥙
> + 明确『**选择**』动作，推出『**转移方程**』 🌮
> + 最后『**遍历穷举**』数组（状态维度） 🥩 （明确 base case）


```
int dp[N+1][W+1]
dp[0][..] = 0
dp[..][0] = 0

for 状态1 in 状态1的所有取值：
    for 状态2 in 状态2的所有取值：
        for ...
            dp[状态1][状态2][...] = 择优(选择1，选择2...)
```



