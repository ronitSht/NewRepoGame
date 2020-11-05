package score;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Creates the high score table.
 */
public class HighScoresTable implements Serializable {
    private List<ScoreInfo> scoreTable = new ArrayList<>();
    private int sizeOfTable;

    /**
     * Create an empty high-scores table with the specified size.
     * The size means that the table holds up to size top scores.
     *
     * @param size size
     */
    public HighScoresTable(int size) {
        this.sizeOfTable = size;
    }

    /**
     * Add a high-score.
     *
     * @param score score
     */
    public void add(ScoreInfo score) {
        int rank = getRank(score.getScore());
        if (rank != -1) {
            scoreTable.add(rank, score);
        }
    }

    /**
     * Return table size.
     *
     * @return sizeOfTable
     */
    public int size() {
        return this.sizeOfTable;
    }

    /**
     * Return the current high scores.
     * The list is sorted such that the highest scores come first.
     *
     * @return scoreTable
     */
    public List<ScoreInfo> getHighScores() {
        return this.scoreTable;
    }

    /**
     * Return the rank of the current score: where will it be on the list if added?
     * Rank 1 means the score will be highest on the list.
     * Rank `size` means the score will be lowest.
     * Rank > `size` means the score is too low and will not be added to the list.
     *
     * @param score score
     * @return the rank
     */
    public int getRank(int score) {
        int counter = 0;
        for (int i = 0; i < this.scoreTable.size(); i++) {
            if (score <= this.scoreTable.get(i).getScore()) {
                counter += 1;
            }
            // if the table is full, it returns -1
            if (counter > this.sizeOfTable) {
                return -1;
            }
        }
        return counter;
    }

    /**
     * Clears the table.
     */
    public void clear() {
        this.scoreTable.clear();
    }

    /**
     * Load table data from file.
     * Current table data is cleared.
     *
     * @param filename filename
     * @throws IOException IOException
     */
    public void load(File filename) throws IOException {
        this.clear();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            HighScoresTable scoresTable;
            scoresTable = (HighScoresTable) ois.readObject();
            ois.close();
        } catch (FileNotFoundException exception) {
            System.out.println("File not found in load!");
        } catch (ClassNotFoundException exception) {
            System.out.println("Class not found in load!");
        }
    }

    /**
     * Save table data to the specified file.
     *
     * @param filename filename
     * @throws IOException IOException
     */
    public void save(File filename) throws IOException {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(filename));
            oos.writeObject(this);
        } catch (IOException exception) {
            System.out.println("Exception in writing in save!");
        } finally {
            if (oos != null) {
                oos.close();
            }
        }
    }

    /**
     * Read a table from file and return it.
     * If the file does not exist, or there is a problem with reading it, an empty table is returned.
     *
     * @param filename filename
     * @return HighScoresTable
     */

    public static HighScoresTable loadFromFile(File filename) {
        ObjectInputStream os = null;
        HighScoresTable highScore;
        try {
            os = new ObjectInputStream(new FileInputStream(filename));
            highScore = (HighScoresTable) os.readObject();
            return highScore;
        } catch (FileNotFoundException exception) {
            System.out.println("File not found in loadFromFile!");
        } catch (ClassNotFoundException exception) {
            System.out.println("Class not found in loadFromFile!");
        } catch (IOException exception) {
            System.out.println("IOException in reading in loadFromFile!");
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException exception) {
                System.out.println("Closing failed!");
            }
        }
        return new HighScoresTable(10);
    }
}

