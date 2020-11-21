package android.example.com.classtacular;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class subjectAdapter extends ArrayAdapter<subject> {

    public subjectAdapter(@NonNull Context context, int resource, @NonNull List<subject> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        subject currentSubject = getItem(position);
        TextView subjectName = (TextView) listItemView.findViewById(R.id.subjectname);
        subjectName.setText(currentSubject.getMsubjectName());

        TextView attendancepercent = (TextView) listItemView.findViewById(R.id.attendancepercent);
        int percent = 0;
        if (currentSubject.getMpresent() == 0 || currentSubject.getMabsent() == 0) {
            percent = 0;
        } else {
            percent = (currentSubject.getMpresent() * 100) / (currentSubject.getMabsent() + currentSubject.getMpresent());
        }
        String per = percent + "%";
        attendancepercent.setText(per);

        TextView attendanceRecord = (TextView) listItemView.findViewById(R.id.noOfClassesRecord);
        String record = currentSubject.getMpresent() + "/" + (currentSubject.getMpresent() + currentSubject.getMabsent());
        attendanceRecord.setText(record);

        ProgressBar bar = (ProgressBar) listItemView.findViewById(R.id.attendanceprogress);
        bar.setProgress(percent);

        TextView classInfo = (TextView) listItemView.findViewById(R.id.classesInfo);
        String info = "";
        if (percent < 77) {
            info = "You Can't Miss Any More Classes";
        } else {
            info = "You Can Miss a Class";
        }
        classInfo.setText(info);

        ImageView plus = (ImageView) listItemView.findViewById(R.id.presentButton);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentSubject.incrementPresent();
                int percent = ((currentSubject.getMpresent()) * 100) / (currentSubject.getMabsent() + currentSubject.getMpresent());
                String per = percent + "%";
                attendancepercent.setText(per);

                String record = currentSubject.getMpresent() + 1 + "/" + (currentSubject.getMpresent() + currentSubject.getMabsent() + 1);
                attendanceRecord.setText(record);

                String info = "";
                if (percent < 77) {
                    info = "You Can't Miss Any More Classes";
                } else {
                    info = "You Can Miss a Class";
                }
                classInfo.setText(info);

                bar.setProgress(percent);
            }
        });

        ImageView minus = (ImageView) listItemView.findViewById(R.id.absentButton);
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentSubject.incrementAbsent();
                int percent = ((currentSubject.getMpresent()) * 100) / (currentSubject.getMabsent() + currentSubject.getMpresent());
                String per = percent + "%";
                attendancepercent.setText(per);

                String record = currentSubject.getMpresent() + 1 + "/" + (currentSubject.getMpresent() + currentSubject.getMabsent() + 1);
                attendanceRecord.setText(record);

                String info = "";
                if (percent <= 75) {
                    info = "You Can't Miss Any More Classes";
                } else {
                    info = "You Can Miss a Class";
                }
                classInfo.setText(info);

                bar.setProgress(percent);
            }
        });

        return listItemView;

    }
}
