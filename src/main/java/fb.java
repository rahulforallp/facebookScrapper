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
            String accessTokenString = "EAACEdEose0cBANWgxtNTJonarayJyB7WTORJ6NxdZBDQDgZCBgCAezaZBmN0aEOPk08tWsZCIdBj7A6YCaFt1pzyxHHpp1veBIBE6ZBnDB6EzN5dowFSZAwyYR14OcW7USXp416afNZCnkUjrFEnffOiiPZBTAUURtc1KyBC7iSecu5Rpmh70cKx";
            AccessToken at = new AccessToken(accessTokenString);
            facebook.setOAuthAccessToken(at);


           // facebook.postStatusMessage("Hello World from Facebook4J.");

            String query = "SELECT movies,email from user where uid=me()";

            JSONArray jsonArray = facebook.executeFQL(query);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                System.out.println("My email : "+jsonObject.get("email"));
                System.out.println(jsonObject.get("movies")+",");
            }

        } catch (Exception e) {
            System.out.println("Exception Occurred "+e.getMessage());
        }


    }


}
