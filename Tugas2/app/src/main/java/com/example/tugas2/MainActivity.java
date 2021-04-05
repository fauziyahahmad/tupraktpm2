package com.example.tugas2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnSubmit;
    private EditText etNama, etNim, etNilai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSubmit = findViewById(R.id.btn_submit);
        etNama = findViewById(R.id.et_nama);
        etNim = findViewById(R.id.et_nim);
        etNilai = findViewById(R.id.et_nilai);

        btnSubmit.setOnClickListener(v ->  {
            try {

                String sNama = etNama.getText().toString();
                String sNIM = etNim.getText().toString();
                String sNilai = etNilai.getText().toString();
                Intent j = new Intent(MainActivity.this, HasilActivity.class);
                j.putExtra("Nama", sNama);
                j.putExtra("NIM", sNIM);

                double nilai = Double.parseDouble(sNilai);
                if (nilai <= 4) {
                    if(nilai > 3.66 && nilai <= 4.00){
                        j.putExtra("Hasil", "A");
                    }else if(nilai > 3.33 && nilai <= 3.66) {
                        j.putExtra("Hasil", "A-");
                    }else if(nilai > 3.00 && nilai <= 3.33) {
                        j.putExtra("Hasil", "B+");
                    }else if(nilai > 2.66 && nilai <= 3.00) {
                        j.putExtra("Hasil", "B");
                    }else if(nilai > 2.33 && nilai <= 2.66) {
                        j.putExtra("Hasil", "B-");
                    }else if(nilai > 2.00 && nilai <= 2.33) {
                        j.putExtra("Hasil", "C+");
                    }else if(nilai > 1.66 && nilai <= 2.00) {
                        j.putExtra("Hasil", "C");
                    }else if(nilai > 1.33 && nilai <= 1.66) {
                        j.putExtra("Hasil", "C-");
                    }else if(nilai > 1.00 && nilai <= 1.33) {
                        j.putExtra("Hasil", "D+");
                    }else {
                        j.putExtra("Hasil", "D");
                    }
                    startActivity(j);
                } else {
                    Toast.makeText(getApplication(), "Nilai tidak boleh di atas 4.00!", Toast.LENGTH_SHORT).show();
                }
            }catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplication(), "Field tidak boleh kosong!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}