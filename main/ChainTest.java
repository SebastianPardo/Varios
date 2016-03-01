package co.edu.unal.ds.main;

import co.edu.unal.ds.chain.*;
import co.edu.unal.ds.pokemon.*;

public class ChainTest {

    public static void main(String[] args) {
        Chain<Pokemon> chain = new Chain<>();
        Charmander c = null;
        for (int i = 0; i < 5; i++) {
            Charmander charchar = new Charmander();
            chain.add(i, charchar);
            if (i == 2) {
                c = charchar;
            }
        }
        System.out.println(chain);
        chain.remove(0);
        System.out.println(chain);
        System.out.println(chain.size());
        System.out.println(chain.get(1));
        System.out.printf("List is %s empty\n", chain.isEmpty() ? "" : "not");
        System.out.println(chain.indexOf(c));
    }
}
