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
    private Button btn;
    private EditText ev;
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn_saveViewModel);
        ev = findViewById(R.id.ev_text);
        text = findViewById(R.id.tv_text);
        viewModel = new ViewModelProvider(this).get(ViewModel.class);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String t = String.valueOf(ev.getText());
                //viewModel에 데이터 저장, 일단 저장하는 것 까지
                viewModel.setUserInfo(t);
                viewModel.getUserId().observe(MainActivity.this, new Observer<String>() {

                            @Override
                            public void onChanged(String s) {
                                Log.d("sucess", s);
                            }
                        });


//                text.setText(viewModel.getUserId());
            }
        });
    }
}