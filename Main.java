
import java.util.ArrayList;
public class Main{
    
    void SieveofEratosthenes(int n){
        ArrayList<Integer> lst = new ArrayList<Integer>();
        for(int i = 2; i <= n; i++){
            lst.add(i);
        }
        for(int i = 0; i < lst.size(); i++){
            for(int x = i + 1; x < lst.size(); x++){
                if((lst.get(x) % lst.get(i)) == 0){
                    lst.remove(x);
                    x--;
                }
            }
        }
        System.out.println(lst);
        goldBachConjecture(16,lst);
    }
    
    void goldBachConjecture(int n, ArrayList<Integer> lst){
        int val1 = 0;
        int val2 = 0;
        for(int i = 0; i < lst.size(); i++){
            for(int x = i + 1; x < lst.size(); x++){
                int a = lst.get(i);
                int b = lst.get(x);
                if(a + b == n){
                    val1 = a;
                    val2 = b;
                }
            }
        }
        System.out.println(n + " = " + val1 + " + " + val2);
    }
    
    void bigInts(int one,int two){
        int count1 = 0;
        int count2 = 0;
        int one1 = one;
        int two2 = two;
        int dif = 0;
        ArrayList<Integer> One = new ArrayList<Integer>();
        ArrayList<Integer> Two = new ArrayList<Integer>();
        ArrayList<Integer> sum = new ArrayList<Integer>();
       while(one1 > 0){
           one1 /= 10;
           count1++;
       }
        while(two2 > 0){
           two2 /= 10;
           count2++;
       }
       for(int i = 0; i < count1; i++){
           int temp = one%10;
           One.add(0,temp);
           one /= 10;
       
       }
        for(int i = 0; i < count2; i++){
           int temp = two%10;
           Two.add(0,temp);
           two /= 10;
       
       }
       dif = Math.abs(count1 - count2);
       if(One.size() > Two.size()){
           for(int i = 0; i < dif; i++){
               Two.add(0,0);
           }
       } else if(Two.size() > One.size()){
           for(int i = 0; i < dif; i++){
               One.add(0,0);
           }
       }
       for(int i = 0; i < One.size(); i++){
               sum.add(0,0);
            }
       
       for(int i = One.size() - 1; i >= 0; i--){
        if((One.get(i) + Two.get(i) + sum.get(i)) < 10){
           sum.set(i,(sum.get(i) + One.get(i) + Two.get(i)));
        } 
        else{
            sum.set(i, (sum.get(i) + One.get(i) + Two.get(i))%10);
            sum.set(i-1,(sum.get(i) + One.get(i) + Two.get(i))/10);
        }
       }
       
       System.out.println(One);
       System.out.println(Two);
       System.out.println(sum);
    }
    
}
