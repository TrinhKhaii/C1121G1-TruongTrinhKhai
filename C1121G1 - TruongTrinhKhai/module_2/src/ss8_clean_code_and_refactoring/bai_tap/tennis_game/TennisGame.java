package ss8_clean_code_and_refactoring.bai_tap.tennis_game;

public class TennisGame {
    public static String getScore(String player1Name, String player2Name, int m_score1, int m_score2) {
        StringBuilder score = new StringBuilder();

        if (m_score1 == m_score2) {
            switch (m_score1) {
                case 0:
                    score = new StringBuilder("Love-All");
                    break;
                case 1:
                    score = new StringBuilder("Fifteen-All");
                    break;
                case 2:
                    score = new StringBuilder("Thirty-All");
                    break;
                case 3:
                    score = new StringBuilder("Forty-All");
                    break;
                default:
                    score = new StringBuilder("Deuce");
                    break;

            }
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            int minusResult = m_score1 - m_score2;
            if (minusResult == 1) score = new StringBuilder("Advantage " + player1Name);
            else if (minusResult == -1) score = new StringBuilder("Advantage " + player2Name);
            else if (minusResult >= 2) score = new StringBuilder("Win for " + player1Name);
            else score = new StringBuilder("Win for "  + player2Name);
        } else {
            int tempScore;
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempScore = m_score1;
                else {
                    score.append("-");
                    tempScore = m_score2;
                }
                switch (tempScore) {
                    case 0:
                        score.append("Love");
                        break;
                    case 1:
                        score.append("Fifteen");
                        break;
                    case 2:
                        score.append("Thirty");
                        break;
                    case 3:
                        score.append("Forty");
                        break;
                }
            }
        }
        return score.toString();
    }

    public static void main(String[] args) {
        System.out.println(getScore("Khai", "Khoi", 10, 3));

    }
}
