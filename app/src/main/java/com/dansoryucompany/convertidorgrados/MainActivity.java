package com.dansoryucompany.convertidorgrados;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerUnidadOrigen;
    private EditText editTextNumber;
    private TextView resultadosTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerUnidadOrigen = findViewById(R.id.spinnerUnidadOrigen);
        editTextNumber = findViewById(R.id.editTextNumber);
        resultadosTextView = findViewById(R.id.resultadosTextView);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.unidades_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerUnidadOrigen.setAdapter(adapter);

        Button buttonConvertir = findViewById(R.id.buttonConvertir);
        buttonConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarConversion();
            }
        });
    }

    private void realizarConversion() {
        String valorTexto = editTextNumber.getText().toString();

        if (valorTexto.isEmpty()) {
            Toast.makeText(this, "Ingresa una cantidad, por favor.", Toast.LENGTH_SHORT).show();
            return;
        }

        double valor = Double.parseDouble(valorTexto);
        String unidadOrigen = spinnerUnidadOrigen.getSelectedItem().toString();
        String resultado = "";

        switch (unidadOrigen) {
            case "Celsius":
                CELCIUS celsius = new CELCIUS(valor);
                resultado = convertirDesdeCelsius(celsius);
                break;
            case "Fahrenheit":
                FAHRENHEIT fahrenheit = new FAHRENHEIT(valor);
                resultado = convertirDesdeFahrenheit(fahrenheit);
                break;
            case "Kelvin":
                KELVIN kelvin = new KELVIN(valor);
                resultado = convertirDesdeKelvin(kelvin);
                break;
        }

        resultadosTextView.setText(resultado);
    }

    private String convertirDesdeCelsius(CELCIUS celsius) {
        FAHRENHEIT fahrenheit = new FAHRENHEIT(0);
        fahrenheit.parse(celsius);
        KELVIN kelvin = new KELVIN(0);
        kelvin.parse(celsius);

        return String.format("Fahrenheit: %.2f °F\nKelvin: %.2f K", fahrenheit.getValor(), kelvin.getValor());
    }

    private String convertirDesdeFahrenheit(FAHRENHEIT fahrenheit) {
        CELCIUS celsius = new CELCIUS(0);
        celsius.parse(fahrenheit);
        KELVIN kelvin = new KELVIN(0);
        kelvin.parse(fahrenheit);

        return String.format("Celsius: %.2f °C\nKelvin: %.2f K", celsius.getValor(), kelvin.getValor());
    }

    private String convertirDesdeKelvin(KELVIN kelvin) {
        CELCIUS celsius = new CELCIUS(0);
        celsius.parse(kelvin);
        FAHRENHEIT fahrenheit = new FAHRENHEIT(0);
        fahrenheit.parse(kelvin);

        return String.format("Celsius: %.2f °C\nFahrenheit: %.2f °F", celsius.getValor(), fahrenheit.getValor());
    }
}