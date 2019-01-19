package com.example.rathana.navigationdrawer_demo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DownloadFragment extends Fragment {

    static DownloadFragment downloadFragment;
    public static DownloadFragment newInstance(){
        if(downloadFragment==null)
            downloadFragment=new DownloadFragment();
        return downloadFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_download,container,false);
    }
}
