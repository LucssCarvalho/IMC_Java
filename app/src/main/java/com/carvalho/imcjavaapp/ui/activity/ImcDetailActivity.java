package com.carvalho.imcjavaapp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.carvalho.imcjavaapp.R;
import com.carvalho.imcjavaapp.model.imcRecord;

public class ImcDetailActivity extends AppCompatActivity {

    private TextView viewResult;
    private TextView viewInfoResult;
    private com.carvalho.imcjavaapp.model.imcRecord imcRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc_detail);
        viewResult = findViewById(R.id.textView_imcResult);
        viewInfoResult = findViewById(R.id.textView_imcInfoResult);
        final Intent data = getIntent();
        if (data.hasExtra("imc")) {
            imcRecord = (imcRecord) data.getSerializableExtra("imc");
            viewResult.setText(imcRecord.imc);
            viewInfoResult.setText(imcRecord.infoImc);
        }
    }
}