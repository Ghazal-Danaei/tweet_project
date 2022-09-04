package twitter;
import  java.util.HashMap;
import java.util.ArrayList;
import java.util.Date;

import static twitter.test.*;

public class user {
    public  void Signup(user u){
        System.out.println("sign up");
        if (userandpass.containsKey(u.USERNAME))
            System.out.println("The username already exists!");
        else
        {
            users.add(u);
            userandpass.put(u.USERNAME,u.PASSWORD);


        }
    }
    public  void Login(String s8,String p8){
        if ((userandpass.containsKey(s8))&&(userandpass.get(s8).equals(p8))){
            System.out.println("successfully logged in");
            test.LN=s8;
            test.r=finduser(LN);

        }
        else
        {
            System.out.print("error!username or password is not correct!");
        }
    }
    public  void Logout(){
        System.out.println(test.LN+"HAS LOGGED OUT");
            test.LN="";
            test.r=test.finduser(LN);
    }
    public  void SHOWTWEETS () {
        for( Date a:this.dates)
        {
            System.out.println((this.dateandtweets.get(a)).ST);
            System.out.println("likes:"+(this.dateandtweets.get(a)).LIKES);
            System.out.println((this.dateandtweets.get(a)).DA);
        }
    }
    public  void Addtweet(String str,int id){
        tweet t=new tweet(str,LN);
        t.ID=id;
        this.tweets.add(t);
        this.dates.add(t.DA);
        this.dateandtweets.put(t.DA,t);
        alldateandtweet.put(t.DA,t);
        test.idandtweet.put(t.ID,t);
    }
    public static ArrayList <tweet>tweets=new ArrayList<tweet>();
    public static HashMap<Date,tweet >dateandtweets = new HashMap<Date,tweet>();
    public  static ArrayList<Date>dates=new ArrayList<>();
    public static ArrayList <user>followers=new ArrayList<>();
    public static ArrayList <user>following=new ArrayList<>();
    public  static String USERNAME;
    public  static String PASSWORD;
    public user(String username,String password) {
        this.USERNAME = username;
        this.PASSWORD = password;
    }

}
