package insterfaces;

import java.util.ArrayList;

import entidades.PoliticaAntirracista;

public interface PoliticaRepositoryInterface {
    void adicionarPolitica(PoliticaAntirracista politica);
    ArrayList<PoliticaAntirracista> listarPoliticas();
    PoliticaAntirracista buscarPoliticaPorNome(String nome);
}

