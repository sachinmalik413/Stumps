package com.aryan.stumps11.CreateTeam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SelectedData {

    private static final SelectedData obj=new SelectedData();
    private SelectedData(){}

    public static SelectedData getSelectedData(){
        return obj;
    }

    private static final HashMap<String,Boolean> map = new HashMap<>();
    private static final List<data> data = new ArrayList<>();

    public List<data> getData(){
        return data;
    }

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

     static class data{
         private String id;
         private String name;
         private String team;
         private String role;
         private String points;

         public data(String id, String name, String team, String role, String points) {
             this.id = id;
             this.name = name;
             this.team = team;
             this.role = role;
             this.points = points;
         }

         public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getTeam() {
            return team;
        }

        public String getRole() {
            return role;
        }

        public String getPoints() {
            return points;
        }
    }
}
