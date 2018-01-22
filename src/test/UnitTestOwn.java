package test;

import data_struct.linear_structure.linear_list.SeqList;
import org.junit.Test;

import java.util.Random;

public class UnitTestOwn {


    @Test
    public void test01() {
        SeqList<Integer> seqList = new SeqList<>();
        Random random = new Random();
        for(int i = 0;i<20;i++){
            seqList.insert(random.nextInt(20));
        }

        System.out.println(seqList);

        seqList.set(0,100);
        seqList.insert(8,55);

        System.out.println(seqList);

        System.out.println(seqList.size());
        System.out.println(seqList.isEmpty());

        seqList.clear();

        System.out.println(seqList);

        System.out.println(seqList.size());
        System.out.println(seqList.isEmpty());

        for(int i = 0;i<20;i++){
            seqList.insert(random.nextInt(20));
        }

        System.out.println(seqList);

        System.out.println(seqList.size());
        System.out.println(seqList.isEmpty());
    }
}
