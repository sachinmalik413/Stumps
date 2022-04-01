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

    enum Role{
        WK,BAT,BOWL,ALL
    }

    private static final HashMap<String,Boolean> map = new HashMap<>();
    private static final List<data> data = new ArrayList<>();
    private static final HashMap<String,data> captainMap = new HashMap<>();
    private static int wicketKeeper = 0;
    private static int batsman = 0;
    private static int bowler = 0;
    private static int allRounder = 0;
    private static int credit = 0;
    private static int teamA = 0;
    private static int teamB = 0;

    public int getRoleCount(String role){
        int count = 0;
        for(com.aryan.stumps11.CreateTeam.SelectedData.data data : captainMap.values()){
            if (data.role.equals(role)){
                count ++;
            }
        }
        return count;
    }

    public static int getWicketKeeper() {
        return wicketKeeper;
    }

    public static void setWicketKeeper(int wicketKeeper) {
        SelectedData.wicketKeeper = wicketKeeper;
    }

    public static int getBatsman() {
        return batsman;
    }

    public static void setBatsman(int batsman) {
        SelectedData.batsman = batsman;
    }

    public static int getBowler() {
        return bowler;
    }

    public static void setBowler(int bowler) {
        SelectedData.bowler = bowler;
    }

    public static int getAllRounder() {
        return allRounder;
    }

    public static void setAllRounder(int allRounder) {
        SelectedData.allRounder = allRounder;
    }

    public static int getCredit() {
        return credit;
    }

    public static void setCredit(int credit) {
        SelectedData.credit = credit;
    }

    public static int getTeamA() {
        return teamA;
    }

    public static void setTeamA(int teamA) {
        SelectedData.teamA = teamA;
    }

    public static int getTeamB() {
        return teamB;
    }

    public static void setTeamB(int teamB) {
        SelectedData.teamB = teamB;
    }

    public HashMap<String,data> getData(){
        return captainMap;
    }

    public void removePlayer(String key){
        captainMap.remove(key);
    }

    public boolean getPlayer(String key){
        if (map.containsKey(key)){
            return map.get(key);
        }
        else{
            return false;
        }
    }

    public void clearData(){
        map.clear();
        data.clear();
    }

    public boolean putPlayer(String key, boolean b){
        if (map.size()<12){
            map.put(key,b);
            return true;
        }
        else{
            return false;
        }

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
