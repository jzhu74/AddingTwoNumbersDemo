package com.example.jerryzhu.addingtwonumbersdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class Activity3 extends AppCompatActivity {
    LineGraphSeries<DataPoint> series;

    private EditText num1;
    private Button add;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        double y,x;
        x = 0;

        GraphView graph = (GraphView) findViewById(R.id.graph);
        series = new LineGraphSeries<DataPoint>();
        for (int i = 0; i < 75; i++) {
            x = x  + 0.1;
            y = (1/(Math.sqrt(2 * Math.PI))) * Math.exp(-0.5 * Math.pow(x, 2));
            series.appendData(new DataPoint(x,y), true, 75);
        }
        graph.addSeries(series);


        num1 = (EditText) findViewById(R.id.etNum1);
        add = (Button) findViewById(R.id.btnAdd);
        result = (TextView) findViewById(R.id.tvAnswer);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double number1 = Double.parseDouble(num1.getText().toString());
                double sum = number1;
                result.setText("Answer: " + (1/(Math.sqrt(2 * Math.PI))) * Math.exp(-0.5 * Math.pow(sum, 2)));

            }
        });
    }
}
