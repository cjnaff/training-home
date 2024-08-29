public class BoardingPass {
     String start;
     String end;

    public BoardingPass(String start, String end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("BoardingPass{");
        sb.append(start).append(" to ").append(end);
        sb.append('}');
        return sb.toString();
    }
}
