package com.example.flextutor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_content);
        Intent intent = getIntent();
        String content_id = intent.getStringExtra("content_id");
        String cont_type = intent.getStringExtra("cont_type");
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        final TextView textView = findViewById(R.id.title);
        final Button read_out = findViewById(R.id.read_out);
        final TextView transcript = findViewById(R.id.textfill);
        final Button tutor = findViewById(R.id.tutor);
        String cont_text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
        textView.setText(content_id);
//        Toast.makeText(this.getApplicationContext(), "cont_type "+cont_type, Toast.LENGTH_SHORT).show();
        if(cont_type.equals("audio") || cont_type.equals("video")){
            read_out.setText("View Transcript");
        }
        else{
            transcript.setText(cont_text);
        }
        read_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cont_type.equals("audio") || cont_type.equals("video")){
                    transcript.setText(cont_text);
                }
                else{
                    // add logic for read out text
                }
            }
        });
        tutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getApplicationContext(), TutorActivity.class);
                myIntent.putExtra("content_id", content_id);
                myIntent.putExtra("cont_text", cont_text);
                startActivity(myIntent);
            }
        });
    }
}