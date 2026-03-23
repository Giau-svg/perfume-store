package util;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateFormatter {
    public static Timestamp toStartOfDay(Date date) {
        LocalDate localDate = date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        LocalDateTime startOfDay = localDate.atStartOfDay(); // Tương đương 00:00:00
        return Timestamp.valueOf(startOfDay);
    }

    public static Timestamp toEndOfDay(Date date) {
        LocalDate localDate = date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        LocalDateTime endOfDay = localDate.atTime(23, 59, 59);
        return Timestamp.valueOf(endOfDay);
    }

}
