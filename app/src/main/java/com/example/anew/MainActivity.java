 package com.example.anew;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import org.mariuszgromada.math.mxparser.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

 public class MainActivity extends AppCompatActivity {

    private EditText display;
    String oldNumber= "";
    boolean newOP =true;
    String op ="+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display =findViewById(R.id.textView);
        display.setShowSoftInputOnFocus(false );

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getString(R.string.display).equals(display.getText().toString())){
                    display.setText("");
                }
            }
        });
    }

    private void updateText(String addString){
        String oldString =display.getText().toString();
        int cursorPosition =display.getSelectionStart();
        String leftString = oldString.substring(0,cursorPosition);
        String rightString = oldString.substring(cursorPosition);
        if (getString(R.string.display).equals(display.getText().toString())){
            display.setText(addString);
            display.setSelection(cursorPosition+1);

        } else{
            display.setText(String.format("%s%s%s",leftString,addString,rightString));
            display.setSelection(cursorPosition+1);
        }


    }
    public void nolbtn(View view){
        updateText("0");
    }
     public void satubtn(View view){
        updateText("1");
     }
     public void duabtn(View view){
        updateText("2");
     }
     public void tigabtn(View view){
        updateText("3");
     }
     public void empatbtn(View view){
        updateText("4");
     }
     public void limabtn(View view){
        updateText("5");
     }
     public void enambtn(View view){
        updateText("6");
     }
     public void tujuhbtn(View view){
        updateText("7");
     }
     public void delapanbtn(View view){
        updateText("8");
     }
     public void sembilanbtn(View view){
         updateText("9");
     }

     public void clearbtn(View view){
        display.setText(" ");
     }

     public void exponentbtn(View view){
         updateText("^");
     }
     public void dividebtn(View view){
         updateText("÷");
     }
     public void multiplybtn(View view){
         updateText("×");
     }
     public void subtractbtn(View view){
         updateText("-");
     }
     public void addbtn(View view){
         updateText("+");
     }

     public void equalsbtn(View view){
         String use= display.getText().toString();
         use = use.replaceAll("÷","/");
         use = use.replaceAll("×","*");

         Expression expression = new Expression(use);
         String hasil = String.valueOf(expression.calculate());
         display.setText(hasil);
         display.setSelection(hasil.length());

     }
     public void pointbtn(View view){
         updateText(".");
     }
     public void plusminusbtn(View view){
         display.setText(" ");
     }

     public void backspace(View view){
        int cursorPosition = display.getSelectionStart();
        int textlength = display.getText().length();
        if (cursorPosition !=0 && textlength !=0){
             SpannableStringBuilder pilih = (SpannableStringBuilder) display.getText();
             pilih.replace(cursorPosition-1,cursorPosition,"");
             display.setText(pilih);
             display.setSelection(cursorPosition-1);

         }
     }
}