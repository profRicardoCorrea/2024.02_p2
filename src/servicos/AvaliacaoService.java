package servicos;

import entidades.Empresa;
import entidades.Especialista;
import insterfaces.AvaliacaoServiceInterface;

public class AvaliacaoService implements AvaliacaoServiceInterface {
    @Override
    public void avaliarEmpresa(Empresa empresa, Especialista especialista) {
        especialista.avaliarEmpresa(empresa);
    }
 
}
