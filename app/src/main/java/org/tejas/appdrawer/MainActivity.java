package org.tejas.appdrawer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize buttons
        Button btnDial = findViewById(R.id.btn_dial);
        Button btnCall = findViewById(R.id.btn_call);
        Button btnSms = findViewById(R.id.btn_sms);
        Button btnContact = findViewById(R.id.btn_contact);
        Button btnWeb = findViewById(R.id.btn_web);
        Button btnMap = findViewById(R.id.btn_map);
        Button btnMail = findViewById(R.id.btn_mail);
        Button btnAppStore = findViewById(R.id.btn_appstore);
        Button btnCamera = findViewById(R.id.btn_camera);
        Button btnAlert = findViewById(R.id.btn_alert); // New button for launching AlertActivity

        // Set button actions
        btnDial.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:123456789"));
            startActivity(intent);
        });

        btnCall.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:123456789"));
            startActivity(intent);
        });

        btnSms.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:123456789"));
            intent.putExtra("sms_body", "Hello!");
            startActivity(intent);
        });

        btnContact.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
            startActivity(intent);
        });

        btnWeb.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
            startActivity(intent);
        });

        btnMap.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:16.874834,74.262493?q=hotel"));
            startActivity(intent);
        });

        btnMail.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:example@gmail.com"));
            intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
            intent.putExtra(Intent.EXTRA_TEXT, "Hello, this is a test email!");
            startActivity(intent);
        });

        btnAppStore.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.example.app"));
            startActivity(intent);
        });

        btnCamera.setOnClickListener(v -> {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(intent);
        });

        // Launch AlertActivity
        btnAlert.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, alert.class);
            startActivity(intent);
        });
    }
}
