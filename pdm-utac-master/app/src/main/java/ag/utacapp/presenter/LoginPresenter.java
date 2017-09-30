package ag.utacapp.presenter;


/**
 * Representa a interação do usuário
 * com a visão (Login)
 */
public interface LoginPresenter {

    // Recupera o email digitado pelo usuário
    String getEmail();

    //Recupera a senha digitada pelo usuário
    String getPassword();

    //  Executa a ação do acionamento do botão login
    void loginButtonClick();

    //  Apresenta uma mensagem de erro para o usuário

    void showMessageError(String msg);
}

