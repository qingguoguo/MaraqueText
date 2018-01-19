package com.qingguoguo.maraquetext;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView viewById = (TextView) findViewById(R.id.marqueTextView);

        viewById.setText(stringToSpannableString(String.format(getString(R.string.string_hint_goto_room), "10:00-11:00")));
        viewById.setText(String.format(getResources().getString(R.string.book),"金瓶梅", "西门庆", 2249, 88.3f));
        viewById.setSelected(true);
    }

    private CharSequence stringToSpannableString(String source) {
        SpannableString spannableString = new SpannableString(source);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#223f42")), 0, spannableString.length() - 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new UnderlineSpan(), spannableString.length() - 5, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#01b7ca")), spannableString.length() - 5, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
    }

    public void btnClick(View view) {
        startActivity(new Intent(this,ListViewTestActivity.class));
    }
}
