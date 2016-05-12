import facebook4j.Account;
import facebook4j.Facebook;
import facebook4j.FacebookFactory;
import facebook4j.ResponseList;
import facebook4j.auth.AccessToken;
import facebook4j.internal.org.json.JSONArray;
import facebook4j.internal.org.json.JSONObject;

/**
 * Created by knoldus on 8/5/16.
 */

public class fb {

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
