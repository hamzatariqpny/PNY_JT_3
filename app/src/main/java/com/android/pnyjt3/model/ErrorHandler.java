package com.android.pnyjt3.model;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;

public class ErrorHandler {

    public static String getErrorMessage(VolleyError error){
        String errorMsg = "";
        if (error instanceof TimeoutError ) {
            errorMsg = "TimeoutError";
        } else if (error instanceof NoConnectionError) {
            errorMsg = "NoConnectionError";
        } else if (error instanceof AuthFailureError) {
            errorMsg = "AuthFailureError";
        } else if (error instanceof ServerError) {
            errorMsg = "ServerError";
        } else if (error instanceof NetworkError) {
            errorMsg = "NetworkError";
        } else if (error instanceof ParseError) {
            errorMsg = "ParseError";
        }else {
            errorMsg = "OtherError";
        }
        return errorMsg;
    }
}
