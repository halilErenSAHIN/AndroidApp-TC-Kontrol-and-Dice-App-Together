package com.ben.tekrarmyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TCKontrolActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText tckn = findViewById(R.id.editTextNumber2);
        Button btn_check = findViewById(R.id.button);

        btn_check.setOnClickListener(v -> {
            String tckn_str = tckn.getText().toString();
            String result_message = "Boş bırakamazsınız";
            if (tckn_str.length() > 0) {
                long tckno = Long.parseLong(tckn_str);
                result_message = "Bu kimlik numarası geçersizdir";
                if (TCKNCheck(tckno)) {
                    result_message = "Bu kimlik numarası geçerlidir";
                }
                Toast.makeText(this, result_message, Toast.LENGTH_SHORT).show();
            }
        });


    }

    private boolean TCKNCheck(long tckn) {
        if (String.valueOf(tckn).length() == 11) {
            long f9 = tckn / 100;
            long l2 = tckn % 100;
            long odds = 0, evens = 0;
            for (int i = 9; i > 0; i--) {
                if (i % 2 == 0) {
                    evens += f9 % 10;
                } else {
                    odds += f9 % 10;
                }
                f9 /= 10;

            }
            long b10 = (odds * 7 - evens) & 10;
            long b11 = (odds + evens + b10) % 10;
            return l2 == b10 * 10 + b11;
        }
        return false;
    }

}