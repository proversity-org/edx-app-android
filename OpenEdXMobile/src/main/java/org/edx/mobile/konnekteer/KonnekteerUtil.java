package org.edx.mobile.konnekteer;

import android.content.Context;
import android.support.annotation.NonNull;
import com.android.volley.*;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.edx.mobile.authentication.AuthResponse;
import org.edx.mobile.http.constants.ApiConstants;
import org.edx.mobile.util.Config;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by adamkatz on 2018/05/17.
 */

public class KonnekteerUtil {

  private static final String KONNEKTEER_END_POINT = "https://viz8n9p0ci.execute-api.us-east-1.amazonaws.com/prod/konnekteer/saveTopicSubscription";

  public static void createTopic(final Context context, final Config config, final String topic){
    StringRequest request = new StringRequest(Request.Method.POST, KONNEKTEER_END_POINT,
            new Response.Listener<String>() {
              @Override
              public void onResponse(String response) {

              }
            }, new Response.ErrorListener() {
      @Override
      public void onErrorResponse(VolleyError error) {

      }
    }
    ){
      @Override
      public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> params = new HashMap<String, String>();
        params.put("Content-Type", "application/json");
        params.put("Authorization", config.getKonnekteerApiKey());
        return params;
      }

      @Override
      public byte[] getBody()
      {

        JSONObject jsonObject = new JSONObject();
        String body = null;
        try
        {
          jsonObject.put("projectId", config.getKonnekteerProjectId());
          jsonObject.put("organisationId", config.getKonnekteerOrganizationId());
          jsonObject.put("topic", topic);
          body = jsonObject.toString();
        } catch (JSONException e)
        {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        try
        {
          return body.toString().getBytes("utf-8");
        } catch (UnsupportedEncodingException e)
        {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        return null;
      }
    };

    RequestQueue queue = Volley.newRequestQueue(context);
    queue.add(request);
  }
}