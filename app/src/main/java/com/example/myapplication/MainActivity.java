        package com.example.myapplication;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.icu.text.SimpleDateFormat;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;

        import java.text.ParseException;
        import java.util.Calendar;
        import java.util.Date;
        import java.util.Locale;

        public class MainActivity extends AppCompatActivity {

            private EditText editTextMensaje;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                Button buttonOK = findViewById(R.id.btnA1);
                buttonOK.setOnClickListener(l->enviarSMS(l));
            }
            public int cEdad(Date Fecha){
                Calendar calNacimiento = Calendar.getInstance();
                calNacimiento.setTime(Fecha);

                Calendar calActual = Calendar.getInstance();

                int edad = calActual.get(Calendar.YEAR) - calNacimiento.get(Calendar.YEAR);
                if (calActual.get(Calendar.DAY_OF_YEAR) < calNacimiento.get(Calendar.DAY_OF_YEAR)) {
                    edad--; // Restar 1 si aún no se ha celebrado el cumpleaños de este año
                }
            return edad;
            }
            public void enviarSMS(View view) {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                Intent intent = new Intent(this, SegundaActivity.class);
                EditText editTextMensaje = findViewById(R.id.txtlabelA1);
                EditText editTextFecha = findViewById(R.id.txtlablel2A1);
                String mensaje = editTextMensaje.getText().toString();
                String fecha = editTextFecha.getText().toString();
                intent.putExtra("mensa", mensaje);

                try { Log.d("MainActivity", "holas21");
                    Date fechaNacimiento = format.parse(fecha);
                    Log.d("MainActivity", "holas12");
                    int edad = cEdad(fechaNacimiento);
                    intent.putExtra("edad", edad);
                    Log.d("MainActivity", "holas1");
                    intent.putExtra("fecha", fecha);

                } catch (ParseException e) {
                    e.printStackTrace();
                    Log.d("MainActivity", "holas");
                    // Manejo de error en caso de que la fecha no sea válida
                }
                startActivity(intent);
            }

        }