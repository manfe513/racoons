import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Bug3 {
    private static final DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {

        getDate();
    }

    private static String getDate() {
        return format.format(new Date());
    }
}