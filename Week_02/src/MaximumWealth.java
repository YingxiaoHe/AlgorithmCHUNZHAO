import java.util.Arrays;

public class MaximumWealth {

    public int maximumWealth(int[][] accounts) {
        return Arrays.stream(accounts).map(ints -> Arrays.stream(ints).sum()).max(Integer::compareTo).get();
    }
}
