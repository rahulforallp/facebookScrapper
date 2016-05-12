import facebook4j.Account;
import facebook4j.Facebook;
import facebook4j.FacebookFactory;
import facebook4j.ResponseList;
import facebook4j.auth.AccessToken;
import facebook4j.internal.org.json.JSONArray;
import facebook4j.internal.org.json.JSONObject;


/*
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
*/

/**
 * Created by knoldus on 8/5/16.
 */

public class fb {

    /*
    get access token by default
    private static final long serialVersionUID = -7453606094644144082L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Facebook facebook = new FacebookFactory().getInstance();
        request.getSession().setAttribute("facebook", facebook);
        StringBuffer callbackURL = request.getRequestURL();
        int index = callbackURL.lastIndexOf("/");
        callbackURL.replace(index, callbackURL.length(), "").append("/callback");
        response.sendRedirect(facebook.getOAuthAuthorizationURL(callbackURL.toString()));
    }*/

    public static void main(String arg[]) {

        Facebook facebook = new FacebookFactory().getInstance();
        try {

            facebook.setOAuthAppId("","");
            String accessTokenString = "EAACEdEose0cBADnENNCwy0tzS1WtWZCDgainTMXJiBNN3JvXsO2RQbU4n7gXd4vC285hdHQjJGyUrDJeYWyu8gVi5r3ZBiS67EHQxRXWgURtSUqhX85XK7DZC0yLZAPzlRQMODT2kEaTGlLRpEaiduA5OKd0QLabNxh8ZACNzywkVZBnmFiIL1";
            AccessToken at = new AccessToken(accessTokenString);
            facebook.setOAuthAccessToken(at);


           //facebook.postStatusMessage("Hello World from Facebook4J.");

            String query = "SELECT movies,first_name,last_name from user where uid IN (SELECT uid2 FROM friend WHERE uid1 = me())";
            String friendquerry="SELECT movies,email from user where uid = me()";
            JSONArray jsonArray = facebook.executeFQL(query);
            JSONArray jsonArrayFriend = facebook.executeFQL(friendquerry);
            System.out.println("\n\n My Friends Movies : ");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                System.out.print("Name : "+jsonObject.get("first_name")+" "+jsonObject.get("last_name")+"\n");
                System.out.println(jsonObject.get("movies")+",");
            }
           System.out.println("\n\nMy Movies and email : ");
            for (int i = 0; i < jsonArrayFriend.length(); i++) {
                JSONObject jsonObject = jsonArrayFriend.getJSONObject(i);
                System.out.println("My email : "+jsonObject.get("email"));
                System.out.print(jsonObject.get("movies")+",");
            }

        } catch (Exception e) {
            System.out.println("Exception Occurred "+e.getMessage());
        }


    }


}
