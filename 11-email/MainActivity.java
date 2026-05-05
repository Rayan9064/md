package com.example.email;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
	// define objects for edit text and button
	Button button;
	EditText sendto, subject, body;

	@SuppressLint("MissingInflatedId")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// Getting instance of edittext and button
		sendto = findViewById(R.id.et1_emailid);
		subject = findViewById(R.id.et2_emailsub);
		body = findViewById(R.id.et3_emailmsg);
		button = findViewById(R.id.btn_Send);
		// attach setOnClickListener to button with Intent object defined in it
		button.setOnClickListener(view -> {
			String emailsend = sendto.getText().toString();
			String emailsubject = subject.getText().toString();
			String emailbody = body.getText().toString();
			// 1. define Intent object with action attribute as ACTION_SEND
			Intent intent = new Intent(Intent.ACTION_SENDTO);
			// add three fields to intent using putExtra function
			// 2. Set the data to mailto: (this restricts it to email apps only)
			intent.setData(Uri.parse("mailto:"));
			// 3. Put all the extra values for mailid, subject and email body
			intent.putExtra(Intent.EXTRA_EMAIL, new String[]{emailsend});
			intent.putExtra(Intent.EXTRA_SUBJECT, emailsubject);
			intent.putExtra(Intent.EXTRA_TEXT, emailbody);

			startActivity(Intent.createChooser(intent, "Choose an Email client :"));
		});
	}
}