package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean mark = false;
    boolean mark1 =true;
    boolean ans =false;
    boolean dot = false;
    boolean min =false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onAddDiv(View view) {
        TextView cView = findViewById(R.id.etNewItem);
        TextView tView = findViewById(R.id.textView);
        if(mark && mark1 && !ans) {
            cView.setText(cView.getText() + "/");
            mark = false;
            mark1 = false;
            dot=false;
            min=false;
        }else if (mark && !mark1){
            String t = cView.getText().toString();
            tView.setText(t);
            cView.setText(calculation(t) + '/');
            mark = false;
            mark1 =false;
            ans=false;
            dot=false;
        }else if(!mark && !mark1 && !dot && !min){
            String t = cView.getText().toString();
            cView.setText(t.substring(0, t.length()-1) + '/');
            mark = false;
            mark1 = false;
            dot=false;
        }else if(ans ){
            cView.setText(cView.getText().toString() + '/');
            mark = false;
            mark1 = false;
            dot=false;
        }
    }

    public void onAddMul(View view) {
        TextView cView = findViewById(R.id.etNewItem);
        TextView tView = findViewById(R.id.textView);
        if(mark && mark1 && !ans) {
            cView.setText(cView.getText() + "x");
            mark = false;
            mark1 = false;
            dot=false;
            min=false;
        }else if (mark && !mark1){
            String t = cView.getText().toString();
            tView.setText(t);
            cView.setText(calculation(t) + 'x');
            mark = false;
            mark1 =false;
            ans=false;
            dot=false;
        }else if(!mark && !mark1 && !dot && !min){
            String t = cView.getText().toString();
            cView.setText(t.substring(0, t.length()-1) + 'x');
            mark = false;
            mark1 = false;
        }else if(ans ){
            cView.setText(cView.getText().toString() + 'x');
            mark = false;
            mark1 = false;
            dot=false;
        }
    }

    public void onAddMin(View view) {
        TextView cView = findViewById(R.id.etNewItem);
        TextView tView = findViewById(R.id.textView);
        if(((!mark && mark1) || (!mark && !mark1)) && !ans && !min && !dot) {
            cView.setText(cView.getText() + "-");
            mark = false;
            dot=false;
            min=true;
        }else if (mark && mark1){
            cView.setText(cView.getText().toString()+ '-');
            mark = false;
            mark1 =false;
            dot=false;
        }else if (mark && !mark1){
            String t = cView.getText().toString();
            tView.setText(t);
            cView.setText(calculation(t) + '-');
            mark = false;
            mark1 =false;
            ans=false;
            dot=false;
        }else if(ans ){
            cView.setText(cView.getText().toString() + '-');
            mark = false;
            mark1 = false;
            dot=false;
        }
    }

    public void onAddPlus(View view) {
        TextView cView = findViewById(R.id.etNewItem);
        TextView tView = findViewById(R.id.textView);
        if(mark && mark1 && !ans) {
            cView.setText(cView.getText() + "+");
            mark = false;
            mark1 = false;
            dot=false;
            min=false;
        }else if (mark && !mark1){
            String t = cView.getText().toString();
            tView.setText(t);
            cView.setText(calculation(t) + '+');
            mark = false;
            mark1 =false;
            ans=false;
            dot=false;
        }else if(!mark && !mark1 && !dot && !min){
            String t = cView.getText().toString();
                cView.setText(t.substring(0, t.length() - 1) + '+');
                mark = false;
                mark1 = false;

        }else if(ans ){
            cView.setText(cView.getText().toString() + '+');
            mark = false;
            mark1 = false;
            dot=false;
            ans=false;
        }
    }

    public void onAddEqu(View view) {
        TextView cView = findViewById(R.id.etNewItem);
        TextView tView = findViewById(R.id.textView);
        if(!mark && !mark1 && !dot) {
            String t = cView.getText().toString();
            t=t.substring(0, t.length()-1);
            tView.setText(t);
            cView.setText(t);
            int a;float b;
            b= Float.parseFloat(cView.getText().toString());
            a=(int) b;
            dot = true;
            if(a == b)dot = false;
            mark = true;
            mark1 = true;
         }else if((mark  && !mark1) || (!mark && dot && !mark1) ){
            String t = cView.getText().toString();
            if(t.charAt(t.length() - 1) == '.')t=t+'0';
            tView.setText(t);
            cView.setText(calculation(t));
            mark = true;
            mark1 =true;
            ans=true;
        }else if(mark1)tView.setText(cView.getText());
    }

    public void onAddrefresh(View view) {
        TextView cView = findViewById(R.id.etNewItem);
        TextView tView = findViewById(R.id.textView);
        cView.setText("");
        tView.setText("");
        mark = false;
        mark1=true;
        ans=false;
        dot=false;
        min=false;
    }

    public void onAddPlusMinus(View view) {
        TextView cView = findViewById(R.id.etNewItem);
        TextView tView = findViewById(R.id.textView);
        String t = cView.getText().toString();
        if(mark && mark1){
            cView.setText(calculationPM(cView.getText().toString()));
             }
        else if((t.indexOf('/') < t.length() || t.indexOf('x') < t.length() || t.indexOf('+') < t.length() || t.indexOf('-') < t.length()) && mark){

            tView.setText( t +"x-1" );
            cView.setText(calculationPM(calculation(t)));
            mark = true;
            mark1 =true;
            ans=true;
            }
        }


    public void onAddPer(View view) {
        TextView cView = findViewById(R.id.etNewItem);
        TextView tView = findViewById(R.id.textView);
        if(mark && mark1 && !ans) {
            cView.setText(cView.getText() + "%");
            mark = false;
            mark1 = false;
            dot=false;
        }else if (mark && !mark1){
            String t = cView.getText().toString();
            tView.setText(t + '=');
            cView.setText(calculation(t) + '%');
            mark = false;
            mark1 =false;
            ans=true;
            dot=false;
        }else if(!mark && !mark1 && !dot && !min){
            String t = cView.getText().toString();
            cView.setText(t.substring(0, t.length() - 1) + '%');
            mark = false;
            mark1 = false;

        }else if(ans && !dot){
            cView.setText(cView.getText().toString() + '%');
            mark = false;
            mark1 = false;
            dot=false;
            ans=false;
        }
    }

    public void onAddDel(View view) {
        TextView cView = findViewById(R.id.etNewItem);
        String t = cView.getText().toString();
        if(ans){

            cView.setText("");
            mark = false;
            mark1=true;
            ans=false;
            dot=false;
            min=false;
        }else if(dot && t.charAt(t.length() - 1) == '.' ){
            cView.setText(t.substring(0, t.length() - 1));
            dot=false;
            mark=true;

        }else if(min && t.charAt(t.length() - 1) == '-' ){
            cView.setText(t.substring(0, t.length() - 1));
            min=false;
            mark=false;

        }else if(mark && mark1){
            if(cView.getText().toString().length()-1 != 0){
                cView.setText(t.substring(0, t.length() - 1));
            }else{
                cView.setText(t.substring(0, t.length() - 1));
                mark =false;
                dot=false;
                min=false;
            }
        }else if(mark || !mark1){
            if(t.indexOf('/')+2 == t.length() || t.indexOf('x')+2 == t.length() || t.indexOf('+')+2 == t.length() || t.indexOf('-')+2 == t.length()){
                cView.setText(t.substring(0, t.length() - 1));
                mark=false;
                dot=false;
            }else if(t.indexOf('/')+1 == t.length() || t.indexOf('x')+1 == t.length() || t.indexOf('+')+1 == t.length() || t.indexOf('-')+1 == t.length()){
                cView.setText(t.substring(0, t.length() - 1));
                mark =true;
                mark1=true;
                int a;float b;
                b=Float.parseFloat(cView.getText().toString());
                a=(int) b;
                if(a==b)dot=false;
                else dot=true;


            }else if(t.indexOf('/') < t.length() || t.indexOf('x') < t.length() || t.indexOf('+') < t.length() || t.indexOf('-') < t.length()){
                cView.setText(t.substring(0, t.length() - 1));

            }
        }
    }

    public void onAddSeven(View view) {
        TextView cView = findViewById(R.id.etNewItem);
        TextView tView = findViewById(R.id.textView);
        if(!ans) {
            cView.setText(cView.getText() + "7");
            mark = true;
        }else if(ans && !mark1){
            cView.setText(cView.getText() + "7");
            mark = true;
            ans = false;
        }else {
            cView.setText("7");
            mark = true;
            ans = false;
            dot=false;
            mark1 = true;
            min= false;
        }
    }


    public void onAddEight(View view) {
        TextView cView = findViewById(R.id.etNewItem);
        if(!ans) {
            cView.setText(cView.getText() + "8");
            mark = true;
        }else if(ans && !mark1){
            cView.setText(cView.getText() + "8");
            mark = true;
            ans = false;
        }else {
            cView.setText("8");
            mark = true;
            ans = false;
            dot=false;
            mark1 = true;
            min= false;
        }
    }

    public void onAddNine(View view) {
        TextView cView = findViewById(R.id.etNewItem);
        if(!ans) {
            cView.setText(cView.getText() + "9");
            mark = true;
        }else if(ans && !mark1){
            cView.setText(cView.getText() + "9");
            mark = true;
            ans = false;
        }else {
            cView.setText("9");
            mark = true;
            ans = false;
            dot=false;
            mark1 = true;
            min= false;
        }
    }


    public void onAddFour(View view) {
        TextView cView = findViewById(R.id.etNewItem);
        if(!ans) {
            cView.setText(cView.getText() + "4");
            mark = true;
        }else if(ans && !mark1){
            cView.setText(cView.getText() + "4");
            mark = true;
            ans = false;
        }else {
            cView.setText("4");
            mark = true;
            ans = false;
            dot=false;
            mark1 = true;
            min= false;
        }
    }

    public void onAddFive(View view) {
        TextView cView = findViewById(R.id.etNewItem);
        if(!ans) {
            cView.setText(cView.getText() + "5");
            mark = true;
        }else if(ans && !mark1){
            cView.setText(cView.getText() + "5");
            mark = true;
            ans = false;
        }else {
            cView.setText("5");
            mark = true;
            ans = false;
            dot=false;
            mark1 = true;
            min= false;
        }
    }

    public void onAddSix(View view) {
        TextView cView = findViewById(R.id.etNewItem);
        if(!ans) {
            cView.setText(cView.getText() + "6");
            mark = true;
        }else if(ans && !mark1){
            cView.setText(cView.getText() + "6");
            mark = true;
            ans = false;
        }else {
            cView.setText("6");
            mark = true;
            ans = false;
            dot=false;
            mark1 = true;
            min= false;
        }
    }

    public void onAddOne(View view) {
            TextView cView = findViewById(R.id.etNewItem);
            if(!ans) {
                cView.setText(cView.getText() + "1");
                mark = true;
            }else if(ans && !mark1){
                cView.setText(cView.getText() + "1");
                mark = true;
                ans = false;
            }else {
                cView.setText("1");
                mark = true;
                ans = false;
                dot=false;
                mark1 = true;
                min= false;
            }
    }

    public void onAddTwo(View view) {
        TextView cView = findViewById(R.id.etNewItem);
        if(!ans) {
            cView.setText(cView.getText() + "2");
            mark = true;
        }else if(ans && !mark1){
            cView.setText(cView.getText() + "2");
            mark = true;
            ans = false;
        }else {
            cView.setText("2");
            mark = true;
            ans = false;
            dot=false;
            mark1 = true;
            min= false;
        }
    }

    public void onAddThree(View view) {
        TextView cView = findViewById(R.id.etNewItem);
        if(!ans) {
            cView.setText(cView.getText() + "3");
            mark = true;
        }else if(ans && !mark1){
            cView.setText(cView.getText() + "3");
            mark = true;
            ans = false;
        }else {
            cView.setText("3");
            mark = true;
            ans = false;
            dot=false;
            mark1 = true;
            min= false;
        }
    }

    public void onAddDot(View view) {
        TextView cView = findViewById(R.id.etNewItem);
        if(!dot && mark1 && !ans )
        {
            cView.setText(cView.getText()+".");
            dot = true;
            mark = false;
        }else if(!mark1 && !ans && !dot){
            cView.setText(cView.getText()+".");
            dot = true;
            mark = false;
        }else if(!mark1 && ans && !dot){
            cView.setText(cView.getText()+".");
            dot = true;
            mark = false;
            mark1 = false;
        }else if(ans ){
            cView.setText(".");
            dot = true;
            ans = false;
            mark = false;
            mark1 = true;
            min= false;
        }
    }

    public void onAddZero(View view) {
        TextView cView = findViewById(R.id.etNewItem);
        if(!ans) {
            cView.setText(cView.getText() + "0");
            mark = true;
        }else if(ans && !mark1){
            cView.setText(cView.getText() + "0");
            mark = true;
            ans = false;
        }else {
            cView.setText("0");
            mark = true;
            ans = false;
            dot=false;
            mark1 = true;
            min= false;
        }
    }

    public String calculation(String s){
        int x=0;
        float y = 0;
        if(s.indexOf('/') != -1) {
            y= (Float.parseFloat(s.substring(0,s.indexOf('/'))) / Float.parseFloat(s.substring(s.indexOf('/')+1))) ;

        }
        else if(s.indexOf('x') != -1) {
            y= (Float.parseFloat(s.substring(0,s.indexOf('x'))) * Float.parseFloat(s.substring(s.indexOf('x')+1))) ;

        }
        else if(s.indexOf('+') != -1) {
            y= (Float.parseFloat(s.substring(0,s.indexOf('+'))) + Float.parseFloat(s.substring(s.indexOf('+')+1))) ;

        }
        else if(s.indexOf('%') != -1) {
            y= ((Float.parseFloat(s.substring(0,s.indexOf('%')))/100) * Float.parseFloat(s.substring(s.indexOf('%')+1))) ;

        }
        else if(s.indexOf('-') != -1) {
            if(s.indexOf('-')==0){
                s=s.substring(1,s.length());
                y=(Float.parseFloat(s.substring(0,s.indexOf('-')))*-1) - Float.parseFloat(s.substring(s.indexOf('-')+1)) ;
            }else
            y= (Float.parseFloat(s.substring(0,s.indexOf('-'))) - Float.parseFloat(s.substring(s.indexOf('-')+1)))  ;

        }
        if(y<0)min=true;
        else min = false;
        dot = true;
        x= (int)y;
        if(x == y){
            dot = false;
            return Integer.toString(x);

        }

        return Float.toString(y);
    }
    String calculationPM(String s){
        int x=0;
        float y = 0;
        y= Float.parseFloat(s) * -1;
        x = (int) y;
        dot = true;
        if(x == y){
            dot = false;
            return Integer.toString(x);

        }

        return Float.toString(y);
    }
}