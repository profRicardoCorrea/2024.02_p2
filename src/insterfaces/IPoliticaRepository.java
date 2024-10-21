package insterfaces;

import java.util.ArrayList;

import entidades.PoliticaAntirracista;

public interface IPoliticaRepository{
    void salvar(PoliticaAntirracista politica);
    ArrayList<PoliticaAntirracista> listarTodas();
    PoliticaAntirracista buscarPorNome(PoliticaAntirracista politica);
    void remover(PoliticaAntirracista politica);
    
}

