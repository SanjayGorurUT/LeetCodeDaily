public class NumCostWays {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long amountOne = 0;
        long numWays = 0;
        while(cost1 * amountOne <= total) {
            long amountTwo = (total - (cost1 * amountOne))/cost2;
            numWays += (amountTwo + 1);
            amountOne++;
        }
        return numWays;
    }

    public static void main(String[] args) {
        NumCostWays numCostWays = new NumCostWays();
        System.out.println(numCostWays.waysToBuyPensPencils(20, 10, 5));
    }
}