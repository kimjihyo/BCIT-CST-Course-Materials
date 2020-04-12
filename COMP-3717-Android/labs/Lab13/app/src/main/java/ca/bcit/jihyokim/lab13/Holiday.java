package ca.bcit.jihyokim.lab13;

public class Holiday {
    private String mHolidayName;
    private String mNextDate;
    private int mIsFixedDate;

    public Holiday(String holidayName, String nextDate, int isFixedDate) {
        mHolidayName = holidayName;
        mNextDate = nextDate;
        mIsFixedDate = isFixedDate;
    }

    public String getHolidayName() {
        return mHolidayName;
    }

    public String getNextDate() {
        return mNextDate;
    }

    public int getIsFixedDate() {
        return mIsFixedDate;
    }
}
