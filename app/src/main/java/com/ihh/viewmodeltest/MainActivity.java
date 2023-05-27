package com.ihh.viewmodeltest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ViewModel viewModel;
    private Button btn, btn2;
    private EditText ev;
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn_saveViewModel);
        ev = findViewById(R.id.ev_text);
        text = findViewById(R.id.tv_text);
        btn2 = findViewById(R.id.btn_initViewModel);
        viewModel = new ViewModelProvider(this).get(ViewModel.class);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String t = String.valueOf(ev.getText());
                viewModel.setUserInfo(t);
                viewModel.getUserId().observe(MainActivity.this, s -> {
                    Log.d("sucess", s);
                    text.setText(s);
                });



            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.initData();
                viewModel.getUserId().observe(MainActivity.this, new Observer<String>() {

                    @Override
                    public void onChanged(String s) {
                        Log.d("sucess2", s);
                        text.setText(s);
                    }
                });

            }
        });
    }
}