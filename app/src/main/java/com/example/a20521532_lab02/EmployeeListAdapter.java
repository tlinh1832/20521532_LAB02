package com.example.a20521532_lab02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class EmployeeListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Employee> employees;

    public EmployeeListAdapter(Context context, ArrayList<Employee> employees) {
        this.context = context;
        this.employees = employees;
    }

    @Override
    public int getCount() {
        return employees.size();
    }

    @Override
    public Object getItem(int position) {
        return employees.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_employee, parent, false);
        }

        Employee employee = employees.get(position);

        TextView textViewName = convertView.findViewById(R.id.textViewName);
        TextView textViewSalary = convertView.findViewById(R.id.textViewSalary);

        textViewName.setText(employee.getName());
        textViewSalary.setText(String.format("%.0f", employee.getNetSalary()));

        return convertView;
    }
}


