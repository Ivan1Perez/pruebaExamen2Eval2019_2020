package modelB;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class CountryFinalist extends Country implements Comparable<CountryFinalist> {

    private int score;
    private Set<CountryFinalist> voted;

    public CountryFinalist(String name){
        super(name);
        this.score = 0;
        voted = new HashSet<>();
    }

    public int getScore(){
        return score;
    }

    public void addScore(int points){
        this.score += points;
    }

    public void vote(ArrayList<CountryFinalist> countries){

        int i;
        for(int voto : Main.SCORES){

            do{
                i = (int) (Math.random() * countries.size());
            }while(countries.get(i) == this || voted.contains(countries.get(i)));

            countries.get(i).addScore(voto);
            voted.add(countries.get(i));

        }
    }

    @Override
    public String toString(){
        return getName() + " -> " + score;
    }

    @Override
    public int compareTo(CountryFinalist c){
        return getName().compareTo(c.getName());
    }

}
