package br.ici.treinamento.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editValor;
    private TextView textPorcentagem;
    private TextView textGorjeta;
    private TextView textTotal;
    private SeekBar seekGorjeta;
    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValor = findViewById(R.id.editTextValor);
        textPorcentagem = findViewById(R.id.textPorcentagem);
        textGorjeta = findViewById(R.id.textGorjeta);
        textTotal = findViewById(R.id.textTotal);
        seekGorjeta = findViewById(R.id.seekBar);




        seekGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            porcentagem = seekBar.getProgress();
            textPorcentagem.setText(Math.round(porcentagem)+"%");
            calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void calcular(){

        Double digitado = Double.parseDouble(editValor.getText().toString());
        Double gorjeta = 0d;
        Double total = 0d;

        if(porcentagem>0) {
             gorjeta = (digitado * (porcentagem / 100));

        }

        total = gorjeta + digitado;

        textGorjeta.setText(String.format("RS %.2f ",gorjeta));
        textTotal.setText(String.format("RS %.2f ",total));

    }


}
