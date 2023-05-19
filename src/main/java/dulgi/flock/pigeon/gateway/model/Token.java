package dulgi.flock.pigeon.gateway.model;


public class Token {
    private String uuid;
    private String token;
    private String registeredTime;

    public void setUuid(String uuid){
        this.uuid = uuid;
    }
    public void setToken(String token){
        this.token=token;
    }
    public void setRegisteredTime(String registeredTime) {
        this.registeredTime = registeredTime;
    }
    public String getUuid() {
        return uuid;
    }
    public String getToken(){
        return token;
    }
    public String getRegisteredTime(){
        return registeredTime;
    }


}

