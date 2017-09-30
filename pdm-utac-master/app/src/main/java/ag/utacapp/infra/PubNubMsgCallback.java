package ag.utacapp.infra;
/**
 *Representa a assinatura de um metodo de retorno de chamada de mensagem
 * que lida com todos os eventos que o PubNub envia para sua aplicação.
 */
public interface PubNubMsgCallback {
    void callback(String name, String msg);
}
