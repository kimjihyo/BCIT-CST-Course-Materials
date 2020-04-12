package ca.bcit.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText editTextTask;
    EditText editTextWho;
    EditText editTextDate;
    Spinner spinnerDone;
    Button buttonAddTask;

    DatabaseReference databaseTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void addTask() {
        String task = editTextTask.getText().toString().trim();
        String who = editTextWho.getText().toString().trim();
        String dateFormat = editTextDate.getText().toString().trim();
        Date date = SimpleDateFormat.parse(dateFormat);
        Boolean done = spinnerDone.getSelectedItem().toString().trim();

        if (TextUtils.isEmpty(task)) {
            Toast.makeText(this, "You must enter the name of task.", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(who)) {
            Toast.makeText(this, "You must enter the name of worker.", Toast.LENGTH_LONG).show();
            return;
        }

        String id = databaseTasks.push().getKey();
        ToDo todo = new ToDo(id, task, who, date, done);
    }
}
