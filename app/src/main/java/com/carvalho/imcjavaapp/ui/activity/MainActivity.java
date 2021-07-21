package com.carvalho.imcjavaapp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.carvalho.imcjavaapp.R;
import com.carvalho.imcjavaapp.model.imcRecord;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText inputHeight, inputWeight;
    private Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initInput();
        configureCalculateButton();
        validadeForm();
    }

    private void validadeForm() {
        inputHeight.addTextChangedListener (new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2){
                checkRequiredFields();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        inputWeight.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkRequiredFields();
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void checkRequiredFields() {
        if (!inputHeight.getText().toString().isEmpty() && !inputWeight.getText().toString().isEmpty()) {
            btnCalculate.setEnabled(true);
        } else {
            btnCalculate.setEnabled(false);
        }
    }

    private void configureCalculateButton() {
        Button buttonCalculate = findViewById(R.id.btnCalculate);
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inputHeight.getText().toString() != null && inputWeight.getText().toString() != null) {
                    calculateImc();
                }
            }
        });
    }

    private void calculateImc() {
        double height = Double.parseDouble(inputHeight.getText().toString()) / 100;
        double weight = Integer.parseInt(inputWeight.getText().toString());
        double imc = weight / (height * height);
        String infoImc = "";
        if (imc < 18.6) {
            infoImc = "Abaixo do Peso";
        } else if (imc >= 18.6 && imc < 24.9) {
            infoImc = "Peso Ideal";
        } else if (imc >= 24.9 && imc < 29.9) {
            infoImc = "Levemente Acima do Peso";
        } else if (imc >= 29.9 && imc < 34.9) {
            infoImc = "Obesidade Grau I";
        } else if (imc >= 34.9 && imc < 39.9) {
            infoImc = "Obesidade Grau II";
        } else if (imc >= 40) {
            infoImc = "Obesidade Grau III";
        }

        DecimalFormat df = new DecimalFormat("#.00");
        String imcFormated = df.format(imc);

        imcRecord imcRecord = new imcRecord(imcFormated, infoImc);
        Intent navigateForm = new Intent(MainActivity.this, ImcDetailActivity.class);
        navigateForm.putExtra("imc", imcRecord);
        startActivity(navigateForm);
    }

    private void initInput() {
        inputHeight = findViewById(R.id.inputHeight);
        inputWeight = findViewById(R.id.inputWeight);
        btnCalculate = findViewById(R.id.btnCalculate);
        btnCalculate.setEnabled(false);
    }
}