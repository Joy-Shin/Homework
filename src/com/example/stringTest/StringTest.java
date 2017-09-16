package com.example.stringTest;

public class StringTest {
    public static void main(String[] args) {
        GetA getA1 = new GetA("aaaaababababab");
        System.out.println(getA1);
    }
}

class GetA {
    private String sentence;
    private int aNum;

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public int getaNum() {
        return aNum;
    }

    public void setaNum(int aNum) {
        this.aNum = aNum;
    }

    public GetA(){}
    public GetA(String sentence)
    {
        this.sentence = sentence;
        this.aNum = calculate(sentence);
    }

    private int calculate(String input)
    {
        int a = 0;
        String[] splitedChars = input.split("");

        for(String s : splitedChars)
        {
            if(s.equals("a") || s.equals("A"))
            {
                a++;
            }
        }

        return a;
    }

    @Override
    public String toString() {
        return "In " + this.sentence + ", the number of A is " + aNum;
    }
}

class getAlphabets {
    private String sentence;
    private int a; private int b; private int c; private int d; private int e;
    private int f; private int g; private int h; private int i; private int j;
    private int k; private int l; private int m; private int n; private int o;
    private int p; private int q; private int r; private int s; private int t;
    private int u; private int v; private int w; private int x; private int y; private int z;

    public getAlphabets(){}
    public getAlphabets(String sentence)
    {
        this.sentence = sentence;
    }

    public void calculate(String sentence)
    {
        String[] alphabets = sentence.split("");
        for(String a : alphabets)
        {
            if(a.equals("A")||a.equals("a"))
                this.a++;
            if(a.equals("b")||a.equals("B"))
                this.b++;
            if(a.equals("c")||a.equals("C"))
                this.c++;
            if(a.equals("d")||a.equals("D"))
                this.d++;
            if(a.equals("e")||a.equals("E"))
                this.e++;
            if(a.equals("f")||a.equals("F"))
                this.f++;
            if(a.equals("g")||a.equals("G"))
                this.g++;
            if(a.equals("h")||a.equals("H"))
                this.h++;
            if(a.equals("i")||a.equals("I"))
                this.i++;
            if(a.equals("j")||a.equals("j"))
                this.j++;
            if(a.equals("k")||a.equals("K"))
                this.k++;
            if(a.equals("l")||a.equals("L"))
                this.l++;
        }
    }
}
