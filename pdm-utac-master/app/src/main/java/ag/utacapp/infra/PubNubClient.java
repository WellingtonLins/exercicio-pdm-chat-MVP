package ag.utacapp.infra;


import android.util.Log;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.pubnub.api.PNConfiguration;
import com.pubnub.api.PubNub;
import com.pubnub.api.callbacks.SubscribeCallback;
import com.pubnub.api.models.consumer.PNStatus;
import com.pubnub.api.models.consumer.pubsub.PNMessageResult;
import com.pubnub.api.models.consumer.pubsub.PNPresenceEventResult;

import java.util.Arrays;

/*
Classe obrigatoria para a autenticação  junto ao servidor da aplicação pubnub
Uma vez autenticado no servidor remoto o fluxo de  mensagens real time
seguirá sem problemas
 */

public class PubNubClient {
//    chaves geradas pela api do pubnub quando voce cria um conta
    private static final String PUBNUB_SUBTOKEN = "sub-c-07592560-8272-11e7-b8ba-72cd244bcd80";
    private static final String PUBNUB_PUBTOKEN = "pub-c-b457289d-cd8c-4bd3-8e24-56c17f8941ec";

    private PubNub pubnub = null;

    private void init() {
        //
        PNConfiguration pnConfiguration = new PNConfiguration();
        pnConfiguration.setSubscribeKey(PUBNUB_SUBTOKEN);
        pnConfiguration.setPublishKey(PUBNUB_PUBTOKEN);
        pnConfiguration.setSecure(false);
        //
        pubnub = new PubNub(pnConfiguration);
    }

    public PubNubClient() {
        init();
    }

    public PubNub connectSubscriber(final PubNubMsgCallback callbackObj) {
        //
        pubnub.addListener(new SubscribeCallback() {
            @Override
            public void status(PubNub pubnub, PNStatus status) {
                Log.d("AGDebug", "Status: " + status.toString());
            }

            @Override
            public void presence(PubNub pubnub, PNPresenceEventResult presence) {
                Log.d("AGDebug", "Presence: " + presence.toString());
            }

            @Override
            public void message(PubNub pubnub, PNMessageResult message) {
                //log
                Log.d("AGDebug", "Recebendo mensagem");
                Log.d("AGDebug", "channel: " + message.getChannel());
                Log.d("AGDebug", "message: " + message.getMessage());
                Log.d("AGDebug", "timetoken: " + message.getTimetoken());
                //recuperando dados
                JsonElement element = message.getMessage();
                JsonObject json = element.getAsJsonObject();
                String name = json.get("name").getAsString();
                String latestmessage = json.get("msg").getAsString();
                //
                callbackObj.callback(name, latestmessage);
            }
        });
        pubnub.subscribe().channels(Arrays.asList("chat")).execute();
        //
        return pubnub;
    }

    public void connectPublisherAndSendMessage(String name, String msg) {
        //
        PNConfiguration pnConfiguration = new PNConfiguration();
        pnConfiguration.setPublishKey(PUBNUB_PUBTOKEN);
        pnConfiguration.setSecure(false);
        //
        PubNub pubnub = new PubNub(pnConfiguration);
        //
        JsonObject json = new JsonObject();
        json.addProperty("name", name);
        json.addProperty("msg", msg);
        //
        pubnub.publish().channel("chat").message(json);
    }

}
