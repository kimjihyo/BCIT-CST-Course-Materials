package ca.bcit.jihyokim.globalinstituteoftechnology;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final static String JSON_FILE = "students.json";
    private static final String TAG = "MainActivity";
    private StudentAdapter studentAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        listView = findViewById(R.id.listView);
        studentAdapter = new StudentAdapter(MainActivity.this, getStudentsData());
        listView.setAdapter(studentAdapter);
    }

    /* Convert JSON String to BaseStudent Model via GSON */
    public List<Student> getStudentsData() {
        // String jsonString = getAssetsJSON(JSON_FILE);
        String filename = getResources().getString(R.string.json_file_name);
        String jsonString = getAssetsJSON(filename);
        Log.d(TAG, "Json: " + jsonString);
        Gson gson = new Gson();
        BaseStudent baseStudent = gson.fromJson(jsonString, BaseStudent.class);
        return  baseStudent.getStudents();
    }

    /* Get File in Assets Folder */
    public String getAssetsJSON(String fileName) {
        String json = null;
        try {
            InputStream inputStream = this.getAssets().open(fileName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    public void onVoteClick(View v) {
        VoteDialogFragment dialog = new VoteDialogFragment();
        dialog.show(getSupportFragmentManager(), "NoticeDialogFragment");
    }
}
