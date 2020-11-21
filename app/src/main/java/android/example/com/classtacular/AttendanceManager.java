package android.example.com.classtacular;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AttendanceManager extends AppCompatActivity {

    final ArrayList<subject> subjects = new ArrayList<subject>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_manager);

    }

    public void addSubject(View view) {
        EditText TextField = (EditText) findViewById(R.id.addSubjectName);
        String name = TextField.getText().toString();
        subjects.add(new subject(name, 0, 0, 0));
        subjectAdapter adapter = new subjectAdapter(AttendanceManager.this, 0, subjects);
        ListView listView = (ListView) findViewById(R.id.subjectList);
        listView.setAdapter(adapter);
    }
}