package dev.daniel.medsystem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//teste git
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Pacientes(View view) {
        Toast.makeText(this,"pacientes",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(MainActivity.this,ActivityPacientes.class);
        startActivity(intent);
    }
}