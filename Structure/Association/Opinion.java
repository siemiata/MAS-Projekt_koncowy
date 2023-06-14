package Structure.Association;

public class Opinion {
    private int score;
    private String text;
    private Reservation reservation;

    public Opinion(int score, String text, Reservation reservation) {
        this.score = score;
        this.text = text;
        this.reservation = reservation;
    }

    public static Opinion createOpinion(int score, String text, Reservation reservation) throws Exception{
        if(reservation == null){
            throw new Exception("Given reservation does not exist");
        }
        Opinion opinion = new Opinion(score,text,reservation);
        reservation.addOpinion(opinion);
        return opinion;
    }
}
