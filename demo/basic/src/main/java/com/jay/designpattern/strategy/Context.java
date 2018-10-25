package com.jay.designpattern.strategy;

public class Context {

    public static void main(String[] args) {
        Context context = new Context(new StrategyA());
        context.specificStrategy();

        context = new Context(new StrategyB());
        context.specificStrategy();

        context = new Context(new StrategyC());
        context.specificStrategy();
    }

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void specificStrategy() {
        strategy.algorithm();
    }
}
