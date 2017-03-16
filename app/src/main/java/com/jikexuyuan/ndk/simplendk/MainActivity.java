package com.jikexuyuan.ndk.simplendk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @BindView(R.id.sample_text)
    TextView sampleText;
    @BindView(R.id.edit_input_1)
    EditText editInput1;
    @BindView(R.id.edit_input_2)
    EditText editInput2;
    @BindView(R.id.add)
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        // Example of a call to a native method
        sampleText.setText(stringFromJNI());
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editInput1.getText().toString().equals("")) {
                    editInput1.startAnimation(new CustomAnimation());
                    return;
                }
                if (editInput2.getText().toString().equals("")) {
                    editInput2.startAnimation(new CustomAnimation());
                    return;
                }
                Add add = new Add();
                int firstNum = Integer.parseInt(editInput1.getText().toString());
                int secondNum = Integer.parseInt(editInput2.getText().toString());
                String total = getString(R.string.total) + String.valueOf(add.addNum(firstNum, secondNum));
                sampleText.setText(total);
            }
        });
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
