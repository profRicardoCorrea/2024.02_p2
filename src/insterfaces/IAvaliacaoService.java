package insterfaces;

import entidades.Empresa;
import entidades.Especialista;

public interface IAvaliacaoService{
    void avaliarEmpresa(Empresa empresa, Especialista especialista);
}
