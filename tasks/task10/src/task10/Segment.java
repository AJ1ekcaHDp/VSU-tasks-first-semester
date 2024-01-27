package task10;
class Segment {
    private int start;
    private int end;

    public Segment(int start, int end) {
        setSegment(start, end);
    }
    public Segment(Segment other) {
        this(other.start, other.end);
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        //this.start = start;
        setSegment(start, this.end);
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        //this.end = end;
        setSegment(this.start, end);
    }

    public void setSegment(int start, int end) {
        if (start < end) {
            this.start = start;
            this.end = end;
        } else {
            this.start = end;
            this.end = start;
        }
    }

    public Segment createCopy() {
        return new Segment(this.start, this.end);
    }
}