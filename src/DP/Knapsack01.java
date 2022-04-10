package DP;

public class Knapsack01 {
    public static void main(String[] args) {
        int[] weights = {100, 40, 50, 60};
        int[] values = {20, 100, 60, 70};
        int capacity = 100;
        Knapsack01 obj = new Knapsack01();
        System.out.println(obj.knapsack(weights, values, capacity, 0));
    }

    int knapsack(int[] weights, int[] values, int capacity, int i){
        if(i==weights.length-1)
            if(capacity>=weights[i])
                return values[i];
            else return 0;
        else{
            if(weights[i]<=capacity){
                return Math.max(values[i]+knapsack(weights, values, capacity-weights[i], i+1),
                        knapsack(weights, values, capacity, i+1));
            }
            else return knapsack(weights, values, capacity, i+1);
        }
    }
}
