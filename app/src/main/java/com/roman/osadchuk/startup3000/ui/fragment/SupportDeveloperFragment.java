package com.roman.osadchuk.startup3000.ui.fragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.roman.osadchuk.startup3000.R;

import java.util.Timer;

public class SupportDeveloperFragment extends Fragment {

    private AdView adView1, adView2, adView3, adView4, adView5,
            adView6, adView7, adView8, adView9, adView10;

    private Button buttonShowAds;
    private Timer timerAsync;

    private ProgressDialog progressDialog;

    public SupportDeveloperFragment() {
        // Required empty public constructor
    }

    public static SupportDeveloperFragment newInstance() {
        SupportDeveloperFragment fragment = new SupportDeveloperFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_support_developer, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        timerAsync = new Timer();
        progressDialog = new ProgressDialog(getActivity());
        buttonShowAds = view.findViewById(R.id.buttonShowAds);
        buttonShowAds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonShowAds.setVisibility(View.GONE);
                //setAdsVisibility(View.VISIBLE);
                //loadAds(getActivity());
                new LoadAdsAsyncTask().execute();
            }
        });

        adView1 = view.findViewById(R.id.adView1);
        adView2 = view.findViewById(R.id.adView2);
        adView3 = view.findViewById(R.id.adView3);
        adView4 = view.findViewById(R.id.adView4);
        adView5 = view.findViewById(R.id.adView5);
        adView6 = view.findViewById(R.id.adView6);
        adView7 = view.findViewById(R.id.adView7);
        adView8 = view.findViewById(R.id.adView8);
        adView9 = view.findViewById(R.id.adView9);
        adView10 = view.findViewById(R.id.adView10);

        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    private void setAdsVisibility(int visibility) {
        if (visibility == 0 || visibility == 4 || visibility == 8) {
            adView1.setVisibility(visibility);
            adView2.setVisibility(visibility);
            adView3.setVisibility(visibility);
            adView4.setVisibility(visibility);
            adView5.setVisibility(visibility);
            adView6.setVisibility(visibility);
            adView7.setVisibility(visibility);
            adView8.setVisibility(visibility);
            adView9.setVisibility(visibility);
            adView10.setVisibility(visibility);
        }
    }

    public void loadAds(final Activity activity) {
        final Runnable loader = new Runnable() {
            @Override
            public void run() {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        AdRequest adRequest1, adRequest2, adRequest3, adRequest4, adRequest5,
                                adRequest6, adRequest7, adRequest8, adRequest9, adRequest10;

                        adRequest1 = new AdRequest.Builder().build();
                        adRequest2 = new AdRequest.Builder().build();
                        adRequest3 = new AdRequest.Builder().build();
                        adRequest4 = new AdRequest.Builder().build();
                        adRequest5 = new AdRequest.Builder().build();
                        adRequest6 = new AdRequest.Builder().build();
                        adRequest7 = new AdRequest.Builder().build();
                        adRequest8 = new AdRequest.Builder().build();
                        adRequest9 = new AdRequest.Builder().build();
                        adRequest10 = new AdRequest.Builder().build();

                        adView1.loadAd(adRequest1);
                        adView2.loadAd(adRequest2);
                        adView3.loadAd(adRequest3);
                        adView4.loadAd(adRequest4);
                        adView5.loadAd(adRequest5);
                        adView6.loadAd(adRequest6);
                        adView7.loadAd(adRequest7);
                        adView8.loadAd(adRequest8);
                        adView9.loadAd(adRequest9);
                        adView10.loadAd(adRequest10);
                    }
                });
            }
        };

    }

    class LoadAdsAsyncTask extends AsyncTask<Void, Void, Void> {

        private AdRequest adRequest1, adRequest2, adRequest3, adRequest4, adRequest5, adRequest6, adRequest7, adRequest8, adRequest9, adRequest10;

        @Override
        protected void onPreExecute() {
            progressDialog.setMessage("Loading ads...");
            progressDialog.show();
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            adRequest1 = new AdRequest.Builder().addTestDevice("66F37B18FB1DC3A8A331AC234B15F0C2").build();
            adRequest2 = new AdRequest.Builder().addTestDevice("66F37B18FB1DC3A8A331AC234B15F0C2").build();
            adRequest3 = new AdRequest.Builder().addTestDevice("66F37B18FB1DC3A8A331AC234B15F0C2").build();
            adRequest4 = new AdRequest.Builder().addTestDevice("66F37B18FB1DC3A8A331AC234B15F0C2").build();
            adRequest5 = new AdRequest.Builder().addTestDevice("66F37B18FB1DC3A8A331AC234B15F0C2").build();
            adRequest6 = new AdRequest.Builder().addTestDevice("66F37B18FB1DC3A8A331AC234B15F0C2").build();
            adRequest7 = new AdRequest.Builder().addTestDevice("66F37B18FB1DC3A8A331AC234B15F0C2").build();
            adRequest8 = new AdRequest.Builder().addTestDevice("66F37B18FB1DC3A8A331AC234B15F0C2").build();
            adRequest9 = new AdRequest.Builder().addTestDevice("66F37B18FB1DC3A8A331AC234B15F0C2").build();
            adRequest10 = new AdRequest.Builder().addTestDevice("66F37B18FB1DC3A8A331AC234B15F0C2").build();
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            adView1.loadAd(adRequest1);
            adView2.loadAd(adRequest2);
            adView3.loadAd(adRequest3);
            adView4.loadAd(adRequest4);
            adView5.loadAd(adRequest5);
            adView6.loadAd(adRequest6);
            adView7.loadAd(adRequest7);
            adView8.loadAd(adRequest8);
            adView9.loadAd(adRequest9);
            adView10.loadAd(adRequest10);

            progressDialog.hide();
        }
    }
}
