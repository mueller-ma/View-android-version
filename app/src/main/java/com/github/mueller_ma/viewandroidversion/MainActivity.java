package com.github.mueller_ma.viewandroidversion;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int sdkVersion = Build.VERSION.SDK_INT;
        String versionName;
        switch (sdkVersion) {
            case 14:
            case 15:
                versionName = "Ice Cream Sandwich";
                break;
            case 16:
            case 17:
            case 18:
                versionName = "Jelly Bean";
                break;
            case 19:
            case 20:
                versionName = "Kitkat";
                break;
            case 21:
            case 22:
                versionName = "Lollipop";
                break;
            case 23:
                versionName = "Marshmallow";
                break;
            case 24:
            case 25:
                versionName = "Nougat";
                break;
            case 26:
            case 27:
                versionName = "Oreo";
                break;
            case 28:
                versionName = "Pie";
                break;
            case 29:
                versionName = "Q";
                break;
            case 30:
                versionName = "R";
                break;
            case 31:
            case 32:
                versionName = "S";
                break;
            default:
                versionName = getString(R.string.unknown);
        }

        TextView versionTextView = findViewById(R.id.version);
        versionTextView.setText(String.format(getString(R.string.codename), versionName));
        versionTextView.append(String.format(Locale.US, getString(R.string.version), Build.VERSION.RELEASE, sdkVersion));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String baseOs = Build.VERSION.BASE_OS;
            if (baseOs.length() > 0) {
                versionTextView.append(String.format(getString(R.string.based_on), baseOs));
            }
            int prevSDK = Build.VERSION.PREVIEW_SDK_INT;
            if (prevSDK != 0) {
                versionTextView.append(String.format(Locale.US, getString(R.string.preview), Build.VERSION.CODENAME, prevSDK));
            }
            versionTextView.append(String.format(getString(R.string.patch), Build.VERSION.SECURITY_PATCH));
        }

        TextView madeByTextView = findViewById(R.id.made_by);
        madeByTextView.setClickable(true);
        madeByTextView.setMovementMethod(LinkMovementMethod.getInstance());
        String text = getString(R.string.made_by) +
                ": <a href='https://www.github.com/mueller-ma'>mueller-ma</a>" +
                getString(R.string.divider) +
                getString(R.string.license) +
                ": <a href='https://www.gnu.org/licenses/gpl-3.0.txt'>GNU GPLv3</a>" +
                getString(R.string.divider) +
                getString(R.string.source_code) +
                ": <a href='https://github.com/mueller-ma/View-android-version'>GitHub</a>";
        madeByTextView.setText(Html.fromHtml(text));
        madeByTextView.append('\n' + getString(R.string.android_trademark));
    }
}
