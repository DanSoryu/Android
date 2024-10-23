package com.dansoryucompany.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView txtDisplay;
    private CALCULADORA calculadora;
    private StringBuilder currentInput;
    private String lastOperator;
    private boolean operatorPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtDisplay = findViewById(R.id.txtDisplay);
        calculadora = new CALCULADORA();
        currentInput = new StringBuilder();
        lastOperator = "";
        operatorPressed = false;

        setNumberButtonListeners();
        setOperatorButtonListeners();
        setClearButtonListener();
        setBackspaceButtonListener();
    }

    // Método para los botones de números
    private void setNumberButtonListeners() {
        int[] numberButtonIds = {
                R.id.button0, R.id.button1, R.id.button2, R.id.button3,
                R.id.button4, R.id.button5, R.id.button6,
                R.id.button7, R.id.button8, R.id.button9, R.id.buttonDot
        };

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button button = (Button) view;
                if (operatorPressed) {
                    currentInput.setLength(0);
                    operatorPressed = false;
                }
                currentInput.append(button.getText());
                txtDisplay.setText(currentInput.toString());
            }
        };

        for (int id : numberButtonIds) {
            findViewById(id).setOnClickListener(listener);
        }
    }

    // Método para los botones de operadores (+, -, *, /)
    private void setOperatorButtonListeners() {
        findViewById(R.id.buttonAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleOperator("+");
            }
        });

        findViewById(R.id.buttonSubtract).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleOperator("-");
            }
        });

        findViewById(R.id.buttonMultiply).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleOperator("*");
            }
        });

        findViewById(R.id.buttonDivide).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleOperator("/");
            }
        });

        findViewById(R.id.buttonEquals).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleEquals();
            }
        });
    }

    // Método para manejar operadores
    private void handleOperator(String operator) {
        if (!currentInput.toString().isEmpty()) {
            calculadora.setOperando1(Double.parseDouble(currentInput.toString()));
            lastOperator = operator;
            operatorPressed = true;
            txtDisplay.setText(currentInput.toString() + " " + operator);  // Mostrar el operador
        }
    }

    // Método para el botón igual (=)
    private void handleEquals() {
        if (!currentInput.toString().isEmpty() && !lastOperator.isEmpty()) {
            calculadora.setOperando2(Double.parseDouble(currentInput.toString()));
            double result = 0.0;

            switch (lastOperator) {
                case "+":
                    result = calculadora.sumar();
                    break;
                case "-":
                    result = calculadora.restar();
                    break;
                case "*":
                    result = calculadora.multiplicar();
                    break;
                case "/":
                    result = calculadora.dividir();
                    break;
            }

            txtDisplay.setText(String.valueOf(result));
            currentInput.setLength(0); // Limpiar la entrada actual
            currentInput.append(result);
            lastOperator = "";
        }
    }

    // Método para borrar toda la operación
    private void setClearButtonListener() {
        findViewById(R.id.buttonClear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentInput.setLength(0);
                txtDisplay.setText("0");
                lastOperator = "";
                operatorPressed = false;
            }
        });
    }

    // Método para borrar un dígito
    private void setBackspaceButtonListener() {
        findViewById(R.id.buttonBackspace).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentInput.length() > 0) {
                    currentInput.deleteCharAt(currentInput.length() - 1);
                    txtDisplay.setText(currentInput.length() > 0 ? currentInput.toString() : "0");
                }
            }
        });
    }
}