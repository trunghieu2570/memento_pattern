package com.example;

public class Main {

    public static void main(String[] args) {
        Originator o = new Originator();
        o.setState("On");

        // Store internal state
        Caretaker c = new Caretaker();
        c.setMemento(o.createMemento());

        // Continue changing originator
        o.setState("Off");

        // Restore saved state
        o.setMemento(c.getMemento());
    }
}


class Originator
{
    private String state;

    // Creates memento
    public Memento createMemento()
    {
        return (new Memento(state));
    }

    // Restores original state
    public void setMemento(Memento memento)
    {
        System.out.println("Restoring state...");
        setState(memento.getState());
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
        System.out.format("State = %s\n", state);
    }
}

class Memento {
    private final String state;
    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

class Caretaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}