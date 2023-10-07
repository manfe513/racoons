public class Bug1 {

    public static void main(String[] args) {
        fun1(false);
    }

    private static void fun1(boolean flag) {
        Number n;

        if( flag )
            n = Double.valueOf((double) (Integer.valueOf(1)));
        else
            n = Double.valueOf(Double.valueOf(2.0).doubleValue());

        System.out.println("n = " + n);
    }
}