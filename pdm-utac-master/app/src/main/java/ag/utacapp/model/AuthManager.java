package ag.utacapp.model;


/**
 * Representa um simples serviço de autenticação
 */
public interface AuthManager {
    String auth(String email, String password) throws AuthServiceException;
}
