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
        boolean check = SelectedData.getSelectedData().getPlayer(key);
        Log.e(TAG, "onBindViewHolder: "+position+" "+check );

        holder.cb.setChecked(check);


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
            putPlayer(key,false);
            cb.setChecked(false);
            Toast.makeText(cc, "You Can not Select Max 11 Players.", Toast.LENGTH_SHORT).show();
        }
    }

    void putPlayer(String key, boolean b){
        if (!(SelectedData.getSelectedData().putPlayer(key,b))){
            Toast.makeText(cc, "Max 11 Players.", Toast.LENGTH_SHORT).show();
        }
    }

    void playerCount(SelectedData.Role role,int status){
        switch (role){
            case WK:
                    if(SelectedData.getWicketKeeper() < 4){
                        SelectedData.setWicketKeeper((SelectedData.getWicketKeeper() + status));
                    }
                    else{
                        Toast.makeText(cc, "Max 4 Wicket Keeper.", Toast.LENGTH_SHORT).show();
                    }

                break;
            case BAT:
                    if(SelectedData.getBatsman() < 6){
                        SelectedData.setBatsman((SelectedData.getBatsman() + status));
                    }
                    else{
                        Toast.makeText(cc, "Max 6 Batsman.", Toast.LENGTH_SHORT).show();
                    }

                break;
            case BOWL:
                    if(SelectedData.getBowler() < 6){
                        SelectedData.setBowler((SelectedData.getBowler() + status));
                    }
                    else{
                        Toast.makeText(cc, "Max 6 Bowler.", Toast.LENGTH_SHORT).show();
                    }
                break;
            case ALL:
                    if(SelectedData.getAllRounder() < 6){
                        SelectedData.setAllRounder((SelectedData.getAllRounder() + status));
                    }
                    else{
                        Toast.makeText(cc, "Max 6 all rounder.", Toast.LENGTH_SHORT).show();
                    }
                break;
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
            putPlayer(key,false);
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
                            putPlayer(key,true);
                            playerCount(SelectedData.Role.WK,1);

                        } else {
                            SelectedData.getSelectedData().removePlayer(list.get(position).getId());
                            Save(key, false);
                            putPlayer(key,false);
                            playerCount(SelectedData.Role.WK,-1);
                            cb.setChecked(false);
                        }
                    } else {
                        Log.e(TAG, "updateCheckValues: "+b+" "+value );
//                            d.Remove(mm.getPname());
                        Save(key, false);
                        SelectedData.getSelectedData().removePlayer(list.get(position).getId());
                        putPlayer(key,false);
                        playerCount(SelectedData.Role.WK,-1);
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
                            putPlayer(key,true);
                            playerCount(SelectedData.Role.BAT,1);
                            hello++;
                            bat++;
                            creditPoints++;
                        } else {
                            SelectedData.getSelectedData().removePlayer(list.get(position).getId());
                            Save(key, false);
                            putPlayer(key,false);
                            playerCount(SelectedData.Role.BAT,-1);
                            cb.setChecked(false);
                        }
                    } else {
                        SelectedData.getSelectedData().removePlayer(list.get(position).getId());
                        d.Remove(mm.getPname());
                        Save(key, false);
                        putPlayer(key,false);
                        playerCount(SelectedData.Role.BAT,-1);
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
                            putPlayer(key,true);
                            hello++;
                            all++;
                            creditPoints++;
                            playerCount(SelectedData.Role.ALL,1);
                        } else {
                            SelectedData.getSelectedData().removePlayer(list.get(position).getId());
                            Save(key, false);
                            putPlayer(key,false);
                            cb.setChecked(false);
                            playerCount(SelectedData.Role.ALL,-1);
                            Toast.makeText(cc, "you can select maximum four all rounder.", Toast.LENGTH_SHORT).show();

                        }
                    } else {
                        SelectedData.getSelectedData().removePlayer(list.get(position).getId());
//                            d.Remove(mm.getPname());
                        Save(key, false);
                        putPlayer(key,false);
                        cb.setChecked(false);
                        playerCount(SelectedData.Role.ALL,-1);
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
                            putPlayer(key,true);
                            hello++;
                            bwl++;
                            creditPoints++;
                            playerCount(SelectedData.Role.BOWL,1);
//
                        } else {
                            SelectedData.getSelectedData().removePlayer(list.get(position).getId());
                            Save(key, false);
                            putPlayer(key,false);
                            cb.setChecked(false);
                            playerCount(SelectedData.Role.BOWL,-1);
                            Toast.makeText(cc, "you can select maximum six bowler.", Toast.LENGTH_SHORT).show();

                        }
                    } else {
                        SelectedData.getSelectedData().removePlayer(list.get(position).getId());
//                            d.Remove(mm.getPname());
//                        Save(key,false);
                        cb.setChecked(false);
                        playerCount(SelectedData.Role.BOWL,-1);
                        Toast.makeText(cc, "you can select maximum six bowler.>>>>>>", Toast.LENGTH_SHORT).show();


                    }
                }

            }else {
                SelectedData.getSelectedData().removePlayer(list.get(position).getId());
                Save(key, false);
                putPlayer(key,false);
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


