package com.example.mynicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Creamos una pantalla para registrarse y que puedes volver al logIn
 * O pulsar el boton de registro e ir al main.
 * @author Pablo Benito
 * @see Log_In
 * @see MainActivity
 */
public class Sign_up extends AppCompatActivity {
Button btn_cancel;
Button btn_register;
ImageView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        btn_cancel = findViewById(R.id.btn_cancel);
        logo = findViewById(R.id.img_inicio);
        Animation miAnimacion = AnimationUtils.loadAnimation(this,R.anim.alpha);
        logo.startAnimation(miAnimacion);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openApp(true);
            }
        });
        btn_register = findViewById(R.id.btn_sign_up);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openApp2(true);
            }
        });
    }

    private void openApp(boolean locationPermission) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Sign_up
                        .this, Log_In.class);
                startActivity(intent);
                finish();
            }
        }, 0);
    }

    private void openApp2(boolean locationPermission) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Sign_up
                        .this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 0);
    }
}