package com.example.calc;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.example.calc.Functions.Functions;
import com.example.calc.Functions.Values;

public class Calculator extends AppCompatActivity {

    private TextView textView;
    private Button button0;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button buttonDot;
    private Button buttonPlus;
    private Button buttonMinus;
    private Button buttonEqually;
    private Button buttonIncrease;
    private Button buttonDecrease;
    private Button buttonUnsigned;
    private ImageButton buttonDelete;
    private ImageButton buttonDeleteAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        textView  = (TextView) findViewById(R.id.textView);
        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonDot = (Button) findViewById(R.id.buttonDot);
        buttonPlus = (Button) findViewById(R.id.buttonPlus);
        buttonMinus = (Button) findViewById(R.id.buttonMinus);
        buttonEqually = (Button) findViewById(R.id.buttonEqually);
        buttonIncrease = (Button) findViewById(R.id.buttonIncrease);
        buttonDecrease = (Button) findViewById(R.id.buttonDecrease);
        buttonUnsigned = (Button) findViewById(R.id.buttonUnsigned);
        buttonDelete = (ImageButton) findViewById(R.id.buttonDelete);
        buttonDeleteAll = (ImageButton) findViewById(R.id.buttonDeleteAll);

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Functions.Znak("+");
                textView.setText(Values.Stroka);
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Functions.Znak("-");
                textView.setText(Values.Stroka);
            }
        });

        buttonIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Functions.Znak("*");
                textView.setText(Values.Stroka);
            }
        });

        buttonDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Functions.Znak("/");
                textView.setText(Values.Stroka);
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Values.Stroka += ",";
                if (!Values.Chislo)
                    Values.Chislo1 += ".";
                else
                    Values.Chislo2 += ".";
                textView.setText(Values.Stroka);
            }
        });

        buttonEqually.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Functions.Equally();
                textView.setText(Values.Stroka);
                }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Values.Ravno)
                {
                    Values.Chislo1 = "";
                    Values.Stroka = "";
                    Values.Chislo1NULL = false;
                    Values.Ravno = false;
                }
                else if (!Values.Chislo1NULL)
                    return;
                else if (Values.Znak == "") {
                    Values.Chislo1 = Values.Chislo1.substring(0, Values.Chislo1.length() - 1);
                    if (Values.Chislo1.length() == 0)
                        Values.Chislo1NULL = false;
                    Values.Stroka = Values.Chislo1;
                }
                else if (!Values.Chislo2NULL)
                {
                    Values.Znak = "";
                    Values.Stroka = Values.Chislo1;
                    Values.Chislo = false;
                }
                else
                {
                    Values.Chislo2 = Values.Chislo2.substring(0, Values.Chislo2.length() - 1);
                    if (Values.Chislo2.length() == 0)
                        Values.Chislo2NULL = false;
                    Values.Stroka = Values.Chislo1 + " " + Values.Znak + " " + Values.Chislo2;
                }
                textView.setText(Values.Stroka);
            }
        });

        buttonDeleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Values.Stroka = "";
                Values.Chislo1 = "";
                Values.Chislo2 = "";
                Values.Znak = "";
                Values.Ravno = false;
                Values.Chislo = false;
                Values.Chislo1NULL = false;
                Values.Chislo2NULL = false;
                textView.setText(Values.Stroka);
            }
        });

        buttonUnsigned.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!Values.Chislo) {
                    if (Values.Chislo1Minus)
                    {
                        Values.Chislo1 = Values.Chislo1.substring(1, Values.Chislo1.length());
                        Values.Chislo1Minus = false;
                    }
                    else
                    {
                        Values.Chislo1 = "-" + Values.Chislo1;
                        Values.Chislo1Minus = true;
                    }
                }
                else {
                    if (Values.Chislo2Minus)
                    {
                        Values.Chislo2 = Values.Chislo2.substring(1, Values.Chislo2.length());
                        Values.Chislo2Minus = false;
                    }
                    else
                    {
                        Values.Chislo2 = "-" + Values.Chislo2;
                        Values.Chislo2Minus = true;
                    }
                }
                Values.Stroka = Values.Chislo1 + " " + Values.Znak + " " + Values.Chislo2;
                textView.setText(Values.Stroka);
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Functions.Vvod(0);
                textView.setText(Values.Stroka);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Functions.Vvod(1);
                textView.setText(Values.Stroka);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Functions.Vvod(2);
                textView.setText(Values.Stroka);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Functions.Vvod(3);
                textView.setText(Values.Stroka);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Functions.Vvod(4);
                textView.setText(Values.Stroka);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Functions.Vvod(5);
                textView.setText(Values.Stroka);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Functions.Vvod(6);
                textView.setText(Values.Stroka);
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Functions.Vvod(7);
                textView.setText(Values.Stroka);
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Functions.Vvod(8);
                textView.setText(Values.Stroka);
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Functions.Vvod(9);
                textView.setText(Values.Stroka);
            }
        });
    }

    private class LoadImage extends AsyncTask<Void, Integer, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        protected Void doInBackground(Void... args) {
            for (int i = 0; i < 100; i += 10) {
                try {
                    Thread.sleep(1000);
                    publishProgress(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            publishProgress(100);
            return null;
        }
        protected void onPostExecute(Void image) {
        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

        }
    }
    }
