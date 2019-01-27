package voice_to_text.sandy148101.com.emailclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText_to, editTextsub,editTextMsg;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_to = (EditText) findViewById(R.id.editText_to);
        editTextsub = (EditText) findViewById(R.id.editText_sub);
        editTextMsg = (EditText) findViewById(R.id.editText_message);
        button = (Button) findViewById(R.id.sendBtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Sendmail();
            }
        });
    }
    public void Sendmail()
    {

        String receipt = editText_to.getText().toString();
        String[]  receipt_list = receipt.split(",");
        String subject = editTextsub.getText().toString();

        String message = editText_to.getText().toString();

        Intent intent= new Intent(Intent.ACTION_SEND);
        intent.putExtra(intent.EXTRA_EMAIL,receipt);
        intent.putExtra(intent.EXTRA_SUBJECT,subject);
        intent.putExtra(intent.EXTRA_TEXT,message);

        intent.setType("message/abc");

        startActivity(Intent.createChooser(intent,"Choose an Email client"));

    }
}
