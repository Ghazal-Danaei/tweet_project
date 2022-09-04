package twitter;
import java.util.Date;

public class tweet {
    public String WRITER;
    public Date DA;
    public  int LIKES;
    public  static int ID ;
    public String ST;
     public tweet(String str,String writer){
        this.ST = str;
        this.DA=new Date();
        this.LIKES=0;
        this.WRITER=writer;
    }







}
