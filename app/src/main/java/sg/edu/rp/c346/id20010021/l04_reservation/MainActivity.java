package sg.edu.rp.c346.id20010021.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText number;
    EditText size;

    DatePicker dp;
    TimePicker tp;
    Button date;
    Button time;

    CheckBox smoke_yes;

    Button reset;
    Button confrim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        number = findViewById(R.id.number);
        size = findViewById(R.id.size);

        dp = findViewById(R.id.dp);
        tp = findViewById(R.id.tp);
        date = findViewById(R.id.date);
        time = findViewById(R.id.time);

        smoke_yes = findViewById(R.id.smoke_yes);

        reset = findViewById(R.id.reset);
        confrim = findViewById(R.id.confrim);

        dp.updateDate(2021, 5, 1);


        confrim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namee= name.getText().toString();
                String phone= number.getText().toString();
                String pax= size.getText().toString();

                String Csmoke="";
                if(smoke_yes.isChecked()){
                    Csmoke="smoking";
                } else{
                    Csmoke="not smoking";
                }

                String datee= dp.getYear()+"/"+(dp.getMonth()+1)+"/"+ dp.getDayOfMonth();
                String timee= tp.getCurrentHour()+":"+ String.format("%02d", tp.getCurrentMinute());

                String msg=namee+", your booking has been completed."+
                        "PAX:"+pax+
                        "Mobile number:"+phone+
                        Csmoke+
                        "Date:"+datee+
                        "Time"+timee;

                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();


            }
        });


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.setText("");
                number.setText("");
                size.setText("");
                smoke_yes.setChecked(false);
                dp.updateDate(2021, 5, 1);
                tp.setCurrentHour(20);
                tp.setCurrentMinute(30);
            }
        });


    }
}