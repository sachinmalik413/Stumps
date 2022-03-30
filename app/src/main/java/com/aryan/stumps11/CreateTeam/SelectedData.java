package com.aryan.stumps11.CreateTeam;

import java.util.HashMap;

public class SelectedData {

    private static final SelectedData obj=new SelectedData();
    private SelectedData(){}

    public static SelectedData getSelectedData(){
        return obj;
    }

    private static HashMap<String,Boolean> map = new HashMap<>();

    public boolean getPlayer(String key){
        if (map.containsKey(key)){
            return map.get(key);
        }
        else{
            return false;
        }
    }

    public void putPlayer(String key, boolean b){
        map.put(key,b);
    }

}
