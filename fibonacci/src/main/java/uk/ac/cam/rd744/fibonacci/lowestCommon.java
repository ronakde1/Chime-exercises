package uk.ac.cam.rd744.fibonacci;

public class lowestCommon {
    static int firstbit(long values){
        int count = -1;
        if (values == 0) return -1;
        while ((values & 1L) == 0) {
            count++;
            values = values >> 1;
        }
        if (values > 1){
            count++;
        }

        return count+1;
    }

    static int compare(long value1, long value2){
        long newvalue = value1 &  value2;
        return firstbit(newvalue);

    }



}
