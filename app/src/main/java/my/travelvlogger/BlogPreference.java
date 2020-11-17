package my.travelvlogger;

import android.content.Context;
import android.content.SharedPreferences;

public class BlogPreference {

    private static final String KEY_LOGIN_STATE = "key login state";
    private SharedPreferences preferences;

    BlogPreference(Context context){
        preferences = context.getSharedPreferences("travel-blog",Context.MODE_PRIVATE);
    }
    public   boolean isLoggenIn(){
        return preferences.getBoolean(KEY_LOGIN_STATE,false);
    }
    public void setLoggenIn(boolean loggenIn){
        preferences.edit().putBoolean(KEY_LOGIN_STATE,loggenIn).apply();
    }







}
