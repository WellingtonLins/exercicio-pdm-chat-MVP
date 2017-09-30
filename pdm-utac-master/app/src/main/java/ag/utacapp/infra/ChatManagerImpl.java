package ag.utacapp.infra;

import com.pubnub.api.PubNub;

import java.util.Observable;
import java.util.Observer;

import ag.utacapp.model.ChatManager;


public class ChatManagerImpl extends Observable implements ChatManager {
    private final PubNubClient client;
    private final String userName;

    private ChatManagerImpl(String userName){
        this.userName = userName;
        this.client = new PubNubClient();
    }

    @Override
    public void registerLikeSubscriber() {
        client.connectSubscriber(new PubNubMsgCallback() {
            @Override
            public void callback(String name, String msg) {
                receiveMessage(name, msg);
            }
        });
    }

    @Override
    public void sendMessage(String msg) {
        client.connectPublisherAndSendMessage(userName, msg);
    }

    @Override
    public void receiveMessage(String name, String msg) {
        setChanged();
        notifyObservers(new String[]{name, msg});
    }

    private static ChatManagerImpl instance = null;

    public static void init(String userName){
        instance = new ChatManagerImpl(userName);
    }

    public static ChatManagerImpl instance(Observer observer){
        instance.addObserver(observer);
        instance.registerLikeSubscriber();
        return instance;
    }

    public static void clear(Observer observer){

        instance.deleteObserver(observer);
    }



}
