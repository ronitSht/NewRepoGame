package menu;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Velocity specifies the change in position on the `x` and the `y` axes.
 *
 * @author Ronit Shternfeld
 * @version 24 April 2018
 */
public class LevelsForSubMenu {
    /**
     * fromReader.
     *
     * @param reader reader
     * @return levels list
     */
    public static List<LevelForSet> fromReader(Reader reader) {
        BufferedReader br = new BufferedReader(reader);
        List<LevelForSet> levelSetList = new ArrayList<>();
        String key = null;
        String name = null;
        String path;
        String line;
        int i = 0;
        try {
            while ((line = br.readLine()) != null) {
                if (line.equals("")) {
                    continue;
                }
                if (i % 2 == 0) {
                    key = line.split(":")[0];
                    name = line.split(":")[1];
                } else {
                    path = line;
                    levelSetList.add(new LevelForSet(key, name, path));
                }
                i++;
            }
        } catch (Exception exception) {
            System.out.println("Exception in reading the levels from the LevelSet!");
        } finally {
            try {
                br.close();
            } catch (Exception exception) {
                System.out.println("Exception in reading the levels from the LevelSet!");
            }
        }
        return levelSetList;
    }
}
