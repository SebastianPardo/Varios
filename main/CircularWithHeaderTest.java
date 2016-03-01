package co.edu.unal.ds.main;

import co.edu.unal.ds.chain.*;

public class CircularWithHeaderTest {
    
    public static void main(String[] args) {
        CircularWithHeader<Integer> list = new CircularWithHeader<>();
        for(int i = 0 ;i < 15; i++){
            if(i%3 == 0)
               list.add(i, 4);
            else
                list.add(i,6);
        }
        System.out.println(list);
        System.out.printf("Index of 5 is %d \n",list.indexOfSpecial(5));
        System.out.printf("\nIndex of 6 is %d \n",list.indexOfSpecial(6));
    }
    
}
