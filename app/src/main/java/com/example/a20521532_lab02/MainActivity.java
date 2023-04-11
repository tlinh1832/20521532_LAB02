package com.example.a20521532_lab02;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextSalary;
    private Button buttonAdd;
    private ListView listViewEmployees;

    private ArrayList<Employee> employees;
    private EmployeeListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextSalary = findViewById(R.id.editTextSalary);
        buttonAdd = findViewById(R.id.buttonAdd);
        listViewEmployees = findViewById(R.id.listViewEmployees);

        employees = new ArrayList<>();
        adapter = new EmployeeListAdapter(this, employees);
        listViewEmployees.setAdapter(adapter);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String salaryString = editTextSalary.getText().toString();

                try {
                    double salary = Double.parseDouble(salaryString);
                    Employee employee = new Employee(name, salary);
                    employees.add(employee);
                    adapter.notifyDataSetChanged();
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Please enter a valid salary", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}