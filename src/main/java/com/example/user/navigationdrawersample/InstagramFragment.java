package com.example.user.navigationdrawersample;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class InstagramFragment extends Fragment {

@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_instagram, container, false);

        final WebView web = (WebView) view.findViewById(R.id.webV);
        web.setWebViewClient(new WebViewClient());
        web.loadUrl("https://www.instagram.com/");
        final Button btn = (Button) view.findViewById(R.id.searchBtn);
        final EditText et = (EditText) view.findViewById(R.id.SVbox);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                web.loadUrl(et.getText().toString());
            }
        });
        return view;

    }
}