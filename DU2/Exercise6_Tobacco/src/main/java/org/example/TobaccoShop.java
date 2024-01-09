package org.example;

import java.util.Random;

public class TobaccoShop implements Runnable{
    private final static int PAPEL=0;
    private static final int TABACO=1;
    private static final int FUEGO=2;
    private Smoker[] smokers=new Smoker[3];
    private Tobacconist tobacconist;

    public TobaccoShop(Smoker[] smoker, Tobacconist tobacconist) {
        this.smokers = smoker;
        this.tobacconist = tobacconist;
    }

    @Override
    public void run() {
        for (Smoker smoker:smokers) {
            tobacconist.giveArticles(smoker,tobacconist.getArticle1(),tobacconist.getArticle2());
            smoker.smoke();
        }

    }
}
