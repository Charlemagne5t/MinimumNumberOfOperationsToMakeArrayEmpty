import java.util.Arrays;

public class Solution {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int cur = 1;
        int res = 0;
        for(int i = 1; i < n; i++){
            if(nums[i] != nums[i - 1] && i == n - 1){
                return -1;
            }
            if(nums[i] == nums[i - 1] && i != n - 1){
                cur++;
            }else if(nums[i] != nums[i - 1] || i == n - 1){
                if(i == n - 1){
                    cur++;
                }
                if(cur == 1){
                    return -1;
                }
                if(cur % 3 == 0){

                    res+= cur / 3;
                    cur = 1;

                }else if(cur % 3 == 2){
                    res += 1 + (cur - 2) / 3;
                    if(i != n - 1){
                        cur = 1;

                    }else cur = 0;

                }else if(cur % 3 == 1){
                    res += 2 + (cur - 4) / 3;
                    if(i != n - 1){
                        cur = 1;

                    }else cur = 0;
                }
            }
        }


        return res;
    }
}
