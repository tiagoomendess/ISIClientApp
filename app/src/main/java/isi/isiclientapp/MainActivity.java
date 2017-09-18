package isi.isiclientapp;

import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    public static final String TAG = "NfcDemo";
    public static RelativeLayout relativeLayout;
    private TextView mTextView;
    private NfcAdapter NfcAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout = (RelativeLayout) findViewById(R.id.activity_main);
    }

    @Override
    protected void onResume() {

        super.onResume();
    }

    public void handleForm(View button) {

        relativeLayout.setBackgroundColor(Color.WHITE);
        final EditText tokenField = (EditText) findViewById(R.id.token);
        String token = tokenField.getText().toString();
        checkToken(token);

    }

    public void checkToken(String token) {

        String url = "https://isi.mendes.com.pt/api/keys/check/" + token;
        FetchData fd = new FetchData();
        fd.url = url;
        fd.execute();

    }


}
