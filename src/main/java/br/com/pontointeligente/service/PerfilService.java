package br.com.pontointeligente.service;

import br.com.pontointeligente.domain.Perfil;
import br.com.pontointeligente.dto.PerfilDTO;

import java.util.Optional;

public interface PerfilService {

    /**
     * O método é responsável por cadastrar uma perfil.
     *
     * @param perfil
     * @return
     */
    PerfilDTO cadastrarPerfil(Perfil perfil);

    /**
     * O método é responsável por consultar uma perfil por id.
     *
     * @param id
     * @return
     */
    Optional<PerfilDTO> buscarPerfilPorCodigo(Long id);

    /**
     * O método e responsável por deletar uma perfil pelo o id informado.
     *
     * @param id
     */
    void deletePerfilPorID(Long id);

    /**
     * O método e responsável por alterar o perfil informada.
     *
     * @param perfil
     * @return
     */
    PerfilDTO alterarPerfil(Perfil perfil);

}
