package com.example.cobak;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi EditText untuk menginput nilai
        editTextNumber = findViewById(R.id.editTextNumber);

        // Mengatur OnClickListener untuk Button
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mengambil nilai integer dari EditText
                int nilai = Integer.parseInt(editTextNumber.getText().toString());

                // Membuat Intent untuk beralih ke MainActivity2 dan mengirim nilai
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("nilai", nilai);
                startActivity(intent);
            }
        });
    }
}
