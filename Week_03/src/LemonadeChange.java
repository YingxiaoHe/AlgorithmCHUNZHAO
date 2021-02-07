/**
 * 柠檬水找零：https://leetcode-cn.com/problems/lemonade-change/
 */
public class LemonadeChange {

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five < 1) {
                    return false;
                }
                ten++;
                five--;
            } else if (bill == 20) {
                //找零20块只有两种方法：1张10块和1张5块、3张5块
                if (five > 0 && ten > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
