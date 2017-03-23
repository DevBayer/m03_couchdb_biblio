package database;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 23878410v on 09/03/17.
 */
public class Model {
    @SerializedName("_id") public String primaryKey = null;
    @SerializedName("_rev") public String rev = null;
    transient public String key = null;
    public String Type = null;
    transient static public String _view_all = null;
    transient static public String _view_key = null;

    public Model() {

    }

    public String getPrimaryKey(){
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        this.Type = type;
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
