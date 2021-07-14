package android.example.com.classtacular;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NotesArea extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_area);

        Button button = findViewById(R.id.addNotesButton);
        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(NotesArea.this, "Click here to add your own Notes",
                        Toast.LENGTH_LONG).show();
                return true;
            }
        });

        button = findViewById(R.id.NotesHubButton);
        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(NotesArea.this, "Click here to open NotesHub",
                        Toast.LENGTH_LONG).show();
                return true;
            }
        });

    }

    public void openAddNotesActivity(View view) {

        Intent i = new Intent(NotesArea.this, AddNotesPane.class);
        startActivity(i);

    }

    public void NotesHubIntent(View view) {
        Uri uri = Uri.parse("https://noteshub.co.in/");
        Intent launchIntent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(launchIntent);

    }
}