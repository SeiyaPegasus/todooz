package fr.todooz.util;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: bphan-luong
 * Date: 07/11/13
 * Time: 16:37
 * To change this template use File | Settings | File Templates.
 */

public class TagCloudTest {
    @Test
    public void add() {
        TagCloud tagCloud = new TagCloud();

        tagCloud.add("java");
    }

/*
    @Test
    public void size() {
        TagCloud tagCloud = new TagCloud();

        tagCloud.add("java");

        assertEquals(1, tagCloud.size());
    }
*/
    @Test
    public void addMutiple() {
        TagCloud tagCloud = new TagCloud();

        tagCloud.add("java", "ruby", "python");
    }

    @Test
    public void addEmpty() {
        TagCloud tagCloud = new TagCloud();

        tagCloud.add();
    }

    @Test
    public void addNull() {
        TagCloud tagCloud = new TagCloud();

        tagCloud.add((String[]) null);

        assertEquals(0, tagCloud.size());
    }

    @Test
    public void contains() {
        TagCloud tagCloud = new TagCloud();

        tagCloud.add("java");

        Assert.assertTrue(tagCloud.contains("java"));
    }

    @Test
    public void size() {
        TagCloud tagCloud = new TagCloud();

        tagCloud.add("java", "java", "python", "", null);

        Assert.assertEquals(2, tagCloud.size());
    }

    @Test
    public void top() {
        TagCloud tagCloud = new TagCloud();

        tagCloud.add("java", "ruby", "python", "c#", "groovy");
        tagCloud.top(3);

        Assert.assertEquals(3, tagCloud.size());
    }

}
