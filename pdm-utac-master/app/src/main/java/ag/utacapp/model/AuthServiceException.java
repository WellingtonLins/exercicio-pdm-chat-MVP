package ag.utacapp.model;


/**
 *Classe de  exceção do serviço de autenticação
 * Essa exceção é lançada quando ocorre um erro de autenticação do usuario
 */
public class AuthServiceException extends Exception {

//  Construtor que recebe a mensagem a ser lançada na ocorrencia da exceção
    public AuthServiceException(String message) {
        super(message);
    }

}
