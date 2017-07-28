package com.aishabibiadambek.user.qazaqbyexample;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class ChangePWRequest extends StringRequest {

    private static final String CHANGEPW_REQUEST_URL = "https://aishaadambek.000webhostapp.com/ChangePassword.php";
    private Map<String, String> params;

    public ChangePWRequest(String name, String username, String password, Response.Listener<String> listener) {
        super(Method.POST, CHANGEPW_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("name", name);
        params.put("username", username);
        params.put("password", password);

    }

    @Override
    public Map<String, String> getParams(){
        return params;
    }
}
