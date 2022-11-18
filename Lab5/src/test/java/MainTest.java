import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class MainTest extends TestCase {


    @Test
    public void testKMP() {
        Assert.assertEquals(10, Main.KMP("ABABDABACDABABCABAB", "ABABCABAB"));
        Assert.assertEquals(11, Main.KMP("ABABDABACDAHelloABCABAB", "Hello"));
        Assert.assertEquals(5, Main.KMP("AWQQWLOLRRRRRXSDSDS", "LOL"));

    }

    @Test
    public void testTimeKMP() {

        //the worst result
        String text = "";
        for (int i = 0; i < 100000; i++) {
            if(i == 50000){
                text+= "OK";
                continue;
            }
            text+= "A";
        }
        long start = System.currentTimeMillis();
        Main.KMP( text, "OK");
        long end = System.currentTimeMillis();
        System.out.println(end - start);


    }


    @Test
    public void testTimeKMP2() {

        //best result
        long start2 = System.currentTimeMillis();
        Main.KMP( "woqqqananandsd", "wo");
        long end2 = System.currentTimeMillis();
        System.out.println(end2 - start2);


    }


    @Test
    public void testTimeKMP3() {


        long start4 = System.currentTimeMillis();
        Main.KMP( "JDJDJDJNCNSJN DNSCDDDABABDABAHOHBABCABAB", "DNS");
        long end4 = System.currentTimeMillis();
        System.out.println(end4 - start4);
    }

    @Test
    public void testTimeKMP4() {

        long start3 = System.currentTimeMillis();
        Main.KMP( "ABABDABACDAJOCKCABAB", "KCABAB");
        long end3 = System.currentTimeMillis();
        System.out.println(end3 - start3);

    }
}