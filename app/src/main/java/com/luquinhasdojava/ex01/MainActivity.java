package com.luquinhasdojava.ex01;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText valorA;
    private EditText valorB;
    private EditText valorC;
    private Button calcular;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        valorA = findViewById(R.id.editTextValorA);
        valorB = findViewById(R.id.editTextValorB);
        valorC = findViewById(R.id.editTextValorC);
        resultado = findViewById(R.id.textViewResultado);
        calcular = findViewById(R.id.buttomCalcular);

        calcular.setOnClickListener(op -> Baskara());
    }
    private void Baskara(){
        double a = Double.parseDouble(valorA.getText().toString());
        double b = Double.parseDouble(valorB.getText().toString());
        double c = Double.parseDouble(valorC.getText().toString());
        double delta = b * b - 4 * a * c;
        String res;

        if(delta < 0 ){
            res = "A equação não possui raízes reais.";
            resultado.setText(res);
        } else if (delta == 0) {
            double x = -b / (2 * a);
            res = "A equação possui uma raiz real:" + x;
            resultado.setText(res);
        }else {
            double sqrtDelta = Math.sqrt(delta);
            double x1 = (-b + sqrtDelta) / (2 * a);
            double x2 = (-b - sqrtDelta) / (2 * a);
            res = "A equação possui duas raízes reais: " + x1 + " e " + x2;
            resultado.setText(res);
        }


    }
}