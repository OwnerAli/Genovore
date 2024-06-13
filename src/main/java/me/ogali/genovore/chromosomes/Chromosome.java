package me.ogali.genovore.chromosomes;

import lombok.Getter;
import me.ogali.genovore.domain.Gene;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Chromosome {

    private final List<Gene> geneList;

    public Chromosome() {
        this.geneList = new ArrayList<>();
    }

    public void addGene(Gene gene) {
        geneList.add(gene);
    }

    public Chromosome crossover(Chromosome other) {
        Chromosome child = new Chromosome();
        int crossoverPoint = (int) (Math.random() * geneList.size());
        for (int i = 0; i < crossoverPoint; i++) {
            child.addGene(this.geneList.get(i));
        }
        for (int i = crossoverPoint; i < other.getGeneList().size(); i++) {
            child.addGene(other.getGeneList().get(i));
        }
        return child;
    }

}
