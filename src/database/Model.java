package database;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 23878410v on 09/03/17.
 */
public class Model {
    transient String primaryKey = "id";
    @SerializedName("_rev") public String rev = null;

    public Model() {

    }

    public String getPrimaryKey(){
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getRev() {
        return rev;
    }

    public void setRev(String rev) {
        this.rev = rev;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        } else {
            if (this.getPrimaryKey() == null){
                return false;
            }
            if (this.getPrimaryKey().equals(((Model) obj).getPrimaryKey())) {
                return true;
            }
        }
        return false;
    }
}
