package android.example.com.classtacular;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class AddNotesPane extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notes_pane);

        Spinner dropdown = findViewById(R.id.course_spinner);
        String[] items = {"B.Tech"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        dropdown = findViewById(R.id.branch_spinner);
        items = new String[]{"CSE", "IT", "ECE", "EEE", "Civil", "Mechanical"};
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        dropdown = findViewById(R.id.semester_spinner);
        items = new String[]{"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th"};
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
    }

    public void ViewNotes(View view) {
        Uri uri = Uri.parse("https://drive.google.com/drive/folders/1JN-dyDCPGGe9gH65aOqVdf4aWfqfQv6F?usp=sharing");
        Intent launchIntent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(launchIntent);
    }
}