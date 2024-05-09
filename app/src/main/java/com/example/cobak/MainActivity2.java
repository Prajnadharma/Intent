package com.example.cobak;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Inisialisasi TextView untuk menampilkan hasil
        textViewResult = findViewById(R.id.textViewResult);

        // Mengambil nilai yang dikirim dari MainActivity
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("nilai")) {
            int nilai = intent.getIntExtra("nilai", 0);

            // Menentukan hasil berdasarkan kondisi
            String hasil;
            if (nilai < 45) {
                hasil = "Nilai E";
            } else if (nilai < 56) {
                hasil = "Nilai D";
            } else if (nilai < 62) {
                hasil = "Nilai C";
            } else if (nilai < 65) {
                hasil = "Nilai C+";
            } else if (nilai < 68) {
                hasil = "Nilai B-";
            } else if (nilai < 74) {
                hasil = "Nilai B";
            } else if (nilai < 77) {
                hasil = "Nilai B+";
            } else if (nilai < 80) {
                hasil = "Nilai A-";
            } else {
                hasil = "Nilai A";
            }

            // Menampilkan hasil di TextView
            textViewResult.setText(hasil);
        }

        // Mengatur OnClickListener untuk Button "Kembali"
        findViewById(R.id.buttonBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Membuat Intent untuk kembali ke MainActivity
                Intent backIntent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(backIntent);
            }
        });

        // Mengatur OnClickListener untuk Button "Share"
        Button shareButton = findViewById(R.id.shareButton);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Panggil metode untuk berbagi hasil
                shareResult();
            }
        });
    }

    // Metode untuk berbagi hasil
    private void shareResult() {
        // Dapatkan teks dari TextView
        String result = textViewResult.getText().toString();

        // Membuat Intent untuk berbagi
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, result);

        // Mulai Intent untuk berbagi
        startActivity(Intent.createChooser(shareIntent, "Share Result"));
    }
}

