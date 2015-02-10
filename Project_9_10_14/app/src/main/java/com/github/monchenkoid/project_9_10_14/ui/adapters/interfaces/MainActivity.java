package com.github.monchenkoid.project_9_10_14.ui.adapters.interfaces;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.github.monchenkoid.project_9_10_14.R;
import com.github.monchenkoid.project_9_10_14.ui.activities.TIMListActivity;

public class MainActivity extends Activity
{
	private Button mButton;

	public static final String TAG = MainActivity.class.getSimpleName();
	private EditText editText;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		editText = (EditText) findViewById(R.id.editText);

		mButton = (Button) findViewById(R.id.button);


		// String jsonRepresentation = gson.toJson(tims);
		//  editText.setText(jsonRepresentation);

	}

	public void onOkClick(View view)
	{
		startActivity(new Intent(this, TIMListActivity.class));
		finish();


	}


}
