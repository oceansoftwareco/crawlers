package pro.ivanov.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DefaultDateTime {
    public static LocalDate today() {
        return LocalDate.now();
    }

    public static DateTimeFormatter defaultFormatter() {
        return DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }
}
