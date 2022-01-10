package Lesson_8;

interface Barrier{

}

class Wall implements Barrier{
    int high;

    Wall(int high) {
        this.high = high;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }
}

class Treadmill implements Barrier{

    int len;

    public Treadmill(int len) {
        this.len = len;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }
}
