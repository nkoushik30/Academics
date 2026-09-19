import java.util.*;
class Knapsack{
    double weight,profit,ratio;
    Knapsack (double weight,double profit){
        this.profit = profit;
        this.weight = weight;
        this.ratio = profit/weight;
    } 
    public static double getMaxProfit(Knapsack[] knapsacks, double m){
        Arrays.sort(knapsacks, (a,b)-> Double.compare(b.ratio,a.ratio));
        double maxProfit=0.0;
        System.out.println("Items placed in the bag");

        for(Knapsack knapsack:knapsacks){
           if(knapsack.weight<=m){ 
            maxProfit += knapsack.profit;
            System.out.println("Item (weight: "+ knapsack.weight+", profit :"+knapsack.profit+") - Taken Fully");
            m-=knapsack.weight;
        }
        else{
            double fraction = m/knapsack.weight;
            maxProfit+=knapsack.profit;
            System.out.println("Item (weight: "+ knapsack.weight*fraction+", profit :"+knapsack.profit*fraction+") - Taken "+fraction*100+"%");
            break;
        }
    }
       return maxProfit;
    }
    public static void main(String args[]){
        Knapsack[] knapsacks={
            new Knapsack(10,20),
            new Knapsack(20,50),
            new Knapsack(30,190),
            new Knapsack(40,150),
            new Knapsack(50,60),
        };
        double m=20;
        double N=getMaxProfit(knapsacks,m);
        System.out.println(+N+" is the Maximum profit attained");
    }
}