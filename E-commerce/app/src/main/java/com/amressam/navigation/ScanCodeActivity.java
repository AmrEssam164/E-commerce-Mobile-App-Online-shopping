package com.amressam.navigation;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScanCodeActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    ZXingScannerView scannerView;
    public static final int REQUEST_CODE=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scannerView = new ZXingScannerView(this);
        setContentView(scannerView);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.mygradient));
        verifyPermissions();
    }

    @Override
    public void handleResult(Result result) {
//        Products.editText.setText(result.getText());
        MainActivity.cam_result = result.getText();
        onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        scannerView.stopCamera();
    }

    @Override
    protected void onResume() {
        super.onResume();
        scannerView.setResultHandler(this);
        scannerView.startCamera();

    }

    private void verifyPermissions(){
        String[] permissions = {Manifest.permission.CAMERA};
        if(ContextCompat.checkSelfPermission(this.getApplicationContext(), permissions[0]) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(ScanCodeActivity.this,permissions,REQUEST_CODE);
        }
    }

}
