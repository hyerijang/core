package Hello.core.lifecycle;

public class NetworkClient {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
        connect();
        call("초기화 연결 메세지");
    }

    public void setUrl(String url) {
        this.url = url;

    }

    public String getUrl() {
        return url;
    }

    public void connect() {
        System.out.println("NetworkClient.connect : " + url);
    }

    public void call(String message) {
        System.out.println("call = " + url + " message = " + message);
    }

    public void disconnect() {
        System.out.println("close : " + url);
    }


    public void init() throws Exception {
        connect();
        call("초기화 연결 메세지");

    }


    public void close() throws Exception {
        disconnect();
        call("종료 메세지");
    }
}
