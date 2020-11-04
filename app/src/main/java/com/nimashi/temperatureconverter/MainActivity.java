package com.nimashi.temperatureconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText value;
    TextView ans;
    Spinner dropdown1,dropdown2;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dropdown1 =findViewById(R.id.spinner1);
        dropdown2 =findViewById(R.id.spinner2);
        button = findViewById(R.id.btn);


        String [] temp = {"Celsius","Fahrenheit","Kelvin"};

        ArrayAdapter<String> adapter= new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, temp);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item );

        dropdown1.setAdapter(adapter);
        dropdown2.setAdapter(adapter);





    }

    public void refresh(View view)
    {
        value.setText("");
        ans.setText("");
    }


    public void Convert(View view){

        double userinput;
        double output;
        String from_unit;
        String to_unit;

        value = findViewById(R.id.value);
        ans =findViewById(R.id.ans);

        String num=value.getText().toString();
        if (num.isEmpty())
        {
            Toast.makeText(this, "Please enter a Value", Toast.LENGTH_SHORT).show();
            return;
        }

        //get data from fields
        userinput = Double.parseDouble(value.getText().toString());
        from_unit =dropdown1.getSelectedItem().toString();
        to_unit =dropdown2.getSelectedItem().toString();

        if(from_unit.equals("Celsius") && to_unit.equals("Fahrenheit")){
            output =((userinput*9)/5)+32;
            ans.setText(String.valueOf(output+" °F"));
              }
        else if(from_unit.equals("Celsius") && to_unit.equals("Kelvin")){
            output =userinput+273.15;
            ans.setText(String.valueOf(output)+" K");
              }
        else if(from_unit.equals("Kelvin") && to_unit.equals("Fahrenheit")){
            output=(((userinput-273.15)*9)/5)+32;
            ans.setText(String.valueOf(output)+" °F");
             }
        else if(from_unit.equals("Kelvin") && to_unit.equals("Celsius")){
            output=(userinput-273.15);
            ans.setText(String.valueOf(output)+" °C");
        }
        else if(from_unit.equals("Fahrenheit") && to_unit.equals("Celsius")){
            output=((userinput-32)*5)/9;
            ans.setText(String.valueOf(output)+" °C");
        }
        else if(from_unit.equals("Fahrenheit") && to_unit.equals("Kelvin")){
            output=(((userinput-32)*5)/9)+273.15;
            ans.setText(String.valueOf(output)+" K");
        }
        else if(from_unit.equals("Fahrenheit") && to_unit.equals("Fahrenheit")){
            output=userinput;
            ans.setText(String.valueOf(output)+ " °F");
        }
        else if(from_unit.equals("Celsius") && to_unit.equals("Celsius")){
            output=userinput;
            ans.setText(String.valueOf(output)+" °C");
        }
        else{
            output=userinput;
            ans.setText(String.valueOf(output)+" K");
        }




    }

}
