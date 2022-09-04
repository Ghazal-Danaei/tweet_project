package twitter;
import java.util.*;
import java.util.HashMap;
public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input ="";
        int id1=-1;
        String s ="";
        String s3 ="";
        String p ="";
        String str ="";
        int g =1;
        int newid=0;
        while (g>0) {
            System.out.println("enter input");
            input=in.next();
            if (input=="Quit")
                g = 0;
            switch (input) {
                case "Logout":
                    finduser(LN).Logout();
                    break;
                case "Signup":
                    String a=in.next();
                    String b=in.next();
                    user r1=new user(a,b);
                    r1.Signup(r1);
                    break;
                case "Login":
                    String f=in.next();
                    String vr=in.next();
                    (finduser(f)).Login(f,vr);
                    break;
                case "Addtweet":
                    if(LN.equals(""))
                        System.out.println("error!not logged in");
                    else{
                        s3=in.next();
                        if(s3.length()>140)
                            System.out.println("MORE THAN 140 CHARACTER");
                        if(s3.equals(""))
                            System.out.println("error!no input!");
                        else{
                            id1++;
                            finduser(LN).Addtweet(s3,id1);
                        }
                    }
                    break;
                case "Myprofile":
                    if(LN.equals(""))
                        System.out.println("error!not logged in");
                    else{
                        System.out.println(finduser(LN).USERNAME);
                        finduser(LN).SHOWTWEETS();
                    }
                    break;
                case "Follow":
                    if(LN.equals(""))
                        System.out.println("error!not logged in");
                    else{
                        String us=in.next();
                        (finduser(us)).followers.add(r);
                        r.following.add(finduser(us));
                    }
                    break;
                case "Unfollow":
                    if(LN.equals(""))
                        System.out.println("error!not logged in");
                    else{
                        String us1=in.next();
                        finduser(us1).followers.remove(r);
                        r.following.remove(finduser(us1));
                    }
                    break;
                case "Followers":
                    if(LN.equals(""))
                        System.out.println("error!not logged in");
                    else{
                        for(user q:r.followers){
                            System.out.println(q.USERNAME);
                        }
                    }
                    break;
                case "Following":
                    if(LN.equals(""))
                        System.out.println("error!not logged in");
                    else{
                        for(user o1:r.following)
                            System.out.println(o1.USERNAME);
                    }
                    break;
                case "Timeline":
                    mixdates.clear();
                    concatenate(finduser(LN).dates);
                    for(user w:finduser(LN).following)
                    {
                        concatenate(w.dates);
                    }
                    for(Date x:mixdates)
                    {
                        System.out.println(alldateandtweet.get(x).WRITER);
                        System.out.println(alldateandtweet.get(x).ST);
                        System.out.println("likes:"+alldateandtweet.get(x).LIKES);
                        System.out.println("Date:"+alldateandtweet.get(x).DA);
                    }
                    break;
                case "Profile":
                    String name=in.next();
                            for(Date D: finduser(name).dates)
                            {
                                System.out.println((finduser(name).dateandtweets.get(D)).WRITER);
                                System.out.println((finduser(name).dateandtweets.get(D)).ST);
                                System.out.println("Date:"+(finduser(name).dateandtweets.get(D)).DA);
                                System.out.println("Likes:"+(finduser(name).dateandtweets.get(D)).LIKES);
                            }
                    break;
                case "Like":
                    int idd=in.nextInt();
                    (idandtweet.get(idd)).LIKES++;
                    break;
                default:
                    System.out.println("no match");
            }
        }
    }
    public static  user r=new user("","");
    public static String LN="";
    public static  ArrayList<Date>mixdates=new ArrayList<>();
    public static HashMap<Date,tweet>alldateandtweet = new HashMap<Date,tweet>();
    public static HashMap<Integer,tweet>idandtweet = new HashMap<Integer, tweet>();
    public static  ArrayList<user>users=new ArrayList<>();
    public static HashMap<String,String> userandpass = new HashMap<String, String>();

    public  static user finduser(String u){
        for (user k :users) {
            if ((k.USERNAME).equals(u)) {
                return k;
            }
        }
            {
                user k2=new user("","");
                return k2;
            }

        }
    // Function to merge arrays
    public static ArrayList<Date> concatenate(ArrayList<Date> a)
    {
        mixdates.addAll(a);
        Collections.sort(mixdates);
        return mixdates;
    }
}
