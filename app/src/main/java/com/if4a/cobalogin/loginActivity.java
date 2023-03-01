package com.if4a.cobalogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {
    private EditText etUsername, etPassword;
    private Button btnLogin;
    private String username, password;
    KendaliLogin KL = new KendaliLogin();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = etUsername.getText().toString();
                password = etPassword.getText().toString();

                if (username.trim().equals(""))
                {
                    etUsername.setError("Username Tidak Boleh Kosong!");
                }
                else if (password.trim().equals(""))
                {
                    etPassword.setError("Password Tidak Boleh Kosong!");

                }
                else
                {
                    if(username.equals("nicow") && password.equals("inipassword"))
                    {
                        KL.setPref(loginActivity.this, MainActivity.keySPusername, username);
                        KL.setPref(loginActivity.this, MainActivity.keySPname, "Nico W :3");
                        startActivity(new Intent(loginActivity.this, MainActivity.class));
                        finish(); // untuk hapus loginactivity
                    }
                    else if(username.equals("alvinw") && password.equals("inipassword"))
                    {
                        KL.setPref(loginActivity.this, MainActivity.keySPusername, username);
                        KL.setPref(loginActivity.this, MainActivity.keySPname, "Alvin W :3");
                        startActivity(new Intent(loginActivity.this, MainActivity.class));
                        finish(); // untuk hapus loginactivity
                    }
                    else {
                        Toast.makeText(loginActivity.this, "Username atau Password belum sesuai! :(", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        // ini versi beda dari view yang bapak buat
//        public void prosesLogin(View view) {
//            username = etUsername.getText().toString();
//            password = etPassword.getText().toString();
//            if(username.equals("admin") && password.equals("admin")){
//                KL.setPref(LoginActivity.this, "spPadang",username);
//                startActivity(new Intent(LoginActivity.this,
//                        MainActivity.class));
//                finish();
//            }
//            else{
//                Toast.makeText(this, "Login Gagal",
//                        Toast.LENGTH_SHORT).show();
//            }
        }
    }
