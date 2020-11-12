package khan.example.calculatorn;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
//import com.google.android.gms.ads.AdView;
import java.io.FileDescriptor;
import java.io.IOError;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button one,two,three,four,five,six,seven,eight,nine,dot,zero,plus,
    minus,multiply,divide,equal,clear,clearE,signC;
    TextView textView, developer;
    String temp,tempNext = "";
    String Operation = "";
    String previous,Next = "";
    String Signchanger = "";
    Double OurTemporary = 0.0;
    Double previous1,Next1 = 0.0;
   // private AdView mAdView;


    Handler handler = new Handler(Looper.getMainLooper() );


    public void setClearE(View view)
    {
        //temp = textView.getText().toString();
        if ( textView.getText().toString() == "" )
        {
            Toaster("enable to perform task on empty screen!");
        }
      /*  else if (!( textView.getText().toString() == ""))
            temp = temp.substring(0,temp.length()-1);
            textView.setText(temp);
            temp = "";*/
        else
        {

            temp = textView.getText().toString();
            try {
                temp = temp.substring(0,temp.length()-1);
                textView.setText(temp);
                temp = "";
            }
            catch (IndexOutOfBoundsException iobe)
            {
                iobe.printStackTrace();
            }


        }

    }


    public void setSignC(View view)
    {
        temp = textView.getText().toString();

        if ( temp == "")
        {
            textView.setText("-0");
        }


        else if ( !(temp.trim() == "+") && !(temp.trim() == "-")
                && !(temp.trim() == "x") && !(temp.trim() == "/") )

        try {

                Signchanger = textView.getText().toString().trim();
                OurTemporary = Double.valueOf(Signchanger);
                OurTemporary  = -1*(OurTemporary);
                textView.setText(String.valueOf(OurTemporary)); Signchanger = ""; OurTemporary = 0.0;

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

   /*      if (!( textView.getText().toString() == "") && !(textView.getText().toString() == "x") && !(textView.getText().toString() == "-") &&
            !(textView.getText().toString() == "+") && !(textView.getText().toString() == "/"))
    {
        Toaster("Attempt failed!");

    }
        if (Nothingavailable())
        {
            Toaster("Attempt failed!");
        }
        if ( (textView.getText().toString() == ""))
        {
            Toaster("Attempt failed!");
        }

        if ( !(textView.getText().toString().trim() == "+") && !(textView.getText().toString().trim() == "-")
                && !(textView.getText().toString().trim() == "x") && !(textView.getText().toString().trim() == "/") )
        {
            Signchanger = textView.getText().toString().trim();
            OurTemporary = Double.valueOf(Signchanger);
            OurTemporary  = -1*(OurTemporary);
            textView.setText(String.valueOf(OurTemporary)); Signchanger = ""; OurTemporary = 0.0;
        }
        else
            Toaster("Please enter number first!");*/

    }


    public void setEqual(View view)
    {

        if ((Operation == "") && ( previous == "") && ( Next == ""))
        {
            Toaster("Please enter a number first!");
        }

        if (!(Operation == ""))
        {
            if (!( previous == ""))
            {
                  previous1 = Double.valueOf(previous);
                 if (!( textView.getText().toString().trim() == ""))
                  Next1 = Double.valueOf(textView.getText().toString().trim());

                if (Operation == "+")
                {
                    Next = String.valueOf(previous1 + Next1);
                    textView.setText(Next);
                    previous = "";
                    Next1 = 0.0;
                    Operation = "";
                    temp = "";
                    tempNext = "";
                    previous1 = 0.0;

                }
                else if (Operation == "-")
                {
                    Next = String.valueOf(previous1 - Next1);
                    textView.setText(Next);
                    previous = "";
                    Next1 = 0.0;
                    Operation = "";
                    temp = "";
                    tempNext = "";
                    previous1 = 0.0;
                }
                else if  (Operation == "x")
                {
                    Next = String.valueOf(previous1 * Next1);
                    textView.setText(Next);
                    previous = "";
                    Next1 = 0.0;
                    Operation = "";
                    temp = "";
                    tempNext = "";
                    previous1 = 0.0;
                }
                else if  (Operation == "/")
                {
                    Next = String.valueOf(previous1 / Next1);
                    textView.setText(Next);
                    previous = "";
                    Next1 = 0.0;
                    Operation = "";
                    temp = "";
                    tempNext = "";
                    previous1 = 0.0;
                }
                else
                    Toaster("Please enter a Number!");

            }
            else
                Toaster("Please enter a Number!");
        }
        else
            Toaster("Please enter a Number!");
    }


   public void initialize()
    {
        textView = (TextView) findViewById(R.id.textView);
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        zero = (Button) findViewById(R.id.zero);
        dot = (Button) findViewById(R.id.dot);
        plus = (Button) findViewById(R.id.plus);
        minus = (Button) findViewById(R.id.minus);
        multiply = (Button) findViewById(R.id.multiply);
        divide = (Button) findViewById(R.id.divide);
        clear = (Button) findViewById(R.id.clear);
        clearE = (Button) findViewById(R.id.clearE);
        signC = (Button) findViewById(R.id.signC);
        equal = (Button) findViewById(R.id.equal);
    }
    public void Toaster(String gettext)
    {
        Toast.makeText(getApplicationContext(),gettext,Toast.LENGTH_SHORT).show();
    }

    public boolean Nothingavailable()
    {
        if (textView.getText().toString().trim() == "" && Operation == "" && previous == "" &&
                Next == "" && temp == "" && tempNext == "" && OurTemporary == 0.0   )
        {
            return true;
        }
        else
            return false;
    }


    public void setMinus(View view)
    {
        if (Nothingavailable())
    {
        Toaster("Attempt failed!");
    }


        if (Operation == "-")
        {
            if ((previous == ""))
                Toaster("Avoid using same operation multiple times!");
            else
                textView.setText(String.valueOf(Double.valueOf(previous) - Double.valueOf(textView.getText().toString().trim())));
            previous = "";
            Operation = "";
        }
        else if (!( textView.getText().toString() == "") && !(textView.getText().toString() == "x") && !(textView.getText().toString() == "-") &&
                !(textView.getText().toString() == "+") && !(textView.getText().toString() == "/"))
        {
            previous =  textView.getText().toString().trim();
            textView.setText("-");

        }
        else if ((textView.getText().toString() == "x") || (textView.getText().toString() == "-") &&
                (textView.getText().toString() == "+") && (textView.getText().toString() == "/"))

        {
            textView.setText("-");

        }
    }
    public void setDivide(View view)
    {
        if (Operation == "/")
        {
            if ((previous == ""))
                Toaster("Avoid using same operation multiple times!");
            else
                textView.setText(String.valueOf(Double.valueOf(previous) / Double.valueOf(textView.getText().toString().trim())));
            previous = "";
            Operation = "";
        }
        else if (!( textView.getText().toString() == "") && !(textView.getText().toString() == "x") && !(textView.getText().toString() == "-") &&
                !(textView.getText().toString() == "+") && !(textView.getText().toString() == "/"))
        {
            previous =  textView.getText().toString().trim();
            textView.setText("/");

        }
        else if ((textView.getText().toString() == "x") || (textView.getText().toString() == "-")
                && (textView.getText().toString() == "+") && (textView.getText().toString() == "/"))
        {
            textView.setText("/");
        }
    }

    public void setMultiply(View view)
    {
        if (Operation == "x")
        {
            if ((previous == ""))
                Toaster("Avoid using same operation multiple times!");
            else
                textView.setText(String.valueOf(Double.valueOf(previous) * Double.valueOf(textView.getText().toString().trim())));
            previous = "";
            Operation = "";
        }
        else if (!( textView.getText().toString() == "") && !(textView.getText().toString() == "x") && !(textView.getText().toString() == "-") &&
                !(textView.getText().toString() == "+") && !(textView.getText().toString() == "/"))
        {
            previous =  textView.getText().toString().trim();
            textView.setText("x");

        }
        else if ((textView.getText().toString() == "x") || (textView.getText().toString() == "-")
                && (textView.getText().toString() == "+") && (textView.getText().toString() == "/"))
        {
            textView.setText("x");

        }

    }

    public void adder(View view)
    {
        if (Operation == "+")
        {
            if ((previous == ""))
                Toaster("Avoid using same operation multiple times!");
            else
                textView.setText(String.valueOf(Double.valueOf(previous) + Double.valueOf(textView.getText().toString().trim())));
                previous = "";
                Operation = "";
        }
        else if (!( textView.getText().toString() == "") && !(textView.getText().toString() == "x") && !(textView.getText().toString() == "-") &&
                !(textView.getText().toString() == "+") && !(textView.getText().toString() == "/"))
        {
           previous =  textView.getText().toString().trim();
           textView.setText("+");

        }
        else if ((textView.getText().toString() == "x") || (textView.getText().toString() == "-") && (textView.getText().toString() == "+") && (textView.getText().toString() == "/"))

        {
            textView.setText("+");

        }

    }

    public void setOne(View view)
    {
         if (textView.getText().toString() == "x")
        {
            Operation = "x";
            textView.setText("1");
        }
        else if (textView.getText().toString() == "+")
        {
            Operation = "+";
            textView.setText("1");
        }
        else if (textView.getText().toString() == "-")
        {
            Operation = "-";
            textView.setText("1");

        }
        else if (textView.getText().toString() == "/")
        {
            Operation = "/";
            textView.setText("1");

        }
         else if (!(textView.getText().toString() == "")  && !(textView.getText().toString() == "x") && !(textView.getText().toString() == "-") &&
                  !(textView.getText().toString() == "+") && !(textView.getText().toString() == "/"))
         {
             temp = textView.getText().toString();
             tempNext = temp + "1";
             textView.setText(tempNext);
             temp = "";
             tempNext = "";
         }
         else
             textView.setText("1");

    }

    public void setTwo(View view)
    {

        if (textView.getText().toString() == "x")
        {
            Operation = "x";
            textView.setText("2");
        }
        else if (textView.getText().toString() == "+")
        {
            Operation = "+";
            textView.setText("2");

        }
        else if (textView.getText().toString() == "-")
        {
            Operation = "-";
            textView.setText("2");
        }
        else if (textView.getText().toString() == "/")
        {
            Operation = "/";
            textView.setText("2");

        }
        else if (!(textView.getText().toString() == "")  && !(textView.getText().toString() == "x") && !(textView.getText().toString() == "-") &&
                !(textView.getText().toString() == "+") && !(textView.getText().toString() == "/"))
        {
            temp = textView.getText().toString();
            tempNext = temp + "2";
            textView.setText(tempNext);
            temp = "";
            tempNext = "";
        }
        else
            textView.setText("2");

    }

    public void setThree(View view)
    {


        if (textView.getText().toString() == "x")
        {
            Operation = "x";
            textView.setText("3");
        }
        else if (textView.getText().toString() == "+")
        {
            Operation = "+";
            textView.setText("3");
        }
        else if (textView.getText().toString() == "-")
        {
            Operation = "-";
            textView.setText("3");

        }
        else if (textView.getText().toString() == "/")
        {
            Operation = "/";
            textView.setText("3");

        }
        else if (!(textView.getText().toString() == "")  && !(textView.getText().toString() == "x") && !(textView.getText().toString() == "-") &&
                !(textView.getText().toString() == "+") && !(textView.getText().toString() == "/"))
        {
            temp = textView.getText().toString();
            tempNext = temp + "3";
            textView.setText(tempNext);
            temp = "";
            tempNext = "";
        }
        else
            textView.setText("3");

    }





    public void setFour(View view)
    {


        if (textView.getText().toString() == "x")
        {
            Operation = "x";
            textView.setText("4");
        }
        else if (textView.getText().toString() == "+")
        {
            Operation = "+";
            textView.setText("4");
        }
        else if (textView.getText().toString() == "-")
        {
            Operation = "-";
            textView.setText("4");

        }
        else if (textView.getText().toString() == "/")
        {
            Operation = "/";
            textView.setText("4");

        }
        else if (!(textView.getText().toString() == "")  && !(textView.getText().toString() == "x") && !(textView.getText().toString() == "-") &&
                !(textView.getText().toString() == "+") && !(textView.getText().toString() == "/"))
        {
            temp = textView.getText().toString();
            tempNext = temp + "4";
            textView.setText(tempNext);
            temp = "";
            tempNext = "";
        }
        else
            textView.setText("4");

    }

    public void setFive(View view)
    {


        if (textView.getText().toString() == "x")
        {
            Operation = "x";
            textView.setText("5");
        }
        else if (textView.getText().toString() == "+")
        {
            Operation = "+";
            textView.setText("5");
        }
        else if (textView.getText().toString() == "-")
        {
            Operation = "-";
            textView.setText("5");

        }
        else if (textView.getText().toString() == "/")
        {
            Operation = "/";
            textView.setText("5");

        }
        else if (!(textView.getText().toString() == "")  && !(textView.getText().toString() == "x") && !(textView.getText().toString() == "-") &&
                !(textView.getText().toString() == "+") && !(textView.getText().toString() == "/"))
        {
            temp = textView.getText().toString();
            tempNext = temp + "5";
            textView.setText(tempNext);
            temp = "";
            tempNext = "";
        }
        else
            textView.setText("5");

    }

    public void setSix(View view)
    {


        if (textView.getText().toString() == "x")
        {
            Operation = "x";
            textView.setText("6");
        }
        else if (textView.getText().toString() == "+")
        {
            Operation = "+";
            textView.setText("6");
        }
        else if (textView.getText().toString() == "-")
        {
            Operation = "-";
            textView.setText("6");

        }
        else if (textView.getText().toString() == "/")
        {
            Operation = "/";
            textView.setText("6");

        }
        else if (!(textView.getText().toString() == "")  && !(textView.getText().toString() == "x") && !(textView.getText().toString() == "-") &&
                !(textView.getText().toString() == "+") && !(textView.getText().toString() == "/"))
        {
            temp = textView.getText().toString();
            tempNext = temp + "6";
            textView.setText(tempNext);
            temp = "";
            tempNext = "";
        }
        else
            textView.setText("6");

    }

    public void setSeven(View view)
    {


        if (textView.getText().toString() == "x")
        {
            Operation = "x";
            textView.setText("7");
        }
        else if (textView.getText().toString() == "+")
        {
            Operation = "+";
            textView.setText("7");
        }
        else if (textView.getText().toString() == "-")
        {
            Operation = "-";
            textView.setText("7");

        }
        else if (textView.getText().toString() == "/")
        {
            Operation = "/";
            textView.setText("7");

        }
        else if (!(textView.getText().toString() == "")  && !(textView.getText().toString() == "x") && !(textView.getText().toString() == "-") &&
                !(textView.getText().toString() == "+") && !(textView.getText().toString() == "/"))
        {
            temp = textView.getText().toString();
            tempNext = temp + "7";
            textView.setText(tempNext);
            temp = "";
            tempNext = "";
        }
        else
            textView.setText("7");

    }

    public void setEight(View view)
    {


        if (textView.getText().toString() == "x")
        {
            Operation = "x";
            textView.setText("8");
        }
        else if (textView.getText().toString() == "+")
        {
            Operation = "+";
            textView.setText("8");
        }
        else if (textView.getText().toString() == "-")
        {
            Operation = "-";
            textView.setText("8");

        }
        else if (textView.getText().toString() == "/")
        {
            Operation = "/";
            textView.setText("8");

        }
        else if (!(textView.getText().toString() == "")  && !(textView.getText().toString() == "x") && !(textView.getText().toString() == "-") &&
                !(textView.getText().toString() == "+") && !(textView.getText().toString() == "/"))
        {
            temp = textView.getText().toString();
            tempNext = temp + "8";
            textView.setText(tempNext);
            temp = "";
            tempNext = "";
        }
        else
            textView.setText("8");

    }

    public void setNine(View view)
    {


        if (textView.getText().toString() == "x")
        {
            Operation = "x";
            textView.setText("9");
        }
        else if (textView.getText().toString() == "+")
        {
            Operation = "+";
            textView.setText("9");
        }
        else if (textView.getText().toString() == "-")
        {
            Operation = "-";
            textView.setText("9");

        }
        else if (textView.getText().toString() == "/")
        {
            Operation = "/";
            textView.setText("9");

        }
        else if (!(textView.getText().toString() == "")  && !(textView.getText().toString() == "x") && !(textView.getText().toString() == "-") &&
                !(textView.getText().toString() == "+") && !(textView.getText().toString() == "/"))
        {
            temp = textView.getText().toString();
            tempNext = temp + "9";
            textView.setText(tempNext);
            temp = "";
            tempNext = "";
        }
        else
            textView.setText("9");

    }

    public void setZero(View view)
    {


        if (textView.getText().toString() == "x")
        {
            Operation = "x";
            textView.setText("0");
        }
        else if (textView.getText().toString() == "+")
        {
            Operation = "+";
            textView.setText("0");
        }
        else if (textView.getText().toString() == "-")
        {
            Operation = "-";
            textView.setText("0");

        }
        else if (textView.getText().toString() == "/")
        {
            Operation = "/";
            textView.setText("0");

        }
        else if (!(textView.getText().toString() == "")  && !(textView.getText().toString() == "x") && !(textView.getText().toString() == "-") &&
                !(textView.getText().toString() == "+") && !(textView.getText().toString() == "/"))
        {
            temp = textView.getText().toString();
            tempNext = temp + "0";
            textView.setText(tempNext);
            temp = "";
            tempNext = "";
        }
        else
            textView.setText("0"); }

    public void setDot(View view) {

        if (textView.getText().toString().contains("."))

        {
            Toaster("You can not use dot multiple times!");

        }
        else


        if (textView.getText().toString() == "x") {
            Operation = "x";
            textView.setText(".");
        } else if (textView.getText().toString() == "+") {
            Operation = "+";
            textView.setText(".");
        } else if (textView.getText().toString() == "-") {
            Operation = "-";
            textView.setText(".");

        }
        else if (textView.getText().toString() == "/") {
            Operation = "/";
            textView.setText(".");

        }
        else if (!(textView.getText().toString() == "/") && !(textView.getText().toString() == "x") && !(textView.getText().toString() == "-") &&
        !(textView.getText().toString() == "+") && !(textView.getText().toString() == "") )
        {
            temp = textView.getText().toString().trim();
            tempNext = temp + ".";
            textView.setText(tempNext);
            temp = "";
            tempNext = "";
        }




       /* tempNext = temp + ".";
        textView.setText(tempNext);
        temp = "";
        tempNext = "";*/

        else
        textView.setText(".");
    }




    public void backspace(View view)
    {
       /* developer = (TextView) findViewById(R.id.developer);
        NewRun newRun = new NewRun(800);
        new Thread(newRun).start();
        developer.animate().translationX(-800);*/

        textView.setText("");
        Operation = "";
        temp = "";
        tempNext = "";
        Next = "";
        previous = "";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initialize();




      /*  View decorView = getWindow().getDecorView();

// Hide both the navigation bar and the status bar.
// SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
// a general rule, you should design your app to hide the status bar whenever you
// hide the navigation bar.
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);*/
        //TextView textView3 = (TextView) findViewById(R.id.textView3);
        //NRunnable nRunnable = new NRunnable(100);
        //new Thread(nRunnable).start();




        //System.out.println(Nothingavailable());
        /*textView.setText("");
        Operation = "";
        previous = "";
        Next = "" ; temp = "" ; tempNext = "" ;
        OurTemporary = 0.0;*/


    }




}
