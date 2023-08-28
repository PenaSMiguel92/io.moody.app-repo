package io.moody.app;
import java.util.*;

public class MoodletService {
    private MoodletDAO moodletDAO;

    MoodletService() {
        this.moodletDAO = new MoodletDAO();
    }

    public void createMoodlets(User user) {
        List<Moodlet> userMoodlets = user.getMoodlets();
        if (!userMoodlets.isEmpty())
            return;

        List<String> moodlet_list = Arrays.asList("sleep_value", "comfort_value", "fun_value", "hunger_value",
                "social_value", "toilet_value", "hygeine_value");
        Moodlet[] moodlets = moodlet_list.stream()
                .map(Moodlet::new)
                .toArray(Moodlet[]::new);

        for (Moodlet mood : moodlets) {
            mood.setOwnerId(user.getId());
            userMoodlets.add(mood);
        }
    }
    
    public boolean insertMoodlets(User user) {
        List<Moodlet> userMoodlets = user.getMoodlets();
        return this.moodletDAO.createRecord(userMoodlets);
    }
}
