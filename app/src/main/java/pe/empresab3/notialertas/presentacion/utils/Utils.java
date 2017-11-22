package pe.empresab3.notialertas.presentacion.utils;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Administrador on 22/11/2017.
 */

public class Utils {

    public void showTimePickerDialog(Context context, final EditText editText) {
        final Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);

        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                String valor = "";
                valor = editText.getText().toString();

                mcurrentTime.set(Calendar.HOUR_OF_DAY, selectedHour);
                mcurrentTime.set(Calendar.MINUTE, selectedMinute);
                String myFormat = "hh:mm a"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                editText.setText(valor + " " + sdf.format(mcurrentTime.getTime()));
            }
        }, hour, minute, false);//Yes 24 hour time
        mTimePicker.setTitle("Elija la hora");
        mTimePicker.setButton(TimePickerDialog.BUTTON_POSITIVE, "Aceptar", mTimePicker);
        mTimePicker.setButton(TimePickerDialog.BUTTON_NEGATIVE, "Cancelar", mTimePicker);
        mTimePicker.show();
    }

    public void showDateDialog(final Context context, final EditText editText, final boolean evaluateDate, final int typeValidation) {
        final Calendar mcurrentTime = Calendar.getInstance();
        int year = mcurrentTime.get(Calendar.YEAR);
        int month = mcurrentTime.get(Calendar.MONTH);
        int day = mcurrentTime.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog;
        dialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                mcurrentTime.set(Calendar.YEAR, year);
                mcurrentTime.set(Calendar.MONTH, monthOfYear);
                mcurrentTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String myFormat = "dd/MM/yyyy";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                editText.setText(sdf.format(mcurrentTime.getTime()));
            }

        }, year, month, day);
        dialog.setButton(DatePickerDialog.BUTTON_POSITIVE, "Aceptar", dialog);
        dialog.setButton(DatePickerDialog.BUTTON_NEGATIVE, "Cancelar", dialog);
        dialog.show();
    }

}