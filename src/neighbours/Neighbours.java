package neighbours;

public class Neighbours {

    private final NeighboursState state;

    public Neighbours(int numbers) {
        if (numbers < 0) throw new IllegalArgumentException("Neighbours number cannot be negative");
        this.state =  convert(numbers);
    }

    private NeighboursState convert(Integer neighboursNumber) {
        if (neighboursNumber < 2) return NeighboursState.FEWER_THAN_TWO_NEIGHBOURS;
        if (neighboursNumber == 2) return NeighboursState.EXACTLY_TWO_NEIGHBOURS;
        if (neighboursNumber == 3) return NeighboursState.EXACTLY_THREE_NEIGHBOURS;
        return NeighboursState.MORE_THAN_THREE_NEIGHBOURS;
    }

    public NeighboursState getState() {
        return state;
    }
}