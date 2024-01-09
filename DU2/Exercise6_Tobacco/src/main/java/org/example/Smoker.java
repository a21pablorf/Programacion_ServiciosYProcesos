package org.example;

public class Smoker {
    private String name;
    private int articleProperty;
    private int articleLeft1;
    private int articleLeft2;

    public Smoker(String name,int articleProperty) {
        this.name=name;
        this.articleProperty = articleProperty;
    }

    public synchronized void smoke(){
        if (canSmoke()){
            System.out.println(this.name+" is smoking.");
        }
        else{
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean canSmoke(){
        if (articleProperty!=articleLeft1 && articleProperty!=articleLeft2 && articleLeft1!=articleLeft2){
            return true;
        }
        return false;
    }

    public int getArticleProperty() {
        return articleProperty;
    }

    public void setArticleProperty(int articleProperty) {
        this.articleProperty = articleProperty;
    }

    public int getArticleLeft1() {
        return articleLeft1;
    }

    public void setArticleLeft1(int articleLeft1) {
        this.articleLeft1 = articleLeft1;
    }

    public int getArticleLeft2() {
        return articleLeft2;
    }

    public void setArticleLeft2(int articleLeft2) {
        this.articleLeft2 = articleLeft2;
    }
}
