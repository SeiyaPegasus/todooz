package fr.todooz.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bphan-luong
 * Date: 07/11/13
 * Time: 16:36
 * To change this template use File | Settings | File Templates.
 */
public class TagCloud {
    private List<String> tags = new ArrayList<String>();

    public int size() {
        return tags.size();
    }

    public void add(String... tags) {
        if (tags == null) {
            return;
        }

        for (String tag : tags) {
            if (canAdd(tag)) {
                this.tags.add(tag);
            }
        }
    }

    public boolean contains(String tag) {
        return tags.contains(tag);
    }

    private boolean canAdd(String tag) {
        return !(tag == null || "".equals(tag) || contains(tag));
    }

    public void top(int count) {
        count = Math.max(count,0);
        //count = Math.min();
        tags = tags.subList(0,count);
    }
}
