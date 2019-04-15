package com.fproject.cod.numbersinfigure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_convert;
    EditText et_number;
    TextView tv_words;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_convert=findViewById(R.id.btn_convert);

        btn_convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_number=findViewById(R.id.et_number);
                tv_words=findViewById(R.id.tv_words);


                if(et_number.getText().toString().length()<0 ||
                        et_number.getText().toString().length()>3 )
                {
                    et_number.setError("Please make sure you input numbers and " +
                            "their length should not exceed 3 digits");
                }
                else
                {
                    int number=Integer.parseInt(et_number.getText().toString());
                    tv_words.setText(numberConvert(number));
                }

            }
        });
    }


    public String numberConvert(int number)
    {
        String num=""+number;
        String arr[]={"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine",};

        String doubleone[]={"Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen"
                ,"Eighteen","Nineteen"};
        String doubleoth[]={"Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        String tens[]={"Hundred" ,"Thousand"};

        if(num.length()==1)
        {
           return ""+arr[number];
        }
        if(num.length()==2)
        {
            int fval=number/10;
            int lval=number%10;
            Toast.makeText(MainActivity.this,"lval="+lval+"fval="+fval,Toast.LENGTH_LONG).show();
            if(lval==0)
            {
                return doubleoth[fval-1];
            }
            else if(fval==1)
            {
                return doubleone[lval-1];
            }
            else if(fval>1)
            {
            return doubleoth[fval-1]+""+arr[lval];
            }
        }
        if(num.length()==3)
        {
            int fval=number/100;
            int lval=number%10;
            int midval=(number/10)%10;
            Toast.makeText(MainActivity.this,"lval="+lval+"midval"
                    +midval+"fval="+fval,Toast.LENGTH_LONG).show();
            if(fval>0 && midval>0 && lval>0)
            {

            return arr[fval]+""+tens[0]+doubleoth[midval-1]+arr[lval];

            }
            else if(fval>0 && midval==0 && lval>0)
            {
                return arr[fval]+""+tens[0]+arr[lval];
            }
            else if(fval>0 && midval>0 && lval==0)
            {
                return arr[fval]+""+tens[0]+doubleoth[midval-1];
            }
            else if(fval>0 && midval==0 && lval==0)
            {
                return arr[fval]+tens[0];
            }


        }

        return "wrong";
    }
}
