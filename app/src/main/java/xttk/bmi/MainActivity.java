package xttk.bmi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    private RadioButton radio_male,radio_female;
    private EditText height,weight;
    private Button btn1;
    private double ip_h,ip_w,bmi;
    private boolean sex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        find();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radio_male.isChecked())
                    sex = true; //true為男性
                else
                    sex = false; //false為女性
                ip_h = Double.valueOf(height.getText().toString());
                ip_w = Double.valueOf(weight.getText().toString());
                bmi = ip_w/ip_h;
                bmi /= ip_h;
                Intent intent = new Intent(MainActivity.this,Page2.class);
                intent.putExtra("bmi",bmi);
                intent.putExtra("sex",sex);
                startActivity(intent);
            }
        });
    }
    private void find(){
        radio_male = (RadioButton) findViewById(R.id.radio_male);
        radio_female = (RadioButton) findViewById(R.id.radio_female);
        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        btn1 = (Button) findViewById(R.id.btn1);
    }
}
