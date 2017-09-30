package ag.utacapp.presenter;

import android.view.View;

/**
 * Representa o item da lista de mensagens recentes
 */
public interface LatestMessagePresenter {

    /**
     * Apresentar o nome do usuário no item
     *
     * @param text
     */
    void setUserName(String text);

    /**
     * Apresentar a mensagem mais recente no item
     *
     * @param msg
     */
    void setLatestMessage(String msg);

    /**
     * Redirectionar para o chat
     */
    void goToChatAction();
}
