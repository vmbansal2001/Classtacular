package android.example.com.classtacular;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
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

        ProgressBar bar = (ProgressBar) listItemView.findViewById(R.id.attendanceprogress);
        bar.setProgress(percent);

        TextView presentno = (TextView) listItemView.findViewById(R.id.present);
        presentno.setText(currentSubject.getMpresent() + "");

        TextView absentno = (TextView) listItemView.findViewById(R.id.absent);
        absentno.setText(currentSubject.getMabsent() + "");

        ImageView plus = (ImageView) listItemView.findViewById(R.id.presentButton);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentSubject.incrementPresent();
                presentno.setText(currentSubject.getMpresent() + "");
                int percent = ((currentSubject.getMpresent()) * 100) / (currentSubject.getMabsent() + currentSubject.getMpresent());
                String per = percent + "%";
                attendancepercent.setText(per);
                bar.setProgress(percent);
            }
        });

        ImageView minus = (ImageView) listItemView.findViewById(R.id.absentButton);
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentSubject.incrementAbsent();
                absentno.setText(currentSubject.getMabsent() + "");
                int percent = ((currentSubject.getMpresent()) * 100) / (currentSubject.getMabsent() + currentSubject.getMpresent());
                String per = percent + "%";
                attendancepercent.setText(per);
                bar.setProgress(percent);
            }
        });

        return listItemView;

    }
}
