package org.example;

public class Tobacconist {

    private int article1;
    private int article2;

    public int getArticle1() {
        return article1;
    }

    public int getArticle2() {
        return article2;
    }

    public Tobacconist(int a, int b) {
        this.article1=a;
        this.article2=b;
    }

    public synchronized void giveArticles(Smoker smoker,int a, int b){
        System.out.println("Voy a dar todos los artículos: "+a+" y "+b);
        if (smoker.getArticleProperty()!=a && smoker.getArticleProperty()!=b){
            smoker.setArticleLeft1(a);
            smoker.setArticleLeft2(b);
            System.out.println("Tobacconist gives the right articles to the smoker");
        }
        else{
            System.out.println("Tobacconist can not give the articles to the smoker because he already has one of them");
        }
    }
}
