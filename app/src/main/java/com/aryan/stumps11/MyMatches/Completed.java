package com.aryan.stumps11.MyMatches;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aryan.stumps11.Adapters.MyMatchesAdapter;
import com.aryan.stumps11.Model.ModelClass;
import com.aryan.stumps11.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Completed#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Completed extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Completed() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Completed.
     */
    // TODO: Rename and change types and number of parameters
    public static Completed newInstance(String param1, String param2) {
        Completed fragment = new Completed();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_completed, container, false);
        RecyclerView rr=view.findViewById(R.id.CView);
        rr.setLayoutManager(new LinearLayoutManager(getContext()));
        rr.setHasFixedSize(true);
        List<ModelClass> list=new ArrayList<>();
        ModelClass mm=new ModelClass();
        mm.setTmimage1(R.drawable.image);
        mm.setTmimage2(R.drawable.image);
        mm.setSmname("Hello");
        mm.setTmname1("Bye");
        mm.setTmname2("Hye");
        mm.setStatus("Completed");
        list.add(mm);
        MyMatchesAdapter ma=new MyMatchesAdapter(getActivity(),list);
        rr.setAdapter(ma);
        return view;
    }
}