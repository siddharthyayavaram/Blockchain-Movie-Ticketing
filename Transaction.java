public class Transaction {
    private int userid;
    private Shows show;
    private int numtickets;

    public Transaction(int userid, Shows show, int numtickets) {
        this.userid = userid;
        this.show = show;
        this.numtickets = numtickets;
    }

    public int getuserid() {
        return userid;
    }

    public int getnumtickets() {
        return numtickets;
    }

    @Override
    public String toString() {
        return "User ID: " + userid + "\nShow Details:\n" + show.toString() + "\nNumber of Tickets: " + numtickets;
    }
}
