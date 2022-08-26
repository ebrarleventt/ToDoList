package com.example.todolistappmvvm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.todolistappmvvm.databinding.ActivityDataInsertBinding;

public class DataInsertActivity extends AppCompatActivity {

    private ActivityDataInsertBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDataInsertBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        String type = getIntent().getStringExtra("type");
        if (type.equals("update")) {
            setTitle("update");
            binding.titleET.setText(getIntent().getStringExtra("title"));
            binding.contentET.setText(getIntent().getStringExtra("content"));
            int id = getIntent().getIntExtra("id", 0);
            binding.addButton.setText("update note");

            binding.addButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.putExtra("title", binding.titleET.getText().toString());
                    intent.putExtra("content", binding.contentET.getText().toString());
                    intent.putExtra("id", id);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            });

        } else {
            setTitle("Add Mode");
            binding.addButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.putExtra("title", binding.titleET.getText().toString());
                    intent.putExtra("content", binding.contentET.getText().toString());
                    setResult(RESULT_OK, intent);
                    finish();
                }
            });

        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(DataInsertActivity.this, MainActivity.class));
    }


}