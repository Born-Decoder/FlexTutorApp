package com.example.flextutor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TutorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tutor);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent intent = getIntent();
        String content_id = intent.getStringExtra("content_id");
        String cont_text = intent.getStringExtra("cont_text");
        final EditText editQuery = findViewById(R.id.edit_query);
        final Button ask = findViewById(R.id.ask);
        final TextView responseText = findViewById(R.id.query_results);

        ask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query_text = "You asked - " + editQuery.getText().toString();
                String existing_response = responseText.getText().toString();
                String new_response = existing_response + "\n\n" + query_text + "\n\n" + cont_text;
                responseText.setText(new_response);
            }
        });
    }
}