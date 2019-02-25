package br.com.pontointeligente.repository;

import br.com.pontointeligente.domain.Empresa;
import br.com.pontointeligente.domain.Funcionario;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("teste")
@FixMethodOrder(MethodSorters.JVM)
public class EmpresaRepositoryTest {

    @Autowired
    private EmpresaRepository empresaRepository;
    private static Empresa empresaParaConsultar;
    private static Empresa empresaCadastrada;

    @Test
    public void testeCadastrarEmpresa() {
        Empresa empresa = new Empresa();
        empresa.setCnpj("12345678912345");
        Funcionario funcionario = new Funcionario();
        funcionario.setCpf("12345678909");
        funcionario.setEmail("Teste@gmail.com");
        funcionario.setNome("teste");
        funcionario.setSenha("12345");
        empresa.setFuncionarios(Arrays.asList(funcionario));
        empresa.setRazaoSocial("Razão Social");
        empresaCadastrada = this.empresaRepository.save(empresa);
        Assert.assertTrue(empresa != null);
    }

    @Test
    public void testeBuscarEmpresa() {
        Optional<Empresa> empresaConsultada = this.empresaRepository.findById(empresaCadastrada.getId());
        Assert.assertEquals(empresaConsultada.get().getId(), empresaCadastrada.getId());
        empresaParaConsultar = empresaConsultada.get();
    }

    @Test
    public void testeAlterarEmpresa() {
                String razaoSocial = "nova Razão Social 01";
                empresaParaConsultar.setRazaoSocial(razaoSocial);
                empresaParaConsultar = this.empresaRepository.save(empresaParaConsultar);
        Assert.assertNotEquals(empresaParaConsultar.getRazaoSocial(), empresaCadastrada.getRazaoSocial());
    }

    @Test
    public void testeDeleteEmpresa() {
        this.empresaRepository.deleteById(empresaParaConsultar.getId());
        Optional<Empresa> validEmpresaDeletada = this.empresaRepository.findById(empresaCadastrada.getId());
        Assert.assertFalse(validEmpresaDeletada.isPresent());
    }


}
