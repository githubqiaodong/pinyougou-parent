package entity;

import java.io.Serializable;

/**返回增加结果
 * Created by Lenovo on 2018/9/4.
 */
public class Result implements Serializable {
    private boolean success;
    private String message;
    public Result() {
    }
    public Result(boolean success, String message) {
        super();
        this.success = success;
        this.message = message;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }


    //getter and setter.....
}
