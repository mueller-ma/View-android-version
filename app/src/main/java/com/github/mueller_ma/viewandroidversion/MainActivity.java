package com.github.mueller_ma.viewandroidversion;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView t = findViewById(R.id.version);
        int sdk = Build.VERSION.SDK_INT;
        String name;
        switch (sdk) {
            case 14:
            case 15: name = "Ice Cream Sandwich";
            break;
            case 16:
            case 17:
            case 18: name = "Jelly Bean";
            break;
            case 19:
            case 20: name = "Kitkat";
            break;
            case 21:
            case 22: name = "Lollipop";
            break;
            case 23: name = "Marshmallow";
            break;
            case 24:
            case 25: name = "Nougat";
            break;
            case 26:
            case 27: name = "Oreo";
            break;
            default: name = getString(R.string.invalid);
        }
        t.setText(String.format(getString(R.string.codename), name));
        t.append(String.format(Locale.US,getString(R.string.version), Build.VERSION.RELEASE, sdk));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            t.append(String.format(getString(R.string.based_on), Build.VERSION.BASE_OS));
            int prevSDK = Build.VERSION.PREVIEW_SDK_INT;
            if(prevSDK != 0) {
                t.append(String.format(Locale.US, getString(R.string.preview), Build.VERSION.CODENAME, prevSDK));
            }
            t.append(String.format(getString(R.string.patch), Build.VERSION.SECURITY_PATCH));
        }

        TextView made_by = findViewById(R.id.made_by);
        made_by.setClickable(true);
        made_by.setMovementMethod(LinkMovementMethod.getInstance());
        String text = getString(R.string.made_by) + " <a href='https://www.github.com/mueller-ma'>mueller-ma</a>";
        made_by.setText(Html.fromHtml(text));
    }
}
