package org.tejas.appdrawer;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class alert extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_alert);

        // Set edge-to-edge insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Alert 1: Terms & Conditions
    public void btnAlert1_Click(android.view.View vw) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Terms & Conditions")
                .setIcon(R.drawable.img)
                .setMessage("Have you read all the T & C?")
                .setCancelable(true)
                .setPositiveButton("Yes, I've Read", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(alert.this, "Yes, you can process now.", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }

    // Alert 2: Delete Confirmation
    public void btnAlert2_Click(android.view.View vw) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete")
                .setIcon(R.drawable.img)
                .setMessage("Are you sure you want to delete it?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(alert.this, "Item deleted successfully.", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(alert.this, "Item not deleted.", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                })
                .show();
    }

    // Alert 3: Exit Confirmation
    public void btnAlert3_Click(android.view.View vw) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Exit")
                .setIcon(R.drawable.img)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(true)
                .setPositiveButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(alert.this, "Welcome back.", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish(); // Close the activity
                    }
                })
                .setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .show();
    }
}
