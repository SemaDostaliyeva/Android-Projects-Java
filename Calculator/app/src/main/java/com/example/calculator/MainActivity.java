package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView resulttext;
    Button button1 , button2 , button3 , button4 , button5 , button6 , button7 , button8 , button9 , button0, buttonmul , buttonsum , buttondift , buttondivide , buttonequal , buttonclean;
    boolean sum , dift , mult , div;
    Float number1 , number2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1=(Button)findViewById(R.id.btn1);
        button2=(Button)findViewById(R.id.btn2);
        button3=(Button)findViewById(R.id.btn3);
        button4=(Button)findViewById(R.id.btn4);
        button5=(Button)findViewById(R.id.btn5);
        button6=(Button)findViewById(R.id.btn6);
        button7=(Button)findViewById(R.id.btn7);
        button8=(Button)findViewById(R.id.btn8);
        button9=(Button)findViewById(R.id.btn9);
        button0=(Button)findViewById(R.id.btn0);
        buttonmul=(Button)findViewById(R.id.btnmultiple);
        buttonsum=(Button)findViewById(R.id.btnsum);
        buttondift=(Button)findViewById(R.id.btndif);
        buttondivide=(Button)findViewById(R.id.btndivide);
        buttonequal=(Button)findViewById(R.id.btnequal);
        resulttext=(TextView)findViewById(R.id.ressultText);
        buttonclean=(Button)findViewById(R.id.buttonClean);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resulttext.setText(resulttext.getText()+"1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resulttext.setText(resulttext.getText()+"2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resulttext.setText(resulttext.getText()+"3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resulttext.setText(resulttext.getText()+"4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resulttext.setText(resulttext.getText()+"5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resulttext.setText(resulttext.getText()+"6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resulttext.setText(resulttext.getText()+"7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resulttext.setText(resulttext.getText()+"8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resulttext.setText(resulttext.getText()+"9");
            }
        });
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resulttext.setText(resulttext.getText()+"0");
            }
        });
        buttonsum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(resulttext==null){
                    resulttext.setText("");
                }
                else{
                    number1=Float.parseFloat(resulttext.getText()+"");
                    sum=true;
                    resulttext.setText(null);
                }
            }
        });
        buttondift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(resulttext==null){
                    resulttext.setText("");
                }
                else{
                    number1=Float.parseFloat(resulttext.getText()+"");
                    dift=true;
                    resulttext.setText(null);
                }
            }
        });
        buttonmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(resulttext==null){
                    resulttext.setText("");
                }
                else{
                    number1=Float.parseFloat(resulttext.getText()+"");
                    mult=true;
                    resulttext.setText(null);
                }
            }
        });
        buttondivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(resulttext==null){
                    resulttext.setText("");
                }
                else{
                    number1=Float.parseFloat(resulttext.getText()+"");
                    div=true;
                    resulttext.setText(null);
                }
            }
        });
        buttonclean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resulttext.setText("");
            }
        });
        buttonequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number2=Float.parseFloat(resulttext.getText()+"");
                if(sum==true){
                    resulttext.setText(number1+number2+"");
                    sum=false;
                }
                else if(dift==true){
                    resulttext.setText(number1-number2+"");
                    dift=false;
                }
                else if(mult==true){
                    resulttext.setText(number1*number2+"");
                }
                else if(div==true){
                    resulttext.setText(number1/number2+"");
                }
            }
        });



    }
}