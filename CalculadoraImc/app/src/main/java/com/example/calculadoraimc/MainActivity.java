package com.example.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText numberWeight = findViewById(R.id.inputWeight);
    EditText numberHeight = findViewById(R.id.inputHeight);
    Button buttonSubmit = findViewById(R.id.buttonSubmit);

    TextView textResult = findViewById(R.id.textResult);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculateImc(View v) {
        double weight = Double.parseDouble(numberWeight.getText().toString());
        double height = Double.parseDouble(numberHeight.getText().toString());

        double result = weight / (height * height);

        textResult.setText((int) result);
    }

}