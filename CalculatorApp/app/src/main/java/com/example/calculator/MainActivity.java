package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextA;
    private TextView textViewB, textViewC, textViewD, textViewE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        editTextA = findViewById(R.id.editTextA);
        textViewB = findViewById(R.id.textViewB);
        textViewC = findViewById(R.id.textViewC);
        textViewD = findViewById(R.id.textViewD);
        textViewE = findViewById(R.id.textViewE);
    }

    public void calculate(View view) {
        try {
            // Get input value
            String inputA = editTextA.getText().toString();
            if (inputA.isEmpty()) {
                Toast.makeText(this, "Masukkan nilai di kolom A", Toast.LENGTH_SHORT).show();
                return;
            }

            double a = Double.parseDouble(inputA);
            
            // Calculate values according to Excel formulas
            double b = a * 2.5;
            double c = Math.ceil(b * 2.5 / 1000) * 1000;
            double d = Math.ceil(c * 2.5 / 1000) * 1000;
            double e = a + b + c + d;

            // Update TextViews
            textViewB.setText(String.format("B: %.2f", b));
            textViewC.setText(String.format("C: %.0f", c));
            textViewD.setText(String.format("D: %.0f", d));
            textViewE.setText(String.format("E: %.2f", e));

        } catch (NumberFormatException ex) {
            Toast.makeText(this, "Input tidak valid", Toast.LENGTH_SHORT).show();
        }
    }

    public void reset(View view) {
        editTextA.setText("");
        textViewB.setText("B: ");
        textViewC.setText("C: ");
        textViewD.setText("D: ");
        textViewE.setText("E: ");
    }
}