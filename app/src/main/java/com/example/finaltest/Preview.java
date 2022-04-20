    package com.example.finaltest;

    import androidx.appcompat.app.AppCompatActivity;

    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.TextView;

    import java.util.ArrayList;

    public class Preview extends AppCompatActivity {
        TextView question_num,question_details;
        EditText answer;
        ArrayList<QuizDetails> arrayList;
        Button Pre,Next;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_preview);
            question_num=findViewById(R.id.previewquestionnum);
            question_details=findViewById(R.id.previewquestion);
            answer=findViewById(R.id.previewanswer);
            Pre=findViewById(R.id.previous);
            Next=findViewById(R.id.next);
            MyDbHandler myDbHandler=new MyDbHandler(getApplicationContext());

            String one="1";
            String two="2";
            String three="3";
            ArrayList<QuizDetails> CurrentQuestion=myDbHandler.ViewData(two);
            for(QuizDetails q:CurrentQuestion)
            {
                question_num.setText(q.getQuestion_num());
                question_details.setText(q.getQuestion_detail());
            }


            Pre.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ArrayList<QuizDetails> CurrentQuestion = myDbHandler.ViewData(one);
                    for (QuizDetails q : CurrentQuestion) {
                        question_num.setText(q.getQuestion_num());
                        question_details.setText(q.getQuestion_detail());
                    }
                }
            });

            Next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ArrayList<QuizDetails> CurrentQuestion = myDbHandler.ViewData(three);
                    for (QuizDetails q : CurrentQuestion) {
                        question_num.setText(q.getQuestion_num());
                        question_details.setText(q.getQuestion_detail());
                    }
                }
            });


        }

        }
