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
            System.out.println("oauth start");
            facebook.setOAuthAppId("","");
            String accessTokenString = "EAACEdEose0cBAMG7tBAhpc6QiiZAOvTsaUZBrGZBo1COohOmvvGe1bvQadw0weq0NE4XSS3wbo2lZBcLRjZBzP1ZB13qopnU9Q1IEExLrrx1WRqWzYUldYOzZBfOMZBMB12GUxCmp8MZCBrIzEsBNkvDGbqnzN3WSaZB2MGOKpp8lZB7oFMoODecE1ZC";
            AccessToken at = new AccessToken(accessTokenString);
            facebook.setOAuthAccessToken(at);
            System.out.println("oauth start");

           // facebook.postStatusMessage("Hello World from Facebook4J.");

            String query = "SELECT email,birthday FROM user WHERE uid = me()";

            JSONArray jsonArray = facebook.executeFQL(query);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                System.out.print(jsonObject.get("email")+",");
                System.out.println(jsonObject.get("birthday"));
            }

        } catch (Exception e) {
            System.out.println("Exception Occurred "+e.getMessage());
        }


    }


}
