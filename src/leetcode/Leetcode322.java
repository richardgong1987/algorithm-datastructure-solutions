package leetcode;

import java.util.Arrays;

public class Leetcode322 {
	int[] memo;

	public static void main(String[] args) {
//		int i = coinChangeCPP(new int[]{9, 6, 5, 1}, 11);
		coinChangeWu(new int[]{1, 2, 5, 7, 10}, 8);
	}

	static int coinChangeCPP(int[] coins, int amount) {
		// Initialize DP array with INT_MAX and dp[0]=0
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;


		// Fill DP array from amount=1 to amount's actual value
		for (int i = 1; i <= amount; ++i) {
			// Try to include all the coins one by one
			for (int j = 0; j < coins.length; ++j) {
				// If this coin is usable(value less than current amount)
				if (coins[j] <= i) {
					// What is the cost for rest of the amount
					// If I use this coin
					// eg. if amount=8 and coins[j]=5 then rest is min cost
					// for 8-5 = 3
					int rest = dp[i - coins[j]];
					// If including this coin gives lesser value
					// than current min value then include it
					if (rest != Integer.MAX_VALUE && rest + 1 < dp[i]) {
						// update min value for amount=i
						dp[i] = rest + 1;
					}
				}
			}
		}
		return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
	}

	static int coinChangeWu(int[] coins, int amount) {

		/**
		 初始化数组dp,长度为amount +1,这是因为dp需要保存金额为0的情况

		 dp[i]表示想要凑齐 i元需要的最少硬币数
		 dp[0] 表示想要凑齐0元需要的硬币数,这里显然是0个硬币
		 dp[1] 表示想要凑齐1元需要的最少硬币数.
		 dp[14]需要想在凑齐14元需要的最少硬币数
		 *
		 */
		/**
		 首先将数组dp里面的值都初始化为-1
		 -1 表示当前的金额还没有找到需要的最少硬币个数
		 */
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, -1);

		//想到要凑齐0元的最少硬币个数,显然就是0个
		//所以就有. 0元,需要 0个硬币
		dp[0] = 0;

		//依次计算想要凑齐1元到amount元的最少硬币个数
		for (int i = 1; i <= amount; i++) {

			/**
			 对于每个金额 i 来说. conis中的每个面值小于 i 的硬币都可以尝试去拼凑 i

			 比如. amount = 8, coins 为 [1,2,5,7,10]
			 其中  1,2,5,7都小于8

			 1可以尝试去拼凑 8
			 2可以尝试去拼凑 8
			 5可以尝试去拼凑 8
			 7可以尝试去拼凑 8
			 所以设置一个变量 j ,遍历数组 coins


			 */
			for (int onecoin : coins) {
				/**
				 1. 如果当前的硬币值onecoin小于 i , 表示这枚硬币可能可以拼凑到 i
				 2. i - onecoin 表示面值 onecoin的硬币想要拼凑 i 需要那么面值的硬币金额. 如果为i - onecoin=0那么说明当前onecoin硬币正好匹配上 i 金额
				 3. 而 dp[i -onecoin]表示想要凑齐 i - onecoin元最少的硬币数
				 4. 如果dp[i - onecoin] != -1,表示想要凑齐 i - onecoin 元需要的最少硬币个数有结果
				 */
				if (onecoin <= i && dp[i - onecoin] != -1) {
					/**
					 这时候,对于金额 i 来说

					 (1) 如果它之前还没有找到凑齐 i 元 需要的最少硬币数:用 dp[i] == -1来表示.
					 或者
					 (2) 如果此时计算的最少硬币个数比之前保存的结果dp[i]更少 (用dp[i - onecoin] + 1 < dp[i] 表示).那么更新它,
					 (用  dp[i]  = dp[i - onecoin] + 1方式更新)

					 注意: dp[i - onecoin] + 1这里的 + 1的意思是:
					 既然dp[i -onecoin]表示想要凑齐 i - onecoin元最少的硬币数.
					 那么凑齐i应该是 dp[i-coin]+ 当前onecoin 所以就是 + 1

					 */
					if (dp[i] == -1 || dp[i - onecoin] + 1 < dp[i]) {
						dp[i] = dp[i - onecoin] + 1;
					}

				}
			}
		}
		return dp[amount];

	}

	int coinChange(int[] coins, int amount) {
		memo = new int[amount + 1];
		// dp 数组全都初始化为特殊值
		Arrays.fill(memo, -666);
		return dp(coins, amount);
	}

	int dp(int[] coins, int amount) {
		if (amount == 0) return 0;
		if (amount < 0) return -1;
		// 查备忘录，防止重复计算
		if (memo[amount] != -666)
			return memo[amount];

		int res = Integer.MAX_VALUE;
		for (int coin : coins) {
			// 计算子问题的结果
			int subProblem = dp(coins, amount - coin);
			// 子问题无解则跳过
			if (subProblem == -1) continue;
			// 在子问题中选择最优解，然后加一
			res = Math.min(res, subProblem + 1);
		}
		// 把计算结果存入备忘录
		memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
		return memo[amount];
	}

}
