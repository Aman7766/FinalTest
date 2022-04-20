package com.example.finaltest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText Question_num,Question_details,Question_Ans;
    Button Add,Update,Delete,Submit,Preview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Question_num=(EditText) findViewById(R.id.questionnumber);
        Question_details=(EditText)findViewById(R.id.quetion);
        Question_Ans=(EditText)findViewById(R.id.answer);
        Add=(Button) findViewById(R.id.addbutton);
        Update=(Button)findViewById(R.id.updatebuttton);
        Delete=(Button)findViewById(R.id.deletebutton);
        Submit=(Button)findViewById(R.id.submitbutton);
        Preview=(Button)findViewById(R.id.previewbutton);

        // Add Button
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Question_num.getText().toString().equals("")) {
                    Question_num.setError("Add Question Number");
                } else if (Question_details.getText().toString().equals("")) {
                    Question_details.setError("Add Question Details");
                } else if (Question_Ans.getText().toString().equals("")) {
                    Question_Ans.setError("Add Answer");
                }
                else
                {
                    String Qs_details=Question_details.getText().toString();
                    String Qs_num=Question_num.getText().toString();
                    String Qs_ans=Question_Ans.getText().toString();

                    QuizDetails quizDetails=new QuizDetails(Qs_details,Qs_num,Qs_ans);
                    MyDbHandler myDbHandler=new MyDbHandler(getApplicationContext());
                    int i=myDbHandler.insertData(quizDetails);
                    if(i==1)
                    {
                        Toast.makeText(getApplicationContext(),"Data Added Successfully",Toast.LENGTH_LONG).show();

                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Error Occurred",Toast.LENGTH_LONG).show();

                    }
                }

            }
        });

        // Update Button
        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Question_id=Question_num.getText().toString();
                if (Question_id.equals(""))
                {
                    Question_num.setError("Add Question Number");
                }
                else {
                    MyDbHandler myDbHandler = new MyDbHandler(getApplicationContext());
                    ArrayList<QuizDetails> arrayList=myDbHandler.ViewData(Question_id);
                    for (QuizDetails q:arrayList)
                    {
                        Question_details.setText(q.getQuestion_detail());
                        Question_Ans.setText(q.getAnswer());
                    }
                }
                }
        });

        // Delete Button
        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Question_id=Question_num.getText().toString();
                if (Question_id.equals(""))
                {
                    Question_num.setError("Add Question Number");
                }
                    else
                    {
                    MyDbHandler myDbHandler=new MyDbHandler(getApplicationContext());
                        ArrayList<QuizDetails> arrayList=myDbHandler.ViewData(Question_id);
                        for (QuizDetails q:arrayList)
                        {
                            Question_details.setText(q.getQuestion_detail());
                            Question_Ans.setText(q.getAnswer());
                        }
                   int i= myDbHandler.DeleteData(Question_id);
                   if(i==1)
                   {
                       Toast.makeText(getApplicationContext(),"Data Deleted Successfully",Toast.LENGTH_LONG).show();
                   }
                   else
                   {
                       Toast.makeText(getApplicationContext(),"Error Occurred",Toast.LENGTH_LONG).show();
                   }
                    }
                }

        });

       // Submit Button
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Question_num.getText().toString().equals("")) {
                    Question_num.setError("Add Question Number");
                } else if (Question_details.getText().toString().equals("")) {
                    Question_details.setError("Add Question Details");
                } else if (Question_Ans.getText().toString().equals("")) {
                    Question_Ans.setError("Add Answer");
                }
                else
                {
                    String Qs_details=Question_details.getText().toString();
                    String Qs_num=Question_num.getText().toString();
                    String Qs_ans=Question_Ans.getText().toString();

                    QuizDetails quizDetails=new QuizDetails(Qs_details,Qs_num,Qs_ans);
                    MyDbHandler myDbHandler=new MyDbHandler(getApplicationContext());
                    int i=myDbHandler.UpdateData(quizDetails);
                    if(i==1)
                    {
                        Toast.makeText(getApplicationContext(),"Data Updated Successfully",Toast.LENGTH_LONG).show();

                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Error Occurred",Toast.LENGTH_LONG).show();

                    }

            }}
        });

        // Preview Button
        Preview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), Preview.class);
                startActivity(intent);
            }
        });

    }


}