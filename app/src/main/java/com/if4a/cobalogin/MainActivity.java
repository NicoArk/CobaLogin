package com.if4a.cobalogin;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.if4a.cobalogin.KendaliLogin;
import com.if4a.cobalogin.R;
import com.if4a.cobalogin.loginActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvSesi, tvName;
    private String ambilSesi;
    private Button btnLogout;

    KendaliLogin KL = new KendaliLogin();
    public static String keySPusername = "z7slVZaJNHoxWYL8wMXBkw==_username";
    public static String keySPname = "z7slVZaJNHoxWYL8wMXBkw==_name";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (KL.isLogin(MainActivity.this,keySPusername)==true){
            setContentView(R.layout.activity_main);

            tvSesi = findViewById(R.id.tv_sesi);
            tvName = findViewById(R.id.tv_name);
           btnLogout = findViewById(R.id.btn_logout);

           tvSesi.setText(KL.getPref(MainActivity.this, keySPusername));
            tvName.setText(KL.getPref(MainActivity.this, keySPname));
            btnLogout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    KL.setPref(MainActivity.this, keySPusername, null);
                    KL.setPref(MainActivity.this, keySPname, null);
                    startActivity(new Intent(MainActivity.this, loginActivity.class));
                    finish();
                }
            });
//            startActivity(new
//                    Intent(MainActivity.this,loginActivity.class));
//            finish();
        }
        else{
            startActivity(new Intent(MainActivity.this,
                    loginActivity.class));
            finish();
        }
    }
//    public void prosesLogout(View view) {
//        KL.setPref(MainActivity.this,"spPadang",null);
//        startActivity(new Intent(MainActivity.this,
//                loginActivity.class));
//        finish();
//    }
}