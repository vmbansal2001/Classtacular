package android.example.com.classtacular;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class settings_pane extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_pane);
    }

    public void ReportBug(View view) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto", "vmbansal2001@gmail.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "ClassTacular Bug Report");
        String message = "Please Describe your Problem Here.";
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);
        startActivity(Intent.createChooser(emailIntent, "Send email..."));
    }
}