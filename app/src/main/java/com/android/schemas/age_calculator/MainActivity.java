package com.android.schemas.age_calculator;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.Gravity;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button calculate, reset;
    private EditText yy,mm,dd,yy1,mm1,dd1;
    private Integer date, month, year;
    private TextView age,age1,age2,comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        yy = (EditText) findViewById(R.id.yy);
        mm = (EditText) findViewById(R.id.mm);
        dd = (EditText) findViewById(R.id.dd);
        yy1 = (EditText) findViewById(R.id.yy1);
        mm1 = (EditText) findViewById(R.id.mm1);
        dd1 = (EditText) findViewById(R.id.dd1);
        calculate = (Button) findViewById(R.id.calculate);
        reset = (Button) findViewById(R.id.reset);
        age = (TextView) findViewById(R.id.age);
        age1 = (TextView) findViewById(R.id.age1);
        age2 = (TextView) findViewById(R.id.age2);
        comment = (TextView) findViewById(R.id.comment);


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer Tdd = Integer.parseInt(dd.getText().toString());
                Integer Tmm = Integer.parseInt(mm.getText().toString());
                Integer Tyy = Integer.parseInt(yy.getText().toString());
                Integer Bdd = Integer.parseInt(dd1.getText().toString());
                Integer Bmm = Integer.parseInt(mm1.getText().toString());
                Integer Byy = Integer.parseInt(yy1.getText().toString());

                if (Tdd >= Bdd && Tmm >= Bmm && Tyy > Byy)
                {
                    date = Tdd - Bdd;
                    month = Tmm - Bmm;
                    year = Tyy - Byy;

                    age.setText(year+ " Year");
                    age1.setText(month+ " Month");
                    age2.setText(date+ " Day");
                }

                else if (Tdd > Bdd && Tmm < Bmm && Tyy > Byy)
                {
                    date = Tdd - Bdd;
                    month = (Tmm+12) - Bmm;
                    year = Tyy - (Byy+1);

                    age.setText(year+ " Year");
                    age1.setText(month+ " Month");
                    age2.setText(date+ " Day");
                }

                else if (Tdd < Bdd && Tmm > Bmm && Tyy > Byy)
                {
                    if (Bmm==5 || Bmm==7 || Bmm==10 || Bmm==12)
                    {
                        date = (Tdd+30) - Bdd;
                        month = Tmm - Bmm;
                        year = Tyy - Byy;

                        age.setText(year+ " Year");
                        age1.setText(month+ " Month");
                        age2.setText(date+ " Day");
                    }

                    else if (Bmm==2 || Bmm==4 || Bmm==6 || Bmm==8 || Bmm==9 || Bmm==11)
                    {
                        date = (Tdd+31) - Bdd;
                        month = Tmm - Bmm;
                        year = Tyy - Byy;

                        age.setText(year+ " Year");
                        age1.setText(month+ " Month");
                        age2.setText(date+ " Day");
                    }
                    else if(Bmm==3 && Byy%4==0)
                    {
                        date = (Tdd+29) - Bdd;
                        month = Tmm - Bmm;
                        year = Tyy - Byy;

                        age.setText(year+ " Year");
                        age1.setText(month+ " Month");
                        age2.setText(date+ " Day");
                    }
                    else if(Bmm==3 && Byy%4!=0)
                    {
                        date = (Tdd+28) - Bdd;
                        month = Tmm - Bmm;
                        year = Tyy - Byy;

                        age.setText(year+ " Year");
                        age1.setText(month+ " Month");
                        age2.setText(date+ " Day");
                    }

                }

                else if (Tdd < Bdd && Tmm < Bmm && Tyy > Byy)
                {
                    if (Bmm==5 || Bmm==7 || Bmm==10 || Bmm==12)
                    {
                        date = (Tdd+30) - Bdd;
                        month = (Tmm+12) - Bmm;
                        year = Tyy - (Byy+1);

                        age.setText(year+ " Year");
                        age1.setText(month+ " Month");
                        age2.setText(date+ " Day");
                    }

                    else if (Bmm==2 || Bmm==4 || Bmm==6 || Bmm==8 || Bmm==9 || Bmm==11)
                    {
                        date = (Tdd+31) - Bdd;
                        month = (Tmm+12) - Bmm;
                        year = Tyy - (Byy+1);

                        age.setText(year+ " Year");
                        age1.setText(month+ " Month");
                        age2.setText(date+ " Day");
                    }
                    else if(Bmm==3 && Byy%4==0)
                    {
                        date = (Tdd+29) - Bdd;
                        month = (Tmm+12) - Bmm;
                        year = Tyy - (Byy+1);

                        age.setText(year+ " Year");
                        age1.setText(month+ " Month");
                        age2.setText(date+ " Date");
                    }
                    else if(Bmm==3 && Byy%4!=0)
                    {
                        date = (Tdd+28) - Bdd;
                        month = (Tmm+12) - Bmm;
                        year = Tyy - (Byy+1);

                        age.setText(year+ " Year");
                        age1.setText(month+ " Month");
                        age2.setText(date+ " Day");
                    }

                }

                if (year<=18)
                {
                    LayoutInflater inflater = getLayoutInflater();
                    View CustomView = inflater.inflate(R.layout.toast, (ViewGroup) findViewById(R.id.toast));
                    Toast toast = new Toast(MainActivity.this);
                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP, 30, 120);
                    toast.setView(CustomView);
                    toast.show();
                }
                else if (year>=19 && year<24)
                {
                    LayoutInflater inflater = getLayoutInflater();
                    View CustomView = inflater.inflate(R.layout.toast1, (ViewGroup) findViewById(R.id.toast1));
                    Toast toast = new Toast(MainActivity.this);
                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP, 30, 120);
                    toast.setView(CustomView);
                    toast.show();
                }

                else if (year>=26 && year<30)
                {
                    LayoutInflater inflater = getLayoutInflater();
                    View CustomView = inflater.inflate(R.layout.toast4, (ViewGroup) findViewById(R.id.toast4));
                    Toast toast = new Toast(MainActivity.this);
                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP, 30, 120);
                    toast.setView(CustomView);
                    toast.show();
                }

                else if (year>=31 && year<50)
                {

                    LayoutInflater inflater = getLayoutInflater();
                    View CustomView = inflater.inflate(R.layout.toast3, (ViewGroup) findViewById(R.id.toast3));
                    Toast toast = new Toast(MainActivity.this);
                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP, 30, 120);
                    toast.setView(CustomView);
                    toast.show();

                }
                else if (year>=51)
                {
                    LayoutInflater inflater = getLayoutInflater();
                    View CustomView = inflater.inflate(R.layout.toast2, (ViewGroup) findViewById(R.id.toast2));
                    Toast toast = new Toast(MainActivity.this);
                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP, 30, 120);
                    toast.setView(CustomView);
                    toast.show();
                }

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dd1.setText(null);
                mm1.setText(null);
                yy1.setText(null);
            }
        });


    }
}
