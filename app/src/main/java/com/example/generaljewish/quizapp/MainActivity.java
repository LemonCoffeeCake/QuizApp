package com.example.generaljewish.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Arrays;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculateScore(View view) {
        RadioGroup rg1=findViewById(R.id.Question1RG);
        int answer1=rg1.getCheckedRadioButtonId();
        boolean[] answers2=new boolean[4];
        boolean[] answers2Correct={true, false, false, true};
        answers2[0]=((CheckBox) findViewById(R.id.Q2A1)).isChecked();
        answers2[1]=((CheckBox) findViewById(R.id.Q2A2)).isChecked();
        answers2[2]=((CheckBox) findViewById(R.id.Q2A3)).isChecked();
        answers2[3]=((CheckBox) findViewById(R.id.Q2A4)).isChecked();
        String answer3=((EditText) findViewById(R.id.Q3A)).getText().toString();
        String answer4=((EditText) findViewById(R.id.Q4A)).getText().toString();
        RadioGroup rg2=findViewById(R.id.Q5RG);
        int answer5=rg2.getCheckedRadioButtonId();
        int score=0;
        if (answer1==R.id.Q1A2)
            score++;

        if (Arrays.equals(answers2,answers2Correct))
            score++;

        if (answer3.toLowerCase().equals("mom's spaghetti"))
            score++;

        if (answer4.toLowerCase().equals("omae wa mou shindeiru")||answer4.toLowerCase().equals("omae wa mo shindeiru"))
            score++;

        if (answer5!=R.id.Q5A4)
            score++;
        else
            score=Integer.MIN_VALUE;

        if(score!=Integer.MIN_VALUE){
            Toast.makeText(getApplicationContext(),"Your score is "+score,Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getApplicationContext(),"Your score is "+score+"\nYou dare to imply that Pepe, who died for our sins, sinned himself?",Toast.LENGTH_LONG).show();
        }
    }
}
