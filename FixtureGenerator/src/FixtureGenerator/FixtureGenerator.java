package FixtureGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class FixtureGenerator {
    ArrayList<String> teams;
    ArrayList<String> matches;


    public void game(){
        Scanner input = new Scanner(System.in);
        System.out.println("Yeterli takım sayısı girildiğinde 0'a basın.");
        ArrayList<String> teamss = new ArrayList<>();
        ArrayList<String> matchess = new ArrayList<>();

        while (true){
            System.out.print("Takımları giriniz : ");
            String teamName = input.next();
            if(Objects.equals(teamName, "0")){
                break;
            }
            else{
                teamss.add(teamName);
            }
        }
        if(teamss.size()%2==1){
            teamss.add("Bay");
        }

        setTeams(teamss);
        System.out.println(getTeams());


        for(int i= 0; i<getTeams().size() ; i++){
            for(int j = 0 ; j<getTeams().size(); j++){

                if(i!=j){
                    String str = getTeams().get(i)+" vs "+getTeams().get(j);
                    matchess.add(str);
                }
            }
        }
        setMatches(matchess);
        int totalMatch = getTeams().size()*(getTeams().size()-1);
        int totalWeek = totalMatch/(getTeams().size()/2);

        int j = getMatches().size();
        int a = 0;
        int swift= 1;

        int week = 1;
        for (int k=0; k<totalWeek ; k++,week++){
            System.out.println("\nWeek "+week+" -----------");
            for (int i=0; i<getTeams().size()/2 ; i++,j--,a++,swift++){
                if(swift%2==1){
                    System.out.println(getMatches().get(a));
                }else{
                    System.out.println(getMatches().get(j));
                }
            }
        }
    }

    public ArrayList<String> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<String> teams) {
        this.teams = teams;
    }

    public ArrayList<String> getMatches() {
        return matches;
    }

    public void setMatches(ArrayList<String> matches) {
        this.matches = matches;
    }
}