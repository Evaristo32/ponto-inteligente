package br.com.pontointeligente.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtils {

    private static final Logger logger = LoggerFactory.getLogger(PasswordUtils.class);

    public PasswordUtils() {
    }

    /**
     * O método e responsável por em criptografar a senha que o usuário digitar para fazer login.
     *
     * @param senha
     * @return
     */
    public static String gerarByCrypt(String senha){
        if (senha == null){
            return senha;
        }
        logger.info("Gerando hash com ByCrypt.");
        return  new BCryptPasswordEncoder().encode(senha);
    }
}
