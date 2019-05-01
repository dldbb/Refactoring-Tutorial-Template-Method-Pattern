package util;

import java.util.Date;

public class DataRange {
    private final Date start;
    private final Date end;

    public DataRange(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }
}
