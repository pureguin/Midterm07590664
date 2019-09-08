package th.ac.su.sc.midterm07590664.Model;

        import java.util.EmptyStackException;

public class Auth  {


    private static final String EMAIL = "pureguin@gmail.com";
    private static final String PASSWORD = "1234";

    private String mEmail;
    private String mPassword;

    public Auth(String email,String password){
        this.mEmail = email;
        this.mPassword = password;
    }

    /*   public String getEmail() {
           return mEmail;
       }

       public void setEmail(String email) {
           this.mEmail = email;
       }

       public String getPassword() {
           return mPassword;
       }

       public void setPassword(String password) {
           this.mPassword = password;
       }
   */
    public boolean check(){
        if ((mEmail.equals(EMAIL) && mPassword.equals(PASSWORD))){
            return true;

        }else {
            return false;
        }
    }


}
