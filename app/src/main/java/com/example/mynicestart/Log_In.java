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
import android.widget.TextView;

/**
 * Aqui creamos la pantalla de 'LOG IN' donde el usuario puede entrar a la aplicacion con su cuenta de usuario y contrasena,
 * Tmabien puede hacer click en el texto debajo del boton para crear una cuanta si no tienen.
 * @author Pablo Benito
 * @see Sign_up
 * @see MainActivity
 */
public class Log_In extends AppCompatActivity {
TextView btn_sign_up;
Button btn_log_in;
ImageView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log__in);
        btn_sign_up = findViewById(R.id.txt_register);
        btn_log_in = findViewById(R.id.btn_log_in);
        logo = findViewById(R.id.img_inicio);
        Animation miAnimacion = AnimationUtils.loadAnimation(this,R.anim.alpha);
        logo.startAnimation(miAnimacion);
        btn_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openApp(true);
            }
        });
        btn_log_in.setOnClickListener(new View.OnClickListener() {
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
                Intent intent = new Intent(Log_In
                        .this, Sign_up.class);
                startActivity(intent);
                finish();
            }
        },0);
    }

    private void openApp2(boolean locationPermission) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Log_In
                        .this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        },0);
    }
}