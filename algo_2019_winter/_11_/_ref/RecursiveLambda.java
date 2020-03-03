package dist._ref;

import java.util.function.Function;
import java.util.function.UnaryOperator;

class RecursiveLambda {
    static final UnaryOperator<Integer> stfactorial = x -> x== 0 
    ? 1 
    : x * RecursiveLambda.stfactorial.apply(x - 1 );

    Function<Integer, Integer> fact = (num) -> {
        if (num == 0) return 0;
        return this.fact.apply(num);
    };
    
    public static void main(String[] args) {
        // UnaryOperator<Integer> square = x -> x * x;
        // System.out.println(square.apply(4));

        /* 작동 X */ // UnaryOperator<Long> factorial = x -> x == 0 ? 1 : x * factorial.apply(x - 1);
        System.out.println(stfactorial.getClass());

        System.out.println(
        stfactorial.apply(5)
        );

        // for (int i = 0;; i++) {
        //     System.out.println(i + ": " + count.apply(i));
        //  }

    }
    static final UnaryOperator<Integer> count = x -> x  == 0 ? 0 : x + RecursiveLambda.count.apply(x - 1);

}