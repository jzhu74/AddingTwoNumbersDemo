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
import java.lang.Math;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    public static double logGamma(double x) {
        double tmp = (x - 0.5) * Math.log(x + 4.5) - (x + 4.5);
        double ser = 1.0 + 76.18009173    / (x + 0)   - 86.50532033    / (x + 1)
                + 24.01409822    / (x + 2)   -  1.231739516   / (x + 3)
                +  0.00120858003 / (x + 4)   -  0.00000536382 / (x + 5);
        return tmp + Math.log(ser * Math.sqrt(2 * Math.PI));
    }
    public static double gamma(double x) { return Math.exp(logGamma(x)); }
    LineGraphSeries<DataPoint> series;

    private EditText num1;
    private Button add;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        double y,x;
        x = 0;

        GraphView graph = (GraphView) findViewById(R.id.graph);
        series = new LineGraphSeries<DataPoint>();
        for (int i = 0; i < 55; i++) {
            x = x  + 0.1;
            y = gamma(x);
            series.appendData(new DataPoint(x,y), true, 55);
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
                result.setText("Answer: " + gamma(sum));

            }
        });



    }


}