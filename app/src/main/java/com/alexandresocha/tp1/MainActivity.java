package com.alexandresocha.tp1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.CharArrayWriter;

public class MainActivity extends AppCompatActivity {

    private Button buttonStart;
    private Button buttonFinish;
    private EditText editText;

    // solution 1
    int numero;

    // solution 2
    static int num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.main_edittext);
        buttonStart = findViewById(R.id.main_button_start);
        buttonFinish = findViewById(R.id.main_button_finish);

        // solution 1
        numero = getIntent().getIntExtra("data", 0);
        editText.append("\n onCreate " + numero);

        // solution 2
        //editText.append("\n onCreate " + num);
    }

    public void onClickStart(View v){
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("onClickStart");
        alertDialog.setMessage("Démarrage d'une nouvelle activité, même code");
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Intent intent = new Intent(MainActivity.this,MainActivity.class);

                        // solution 1
                        intent.putExtra("data", ++numero);
                        startActivity(intent);

                        // solution 2
                        //num++;
                        //startActivity(intent);
                    }
                });

        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Annuler",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    public void onClickFinish(View v){
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.editText.append("\n onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.editText.append("\n onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        this.editText.append("\n onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        this.editText.append("\n onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.editText.append("\n onStop");
    }


}