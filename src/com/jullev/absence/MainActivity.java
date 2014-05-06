package com.jullev.absence;

import id.flwi.util.ActivityUtil;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	Button submit;
	EditText uname,pass;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		uname = (EditText) findViewById(R.id.username);
		pass = (EditText) findViewById(R.id.pass);
		submit = (Button) findViewById(R.id.btnlgn);
		submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public void Login(){
		String username = uname.getText().toString();
		String password = pass.getText().toString();
		if(username.equals("admin")&&password.equals("admin")){
			ActivityUtil.setSharedPreference(this, "username", username);
			startActivity(new Intent(MainActivity.this, HomeGuru.class));
		}
				
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
