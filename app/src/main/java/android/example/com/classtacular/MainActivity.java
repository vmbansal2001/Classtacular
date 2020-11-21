package android.example.com.classtacular;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void select_student_photo(View view) {
        Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickPhoto, 1);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        ImageView imageview = (ImageView) findViewById(R.id.student_photo);
        if (resultCode == RESULT_OK) {
            Uri selectedImage = imageReturnedIntent.getData();
            imageview.setImageURI(selectedImage);
        }
    }

    public void OpenTimeTableActivity(View view) {
        Intent i = new Intent(MainActivity.this, TimeTableActivity.class);
        startActivity(i);
    }

    public void OpenNotesAreaActivity(View view) {
        Intent i = new Intent(MainActivity.this, NotesArea.class);
        startActivity(i);
    }

    public void OpenAttendanceManagerActivity(View view) {
        Intent i = new Intent(MainActivity.this, AttendanceManager.class);
        startActivity(i);
    }

}