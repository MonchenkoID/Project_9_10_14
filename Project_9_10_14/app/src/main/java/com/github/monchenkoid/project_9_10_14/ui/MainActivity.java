package com.github.monchenkoid.project_9_10_14.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.github.monchenkoid.project_9_10_14.R;
import com.github.monchenkoid.project_9_10_14.bo.models.TIM;
import com.github.monchenkoid.project_9_10_14.bo.models.TIMGroup;
import com.github.monchenkoid.project_9_10_14.gson.serialize.TIMGroupSerializer;
import com.github.monchenkoid.project_9_10_14.gson.serialize.TimSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainActivity extends Activity {
    // Button mButton;

    private EditText editText;
    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);

        // mButton = (Button) findViewById(R.id.button);

        TIM tim;
        TIMGroup timGr = new TIMGroup();


        tim = new TIM("Дон Кихот");
        tim.setName1("ИЛЭ");
        tim.setName2("Интуитивно-Логический Экстраверт");
        tim.setName3("Искатель");
        tim.setName4("ENTP");

        tim.setdUng1("Экстраверт");
        tim.setdUng2("Интуит");
        tim.setdUng3("Логик");
        tim.setdUng4("Иррационал");

        tim.setReign1("Статик");
        tim.setReign2("Позитивист");
        tim.setReign3("Квестим");
        tim.setReign4("Тактик");
        tim.setReign5("Конструктивист");
        tim.setReign6("Процессер");
        tim.setReign7("Уступчивый");
        tim.setReign8("Беспечный");
        tim.setReign9("Рассудительный");
        tim.setReign10("Весёлый");
        tim.setReign11("Демократ");

        tim.setModelA1("I - интуиция возможностей");
        tim.setModelA2("L - структурная логика");
        tim.setModelA3("F - силовая сенсорика");
        tim.setModelA4("R - этика отношений");
        tim.setModelA5("S - сенсорика ощущений");
        tim.setModelA6("E - этика эмоций");
        tim.setModelA7("T - интуиция времени");
        tim.setModelA8("P - деловая логика");
        timGr.addTIM(tim);
        tim = new TIM("Дuma");
        timGr.addTIM(tim);
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(TIM.class, new TimSerializer())
                .registerTypeAdapter(TIMGroup.class, new TIMGroupSerializer())
                .create();
        String json = gson.toJson(timGr);

        // Log.i(TAG, json);
        editText.setText(json);

        //  Adams adams = new Adams();
        //  adams.AdRun();

       /* TIMBean timBean = new TIMBean();
        timBean.setId(1234567890777L);
        timBean.setName("Balzak");
        Log.d(String.valueOf("test"), "begin asynctask");
        ArrayList<TIMBean> tim;

        try {
            tim = new EndpointsAsyncTask().execute(timBean).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        //TIMBean timBean = (TIMBean) getIntent().getSerializableExtra();
        Log.d(String.valueOf("test"), "end asynctask");
    */
    }

    public void onOkClick(View view) {
        startActivity(new Intent(this, TIMListActivity.class));
        finish();


    }


}
