package ag.utacapp.model;

/*Interface que representa o gerenciamento do chat */

public interface ChatManager {
    void registerLikeSubscriber();//metodo para se registrar como assinante
    // enviar a menssagem  ,recebe a mensagem como parametro para ser enviada
    void sendMessage(String msg);
    // receber a menssagem,Recebe o nome e a mensagem como parametros
    void receiveMessage(String name, String message);
}
