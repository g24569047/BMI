package xttk.bmi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Page2 extends AppCompatActivity {

    private TextView tv1,tv2;
    private Button btn2;
    private double bmi;
    private boolean sex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        Intent intent = getIntent();
        bmi = intent.getDoubleExtra("bmi",0.0);
        DecimalFormat df=new DecimalFormat("#.##");
        String s=df.format(bmi);
        sex = intent.getBooleanExtra("sex",true);
        find();

        tv1.setText(getString(R.string.Result1)+s);
        if (sex == true){
            if (bmi<20)
                tv2.setText(getString(R.string.Result2_1));
            else if (bmi>25)
                tv2.setText(getString(R.string.Result2_3));
            else
                tv2.setText(getString(R.string.Result2_2));
        }
        else {
            if (bmi<18)
                tv2.setText(getString(R.string.Result2_1));
            else if (bmi>22)
                tv2.setText(getString(R.string.Result2_3));
            else
                tv2.setText(getString(R.string.Result2_2));
        }

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Page2.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void find(){
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        btn2 = (Button) findViewById(R.id.btn2);
    }
}
