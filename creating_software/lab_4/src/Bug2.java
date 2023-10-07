public class Bug2 {

    static boolean flag1, flag2 = true;

    public static void main(String[] args) {

        Integer n;
        if( flag1 ) n = Integer.valueOf(1);
        else {
            if( flag2 )
                n = Integer.valueOf(Integer.valueOf(2).intValue());
            else
                n = Integer.valueOf(((Integer)null).intValue());
        }
    }
}