package repositorios;

import java.util.ArrayList;

import entidades.PoliticaAntirracista;
import insterfaces.PoliticaRepositoryInterface;

class PoliticaRepository implements PoliticaRepositoryInterface {
    private ArrayList<PoliticaAntirracista> politicas = new ArrayList<>();

    @Override
    public void adicionarPolitica(PoliticaAntirracista politica) {
        politicas.add(politica);
    }

    @Override
    public ArrayList<PoliticaAntirracista> listarPoliticas() {
        return politicas;
    }

    @Override
    public PoliticaAntirracista buscarPoliticaPorNome(String nome) {
        for (PoliticaAntirracista politica : politicas) {
            if (politica.getNome().equalsIgnoreCase(nome)) {
                return politica;
            }
        }
        return null;
    }

	 
}
