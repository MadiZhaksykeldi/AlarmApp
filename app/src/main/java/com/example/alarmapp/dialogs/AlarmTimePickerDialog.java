package com.example.alarmapp.dialogs;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.alarmapp.AlarmTime;
import com.example.alarmapp.R;

public class AlarmTimePickerDialog extends TimePickerDialog {

    public AlarmTimePickerDialog(Context context, OnTimeSetListener listener, int hourOfDay, int minute,
                                 boolean is24HourView) {
        super(context, listener, hourOfDay, minute, is24HourView);
    }

    @Override
    public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
        super.onTimeChanged(view, hourOfDay, minute);
        showTimeLeft(hourOfDay, minute);
    }

    @Override
    public void setCustomTitle(View customTitleView) {
        if (getContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) { //title is displayed in portrait orientation only
            super.setCustomTitle(customTitleView);
        }
    }

    public void showTimeLeft(int hour, int minute) {
        if (getContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            TextView textView = (TextView) this.findViewById(R.id.textview_timepickerdialog_timeleft);
            AlarmTime time = new AlarmTime(hour, minute);
            textView.setText(getContext().getString(R.string.all_time_left, time.getHoursLeft(), time.getMinutesLeft()));
        }
    }
}