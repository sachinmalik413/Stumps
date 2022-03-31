package com.aryan.stumps11.CreateTeam;

import static android.content.Context.MODE_PRIVATE;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.aryan.stumps11.Adapters.TabAdapter;
import com.aryan.stumps11.Extra.CommonData;
import com.aryan.stumps11.Model.ModelClass;
import com.aryan.stumps11.R;
import com.aryan.stumps11.api_integration.OnClick;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class CreateTeamAdapter extends RecyclerView.Adapter<CreateTeamAdapter.ViewHolder> {
    Context cc;
    List<ModelClass>list;
    String mobile;
    static int crept;
    int hello,wk,bat,all,bwl,creditPoints;
    static int addCreditPoint;
    private SharedPreferences sp;
    OnClick onClick;
    int count=0,full=0,countrycount=0;
    double creditcount;
    private db d;
    private String TAG = "sachin";


    public CreateTeamAdapter(Context cc, List<ModelClass> list,OnClick onClick) {
        this.cc = cc;
        this.list = list;
        this.onClick=onClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(cc);
        View view=layoutInflater.inflate(R.layout.playerlayout,null);
        return new ViewHolder(view);
    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
//        ModelClass mm = list.get(position);
//        DataBase db = new DataBase(cc);
//        SharedPreferences mob = cc.getSharedPreferences("Mobile", MODE_PRIVATE);
//        mobile = mob.getString("mKey", "0");
//
//        Glide.with(cc).load(list.get(position).getImages());
//        holder.ttcountry.setText(list.get(position).getTname());
//        holder.ttcredits.setText(list.get(position).getCredits());
//        holder.ttpts.setText(list.get(position).getPts());
//        holder.ttstatus.setText(list.get(position).getStatus());
//        holder.ttname.setText(list.get(position).getPname());
//        String key = "Hello" + list.get(position).getPname() + position;
//        holder.cb.setChecked(Update(key));

//        holder.cb.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                if (hello == 11 || hello >= 11) {
//                    Toast.makeText(cc, "Player Length is greater than 11", Toast.LENGTH_SHORT).show();
//                }
//
//                if (hello > 11) {
//                    Toast.makeText(cc, "Player Length is greater than 11", Toast.LENGTH_SHORT).show();
//                } else {
//
//
//                    SharedPreferences mob = cc.getSharedPreferences("wk", MODE_PRIVATE);
//                    String role = mob.getString("mKey", "0");
//
//
//                    sp = cc.getSharedPreferences("Counts", MODE_PRIVATE);
//
//                    hello = sp.getInt("Key", 0);
//                    wk = sp.getInt("wKey", db.getwK("wk"));
//                    bat = sp.getInt("bKey", db.getwK("bat"));
//                    all = sp.getInt("aKey", db.getwK("all"));
//                    bwl = sp.getInt("bwlKey", db.getwK("bwl"));
//                    creditPoints = sp.getInt("creditPoints", crept);
//                }
//
//            }
///*                if (holder.cb.isChecked()) {
//                    Save(key, true);*/
////                    db.AddPlayer(list.get(position).getId(),mobile,list.get(position).getPname(),list.get(position).getTname(),list.get(position).getRole(),list.get(position).getPts(),list.get(position).getCredits(),null,null);
//            //    Toast.makeText(cc, "Player "+list.get(position).getPname(), Toast.LENGTH_SHORT).show();
//
//            /* if (list.get(position).getRole().equals("wk")) {
//             */     /*if (wk < 1 || wk >= 4) {
//
//                            Toast.makeText(cc, "only four wicket keeper select", Toast.LENGTH_SHORT).show();
////                            holder.cb.setBackgroundColor(Color.WHITE);
//
////                            h
//                            holder.cb.setChecked(false);
//                            holder.rr.setClickable(false);
//                            //    wk=sp.getInt("wKey",0);
//
//                            //Toast.makeText(cc, "Player "+list.get(position), Toast.LENGTH_SHORT).show();
//                        } else if (hello == 11 || hello >= 11) {
//
//                            holder.cb.setChecked(false);
//                            holder.rr.setClickable(false);
//                            ;
//                            Toast.makeText(cc, "You Does't Select More Than 11 Player  " + hello, Toast.LENGTH_SHORT).show();
//
//                        }*/
////                    }
//                        /*if(wk>=4){
//                            holder.cb.setChecked(false);
//                            holder.rr.setClickable(false);
//                            Toast.makeText(cc, "Only 4 Wk Select  " + hello, Toast.LENGTH_SHORT).show();
//                            Save(key,false);
//                        } else if(hello>=11){
//                            holder.cb.setChecked(false);
//                            holder.rr.setClickable(false);
//
//                            Toast.makeText(cc, "you doesn't select more than 11" + hello, Toast.LENGTH_SHORT).show();
//
//
//                        } else {
//                            db.AddPlayer(list.get(position).getId(), mobile, list.get(position).getPname(), list.get(position).getTname(), list.get(position).getRole(), list.get(position).getPts(), list.get(position).getCredits(), null, null);
//                            hello++;
//                            wk++;
//                            creditPoints++;
//
//*/
//
//
////                            try {
////
////                                String cp = list.get(position).getCredits();
////                                crept = Integer.parseInt(cp);
////                                ArrayList<Integer> addCredit = new ArrayList<Integer>();
////                                addCredit.add(crept);
////
////                                for (int totalCredit : addCredit) {
////                                    addCreditPoint += totalCredit;
//////                                    Toast.makeText(cc, "i<<<"+addCreditPoint, Toast.LENGTH_SHORT).show();
////
////
////                                }
////
////                                Intent intent = new Intent("custom-message");
////                                //            intent.putExtra("quantity",Integer.parseInt(quantity.getText().toString()));
////                                intent.putExtra("c", addCreditPoint);
//////                                    intent.putExtra("item",ItemName);
////                                LocalBroadcastManager.getInstance(cc).sendBroadcast(intent);
////
////
////                            } catch (Exception e) {
////                                e.printStackTrace();
////                            }
//
//            //                                Toast.makeText(cc, "You select "+hello, Toast.LENGTH_SHORT).show();
//
//
////                            holder.rr.setBackgroundColor(Color.WHITE);
//
//
//            //}
//
//
//            // bast man logic
///*
//                if (list.get(position).getRole().equals("bat")) {
//                        */
///*if (bat == 6 || bat > 6) {
//
//                            Toast.makeText(cc, "only six bastman select", Toast.LENGTH_SHORT).show();
//                            holder.cb.setChecked(false);
//                            holder.rr.setClickable(false);
//
//
//                        }*//*
//
//                    if (bat >= 6) {
//
//                        Toast.makeText(cc, "only six batsman select", Toast.LENGTH_SHORT).show();
//                        holder.cb.setChecked(false);
//                        holder.rr.setClickable(false);
//                        Save(key, false);
//                    } else if (hello >= 11) {
//                        holder.cb.setChecked(false);
//                        holder.rr.setClickable(false);
//
//                        Toast.makeText(cc, "you doesn't select more than 11" + hello, Toast.LENGTH_SHORT).show();
//
//
//                    } else {
//                        holder.rr.setBackgroundColor(ContextCompat.getColor(cc, R.color.PlayerSelected));
//                        db.AddPlayer(list.get(position).getId(), mobile, list.get(position).getPname(), list.get(position).getTname(), list.get(position).getRole(), list.get(position).getPts(), list.get(position).getCredits(), null, null);
//                        hello++;
//                        bat++;
//                        creditPoints++;
////                            Toast.makeText(cc, "You select "+hello, Toast.LENGTH_SHORT).show();
//                    }
//
//                    if (list.get(position).getRole().equals("all")) {
//
//                        */
///*if (all < 1 || all > 6) {
//
//                            Toast.makeText(cc, "only 4  all rounder  select", Toast.LENGTH_SHORT).show();
//                            holder.cb.setChecked(false);
//                            holder.rr.setClickable(false);
//                            Save(key,false);
//
//
//                        }
//
//                        if (all >= 6) {
//
//                            Toast.makeText(cc, "only 4  all rounder  select", Toast.LENGTH_SHORT).show();
//                            holder.cb.setChecked(false);
//                            holder.rr.setClickable(false);
//                            Save(key,false);
//
//
//                        }
//                        else if(hello>=11){
//                            holder.cb.setChecked(false);
//                            holder.rr.setClickable(false);
//
//                            Toast.makeText(cc, "you doesn't select more than 11" + hello, Toast.LENGTH_SHORT).show();
//
//
//                        }
//                         else {
//                            holder.rr.setBackgroundColor(ContextCompat.getColor(cc, R.color.PlayerSelected));
//                            db.AddPlayer(list.get(position).getId(), mobile, list.get(position).getPname(), list.get(position).getTname(), list.get(position).getRole(), list.get(position).getPts(), list.get(position).getCredits(), null, null);
//
//                            hello++;
//                            all++;
//                            creditPoints++;
//
//
//
//
////                            holder.rr.setBackgroundColor(ContextCompat.getColor(cc,R.color.PlayerSelected));
////                            db.AddPlayer(list.get(position).getId(),mobile,list.get(position).getPname(),list.get(position).getTname(),list.get(position).getRole(),list.get(position).getPts(),list.get(position).getCredits(),null,null);
////
////                            hello++;
////                            all++;
////                            creditPoints++;
//
////                            Toast.makeText(cc, "You select "+hello, Toast.LENGTH_SHORT).show();
//
//
//                    }
//
//                    }
//                    if(list.get(position).getRole().equals("bowl")){
//                        if (bwl<1 || bwl>6 ){
//
//                            Toast.makeText(cc,"only 6  bowler  select",Toast.LENGTH_SHORT).show();
//                            holder.cb.setChecked(false);
//                            holder.rr.setClickable(false);
//                            Save(key,false);
//
//                        }/*else if(hello==11 || hello>=11){
//                                holder.cb.setChecked(false);
//                                holder.rr.setClickable(false);
//                                Toast.makeText(cc, "You Does not  Select More Than 11 Player  "+hello, Toast.LENGTH_SHORT).show();
//
//                            }
//
//                        else if(hello>=11){
//                            holder.cb.setChecked(false);
//                            holder.rr.setClickable(false);
//
//                            Toast.makeText(cc, "you doesn't select more than 11" + hello, Toast.LENGTH_SHORT).show();
//                        }
//                        else{
//
////                            Toast.makeText(cc, "You select "+hello, Toast.LENGTH_SHORT).show();
//
//                            }
//
//
//                        }
//
//
//
//                }
//                else {
//                    Save(key, false);
//                    holder.rr.setBackgroundColor(Color.WHITE);
//                    db.RemovePlayer(mobile, list.get(position).getId());
//                    hello--;
//                    if(list.get(position).getRole().equals("wk")){
//
//                        wk--;
//                        creditPoints--;
//                        Toast.makeText(cc, ""+wk, Toast.LENGTH_SHORT).show();
//                    }
//                    if(list.get(position).getRole().equals("bat")){
//                        bat--;
//                        creditPoints--;
//                        Toast.makeText(cc, ""+bat, Toast.LENGTH_SHORT).show();
//                    }
//                    if(list.get(position).getRole().equals("all")){
//                        all--;
//                        creditPoints--;
//                        Toast.makeText(cc, ""+all, Toast.LENGTH_SHORT).show();
//                    }
//                    if(list.get(position).getRole().equals("bowl")){
//                        bwl--;
//                        creditPoints--;
//                        Toast.makeText(cc, ""+bwl, Toast.LENGTH_SHORT).show();
//                    }
//                }
//                SharedPreferences.Editor editor1=sp.edit();
//                editor1.putInt("Key",hello);
//                editor1.putInt("wKey",wk);
//                editor1.putInt("bKey",bat);
//                editor1.putInt("aKey",all);
//                editor1.putInt("bwlKey",bwl);
//                editor1.putInt("creditPoints",creditPoints);
//                editor1.commit();
////                editor1.clear();
////                editor1.apply();
//            }
//        });
//        if(holder.cb.isChecked()){
//            holder.rr.setBackgroundColor(ContextCompat.getColor(cc,R.color.PlayerSelected));
//        }
//        else {
//            holder.rr.setBackgroundColor(Color.WHITE);
//        }
//
//    }
//

///
//
////
//        }
//    }




    //-------------------------------------

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        ModelClass mm=list.get(position);
        DataBase db = new DataBase(cc);
        db d=new db(cc);
        SharedPreferences mob = cc.getSharedPreferences("Mobile", MODE_PRIVATE);
        mobile = mob.getString("mKey", "0");
        String key = "Hello" + list.get(position).getPname() + position;
        Glide.with(cc).load(list.get(position).getImages());
        holder.ttcountry.setText(list.get(position).getTname());
        holder.ttcredits.setText(list.get(position).getCredits());
        holder.ttpts.setText(list.get(position).getPts());
        holder.ttstatus.setText(list.get(position).getStatus());
        holder.ttname.setText(list.get(position).getPname());
        //boolean check = Update(list.get(position).getPname());
        boolean check = SelectedData.getSelectedData().getPlayer(key);
        Log.e(TAG, "onBindViewHolder: "+position+" "+check );
        //holder.cb.setOnCheckedChangeListener(null);

        holder.cb.setChecked(check);
//        holder.cb.setChecked(Update(key));

        /*holder.cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                updateCheckValues((!check),position,holder.cb,holder.rr);


            }
        });*/





        /*holder.cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {



                }



        });*/


//        holder.cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                SharedPreferences sp=cc.getSharedPreferences("Counts",Context.MODE_PRIVATE);
////                hello=sp.getInt("Key",0);
////                wk=sp.getInt("wKey",0);
////                bat=sp.getInt("bKey",0);
////                all=sp.getInt("aKey",0);
////                bwl=sp.getInt("bwlKey",0);
//
////
////                wk=sp.getInt("wKey",d.getCountRole("wk"));
////                bat=sp.getInt("bKey",d.getCountRole("bat"));
////                all=sp.getInt("aKey",d.getCountRole("all"));
////                bwl=sp.getInt("bwlKey",d.getCountRole("bwl"));
//
//
//                 if(list.get(position).getRole().equals("wk")){
//                   int value= fun(d,1,key,holder.cb,"wk");
//
//
//                    if(value<4 && b==true){
//
//                        fun11(d,key,holder.cb,11);
//                        fun7(d,7,key,holder.cb,list.get(position).getCountry());
//
//                        fun100(d);
//                        d.CountRole("wk");
//
//
//
//                        if((count<1 && full<11) || countrycount<7){
//
//                            d.Save(list.get(position).getPname(),list.get(position).getRole(),list.get(position).getCountry(),list.get(position).getPname1());
//                          //  Save(key,true);
//                        }
//
//                        else {
//                            Save(key,false);
//                            holder.cb.setChecked(false);
//                        }
//                    }
//
//                    else {
//                        d.Remove(mm.getPname());
//                    //    Save(key,false);
//                        holder.cb.setChecked(false);
////                            cb.setChecked(false);
//                            Toast.makeText(cc, "you can select maximum four wicket keeper.", Toast.LENGTH_SHORT).show();
//
//                    }
//
//
//                }
//
//                if(list.get(position).getRole().equals("bat")){
//                    int value= fun(d,6,key,holder.cb,"bat");
//
//                    if(value<6 && b==true){
//                        fun11(d,key,holder.cb,11);
//                        fun7(d,7,key,holder.cb,list.get(position).getCountry());
//
//                        fun100(d);
//
//                        if((count<6 && full<11) || countrycount<7){
//                            d.Save(list.get(position).getPname(),list.get(position).getRole(),list.get(position).getCountry(),list.get(position).getPoints());
//                       //     Save(key,true);
//                        }
//                        else {
//                            Save(key,false);
//                            holder.cb.setChecked(false);
//                        }
//                    }
//
//                    else {
//                        d.Remove(mm.getPname());
//                     //   Save(key,false);
//                        holder.cb.setChecked(false);
//                        Toast.makeText(cc, "you can select maximum six batsman", Toast.LENGTH_SHORT).show();
//
//                    }
//                }
//
//                if(list.get(position).getRole().equals("all")){
//                  int value=  fun(d,6,key,holder.cb,"all");
//
//                    if(value<4 && b==true){
//                        fun11(d,key,holder.cb,11);
//                        fun100(d);
//                        fun7(d,7,key,holder.cb,list.get(position).getCountry());
//                        if((count<6 && full<11) || countrycount<7){
//                            d.Save(list.get(position).getPname(),list.get(position).getRole(),list.get(position).getCountry(),list.get(position).getPoints());
//                     //       Save(key,true);
//                        }
//                        else {
//                            Save(key,false);
//                            holder.cb.setChecked(false);
//                            Toast.makeText(cc, "you can select maximum four all rounder.", Toast.LENGTH_SHORT).show();
//
//                        }
//                    }
//                    else {
//                        d.Remove(mm.getPname());
//                    //    Save(key,false);
//                        holder.cb.setChecked(false);
//                        Toast.makeText(cc, "you can select maximum four all rounder.", Toast.LENGTH_SHORT).show();
//
//
//                    }
//                }
//
//                if(list.get(position).getRole().equals("bowl")){
//                    int value =fun(d,6,key,holder.cb,"bowl");
//
//                    if(value<6 && b==true){
//                        fun100(d);
//                        fun11(d,key,holder.cb,11);
//                        fun7(d,7,key,holder.cb,list.get(position).getCountry());
//
//                        if((count<6 && full<11) || countrycount<7){
//                            d.Save(list.get(position).getPname(),list.get(position).getRole(),list.get(position).getCountry(),list.get(position).getPoints());
//                       //     Save(key,true);
////
//                        }
//                        else {
//                          //  Save(key,false);
//                            holder.cb.setChecked(false);
//                            Toast.makeText(cc, "you can select maximum six bowler.", Toast.LENGTH_SHORT).show();
//
//                        }
//                    }
//
//                    else {
//                        d.Remove(mm.getPname());
////                        Save(key,false);
//                        holder.cb.setChecked(false);
//                        Toast.makeText(cc, "you can select maximum six bowler.>>>>>>", Toast.LENGTH_SHORT).show();
//
//
//                    }
//                }
//
//                wk=sp.getInt("wKey",d.getCountRole("wk"));
//                bat=sp.getInt("bKey",d.getCountRole("bat"));
//                all=sp.getInt("aKey",d.getCountRole("all"));
//                bwl=sp.getInt("bwlKey",d.getCountRole("bwl"));
//
//
//                SharedPreferences.Editor editor1=sp.edit();
//                editor1.putInt("Key",hello);
//                editor1.putInt("wKey",wk);
//                editor1.putInt("bKey",bat);
//                editor1.putInt("aKey",all);
//                editor1.putInt("bwlKey",bwl);
//                editor1.putInt("creditPoints",creditPoints);
//                editor1.commit();
//             //   editor1.clear();
//                editor1.apply();
//            }
//        });

        if(holder.cb.isChecked()){
            holder.rr.setBackgroundColor(ContextCompat.getColor(cc,R.color.PlayerSelected));
        }
        else {
            holder.rr.setBackgroundColor(Color.WHITE);
        }



    }
    void fun11(db d,String key,CheckBox cb,int c){
        Cursor cc1=d.FullCount();
        cc1.moveToFirst();

        do{
            full=cc1.getCount();
        }while (cc1.moveToNext());

        if(full==c){
            Save(key,false);
            SelectedData.getSelectedData().putPlayer(key,false);
            cb.setChecked(false);
            Toast.makeText(cc, "You Can not Select Max 11 Players.", Toast.LENGTH_SHORT).show();
        }
    }

    void fun100(db d){
        Cursor cc1=d.Sum_of_Credits();
        cc1.moveToFirst();

        do{
            creditcount=cc1.getDouble(0);
        }while (cc1.moveToNext());

        if(creditcount>100){
            /*Save(key,false);
            cb.setChecked(false);
            */
            Toast.makeText(cc, "100 Credits Reached.", Toast.LENGTH_SHORT).show();
        }
        if(creditcount>100){
            /*Save(key,false);
            cb.setChecked(false);
            */
            Toast.makeText(cc, "100 Credits not Reached.", Toast.LENGTH_SHORT).show();
        }
    }


    int fun(db d,int c,String key,CheckBox cb,String role){
        Cursor cc1=d.CountRole(role);
        cc1.moveToFirst();

        do{
            count=cc1.getCount();
        }while (cc1.moveToNext());

//        if(count==c){
//            Save(key,false);
//            cb.setChecked(false);
//            Toast.makeText(cc, "Sorry You are Not Eligible.", Toast.LENGTH_SHORT).show();
//        }
        return count;
    }

    void fun7(db d,int c,String key,CheckBox cb,String Country){
        Cursor cc1=d.CountCountry(Country);
        cc1.moveToFirst();

        do{
            countrycount=cc1.getCount();
        }while (cc1.moveToNext());

        if(countrycount==c){
            Save(key,false);
            SelectedData.getSelectedData().putPlayer(key,false);
            cb.setChecked(false);
            Toast.makeText(cc, "You Can not Select all Players From a Team.", Toast.LENGTH_SHORT).show();
        }
    }


    public void Save(String Key,boolean value){
        SharedPreferences sp=cc.getSharedPreferences("Preference", MODE_PRIVATE);
        SharedPreferences.Editor editor1=sp.edit();
        editor1.putBoolean(Key,value);
        editor1.apply();
    }


    public boolean Update(String Key){
        SharedPreferences sp=cc.getSharedPreferences("Preference", MODE_PRIVATE);
        boolean kk=sp.getBoolean(Key,false);
        return kk;
//        d=new db(cc);
//         boolean bq= d.getChecked(Key);
//
//
//        return bq;
    }





    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onViewRecycled(@NonNull ViewHolder holder) {
        if (holder.cb != null) {
            holder.cb.setOnClickListener(null);
        }
        super.onViewRecycled(holder);
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView ii;
        CheckBox cb;
        TextView ttname,ttstatus,ttpts,ttcredits,ttcountry;
        RelativeLayout rr;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rr=itemView.findViewById(R.id.PlayerLayout);
            cb=itemView.findViewById(R.id.checkBox);
//            ii=itemView.findViewById(R.id.imageView22);
            ttname=itemView.findViewById(R.id.textView54);
            ttstatus=itemView.findViewById(R.id.textView64);
            ttpts=itemView.findViewById(R.id.textView65);
            ttcredits=itemView.findViewById(R.id.textView66);
 ;           ttcountry=itemView.findViewById(R.id.textView68);
            cb.setOnClickListener(this);
        }



        @Override
        public void onClick(View view) {
            String key = "Hello" + list.get(getAdapterPosition()).getPname() + getAdapterPosition();
            boolean check = SelectedData.getSelectedData().getPlayer(key);
            updateCheckValues((!check),getAdapterPosition(),cb,rr);
        }
    }

    void updateCheckValues(boolean b, int position, CheckBox cb, RelativeLayout rr){

            Log.e(TAG, "onCheckedChanged: "+position );
            ModelClass mm=list.get(position);
            DataBase db = new DataBase(cc);
            db d=new db(cc);

            String key = "Hello" + list.get(position).getPname() + position;

            if (hello==11 || hello>=11){
                Toast.makeText(cc, "Player Length is greater than 11", Toast.LENGTH_SHORT).show();
            }else{
                sp=cc.getSharedPreferences("Counts",Context.MODE_PRIVATE);
                hello=sp.getInt("Key",0);
                wk=sp.getInt("wKey",d.getCountRole("wk"));
                bat=sp.getInt("bKey",d.getCountRole("bat"));
                all=sp.getInt("aKey",d.getCountRole("all"));
                bwl=sp.getInt("bwlKey",d.getCountRole("bowl"));
                creditPoints= sp.getInt("creditPoints", crept);


            }

            if (cb.isChecked()) {
                if (list.get(position).getRole().equals("wk")) {
                    int value = fun(d, 1, key, cb, "wk");


                    if (wk < 4 && b == true) {

                        fun11(d, key, cb, 11);
                        fun7(d, 7, key, cb, list.get(position).getCountry());

                        fun100(d);


                        if ((count < 1 && full < 11) || countrycount < 7) {

                            d.Save(list.get(position).getPname(), list.get(position).getRole(), list.get(position).getCountry(), list.get(position).getPname1());
                            SelectedData.getSelectedData().getData().put(list.get(position).getId(),new SelectedData.data(list.get(position).getId(),list.get(position).getPname(),list.get(position).getTname1(),list.get(position).getRole(),list.get(position).getPname1()));
                            //SelectedData.getSelectedData().getData().add(new SelectedData.data(list.get(position).getId(),list.get(position).getPname(),list.get(position).getTname1(),list.get(position).getRole(),list.get(position).getPname1()));
                            hello++;
                            wk++;
                            creditPoints++;
                            Save(key, true);
                            SelectedData.getSelectedData().putPlayer(key,true);

                        } else {
                            Save(key, false);
                            SelectedData.getSelectedData().putPlayer(key,false);
                            cb.setChecked(false);
                        }
                    } else {
                        Log.e(TAG, "updateCheckValues: "+b+" "+value );
//                            d.Remove(mm.getPname());
                        Save(key, false);
                        SelectedData.getSelectedData().putPlayer(key,false);
                        cb.setChecked(false);
                        Toast.makeText(cc, "you can select maximum four wicket keeper.", Toast.LENGTH_SHORT).show();

                    }


                }

                if (list.get(position).getRole().equals("bat")) {
                    int value = fun(d, 6, key, cb, "bat");

                    if (bat < 6 && b == true) {
                        fun11(d, key, cb, 11);
                        fun7(d, 7, key, cb, list.get(position).getCountry());

                        fun100(d);

                        if ((count < 6 && full < 11) || countrycount < 7) {
                            d.Save(list.get(position).getPname(), list.get(position).getRole(), list.get(position).getCountry(), list.get(position).getPoints());
                            SelectedData.getSelectedData().getData().put(list.get(position).getId(),new SelectedData.data(list.get(position).getId(),list.get(position).getPname(),list.get(position).getTname1(),list.get(position).getRole(),list.get(position).getPname1()));
                            Save(key, true);
                            SelectedData.getSelectedData().putPlayer(key,true);
                            hello++;
                            bat++;
                            creditPoints++;
                        } else {
                            Save(key, false);
                            SelectedData.getSelectedData().putPlayer(key,false);
                            cb.setChecked(false);
                        }
                    } else {
                        d.Remove(mm.getPname());
                        Save(key, false);
                        SelectedData.getSelectedData().putPlayer(key,false);
                        cb.setChecked(false);
                        Toast.makeText(cc, "you can select maximum six batsman", Toast.LENGTH_SHORT).show();

                    }
                }

                if (list.get(position).getRole().equals("all")) {
                    int value = fun(d, 6, key, cb, "all");

                    if (all < 4 && b == true) {
                        fun11(d, key, cb, 11);
                        fun100(d);
                        fun7(d, 7, key, cb, list.get(position).getCountry());
                        if ((count < 6 && full < 11) || countrycount < 7) {
                            d.Save(list.get(position).getPname(), list.get(position).getRole(), list.get(position).getCountry(), list.get(position).getPoints());
                            SelectedData.getSelectedData().getData().put(list.get(position).getId(),new SelectedData.data(list.get(position).getId(),list.get(position).getPname(),list.get(position).getTname1(),list.get(position).getRole(),list.get(position).getPname1()));
                            Save(key, true);
                            SelectedData.getSelectedData().putPlayer(key,true);
                            hello++;
                            all++;
                            creditPoints++;
                        } else {
                            Save(key, false);
                            SelectedData.getSelectedData().putPlayer(key,false);
                            cb.setChecked(false);
                            Toast.makeText(cc, "you can select maximum four all rounder.", Toast.LENGTH_SHORT).show();

                        }
                    } else {
//                            d.Remove(mm.getPname());
                        Save(key, false);
                        SelectedData.getSelectedData().putPlayer(key,false);
                        cb.setChecked(false);
                        Toast.makeText(cc, "you can select maximum four all rounder.", Toast.LENGTH_SHORT).show();


                    }
                }

                if (list.get(position).getRole().equals("bowl")) {
                    int value = fun(d, 6, key, cb, "bowl");

                    if (bwl < 6 && b == true) {
                        fun100(d);
                        fun11(d, key, cb, 11);
                        fun7(d, 7, key, cb, list.get(position).getCountry());

                        if ((count < 6 && full < 11) || countrycount < 7) {
                            d.Save(list.get(position).getPname(), list.get(position).getRole(), list.get(position).getCountry(), list.get(position).getPoints());
                            SelectedData.getSelectedData().getData().put(list.get(position).getId(),new SelectedData.data(list.get(position).getId(),list.get(position).getPname(),list.get(position).getTname1(),list.get(position).getRole(),list.get(position).getPname1()));
                            Save(key, true);
                            SelectedData.getSelectedData().putPlayer(key,true);
                            hello++;
                            bwl++;
                            creditPoints++;
//
                        } else {
                            Save(key, false);
                            SelectedData.getSelectedData().putPlayer(key,false);
                            cb.setChecked(false);
                            Toast.makeText(cc, "you can select maximum six bowler.", Toast.LENGTH_SHORT).show();

                        }
                    } else {
//                            d.Remove(mm.getPname());
//                        Save(key,false);
                        cb.setChecked(false);
                        Toast.makeText(cc, "you can select maximum six bowler.>>>>>>", Toast.LENGTH_SHORT).show();


                    }
                }

            }else {
                Save(key, false);
                SelectedData.getSelectedData().putPlayer(key,false);
                rr.setBackgroundColor(Color.WHITE);
                db.RemovePlayer(mobile, list.get(position).getId());
                hello--;
                if(list.get(position).getRole().equals("wk")){
                    wk--;
                    Toast.makeText(cc, ""+wk, Toast.LENGTH_SHORT).show();
                }
                if(list.get(position).getRole().equals("bat")){
                    bat--;
                    Toast.makeText(cc, ""+bat, Toast.LENGTH_SHORT).show();
                }
                if(list.get(position).getRole().equals("all")){
                    all--;
                    Toast.makeText(cc, ""+all, Toast.LENGTH_SHORT).show();
                }
                if(list.get(position).getRole().equals("bowl")){
                    bwl--;
                    Toast.makeText(cc, ""+bwl, Toast.LENGTH_SHORT).show();
                }
            }
            SharedPreferences.Editor editor1=sp.edit();
            editor1.putInt("Key",hello);
            editor1.putInt("wKey",wk);
            editor1.putInt("bKey",bat);
            editor1.putInt("aKey",all);
            editor1.putInt("bwlKey",bwl);
            editor1.putInt("creditPoints",creditPoints);
//                editor1.clear();
            editor1.apply();

    }
        }


