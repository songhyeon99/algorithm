package javaProgramming;

class Pen {
    int amount;
    int getAmount() { return amount; }
    void setAmount (int amount) { this.amount = amount; }
}
class SharpPencil extends Pen{
    int width;
}

class Ballpen extends Pen {
    String color;
    String getColor() { return color; }
    void setColor(String color) { this.color = color; }
}

class FountainPen extends Ballpen{
    public void refill (int n) { setAmount(n); }
}