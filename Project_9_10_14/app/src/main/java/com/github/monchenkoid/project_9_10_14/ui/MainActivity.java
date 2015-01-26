package com.github.monchenkoid.project_9_10_14.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.github.monchenkoid.project_9_10_14.R;
import com.github.monchenkoid.project_9_10_14.bo.models.TypeInfMet;
import com.github.monchenkoid.project_9_10_14.utils.Constants;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    // Button mButton;

    public static final String TAG = MainActivity.class.getSimpleName();
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        ArrayList<String> name;
        name = new ArrayList<>();

        name.add("Дон Кихот");
        name.add("ИЛЭ");
        name.add("Интуитивно-Логический Экстраверт");
        name.add("Искатель");
        name.add("ENTP");


        ArrayList<String> dUng = new ArrayList<>();

        dUng.add("Экстраверт");
        dUng.add("Интуит");
        dUng.add("Логик");
        dUng.add("Иррационал");


        ArrayList<String> reign;
        reign = new ArrayList<>();

        reign.add("Статик");
        reign.add("Позитивист");
        reign.add("Квестим");
        reign.add("Тактик");
        reign.add("Конструктивист");
        reign.add("Процессер");
        reign.add("Уступчивый");
        reign.add("Беспечный");
        reign.add("Рассудительный");
        reign.add("Весёлый");
        reign.add("Демократ");


        ArrayList<String> modelA = new ArrayList<>();

        modelA.add("I - интуиция возможностей");
        modelA.add("L - структурная логика");
        modelA.add("F - силовая сенсорика");
        modelA.add("R - этика отношений");
        modelA.add("S - сенсорика ощущений");
        modelA.add("E - этика эмоций");
        modelA.add("T - интуиция времени");
        modelA.add("P - деловая логика");
        Long id = 1000000000000L;
        TypeInfMet typeInfMet = new TypeInfMet(id, name, dUng, reign, modelA, null);
        ArrayList<TypeInfMet> tims;
        tims = new ArrayList<>();
        Gson gson = new Gson();

        tims.add(typeInfMet);

        name.add("Дuma");
        typeInfMet = new TypeInfMet(id, name, dUng, reign, modelA, null);
        tims.add(typeInfMet);

        String jsonRepresentation = gson.toJson(tims);
        editText.setText(jsonRepresentation);

    }

    public void onOkClick(View view) {
        startActivity(new Intent(this, TIMListActivity.class));
        finish();


    }


}
