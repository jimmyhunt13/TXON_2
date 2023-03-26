package com.example.txon_02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
TextView resulttv,solutiontv;
MaterialButton buttonC,buttonOpenBrack,buttonClosebrack;
MaterialButton buttonadd,buttonsub,buttonmulti,buttondiv,buttonequal;
MaterialButton button0,button1,button2,button3,button4,button5,button6,button7,button8,button9;
MaterialButton buttonAC,buttondot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resulttv=findViewById(R.id.result_tv);
        solutiontv=findViewById(R.id.solution_tv);
             assign(buttonC,R.id.button_c);
             assign(buttonClosebrack,R.id.button_closebrc);
             assign(buttonOpenBrack,R.id.button_openbrc);
            assign(buttonadd,R.id.button_add);
            assign(buttonmulti,R.id.button_multi);
            assign(buttonsub,R.id.button_sub);
            assign(buttondiv,R.id.button_div);
            assign(button0,R.id.button_0);
            assign(button1,R.id.button_1);
            assign(button2,R.id.button_2);
            assign(button3,R.id.button_3);
            assign(button4,R.id.button_4);
            assign(button5,R.id.button_5);
            assign(button6,R.id.button_6);
            assign(button7,R.id.button_7);
            assign(button8,R.id.button_8);
            assign(button9,R.id.button_9);
            assign(buttonAC,R.id.button_AC);
            assign(buttondot,R.id.button_decimal);
    }
    void assign(MaterialButton btnn, int id){
    btnn=findViewById(id);
    btnn.setOnClickListener(this);
    }

    public void onClick(View view){
   MaterialButton button=(MaterialButton) view;
   String buttonText=button.getText().toString();
   String datatoCalculate= solutiontv.getText().toString();
   if(buttonText.equals("AC")){
       solutiontv.setText("");
       resulttv.setText("0");
       return;

   }
   if(buttonText.equals("=")) {
       solutiontv.setText(resulttv.getText());
       return;
   }
       if(buttonText.equals("C")){
          datatoCalculate=datatoCalculate.substring(0,datatoCalculate.length()-1);
       }
       else{
           datatoCalculate=datatoCalculate+buttonText;
       }
       solutiontv.setText(datatoCalculate);
       String finalResult=getResult(datatoCalculate);
      if(!finalResult.equals("Err")){{
          resulttv.setText(finalResult);
      }}
    }
        String getResult(String data){
 try{
     Context context=Context.enter();
     context.setOptimizationLevel(-1);
     Scriptable scriptable=context.initStandardObjects();
    String finalResult= context.evaluateString(scriptable,data,"Javascript",1,null).toString();
  if(finalResult.equals(".0")){
      finalResult=finalResult.replace("0","");
  }
    return finalResult;
 }
catch (Exception e){
     return "Err";
}
    }

}