package ca.bcit.jihyokim.lab13;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class HolidayAdapter extends BaseAdapter {
    private ArrayList<Holiday> holidayList;
    private Context mContext;

    public HolidayAdapter(Context context, ArrayList<Holiday> items) {
        mContext = context;
        holidayList = items;
    }

    @Override
    public int getCount() {
        return holidayList.size();
    }

    @Override
    public Object getItem(int position) {
        return holidayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(mContext);
            v = vi.inflate(R.layout.holiday_row_item, parent, false);
        }

        TextView nameTv = v.findViewById(R.id.holiday_name);
        TextView dateTv = v.findViewById(R.id.holiday_next_date);
        TextView isFixedDateTv = v.findViewById(R.id.holiday_is_fixed_date);

        nameTv.setText(holidayList.get(position).getHolidayName());
        dateTv.setText(holidayList.get(position).getNextDate());
        isFixedDateTv.setText(String.valueOf(holidayList.get(position).getIsFixedDate()));

        return v;
    }
}
