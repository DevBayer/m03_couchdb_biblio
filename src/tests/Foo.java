package tests;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 23878410v on 09/03/17.
 */
public class Foo {
    @SerializedName("_id") String id;
    @SerializedName("_rev") String rev;
    String test;
    String ja2;

    public Foo() {
        test = "hola";
    }
}
