package com.dicoding.picodiploma.nilaimahasiswa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class InputActivity extends AppCompatActivity {

    EditText edt1,edt2,edt3,edt4,edt5,edt6;
    RadioGroup rgKel;
    RadioButton rbKel;
    Button bSimpan;

    // Firebase
    FirebaseDatabase db;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        Intent receivedIntent = getIntent();

        edt1=(EditText) findViewById(R.id.edt1);
        edt2=(EditText) findViewById(R.id.edt2);
        edt3=(EditText) findViewById(R.id.edt3);
        edt4=(EditText) findViewById(R.id.edt4);
        edt5=(EditText) findViewById(R.id.edt5);
        edt6=(EditText) findViewById(R.id.edt6);
        rgKel = (RadioGroup) findViewById(R.id.rgKel);
        bSimpan=(Button) findViewById(R.id.btnSimpan);

        db = FirebaseDatabase.getInstance();
        ref = db.getReference().child("mahasiswa");

        if(receivedIntent.hasExtra("key")&&receivedIntent.hasExtra("key2")&&
                receivedIntent.hasExtra("key3")&&
                receivedIntent.hasExtra("key4")&&
                receivedIntent.hasExtra("key5")&&
                receivedIntent.hasExtra("key6")&&
                receivedIntent.hasExtra("key7")){
        } else {
            bSimpan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String nim, nama, gol, huruf, jurusan;
                    double total, ntugas, nquis, nmid, nfinal;

                    int selected = rgKel.getCheckedRadioButtonId();
                    rbKel = (RadioButton) findViewById(selected);

                    nim = edt1.getText().toString();
                    gol = rbKel.getText().toString();
                    jurusan=null;
                    if (gol.equals("Kelompok I")) {
                        jurusan = "Teknik Informatika";
                    } else {
                        jurusan = "Sistem Informasi";
                    }
                    nama = edt2.getText().toString();
                    ntugas = Double.parseDouble(edt3.getText().toString());
                    nquis = Double.parseDouble(edt4.getText().toString());
                    nmid = Double.parseDouble(edt5.getText().toString());
                    nfinal = Double.parseDouble(edt6.getText().toString());
                    total = (0.3*ntugas + 0.1*nquis + 0.3*nmid + 0.3*nfinal);

                    huruf=null;
                    if (total >= 80) {
                        huruf=("A");
                    } else if (total >= 60 && total < 80) {
                        huruf=("B");
                    } else if (total >= 50 && total < 60) {
                        huruf=("C");
                    } else if (total >= 40 && total < 50) {
                        huruf=("D");
                    } else {
                        huruf=("E");
                    }

                    Pojo p = new Pojo(nim, jurusan, nama, huruf, total);
                    ref.child(nim).setValue(p);
                    InputActivity.this.finish();
                    Toast.makeText(InputActivity.this, "Sukses menambah data nilai mahasiswa!", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}
